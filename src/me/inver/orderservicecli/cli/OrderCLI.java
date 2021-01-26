package me.inver.orderservicecli.cli;

import me.inver.orderservicecli.common.ObjectId;
import me.inver.orderservicecli.model.Order;
import me.inver.orderservicecli.repository.OrderRepository;

import java.math.BigDecimal;

public class OrderCLI implements CLI, Service<Order>{
    private final OrderRepository orderRepository = new OrderRepository();

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
                create(new Order(new ObjectId(commandSegments[2]), new BigDecimal(commandSegments[3]), commandSegments));
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
        System.out.println("Subcommand not found. See \"order help\"");
    }

    @Override
    public void printOne(Order order, boolean isListItem) {
        if(isListItem) System.out.println("  - id: " + order.getId());
        else System.out.println("    id: " + order.getId());

        System.out.println("    date: " + order.getDate());
        System.out.println("    purchaser: " + order.getPurchaser());
        System.out.println("    cost: " + order.getCost());

        var items = order.getItems();
        System.out.println("    items: ");
        for(String singleItem : items)
            System.out.println("      - " + singleItem);
    }

    @Override
    public void printOneById(ObjectId id) {
        var order = orderRepository.findOneById(id);
        System.out.println("order:");
        printOne(order, false);
    }

    @Override
    public void printAll() {
        var allOrders = orderRepository.findAll();
        System.out.println("orders:");
        for(Order order: allOrders)
            printOne(order, true);
    }

    @Override
    public void create(Order order) {
        orderRepository.saveOne(order);
        System.out.println("Created new order");
    }

    @Override
    public void remove(ObjectId id) {
        orderRepository.removeOneById(id);
        System.out.println("Deleted order");
    }
}
