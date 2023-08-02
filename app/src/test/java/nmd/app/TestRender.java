package nmd.app;

import nmd.command.factory.Render;

import java.util.ArrayList;
import java.util.List;

public class TestRender implements Render {

    private final List<String> lines;

    public TestRender() {
        this.lines = new ArrayList<>();
    }

    @Override
    public void println(String text) {
        lines.add(text);
    }

    public List<String> getLines() {
        return lines;
    }
}
