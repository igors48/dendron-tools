package nmd.command;

import lombok.NonNull;

/**
 * @author Igor Usenko
 */
public interface Executor {
    void execute(@NonNull Command command);
}
