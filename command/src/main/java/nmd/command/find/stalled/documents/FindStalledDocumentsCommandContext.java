package nmd.command.find.stalled.documents;

import nmd.cli.parameters.FindStalledDocumentsCommandParameters;

public record FindStalledDocumentsCommandContext(
        FindStalledDocumentsCommandParameters parameters
) implements nmd.command.Context<FindStalledDocumentsCommandParameters> {
}
