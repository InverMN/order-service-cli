package me.inver.orderservicecli.cli;

public class Entrypoint extends Command {
    public static Command[] subcommands = {
            new OrderCommand(), new ClientCommand()
    };

    public Entrypoint() {
        super("", "", "", null, subcommands);
    }
}
