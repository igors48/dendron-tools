package nmd.command;

import lombok.NonNull;
import nmd.command.factory.Command;

/**
 * @author Igor Usenko
 */
public interface Render {
    Render EMPTY = new Render() {};

    default void render(@NonNull Command command){};
}
