package nmd.command;

import lombok.NonNull;

/**
 * @author Igor Usenko
 */
public interface Render {
    void render(@NonNull Command command);
}
