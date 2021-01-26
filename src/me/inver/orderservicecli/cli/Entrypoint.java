package me.inver.orderservicecli.cli;

public class Entrypoint implements CLI {
    private static final OrderCLI orderCLI = new OrderCLI();
    private static final ClientCLI clientCLI = new ClientCLI();

    @Override
    public void execute(String[] commandSegments) {
        switch (commandSegments[0]) {
            case "order":
                orderCLI.execute(commandSegments);
                break;
            case "client":
                clientCLI.execute(commandSegments);
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

    }
}
