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

    private final FileSystem fileSystem;
    private final Time time;

    public Factory(FileSystem fileSystem, Time time) {
        this.fileSystem = fileSystem;
        this.time = time;
    }
    public Command create(CommandParameters parameters) {
        // 1. validate parameters
        // 2. create command context (1 + 2 as a one step)
        // 3. create command
        return createFindStalledDocumentsCommand((FindStalledDocumentsCommandParameters) parameters);
    }

    private Command createFindStalledDocumentsCommand(FindStalledDocumentsCommandParameters p) {
        FIND_STALLED_DOCUMENTS_COMMAND_VALIDATOR.validate(p);
        val context = new FindStalledDocumentsCommandContext(Integer.parseInt(p.months()), p.workingDir(), fileSystem, time);
        val render = new FindStalledDocumentsCommandRender();
        return new FindStalledDocumentsCommandExecutor(context, render);
    }
}
