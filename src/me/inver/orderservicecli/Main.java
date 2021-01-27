package me.inver.orderservicecli;

import me.inver.orderservicecli.cli.Entrypoint;
import me.inver.orderservicecli.common.Role;

import java.util.Scanner;

public class Main {
    private static final Entrypoint entrypoint = new Entrypoint();
    public static Role role;

    public static void main(String[] args) {
        setRole(args);
        System.out.println(role);
	    listenCommands();
    }

    static private  void setRole(String[] args) {
        role = args.length > 0 ? Role.fromString(args[0]) : Role.USER;
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
