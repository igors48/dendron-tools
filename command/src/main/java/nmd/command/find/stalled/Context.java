package nmd.command.find.stalled;

import nmd.cli.parameters.FindStalledDocumentsCommandParameters;

record Context(
        FindStalledDocumentsCommandParameters parameters
) implements nmd.command.Context<FindStalledDocumentsCommandParameters> {
}
