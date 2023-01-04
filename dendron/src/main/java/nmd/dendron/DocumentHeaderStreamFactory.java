package nmd.dendron;

import java.util.stream.Stream;

/**
 * @author Igor Usenko
 */
public interface DocumentHeaderStreamFactory {
    Stream<DocumentHeader> create(String directory);
}
