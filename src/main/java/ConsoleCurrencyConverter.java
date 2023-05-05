import implementations.JsonExchangeRateProvider;
import implementations.SimpleCurrencyConverter;
import interfaces.CurrencyConverter;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleCurrencyConverter {
    private final CurrencyConverter converter;
    private final Scanner console = new Scanner(System.in);

    public ConsoleCurrencyConverter(CurrencyConverter converter) {
        this.converter = converter;
    }

    private void display() {
        System.out.println("Choose an option:");
        System.out.println("    C: Convert currency");
        System.out.println("    Q: Quit");
    }

    public void run() throws IOException {
        while (true) {
            display();
            String choise = console.next();
            if (choise.equalsIgnoreCase("Q")) {
                break;
            } else if (choise.equalsIgnoreCase("C")) {
                System.out.print("Enter currency code to convert from: ");
                String curFrom = console.next();
                System.out.print("Enter currency code to convert to: ");
                String curTo = console.next();
                System.out.print("Enter amount to convert: ");
                Double amount = console.nextDouble();
                try {
                    double new_amount = converter.convert(curFrom, curTo, amount);
                    System.out.println("Your converted amount: " + new_amount + " " + curTo);
                } catch (IllegalArgumentException e) {
                    System.out.println("Currency pair " + curFrom + "/" + curTo + " doesn't exists");
                }
            }
            {

            }
        }
    }

    public static void main(String[] args) throws IOException {
        ConsoleCurrencyConverter app = new ConsoleCurrencyConverter(new SimpleCurrencyConverter(new JsonExchangeRateProvider("src/main/resources/rates/rates.json")));
        app.run();
    }
}
