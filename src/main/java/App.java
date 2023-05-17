import converter.SimpleCurrencyConverter;
import rateprovider.JsonExchangeRateProvider;
import ui.ConsoleUserInterface;

public class App {
    public static void main(String[] args) {
        ConverterApp converterApp = new ConverterApp(new SimpleCurrencyConverter(),
                new JsonExchangeRateProvider("src/main/resources/rates/rates.json"),
                new ConsoleUserInterface()
                );
        converterApp.app();
    }
}
