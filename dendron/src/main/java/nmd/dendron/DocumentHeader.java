package nmd.dendron;

/**
 * @author Igor Usenko
 */
public record DocumentHeader(String fileName, Header header) {

    public long updated() {
        return header.updated();
    }
}
