package nmd;

/**
 * @author Igor Usenko
 */
final class CommandParametersValidationException extends RuntimeException {
    public CommandParametersValidationException(String message) {
        super(message);
    }
}
