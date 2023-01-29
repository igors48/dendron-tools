package nmd.command;

import lombok.NonNull;
import nmd.command.factory.Command;

/**
 * @author Igor Usenko
 */
public interface Executor<T extends Context> {

    Executor EMPTY = new Executor(){};

    default void execute(){};
}
