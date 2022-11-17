package nmd;

import lombok.val;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class HeaderParserTest {

    private static Stream<Arguments> happyFlow() {
        val data = new ArrayList<Arguments>();

        data.add(Arguments.of(
                "happy flow",
                List.of(
                        "---",
                        "updated: 1668508066883",
                        "---"
                ),
                new Header(1668508066883L)
        ));

        return data.stream();
    }

    @ParameterizedTest
    @MethodSource("happyFlow")
    void testHappyFlow(String message, List<String> lines, Header expected) {
        val actual = HeaderParser.parseHeader(lines);
        assertEquals(expected, actual, message);
    }

    private static Stream<Arguments> cornerCases() {
        val data = new ArrayList<Arguments>();

        data.add(Arguments.of(
                "when no content",
                Collections.emptyList(),
                "no content"
        ));

        data.add(Arguments.of(
                "when one line",
                List.of(
                        "---"
                ),
                "invalid content"
        ));

        data.add(Arguments.of(
                "when two lines",
                List.of(
                        "---",
                        "---"
                ),
                "invalid content"
        ));

        data.add(Arguments.of(
                "when header start signature missing",
                List.of(
                        "updated: 1668508066883",
                        "---",
                        "content"
                ),
                "no header start signature"
        ));

        data.add(Arguments.of(
                "when header stop signature missing",
                List.of(
                        "---",
                        "updated: 1668508066883",
                        "content"
                ),
                "no header stop signature"
        ));

        data.add(Arguments.of(
                "when header updated field missing",
                List.of(
                        "---",
                        "noupdated: 1668508066883",
                        "---",
                        "content"
                ),
                "no header updated field"
        ));

        data.add(Arguments.of(
                "when header updated field empty",
                List.of(
                        "---",
                        "updated:",
                        "---",
                        "content"
                ),
                "header updated field empty"
        ));

        data.add(Arguments.of(
                "when header updated field malformed",
                List.of(
                        "---",
                        "updated 1668508066883",
                        "---",
                        "content"
                ),
                "header updated field malformed"
        ));

        data.add(Arguments.of(
                "when header updated field invalid",
                List.of(
                        "---",
                        "updated: 1668d50806g6883",
                        "---",
                        "content"
                ),
                "header updated field invalid"
        ));

        return data.stream();
    }

    @ParameterizedTest
    @MethodSource("cornerCases")
    void testCornerCases(String message, List<String> lines, String expectedMessage) {
        val thrown = assertThrows(
                HeaderParserException.class,
                () -> HeaderParser.parseHeader(lines)
        );

        assertTrue(thrown.getMessage().contains(expectedMessage), "then exception thrown: " + expectedMessage);
    }
}