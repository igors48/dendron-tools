package nmd;

/**
 * @author Igor Usenko
 */
record DocumentHeader(String fileName, Header header) {

    public long updated() {
        return header.updated();
    }
}
