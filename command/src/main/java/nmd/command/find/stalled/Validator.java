package nmd.command.find.stalled;

import lombok.NonNull;
import lombok.val;
import nmd.cli.parameters.FindStalledDocumentsCommandParameters;
import nmd.command.CommandParametersValidationException;

public final class Validator implements nmd.command.Validator<FindStalledDocumentsCommandParameters> {

    @Override
    public void validate(@NonNull FindStalledDocumentsCommandParameters parameters) {
        val months = parameters.months();
        if (months == null || months.isBlank()) throw new CommandParametersValidationException("months is empty");
        val workingDir = parameters.workingDir();
        if (workingDir == null || workingDir.isBlank())
            throw new CommandParametersValidationException("working directory is empty");
    }

}
