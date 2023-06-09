import currencyconverter.converter.CurrencyConverter;
import currencyconverter.converter.SimpleCurrencyConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import currencyconverter.rateprovider.ExchangeRateProvider;
import currencyconverter.rateprovider.JsonExchangeRateProvider;
import currencyconverter.ui.ConsoleUserInterface;
import currencyconverter.ui.UserInterface;


@Configuration
@ComponentScan(basePackages = {"currencyconverter"})
public class AppConfig {
    @Value("src/main/resources/rates/rates.json")
    public String filename;
    @Autowired
    public ExchangeRateProvider exchangeRateProvider(@Value("${filename}") String filename) {
        return new JsonExchangeRateProvider(filename);
    }
    public CurrencyConverter currencyConverter() {
        return new SimpleCurrencyConverter();
    }
    public UserInterface userInterface() {
        return new ConsoleUserInterface();
    }
}
