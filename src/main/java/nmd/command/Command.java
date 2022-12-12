package nmd.command;

import lombok.NonNull;
import nmd.command.stalled.FindStalledDocuments;

/**
 * @author Igor Usenko
 */
public final class Command<T extends Parameters> {

    private final T parameters;
    private final Validator validator;
    private final Executor executor;
    private final Render render;

    public Command(@NonNull T parameters, @NonNull Validator validator, @NonNull Executor executor, @NonNull Render render) {
        this.parameters = parameters;
        this.validator = validator;
        this.executor = executor;
        this.render = render;
    }

    public T getParameters() {
        return parameters;
    }

    public void validate(){
        validator.validate(this);
    };
    public void execute(){
        executor.execute(this);
    };
    public void render(){
        render.render(this);
    };
}
