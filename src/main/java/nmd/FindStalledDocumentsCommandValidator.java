package nmd;

import lombok.val;

/**
 * Validates a command parameters
 * <br>
 * Parameters are considered valid if command execution can be started using them
 * <br>
 *
 * @author Igor Usenko
 */
final class FindStalledDocumentsCommandValidator {

    static void validate(FindStalledDocumentsCommandParameters parameters) {
        val months = parameters.months();
        if (months == null || months.isBlank()) throw new CommandParametersValidationException("months is empty");
        val workingDir = parameters.workingDir();
        if (workingDir == null || workingDir.isBlank())
            throw new CommandParametersValidationException("working directory is empty");
    }

}
