package nmd.command.factory;

import nmd.cli.parameters.CommandParameters;
import nmd.cli.parameters.FindStalledDocumentsCommandParameters;
import nmd.command.Executor;
import nmd.command.Render;
import nmd.command.Validator;

/**
 * @author Igor Usenko
 */
public final class Factory {

    public static Command create(CommandParameters parameters) {
        return switch (parameters){
            case FindStalledDocumentsCommandParameters p -> new Command(null, Validator.EMPTY, Executor.EMPTY, Render.EMPTY);
        };
    }
}
