package nmd.command.find.stalled.documents;

import lombok.val;
import nmd.command.factory.Command;

public class FindStalledDocumentsCommandExecutor implements Command {

    private static final long MONTH_TO_MILLIS = 30L * 24 * 60 * 60 * 1000;
    private final FindStalledDocumentsCommandContext context;
    private final FindStalledDocumentsCommandRender render;

    public FindStalledDocumentsCommandExecutor(FindStalledDocumentsCommandContext context, FindStalledDocumentsCommandRender render) {
        this.context = context;
        this.render = render;
    }

    @Override
    public void execute() {
        val now = context.time().current();
        val treshold = now - (long) context.months() * MONTH_TO_MILLIS;
        context.streamFactory().create(context.workingDir())
                .filter(candidate -> {
                    val updated = candidate.updated();
                    return updated <= treshold;
                })
                .forEach(render::renderStalled);
    }
}
