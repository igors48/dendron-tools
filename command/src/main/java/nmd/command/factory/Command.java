package nmd.command.factory;

import lombok.NonNull;
import nmd.command.Executor;
import nmd.command.Parameters;
import nmd.command.Render;
import nmd.command.Validator;

/**
 * @author Igor Usenko
 */
public class Command<T extends Parameters> {

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

    public void validate() {
        validator.validate(this);
    }

    public void execute() {
        executor.execute(this);
    }

    public void render() {
        render.render(this);
    }

}
