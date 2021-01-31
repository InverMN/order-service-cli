package me.inver.orderservicecli.cli;

import me.inver.orderservicecli.cli.Command;
import me.inver.orderservicecli.cli.client.CreateClient;
import me.inver.orderservicecli.cli.client.PrintAllClients;
import me.inver.orderservicecli.cli.client.PrintClientById;
import me.inver.orderservicecli.cli.client.RemoveClientById;

public class ClientCommand extends Command {
    public static Command[] subcommands = {
            new PrintAllClients(), new CreateClient(), new PrintClientById(), new RemoveClientById()
    };

    public ClientCommand() {
        super("client", "Manipulates clients in application", "client <SUBCOMMAND> <ARGS...>", null, subcommands);
    }
}
