package me.inver.orderservicecli.cli;

import me.inver.orderservicecli.cli.order.CreateOrder;
import me.inver.orderservicecli.cli.order.PrintOrderById;
import me.inver.orderservicecli.cli.order.PrintAllOrders;
import me.inver.orderservicecli.cli.order.RemoveOrderById;

public class OrderCommand extends Command {
    public static Command[] subcommands = {
            new PrintAllOrders(), new CreateOrder(), new PrintOrderById(), new RemoveOrderById()
    };

    public OrderCommand() {
        super("order", "Manipulates orders in application", "order <SUBCOMMAND> <ARGS...>", null, subcommands);
    }
}
