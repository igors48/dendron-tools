package nmd;

import lombok.val;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Igor Usenko
 */
public class App {

    public static void main(String[] args) throws IOException {
        val path = args[0];
        try (val dir = Files.newDirectoryStream(
                Paths.get(path), "*.md")) {

            for (val entry : dir) {
                val lines = Files.readAllLines(entry);
                try {
                    val document = DocumentParser.parse(lines);
                    System.out.printf("%s : %s\r\n", entry, document);
                } catch (LinkExtractorException e) {
                    System.out.printf("Error in %s\r\n", entry);
                }
            }
        }
    }

}
