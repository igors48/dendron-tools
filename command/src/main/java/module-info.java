module command {
    requires static lombok;

    requires cli;
    requires dendron;

    exports nmd.command.factory to app;
}