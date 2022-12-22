package nmd;

import lombok.val;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import java.io.IOException;

/**
 * @author Igor Usenko
 */
public class App {

    public static void main(String[] args) throws IOException, ParseException {
        val options = new Options();
        options.addOption("w", "workingDirectory", true, "");
        options.addOption("s", "stalled", true, "");

        val parser = new DefaultParser();
        val commandLine = parser.parse(options, args);
        val workingDir = commandLine.getOptionValue("w");
        val stalledPeriod = commandLine.getOptionValue("s");
        System.out.println(workingDir + " " + stalledPeriod);
//        val path = args[0];
//        try (val dir = Files.newDirectoryStream(
//                Paths.get(path), "*.md")) {
//
//            for (val entry : dir) {
//                val lines = Files.readAllLines(entry);
//                try {
//                    val document = DocumentParser.parse(lines);
//                    System.out.printf("%s : %s\r\n", entry, document);
//                } catch (LinkExtractorException e) {
//                    System.out.printf("Error in %s\r\n", entry);
//                }
//            }
//        }
    }

}
