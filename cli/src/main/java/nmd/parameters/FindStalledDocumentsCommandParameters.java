package nmd.parameters;

import nmd.CommandParameters;

/**
 * @author Igor Usenko
 */
public record FindStalledDocumentsCommandParameters(
        String months,
        String workingDir
) implements CommandParameters {
}
