package nmd.command.factory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileSystem {

    FileSystem DEFAULT = new FileSystem() {
    };

    default Stream<String> files(String directory) throws IOException {
        return Files.list(Path.of(directory))
                .filter(path -> !Files.isDirectory(path))
                .map(Path::toString);
    }

    default Stream<String> lines(String file) throws IOException {
        return Files.lines(Path.of(file));
    }

}
