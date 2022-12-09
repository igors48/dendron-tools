package nmd;

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
