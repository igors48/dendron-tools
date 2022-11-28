package nmd;

import lombok.RequiredArgsConstructor;
import lombok.val;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Igor Usenko
 */
@RequiredArgsConstructor
final class FindStalledDocumentsCommand {

    private final long from;
    private final long to;
    private final Iterable<DocumentHeader> documentHeaders;

    Set<DocumentHeader> find() {
        val result = new HashSet<DocumentHeader>();
        // or stream??
        // document parse error handling ??
        for (val candidate: documentHeaders) {
            val updated = candidate.updated();
            val stalled = (updated >= from) && (updated <= to);
            if (stalled) result.add(candidate);
        }

        return result;
    }

}
