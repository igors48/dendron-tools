package nmd;

import java.util.stream.Stream;

/**
 * @author Igor Usenko
 */
interface DocumentHeaderStreamFactory {
    Stream<DocumentHeader> create(String directory);
}
