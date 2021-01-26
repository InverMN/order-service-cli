package me.inver.orderservicecli.cli;

import me.inver.orderservicecli.common.ObjectId;
import me.inver.orderservicecli.model.Client;
import me.inver.orderservicecli.model.Order;
import me.inver.orderservicecli.repository.ClientRepository;
import me.inver.orderservicecli.repository.OrderRepository;

import java.math.BigDecimal;

public class ClientCLI implements CLI, Service<Client>{
    private final ClientRepository clientRepository = new ClientRepository();

    @Override
    public void execute(String[] commandSegments) {
        switch (commandSegments[1]) {
            case "list":
                printAll();
                break;
            case "get":
                printOneById(new ObjectId(commandSegments[2]));
                break;
            case "create":
                create(new Client(commandSegments[2], commandSegments[3]));
                break;
            case "remove":
                remove(new ObjectId(commandSegments[2]));
                break;
            case "help":
                printHelp();
                break;
            default:
                printNotFound();
        }
    }

    @Override
    public void printHelp() {

    }

    @Override
    public void printNotFound() {
        System.out.println("Subcommand not found. See \"client help\"");
    }

    @Override
    public void printOne(Client client, boolean isListItem) {
        if(isListItem) System.out.println("  - id: " + client.getId());
        else System.out.println("    id: " + client.getId());

        System.out.println("    name: " + client.getName());
        System.out.println("    surname: " + client.getSurname());
    }

    @Override
    public void printOneById(ObjectId id) {
        var client = clientRepository.findOneById(id);
        System.out.println("client:");
        printOne(client, false);
    }

    @Override
    public void printAll() {
        var allClients = clientRepository.findAll();
        System.out.println("clients:");
        for(Client client: allClients)
            printOne(client, true);
    }

    @Override
    public void create(Client client) {
        clientRepository.saveOne(client);
        System.out.println("Created new client");
    }

    @Override
    public void remove(ObjectId id) {
        clientRepository.removeOneById(id);
        System.out.println("Deleted client");
    }
}
