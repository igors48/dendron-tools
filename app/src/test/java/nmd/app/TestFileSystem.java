package nmd.app;

import nmd.command.factory.FileSystem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class TestFileSystem implements FileSystem {

    private final Map<String, List<String>> image;

    public TestFileSystem(Map<String, List<String>> image) {
        this.image = image;
    }

    @Override
    public Stream<String> files(String directory) throws IOException {
        return image.keySet().stream();
    }

    @Override
    public Stream<String> lines(String file) throws IOException {
        List<String> lines = image.get(file);
        if (lines == null) {
            throw new FileNotFoundException(file);
        }
        return lines.stream();
    }

}
