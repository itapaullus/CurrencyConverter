import currencyconverter.converter.CurrencyConverter;
import currencyconverter.rateprovider.ExchangeRateProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import currencyconverter.ui.UserInterface;


public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        new ConverterApp(context.getBean(CurrencyConverter.class), context.getBean(ExchangeRateProvider.class), context.getBean(UserInterface.class)).app();
    }
}
