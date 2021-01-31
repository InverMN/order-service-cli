package me.inver.orderservicecli.cli.client;

import me.inver.orderservicecli.cli.Command;
import me.inver.orderservicecli.common.ObjectId;
import me.inver.orderservicecli.exception.InvalidArgumentsException;
import me.inver.orderservicecli.repository.ClientRepository;

public class PrintClientById extends Command {
    public PrintClientById() {
        super("get", "Prints single client", "client get <CLIENT_ID>", null, new Command[0]);
    }

    @Override
    public void execute(String[] args) throws InvalidArgumentsException {
        if(args.length != 1) throw new InvalidArgumentsException();
        var client = ClientRepository.clientRepository.findOneById(new ObjectId(args[0]));
        System.out.println("client:");
        System.out.println("    id: " + client.getId());
        System.out.println("    name: " + client.getName());
        System.out.println("    surname: " + client.getSurname());
    }
}
