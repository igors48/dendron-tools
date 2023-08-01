package nmd.app;

import lombok.val;
import nmd.cli.parser.CommandLineParser;
import nmd.command.factory.*;

/**
 * @author Igor Usenko
 */
final class App {

    public static void main(String[] args) {
        new App().run(args, FileSystem.DEFAULT, System::currentTimeMillis, System.out::println);
    }

    void run(String[] args, FileSystem fileSystem, Time time, Render render) {
        val parameters = CommandLineParser.parse(args);
        Factory factory = new Factory(fileSystem, time, render);
        Command command = factory.create(parameters);
        command.execute();
    }

}
