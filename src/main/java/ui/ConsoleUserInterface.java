package ui;

import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void ShowMenu() {
        System.out.println("Choose an option:");
        System.out.println("    C: Convert currency");
        System.out.println("    Q: Quit");
    }

    @Override
    public Action getAction() {
        Action result = null;
        String cmd = scanner.next();
        if (cmd.equalsIgnoreCase("Q")) {
            result = Action.Quit;
        } else if (cmd.equalsIgnoreCase("C")) {
            result = Action.ExchangeCurrency;
        } else {
            System.out.println("Bad input, try again");
            getAction();
        }
        return result;
    }

    @Override
    public String getCurrency() {
        System.out.println("Enter a currency:");
        return scanner.next();
    }

    @Override
    public Double getAmount() {
        System.out.println("Enter an amount:");
        return scanner.nextDouble();
    }
}
