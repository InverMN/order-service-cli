package me.inver.orderservicecli.cli.order;

import me.inver.orderservicecli.cli.Command;
import me.inver.orderservicecli.common.ObjectId;
import me.inver.orderservicecli.exception.InvalidArgumentsException;
import me.inver.orderservicecli.model.Order;
import me.inver.orderservicecli.repository.OrderRepository;

import java.math.BigDecimal;
import java.util.Arrays;

public class CreateOrder extends Command {
    public CreateOrder() {
        super("create", "Creates new order", "order create <PURCHASER_ID> <COST> <ITEMS...>", null, new Command[0]);
    }

    @Override
    public void execute(String[] args) throws InvalidArgumentsException {
        if(args.length < 2) throw new InvalidArgumentsException();

        var order = new Order(new ObjectId(args[0]), new BigDecimal(args[1]), Arrays.copyOfRange(args, 2, args.length));
        OrderRepository.orderRepository.saveOne(order);
        System.out.println("Created new order");
    }
}
