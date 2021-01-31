package me.inver.orderservicecli.cli.order;

import me.inver.orderservicecli.cli.Command;
import me.inver.orderservicecli.model.Order;
import me.inver.orderservicecli.repository.OrderRepository;

public class PrintAllOrders extends Command {
    public PrintAllOrders() {
        super("list", "Lists all orders", "order list", null, new Command[0]);
    }

    @Override
    public void execute(String[] args) {
        var allOrders = OrderRepository.orderRepository.findAll();
        System.out.println("orders:");
        for(Order order: allOrders) {
            System.out.println("  - id: " + order.getId());

            System.out.println("    date: " + order.getDate());
            System.out.println("    purchaser: " + order.getPurchaser());
            System.out.println("    cost: " + order.getCost());

            var items = order.getItems();
            System.out.println("    items: ");
            for(String singleItem : items)
                System.out.println("      - " + singleItem);
        }
    }
}
