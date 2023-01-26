module command {
    requires lombok;

    requires cli;
    requires dendron;

    exports nmd.command.factory to app;
}