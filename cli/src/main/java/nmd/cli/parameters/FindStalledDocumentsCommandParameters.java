package nmd.cli.parameters;

/**
 * @author Igor Usenko
 */
public record FindStalledDocumentsCommandParameters(
        String months,
        String workingDir
) implements CommandParameters {
}
