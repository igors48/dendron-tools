package nmd.command.find.stalled.documents;

import lombok.NonNull;
import lombok.val;
import nmd.cli.parameters.FindStalledDocumentsCommandParameters;
import nmd.command.CommandParametersValidationException;

public final class FindStalledDocumentsCommandValidator implements nmd.command.Validator<FindStalledDocumentsCommandParameters> {

    public static final FindStalledDocumentsCommandValidator FIND_STALLED_DOCUMENTS_COMMAND_VALIDATOR = new FindStalledDocumentsCommandValidator();

    @Override
    public void validate(@NonNull FindStalledDocumentsCommandParameters parameters) {
        val months = parameters.months();
        if (months == null || months.isBlank()) throw new CommandParametersValidationException("days is empty");
        val workingDir = parameters.workingDir();
        if (workingDir == null || workingDir.isBlank())
            throw new CommandParametersValidationException("working directory is empty");
    }

}
