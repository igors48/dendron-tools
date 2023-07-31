package nmd.app;

import lombok.val;
import nmd.cli.parser.CommandLineParser;
import nmd.command.factory.Command;
import nmd.command.factory.Factory;
import nmd.command.factory.FileSystem;

/**
 * @author Igor Usenko
 */
final class App {

    public static void main(String[] args) {
        val parameters = CommandLineParser.parse(args);
        Factory factory = new Factory(FileSystem.DEFAULT, System::currentTimeMillis);
        Command command = factory.create(parameters);
        command.execute();
    }

}
