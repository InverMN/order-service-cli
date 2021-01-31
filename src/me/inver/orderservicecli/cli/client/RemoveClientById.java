package me.inver.orderservicecli.cli.client;

import me.inver.orderservicecli.cli.Command;
import me.inver.orderservicecli.common.ObjectId;
import me.inver.orderservicecli.exception.InvalidArgumentsException;
import me.inver.orderservicecli.repository.ClientRepository;

public class RemoveClientById extends Command {
    public RemoveClientById() {
        super("remove", "Removes a client", "order remove <CLIENT_ID>", null, new Command[0]);
    }

    @Override
    public void execute(String[] args) throws InvalidArgumentsException {
        if(args.length != 1) throw new InvalidArgumentsException();

        ClientRepository.clientRepository.removeOneById(new ObjectId(args[0]));
        System.out.println("Client deleted");
    }
}
