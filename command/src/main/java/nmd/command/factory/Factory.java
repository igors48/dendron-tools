package nmd.command.factory;

import lombok.val;
import nmd.cli.parameters.CommandParameters;
import nmd.cli.parameters.FindStalledDocumentsCommandParameters;
import nmd.command.find.stalled.documents.FindStalledDocumentsCommandContext;
import nmd.command.find.stalled.documents.FindStalledDocumentsCommandExecutor;

import static nmd.command.find.stalled.documents.FindStalledDocumentsCommandValidator.FIND_STALLED_DOCUMENTS_COMMAND_VALIDATOR;

/**
 * @author Igor Usenko
 */
public final class Factory {

    private final FileSystem fileSystem;
    private final Time time;
    private final Render render;

    public Factory(FileSystem fileSystem, Time time, Render render) {
        this.fileSystem = fileSystem;
        this.time = time;
        this.render = render;
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
        return new FindStalledDocumentsCommandExecutor(context, render);
    }
}
