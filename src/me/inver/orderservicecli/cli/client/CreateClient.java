package me.inver.orderservicecli.cli.client;

import me.inver.orderservicecli.cli.Command;
import me.inver.orderservicecli.exception.InvalidArgumentsException;
import me.inver.orderservicecli.model.Client;
import me.inver.orderservicecli.repository.ClientRepository;

public class CreateClient extends Command {
    public CreateClient() {
        super("create", "Creates new client", "client create <NAME> <SURNAME>", null, new Command[0]);
    }

    @Override
    public void execute(String[] args) throws InvalidArgumentsException {
        if(args.length != 2) throw new InvalidArgumentsException();

        var client = new Client(args[0], args[1]);
        ClientRepository.clientRepository.saveOne(client);
        System.out.println("Created new client");
    }
}
