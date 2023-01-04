package nmd.command;

import lombok.RequiredArgsConstructor;
import lombok.val;
import nmd.dendron.DocumentHeader;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Igor Usenko
 */
@RequiredArgsConstructor
final class FindStalledDocumentsCommand {

    private static final long MONTH_TO_MILLIS = 30L * 24 * 60 * 60 * 1000;

    private final FindStalledDocumentsCommandContext context;

    Set<DocumentHeader> find() {
        val now = context.time().current();
        val treshold = now - (long) context.months() * MONTH_TO_MILLIS;
        return context.streamFactory().create(context.workingDir()).filter(candidate -> {
            val updated = candidate.updated();
            return updated <= treshold;
        }).collect(Collectors.toSet());
    }

}
