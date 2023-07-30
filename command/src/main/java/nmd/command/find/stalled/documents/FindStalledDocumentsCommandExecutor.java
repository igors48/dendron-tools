package nmd.command.find.stalled.documents;

import lombok.val;
import nmd.command.factory.Command;

import java.text.SimpleDateFormat;

public class FindStalledDocumentsCommandExecutor implements Command {

    private static final String DATE_FORMAT = "d MMM yyyy";
    private static final long DAYS_TO_MILLIS = 24 * 60 * 60 * 1000;
    private final FindStalledDocumentsCommandContext context;
    private final FindStalledDocumentsCommandRender render;

    public FindStalledDocumentsCommandExecutor(FindStalledDocumentsCommandContext context, FindStalledDocumentsCommandRender render) {
        this.context = context;
        this.render = render;
    }

    @Override
    public void execute() {
        val now = context.time().current();
        val treshold = now - (long) context.days() * DAYS_TO_MILLIS;
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        System.out.println("Not updated more than " + context.days() + " days. Since: " + formatter.format(treshold));
        context.streamFactory().create(context.workingDir())
                .filter(candidate -> {
                    val updated = candidate.updated();
                    return updated <= treshold;
                })
                .sorted((h1, h2) -> h1.updated() > h2.updated() ? 1 : -1)
                .forEach(render::renderStalled);
    }
}
