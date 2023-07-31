package nmd.command;

import nmd.command.factory.Time;
import nmd.dendron.DocumentHeaderStreamFactory;

/**
 * @author Igor Usenko
 */
public record FindStalledDocumentsCommandContext(
        int months,
        String workingDir,
        DocumentHeaderStreamFactory streamFactory,
        Time time
) {
}
