import converter.CurrencyConverter;
import converter.SimpleCurrencyConverter;
import rateprovider.JsonExchangeRateProvider;
import ui.Action;
import ui.ConsoleUserInterface;
import ui.UserInterface;

public class ConverterApp {
    public static void app() {
        CurrencyConverter converter = new SimpleCurrencyConverter(new JsonExchangeRateProvider("src/main/resources/rates/rates.json"));
        UserInterface ui = new ConsoleUserInterface();
        while (true) {
            ui.ShowMenu();
            Action action = ui.getAction();
            if (action.equals(Action.Quit)) {
                break;
            } else if (action.equals(Action.ExchangeCurrency)) {
                try {
                    System.out.println(converter.convert(
                            ui.getCurrency("Enter a currency to convert from"),
                            ui.getCurrency("Enter a currency to convert from"),
                            ui.getAmount("Enter an amount to convert")));
                }
                catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
