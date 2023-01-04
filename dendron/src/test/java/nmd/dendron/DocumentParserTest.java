package nmd.dendron;

import lombok.val;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author Igor Usenko
 */
class DocumentParserTest {

    private static Stream<Arguments> source() {
        val data = new ArrayList<Arguments>();

        data.add(Arguments.of(
                "when no content then no links in document",
                Collections.emptyList(),
                Collections.emptyList()
        ));

        data.add(Arguments.of(
                "when content does not contain any link then no links in document",
                List.of(
                        "content 01",
                        "content 02"
                ),
                Collections.emptyList()
        ));

        data.add(Arguments.of(
                "when content do contains links then its stored in document",
                List.of(
                        "content 01",
                        "content 02 [[a|b.c]]"
                ),
                List.of(new Link("a", "b.c"))
        ));

        return data.stream();
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(String message, List<String> content, List<Link> expected) {
        val actual = DocumentParser.parse(content).links();
        assertEquals(expected, actual, message);
    }
}