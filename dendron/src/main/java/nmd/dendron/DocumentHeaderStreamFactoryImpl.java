package nmd.dendron;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class DocumentHeaderStreamFactoryImpl implements DocumentHeaderStreamFactory {
    @Override
    public Stream<DocumentHeader> create(String directory) {
        try (Stream<Path> stream = Files.list(Paths.get(directory))) {
            List<Path> paths = stream
                    .filter(file -> !Files.isDirectory(file))
                    .filter(file -> file.toString().endsWith(".md"))
                    .toList();
            return paths.stream().map(this::parseHeader);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Stream.empty();
        }
    }

    private DocumentHeader parseHeader(Path path) {
        try {
            List<String> lines = Files.readAllLines(path);
            Header header = HeaderParser.parseHeader(lines);
            return new DocumentHeader(path.toString(), header);
        } catch (Exception e) {
            System.out.println(path + " " + e.getMessage());
            return null;
        }
    }

}
