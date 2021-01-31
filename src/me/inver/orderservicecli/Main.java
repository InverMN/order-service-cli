package me.inver.orderservicecli;

import me.inver.orderservicecli.cli.Entrypoint;
import me.inver.orderservicecli.common.Role;
import me.inver.orderservicecli.exception.InvalidArgumentsException;

import java.util.Scanner;

public class Main {
    public static Role role;

    public static void main(String[] args) {
        setRole(args);
	    listenCommands();
    }

    static private  void setRole(String[] args) {
        role = args.length > 0 ? Role.fromString(args[0]) : Role.USER;
    }

    static private void listenCommands() {
        var scanner = new Scanner(System.in);
        var entrypoint = new Entrypoint();
        while(true) {
            String command = scanner.nextLine();
            String[] commandFragments = command.split("\\s+");
            try {
                entrypoint.execute(commandFragments);
            } catch (InvalidArgumentsException exception) {
                System.out.println("Invalid command arguments!");
            }
        }
    }
}
