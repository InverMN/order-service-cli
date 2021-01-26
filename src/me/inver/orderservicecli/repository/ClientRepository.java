package me.inver.orderservicecli.repository;

import me.inver.orderservicecli.common.ObjectId;
import me.inver.orderservicecli.model.Client;
import me.inver.orderservicecli.model.Order;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ClientRepository implements Repository<Client> {
    private ArrayList<Client> clients = new ArrayList<>();

    @Override
    public void saveOne(Client client) {
        clients.add(client);
    }

    @Override
    public boolean exists(ObjectId id) {
        return findOneById(id) != null;
    }

    @Override
    public Client[] findAll() {
        var clientArray = new Client[clients.size()];
        for (int i = 0; i < clients.size(); i++)
            clientArray[i] = clients.get(i);
        return clientArray;
    }

    @Override
    public Client findOneById(ObjectId id) {
        return clients
                .stream()
                .filter(singleOrder -> singleOrder.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void removeOneById(ObjectId id) {
        clients = (ArrayList<Client>) clients
                .stream()
                .filter(singleOrder -> !singleOrder.getId().equals(id))
                .collect(Collectors.toList());
    }
}
