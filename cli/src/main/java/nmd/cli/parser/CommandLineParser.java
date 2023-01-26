package nmd.cli.parser;

import lombok.val;
import nmd.cli.parameters.CommandParameters;
import nmd.cli.parameters.FindStalledDocumentsCommandParameters;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * Detects a command from command line arguments
 * <br>
 * Converts arguments to the command parameters
 * <br>
 * Does not validate the parameters
 *
 * @author Igor Usenko
 */
public final class CommandLineParser {

    public static CommandParameters parse(String[] arguments) {
        try {
            if (arguments.length == 0) {
                throw new CommandLineParserException("no arguments");
            }
            val options = new Options();
            options.addOption("w", "workingDirectory", true, "");
            options.addOption("s", "stalled", true, "");

            val parser = new DefaultParser();
            CommandLine commandLine = parser.parse(options, arguments);
            val workingDir = commandLine.getOptionValue("w");
            val months = commandLine.getOptionValue("s");

            if (months == null) {
                throw new CommandLineParserException("no command");
            }

            return new FindStalledDocumentsCommandParameters(months, workingDir);
        } catch (ParseException e) {
            throw new CommandLineParserException(e);
        }
    }

}
