package ui;

import model.Currency;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface {
    final Scanner scanner = new Scanner(System.in);

    @Override
    public void showMenu() {
        System.out.println("Choose an option:");
        System.out.println("    C: Convert currency");
        System.out.println("    Q: Quit");
    }

    @Override
    public Action getAction() {
        String cmd = scanner.next();
        return Action.fromString(cmd);
    }

    @Override
    public Currency getCurrency(String message) {
        System.out.println(message);
        return Currency.fromString(scanner.next());
    }

    @Override
    public Double getAmount(String message) {
        System.out.println(message);
        try {
            return scanner.nextDouble();
        }
        catch (InputMismatchException e) {
            throw new IllegalArgumentException("Bad amount");
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}
