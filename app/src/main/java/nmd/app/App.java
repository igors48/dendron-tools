package nmd.app;

import lombok.val;
import nmd.cli.parser.CommandLineParser;
import nmd.command.factory.Factory;

/**
 * @author Igor Usenko
 */
final class App {

    public static void main(String[] args) {
        val parameters = CommandLineParser.parse(args);
        val command = Factory.create(parameters);
        command.validate();
        command.execute();
        command.render();
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
