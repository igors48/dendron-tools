package nmd.cli;

import lombok.val;
import nmd.cli.parameters.FindStalledDocumentsCommandParameters;
import nmd.cli.parser.CommandLineParser;
import nmd.cli.parser.CommandLineParserException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Igor Usenko
 */
class CommandLineParserTest {

    private static Stream<Arguments> happyFlow() {
        val data = new ArrayList<Arguments>();

        data.add(Arguments.of(
                "when all arguments present then command parameters set",
                new String[]{"-s", "1", "-w", "directory"},
                new FindStalledDocumentsCommandParameters("1", "directory")
        ));

        return data.stream();
    }

    @ParameterizedTest
    @MethodSource("happyFlow")
    void whenHappyFlow(String message, String[] arguments, FindStalledDocumentsCommandParameters expected) {
        val actual = new CommandLineParser().parse(arguments);
        assertEquals(expected, actual, message);
    }

    private static Stream<Arguments> cornerCases() {
        val data = new ArrayList<Arguments>();

        data.add(Arguments.of(
                "when no arguments",
                new String[]{},
                "no arguments"
        ));

        data.add(Arguments.of(
                "when no command",
                new String[]{"-w", "directory"},
                "no command"
        ));

        return data.stream();
    }

    @ParameterizedTest
    @MethodSource("cornerCases")
    void whenCornerCases(String message, String[] arguments, String expectedMessage) {
        val thrown = assertThrows(
                CommandLineParserException.class,
                () -> new CommandLineParser().parse(arguments)
        );

        assertTrue(thrown.getMessage().contains(expectedMessage), "then exception thrown: " + expectedMessage);
    }

}