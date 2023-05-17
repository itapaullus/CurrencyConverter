package ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface {
    final Scanner scanner = new Scanner(System.in);

    @Override
    public void showMenu() {
        System.out.println("Choose an option:");
        System.out.println("    Exchange: Convert currency");
        System.out.println("    Quit: Quit");
    }

    @Override
    public Action getAction() throws InvalidAction {
        String cmd = scanner.next();
        Action result;
        try {
            result = Action.valueOf(cmd.toUpperCase());
            return result;
        }
        catch (IllegalArgumentException e) {
            throw new InvalidAction("Action "+cmd+" doesn't exists");
        }
    }

    @Override
    public String getCurrency(String message) {
        System.out.println(message);
        return scanner.next().toUpperCase();
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
