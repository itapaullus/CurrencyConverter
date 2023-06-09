import currencyconverter.converter.CurrencyConverter;
import currencyconverter.converter.SimpleCurrencyConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import currencyconverter.rateprovider.ExchangeRateProvider;
import currencyconverter.rateprovider.JsonExchangeRateProvider;
import currencyconverter.ui.ConsoleUserInterface;
import currencyconverter.ui.UserInterface;

@Configuration
@ComponentScan(basePackages = {"currencyconverter"})
public class AppConfig {
    @Bean
    public ExchangeRateProvider exchangeRateProvider() {
        return new JsonExchangeRateProvider("src/main/resources/rates/rates.json");
    }
    @Bean
    public CurrencyConverter currencyConverter() {
        return new SimpleCurrencyConverter();
    }
    @Bean
    public UserInterface userInterface() {
        return new ConsoleUserInterface();
    }
}
