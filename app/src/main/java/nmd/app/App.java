package nmd.app;

import lombok.val;
import nmd.cli.parser.CommandLineParser;
import nmd.command.factory.Command;
import nmd.command.factory.Factory;
import nmd.command.factory.FileSystem;
import nmd.command.factory.Time;

/**
 * @author Igor Usenko
 */
final class App {

    public static void main(String[] args) {
        new App().run(args, FileSystem.DEFAULT, System::currentTimeMillis);
    }

    void run(String[] args, FileSystem fileSystem, Time time) {
        val parameters = CommandLineParser.parse(args);
        Factory factory = new Factory(fileSystem, time, System.out::println);
        Command command = factory.create(parameters);
        command.execute();
    }

}
