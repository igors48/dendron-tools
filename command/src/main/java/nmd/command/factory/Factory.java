package nmd.command.factory;

import lombok.val;
import nmd.cli.parameters.CommandParameters;
import nmd.cli.parameters.FindStalledDocumentsCommandParameters;
import nmd.command.find.stalled.documents.FileSystem;
import nmd.command.find.stalled.documents.FindStalledDocumentsCommandContext;
import nmd.command.find.stalled.documents.FindStalledDocumentsCommandExecutor;
import nmd.command.find.stalled.documents.FindStalledDocumentsCommandRender;
import nmd.dendron.DocumentHeaderStreamFactoryImpl;

import static nmd.command.find.stalled.documents.FindStalledDocumentsCommandValidator.FIND_STALLED_DOCUMENTS_COMMAND_VALIDATOR;

/**
 * @author Igor Usenko
 */
public final class Factory {

    public static Command create(CommandParameters parameters) {
        // 1. validate parameters
        // 2. create command context (1 + 2 as a one step)
        // 3. create command
        return createFindStalledDocumentsCommand((FindStalledDocumentsCommandParameters) parameters);
    }

    private static Command createFindStalledDocumentsCommand(FindStalledDocumentsCommandParameters p) {
        FIND_STALLED_DOCUMENTS_COMMAND_VALIDATOR.validate(p);
        val context = new FindStalledDocumentsCommandContext(Integer.parseInt(p.months()), p.workingDir(), new DocumentHeaderStreamFactoryImpl(), FileSystem.DEFAULT, System::currentTimeMillis);
        val render = new FindStalledDocumentsCommandRender();
        return new FindStalledDocumentsCommandExecutor(context, render);
    }
}
