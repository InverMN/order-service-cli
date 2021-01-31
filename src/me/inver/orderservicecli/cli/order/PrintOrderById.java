package me.inver.orderservicecli.cli.order;

import me.inver.orderservicecli.cli.Command;
import me.inver.orderservicecli.common.ObjectId;
import me.inver.orderservicecli.exception.InvalidArgumentsException;
import me.inver.orderservicecli.repository.OrderRepository;

public class PrintOrderById extends Command {
    public PrintOrderById() {
        super("get", "Prints single order", "order get <ORDER_ID>", null, new Command[0]);
    }

    @Override
    public void execute(String[] args) throws InvalidArgumentsException {
        if(args.length != 2) throw new InvalidArgumentsException();
        var order = OrderRepository.orderRepository.findOneById(new ObjectId(args[0]));

        System.out.println("order:");
        System.out.println("    id: " + order.getId());
        System.out.println("    date: " + order.getDate());
        System.out.println("    purchaser: " + order.getPurchaser());
        System.out.println("    cost: " + order.getCost());
        var items = order.getItems();
        System.out.println("    items: ");
        for(String singleItem : items)
            System.out.println("      - " + singleItem);
    }
}
