package nmd.command;

import lombok.RequiredArgsConstructor;
import nmd.cli.parameters.FindStalledDocumentsCommandParameters;
import nmd.command.factory.Time;
import nmd.dendron.DocumentHeaderStreamFactory;

/**
 * @author Igor Usenko
 */
@RequiredArgsConstructor
final class CommandContextFactory {

    private final DocumentHeaderStreamFactory streamFactory;
    private final Time time;

    FindStalledDocumentsCommandContext create(FindStalledDocumentsCommandParameters parameters) {
        return new FindStalledDocumentsCommandContext(
                Integer.parseInt(parameters.months()),
                parameters.workingDir(),
                streamFactory,
                time
        );
    }
}
