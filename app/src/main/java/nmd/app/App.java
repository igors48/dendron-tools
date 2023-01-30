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
        command.execute();
        command.render();
    }

}
