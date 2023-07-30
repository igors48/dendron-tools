package nmd.app;

import lombok.val;
import nmd.cli.parser.CommandLineParser;
import nmd.command.factory.Command;
import nmd.command.factory.Factory;

/**
 * @author Igor Usenko
 */
final class App {

    public static void main(String[] args) {
        val parameters = CommandLineParser.parse(args);
        Command command = Factory.create(parameters);
        command.execute();
    }

}
