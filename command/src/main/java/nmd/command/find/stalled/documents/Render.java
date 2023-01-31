package nmd.command.find.stalled.documents;

import nmd.command.Result;
import nmd.dendron.DocumentHeader;

/**
 * @author Igor Usenko
 */
public interface Render {

    void renderStalled(DocumentHeader header);
}
