package nmd.app;

import nmd.command.factory.Time;

public class TestTime implements Time {

    @Override
    public long current() {
        return 0;
    }
}
