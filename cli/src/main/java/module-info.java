module cli {
    requires static lombok;

    requires commons.cli;

    exports nmd.cli.parser to app;
    exports nmd.cli.parameters to command;
}