package nmd.command.factory;

import lombok.val;
import nmd.cli.parameters.CommandParameters;
import nmd.cli.parameters.FindStalledDocumentsCommandParameters;
import nmd.command.find.stalled.documents.FindStalledDocumentsCommandContext;
import nmd.command.find.stalled.documents.FindStalledDocumentsCommandExecutor;
import nmd.command.find.stalled.documents.FindStalledDocumentsCommandRender;

import static nmd.command.find.stalled.documents.FindStalledDocumentsCommandValidator.FIND_STALLED_DOCUMENTS_COMMAND_VALIDATOR;

/**
 * @author Igor Usenko
 */
public final class Factory {

    public static Command create(CommandParameters parameters) {
        // 1. validate parameters
        // 2. create command context (1 + 2 as an one step)
        // 3. create command
        return switch (parameters) {
            case FindStalledDocumentsCommandParameters p -> createFindStalledDocumentsCommand(p);
        };
    }

    private static Command createFindStalledDocumentsCommand(FindStalledDocumentsCommandParameters p) {
        FIND_STALLED_DOCUMENTS_COMMAND_VALIDATOR.validate(p);
        val context = new FindStalledDocumentsCommandContext(p);
        val executor = new FindStalledDocumentsCommandExecutor();
        val render = new FindStalledDocumentsCommandRender();
        return new Command(executor, render);
    }
}
