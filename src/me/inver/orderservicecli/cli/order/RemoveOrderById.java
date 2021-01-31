package me.inver.orderservicecli.cli.order;

import me.inver.orderservicecli.cli.Command;
import me.inver.orderservicecli.common.ObjectId;
import me.inver.orderservicecli.exception.InvalidArgumentsException;
import me.inver.orderservicecli.repository.OrderRepository;

public class RemoveOrderById extends Command {
    public RemoveOrderById() {
        super("remove", "Removes a order", "order remove <ORDER_ID>", null, new Command[0]);
    }

    @Override
    public void execute(String[] args) throws InvalidArgumentsException {
        if(args.length != 1) throw new InvalidArgumentsException();
        OrderRepository.orderRepository.removeOneById(new ObjectId(args[0]));
        System.out.println("Order deleted");
    }
}
