package nmd.cli;

/**
 * @author Igor Usenko
 */
final class CommandLineParserException extends RuntimeException {

    public CommandLineParserException(String message) {
        super(message);
    }

    public CommandLineParserException(Exception exception) {
        super(exception);
    }
}
