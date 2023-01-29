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
        // 1. validate parameters
        // 2. create command context
        // 3. create command
        return switch (parameters){
            case FindStalledDocumentsCommandParameters p -> new Command( Executor.EMPTY, Render.EMPTY);
        };
    }
}
