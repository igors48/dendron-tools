package nmd.command;

import lombok.NonNull;
import nmd.command.stalled.FindStalledDocumentsParameters;

/**
 * @author Igor Usenko
 */
final class Factory {
    public Command create(@NonNull Parameters parameters){
        return switch (parameters) {
            case FindStalledDocumentsParameters p -> new Command<>(p, null, null, null);
            default -> throw new IllegalStateException("Unexpected value: " + parameters);
        };
    }
}
