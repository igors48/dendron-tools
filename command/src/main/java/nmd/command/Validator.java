package nmd.command;

import lombok.NonNull;
import nmd.command.factory.Command;

/**
 * @author Igor Usenko
 */
public interface Validator {

    Validator EMPTY = new Validator() {};

    default void validate(@NonNull Command command){};
}
