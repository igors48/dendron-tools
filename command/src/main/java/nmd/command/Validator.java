package nmd.command;

import lombok.NonNull;
import nmd.cli.parameters.CommandParameters;

/**
 * @author Igor Usenko
 */
public interface Validator<T extends CommandParameters> {

    Validator EMPTY = new Validator() {};

    default void validate(@NonNull T t){};
}
