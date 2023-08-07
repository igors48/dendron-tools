package nmd.dendron;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class HeaderParserFromStreamTest {

    private static Stream<Arguments> happyFlow() {
        return Stream.of(
                Arguments.of("updated: 1668508066883", new Header(1668508066883L)),
                Arguments.of("updated:1668508066883", new Header(1668508066883L)),
                Arguments.of("updated :1668508066883", new Header(1668508066883L)),
                Arguments.of("updated : 1668508066883", new Header(1668508066883L))
        );
    }

    @ParameterizedTest
    @MethodSource("happyFlow")
    void testHappyFlow(String line, Header expected) {
        HeaderParserFromStream parser = new HeaderParserFromStream();

        boolean status = parser.newLine(line);
        assertFalse(status);

        assertEquals(expected, parser.getResult());
    }

    @Test
    void whenNextLineNeeded() {
        HeaderParserFromStream parser = new HeaderParserFromStream();

        boolean status = parser.newLine("some text");
        assertTrue(status);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "updated",
            "updated:",
            "updated:0",
            "updated:-1",
            "updated:1 1",
            "updated:a",
    })
    void testCornerCases(String line) {
        assertThrows(HeaderParserException.class, () -> {
            HeaderParserFromStream parser = new HeaderParserFromStream();
            parser.newLine(line);
        });
    }
}
