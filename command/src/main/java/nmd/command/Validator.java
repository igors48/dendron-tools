package nmd.command;

import lombok.NonNull;

/**
 * @author Igor Usenko
 */
public interface Validator {
    void validate(@NonNull Command command);
}
