package nmd.dendron;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class DocumentHeaderStreamFactoryImpl implements DocumentHeaderStreamFactory {
//    @Override
//    public Stream<DocumentHeader> create(String directory) {
//        try (Stream<Path> stream = Files.list(Paths.get(directory))) {
//            List<Path> paths = stream
//                    .filter(file -> !Files.isDirectory(file))
//                    .filter(file -> file.toString().endsWith(".md"))
//                    .toList();
//            return paths.stream().map(this::parseHeader);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return Stream.empty();
//        }
//    }

    @Override
    public Stream<DocumentHeader> create(String directory) throws IOException {
        return Files.list(Paths.get(directory))
                .filter(file -> !Files.isDirectory(file))
                .filter(file -> file.toString().endsWith(".md"))
                .map(this::parseHeader);
    }

    private DocumentHeader parseHeader(Path path) {
        HeaderParserFromStream parser = new HeaderParserFromStream();
        try (Stream<String> lines = Files.lines(path)) {
            long count = lines.takeWhile(parser::newLine).count();
            System.out.println(path + " " + count);
            return new DocumentHeader(path.toString(), parser.getResult());
        } catch (Exception e) {
            System.out.println(path + " " + e.getMessage());
            return null;
        }
    }

}
