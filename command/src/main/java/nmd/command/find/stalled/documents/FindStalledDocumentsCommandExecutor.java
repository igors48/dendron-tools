package nmd.command.find.stalled.documents;

import lombok.val;
import nmd.command.factory.Command;
import nmd.command.factory.Render;
import nmd.dendron.DocumentHeader;
import nmd.dendron.HeaderParserFromStream;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class FindStalledDocumentsCommandExecutor implements Command {

    private static final String DATE_FORMAT = "d MMM yyyy";
    private static final long DAYS_TO_MILLIS = 24 * 60 * 60 * 1000;
    private final FindStalledDocumentsCommandContext context;
    private final Render render;

    public FindStalledDocumentsCommandExecutor(FindStalledDocumentsCommandContext context, Render render) {
        this.context = context;
        this.render = render;
    }

    @Override
    public void execute() {
        val now = context.time().current();
        val threshold = now - (long) context.days() * DAYS_TO_MILLIS;
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        System.out.println();
        try (Stream<String> files = context.fileSystem().files(context.workingDir())) {
            Stream<String> stalled = files.filter(file -> file.endsWith(".md"))
                    .map(this::parseHeader)
                    .filter(candidate -> {
                        val updated = candidate.updated();
                        return updated <= threshold;
                    })
                    .sorted((h1, h2) -> h1.updated() > h2.updated() ? 1 : -1)
                    .map(this::renderStalled);
            Stream<String> header = Stream.of("Not updated more than " + context.days() + " days. Since: " + formatter.format(threshold));
            Stream.concat(header, stalled).forEach(render::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private DocumentHeader parseHeader(String path) {
        HeaderParserFromStream parser = new HeaderParserFromStream();
        try (Stream<String> lines = context.fileSystem().lines(path)) {
            long count = lines.takeWhile(parser::newLine).count();
            System.out.println(path + " " + count);
            return new DocumentHeader(path, parser.getResult());
        } catch (Exception e) {
            System.out.println(path + " " + e.getMessage());
            return null;
        }
    }

    public String renderStalled(DocumentHeader header) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        String date = formatter.format(new Date(header.updated()));
        long diff = System.currentTimeMillis() - header.updated();
        long days = TimeUnit.MILLISECONDS.toDays(diff);
        return header.fileName() + " last updated: " + date + " (" + days + ") days";
    }
}
