package nmd.cli.parameters;

import nmd.cli.parser.CommandParameters;

/**
 * @author Igor Usenko
 */
public record FindStalledDocumentsCommandParameters(
        String months,
        String workingDir
) implements CommandParameters {
}
