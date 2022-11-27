package nmd;

/**
 * @author Igor Usenko
 */
public class CommandLineParserException extends RuntimeException {

    public CommandLineParserException(String message) {
        super(message);
    }

    public CommandLineParserException(Exception exception) {
        super(exception);
    }
}
