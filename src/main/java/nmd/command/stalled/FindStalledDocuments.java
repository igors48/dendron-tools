package nmd.command.stalled;

import lombok.NonNull;
import nmd.command.Command;
import nmd.command.Executor;
import nmd.command.Render;
import nmd.command.Validator;

/**
 * @author Igor Usenko
 */
public final class FindStalledDocuments extends Command {

    private final FindStalledDocumentsParameters parameters;

    public FindStalledDocuments(@NonNull Validator validator, @NonNull Executor executor, @NonNull Render render, FindStalledDocumentsParameters parameters) {
        super(validator, executor, render);
        this.parameters = parameters;
    }
}
