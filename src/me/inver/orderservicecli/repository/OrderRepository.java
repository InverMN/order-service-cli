package me.inver.orderservicecli.repository;

import me.inver.orderservicecli.common.ObjectId;
import me.inver.orderservicecli.model.Order;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class OrderRepository implements Repository<Order> {
    private ArrayList<Order> orders = new ArrayList<>();

    @Override
    public void saveOne(Order order) {
        orders.add(order);
    }

    @Override
    public boolean exists(ObjectId id) {
        return findOneById(id) != null;
    }

    @Override
    public Order[] findAll() {
        var orderArray = new Order[orders.size()];
        for (int i = 0; i < orders.size(); i++)
            orderArray[i] = orders.get(i);
        return orderArray;
    }

    @Override
    public Order findOneById(ObjectId id) {
        return orders
                .stream()
                .filter(singleOrder -> singleOrder.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void removeOneById(ObjectId id) {
        orders = (ArrayList<Order>) orders
                .stream()
                .filter(singleOrder -> !singleOrder.getId().equals(id))
                .collect(Collectors.toList());
    }
}
