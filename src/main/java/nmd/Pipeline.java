package nmd;

import lombok.RequiredArgsConstructor;
import lombok.val;

/**
 * @author Igor Usenko
 */
@RequiredArgsConstructor
final class Pipeline {

    private final CommandLineParser commandLineParser;
    private final CommandParametersValidator commandParametersValidator;
    private final CommandContextFactory commandContextFactory;
    private final CommandFactory commandFactory;


    void process(String[] arguments) {
        val parameters = commandLineParser.parse(arguments);
        commandParametersValidator.validate(parameters);
        val context = commandContextFactory.create(parameters);
        val command  = commandFactory.create(context);
        val result = command.execute();
    }

}
