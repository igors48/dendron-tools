package nmd;

import lombok.RequiredArgsConstructor;
import lombok.val;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Igor Usenko
 */
@RequiredArgsConstructor
final class FindStalledDocumentsCommand {

    private final FindStalledDocumentsCommandParameters parameters;
    private final DocumentHeaderStreamFactory streamFactory;
    private final Time time;

    Set<DocumentHeader> find() {
        val from = calculateFrom(); // ?? just "older than" maybe
        val to = calculateTo();
        return streamFactory.create(parameters.workingDir()).filter(c -> {
            val updated = c.updated();
            return (updated >= from) && (updated <= to);
        }).collect(Collectors.toSet());
    }

    private long calculateTo() {
        return 0;
    }

    private long calculateFrom() {
        return 0;
    }

}
