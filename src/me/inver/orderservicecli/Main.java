package me.inver.orderservicecli;

import me.inver.orderservicecli.cli.Entrypoint;
import java.util.Scanner;

public class Main {
    private static final Entrypoint entrypoint = new Entrypoint();

    public static void main(String[] args) {
	    listenCommands();
    }

    static private void listenCommands() {
        var scanner = new Scanner(System.in);
        while(true) {
            String command = scanner.nextLine();
            String[] commandFragments = command.split("\\s+");
            entrypoint.execute(commandFragments);
        }
    }
}
