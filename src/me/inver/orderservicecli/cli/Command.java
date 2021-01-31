package me.inver.orderservicecli.cli;

import me.inver.orderservicecli.exception.InvalidArgumentsException;
import me.inver.orderservicecli.exception.UnknownCommandException;

import java.util.Arrays;

public abstract class Command {
    private final String commandHeader;
    private final String commandDescription;
    private final String commandCallSchema;

    public Command(String header, String description, String callSchema, Command parent, Command[] subcommands) {
        commandHeader = header;
        commandDescription = description;
        commandCallSchema = callSchema;

        this.parent = parent;
        this.subcommands = subcommands;
    }

    private final Command parent;

    public String getCommandHeader() {
        return commandHeader;
    }

    public String getCommandDescription() {
        return commandDescription;
    }

    public String getCommandCallSchema() {
        return commandCallSchema;
    }

    public Command getParent() {
        return parent;
    }

    public Command[] getSubcommands() {
        return subcommands;
    }

    private final Command[] subcommands;

    private void executeWithHelp(String[] args) throws InvalidArgumentsException {
        if(args.length == 1 && args[0].equals("--help")) this.printHelp();
        else this.execute(args);
    }

    public void execute(String[] args) throws InvalidArgumentsException {
        try {
            executeSubcommand(args);
        } catch (UnknownCommandException exception) {
            System.out.println("Command not found. To see more run with --help");
        }
    }

    private void executeSubcommand(String[] args) throws UnknownCommandException, InvalidArgumentsException {
        for(Command subcommand : subcommands) {
            if(args.length > 0 && subcommand.commandHeader.equals(args[0])) {
                var subcommandArgs = Arrays.copyOfRange(args, 1, args.length);
                subcommand.executeWithHelp(subcommandArgs);
                return;
            }
        }
        throw new UnknownCommandException();
    }

    private void printHelp() {
        System.out.println(this.commandDescription);
        System.out.println("Call: \"" + this.commandCallSchema + "\"");
    };
}
