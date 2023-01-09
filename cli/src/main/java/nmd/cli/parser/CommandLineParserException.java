package nmd.cli.parser;

/**
 * @author Igor Usenko
 */
public final class CommandLineParserException extends RuntimeException {

    public CommandLineParserException(String message) {
        super(message);
    }

    public CommandLineParserException(Exception exception) {
        super(exception);
    }
}
