package nmd.command;

import lombok.val;
import nmd.cli.parameters.FindStalledDocumentsCommandParameters;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Igor Usenko
 */
class CommandFindStalledDocumentsCommandContextFindStalledDocumentsCommandValidatorTest {

    private static Stream<Arguments> cornerCases() {
        val data = new ArrayList<Arguments>();

        data.add(Arguments.of(
                "when month is empty",
                new FindStalledDocumentsCommandParameters("", "w"),
                "months is empty"
        ));

        data.add(Arguments.of(
                "when month is null",
                new FindStalledDocumentsCommandParameters(null, "w"),
                "months is empty"
        ));

        data.add(Arguments.of(
                "when working dir is empty",
                new FindStalledDocumentsCommandParameters("1", ""),
                "working directory is empty"
        ));

        data.add(Arguments.of(
                "when working dir is null",
                new FindStalledDocumentsCommandParameters("1", null),
                "working directory is empty"
        ));

        return data.stream();
    }

    @ParameterizedTest
    @MethodSource("cornerCases")
    void testCornerCases(String message, FindStalledDocumentsCommandParameters parameters, String expectedMessage) {
        val thrown = assertThrows(
                CommandParametersValidationException.class,
                () -> new CommandParametersValidator().validate(parameters)
        );

        assertTrue(thrown.getMessage().contains(expectedMessage), "then exception thrown: " + expectedMessage);

    }

    @Test
    void happyFlow() {
        try {
            new CommandParametersValidator().validate(new FindStalledDocumentsCommandParameters("1", "2"));
        } catch (Exception e) {
            fail();
        }
    }
}