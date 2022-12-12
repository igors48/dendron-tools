package nmd;

import lombok.RequiredArgsConstructor;
import lombok.val;

/**
 * @author Igor Usenko
 */
@RequiredArgsConstructor
final class CommandContextFactory {

    private final DocumentHeaderStreamFactory streamFactory;
    private final Time time;

    FindStalledDocumentsCommandContext create(FindStalledDocumentsCommandParameters parameters) {
        return new FindStalledDocumentsCommandContext(
                Integer.parseInt(parameters.months()),
                parameters.workingDir(),
                streamFactory,
                time
        );
    }
}
