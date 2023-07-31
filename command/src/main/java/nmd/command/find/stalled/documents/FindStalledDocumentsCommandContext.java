package nmd.command.find.stalled.documents;

import nmd.command.Context;
import nmd.command.factory.FileSystem;
import nmd.command.factory.Time;

public record FindStalledDocumentsCommandContext(
        int days,
        String workingDir,
        FileSystem fileSystem,
        Time time
) implements Context {
}
