package nmd.command.find.stalled.documents;

import nmd.dendron.DocumentHeader;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FindStalledDocumentsCommandRender implements Render {

    private static final String DATE_FORMAT = "d MMM yyyy";

    @Override
    public void renderStalled(DocumentHeader header) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        String date = formatter.format(new Date(header.updated()));
        System.out.println(header.fileName() + " last updated: " + date);
    }
}
