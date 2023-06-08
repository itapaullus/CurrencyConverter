import converter.CurrencyConverter;
import converter.SimpleCurrencyConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import rateprovider.ExchangeRateProvider;
import rateprovider.JsonExchangeRateProvider;
import ui.ConsoleUserInterface;
import ui.UserInterface;

@Configuration
@ComponentScan
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
