package nmd.dendron;

import java.io.IOException;
import java.util.stream.Stream;

/**
 * @author Igor Usenko
 */
public interface DocumentHeaderStreamFactory {
    Stream<DocumentHeader> create(String directory) throws IOException;
}
