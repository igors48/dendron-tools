package nmd.command.find.stalled.documents;

import nmd.command.Context;
import nmd.command.Time;
import nmd.dendron.DocumentHeaderStreamFactory;

public record FindStalledDocumentsCommandContext(
        int months,
        String workingDir,
        DocumentHeaderStreamFactory streamFactory,
        Time time
) implements Context {
}
