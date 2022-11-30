package nmd;

import lombok.val;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

class FindStalledDocumentsCommandTest {

    private static Stream<Arguments> arguments() {
        val data = new ArrayList<Arguments>();

        data.add(Arguments.of(
                "when month is empty",
                new FindStalledDocumentsCommandParameters("", "w"),
                "months is empty"
        ));

        return data.stream();
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testFind(String message, FindStalledDocumentsCommandParameters parameters, String expectedMessage) {
    }

}