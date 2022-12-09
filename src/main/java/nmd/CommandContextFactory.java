package nmd;

import lombok.RequiredArgsConstructor;

/**
 * @author Igor Usenko
 */
@RequiredArgsConstructor
final class CommandContextFactory {

    private final DocumentHeaderStreamFactory streamFactory;
    private final Time time;

    FindStalledDocumentsCommandContext create(FindStalledDocumentsCommandParameters parameters) {
        return null;
    }
}
