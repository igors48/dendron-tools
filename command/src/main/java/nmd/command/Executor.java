package nmd.command;


/**
 * @author Igor Usenko
 */
public interface Executor {

    Executor EMPTY = new Executor() {
    };

    default void execute() {
    }

    ;
}
