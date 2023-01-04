module cli {
    requires lombok;
    requires commons.cli;

    exports nmd.parameters to command;
}