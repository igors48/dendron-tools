package nmd.command;

/**
 * @author Igor Usenko
 */
public final class CommandParametersValidationException extends RuntimeException {
    public CommandParametersValidationException(String message) {
        super(message);
    }
}
