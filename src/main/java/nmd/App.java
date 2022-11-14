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
                System.out.println(entry);

            }
        }
    }

}
