package me.inver.orderservicecli.cli.client;

import me.inver.orderservicecli.cli.Command;
import me.inver.orderservicecli.model.Client;
import me.inver.orderservicecli.repository.ClientRepository;

public class PrintAllClients extends Command {
    public PrintAllClients() {
        super("list", "Lists all clients", "client list", null, new Command[0]);
    }

    @Override
    public void execute(String[] args) {
        var allClients = ClientRepository.clientRepository.findAll();
        System.out.println("clients:");
        for(Client client: allClients) {
            System.out.println("  - id: " + client.getId());

            System.out.println("    name: " + client.getName());
            System.out.println("    surname: " + client.getSurname());
        }
    }
}
