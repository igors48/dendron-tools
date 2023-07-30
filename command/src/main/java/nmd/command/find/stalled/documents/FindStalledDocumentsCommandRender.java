package nmd.command.find.stalled.documents;

import nmd.dendron.DocumentHeader;

public class FindStalledDocumentsCommandRender implements Render {

    @Override
    public void renderStalled(DocumentHeader header) {
        System.out.println(header.fileName());
    }
}
