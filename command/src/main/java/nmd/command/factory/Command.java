package nmd.command.factory;

import lombok.NonNull;
import nmd.command.Executor;
import nmd.command.Context;
import nmd.command.Render;
import nmd.command.Result;

/**
 * @author Igor Usenko
 */
public class Command<C extends Context, R extends Result> {

    private final Executor<C> executor;
    private final Render<R> render;

    public Command(@NonNull Executor<C> executor, @NonNull Render<R> render) {
        this.executor = executor;
        this.render = render;
    }

    public void execute() {
        executor.execute();
    }

    public void render() {
        render.render();
    }

}
