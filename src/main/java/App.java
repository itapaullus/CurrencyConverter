import converter.CurrencyConverter;
import converter.SimpleCurrencyConverter;
import rateprovider.ExchangeRateProvider;
import rateprovider.JsonExchangeRateProvider;
import ui.ConsoleUserInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ui.UserInterface;


public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //new ConverterApp(context.getBean(CurrencyConverter.class), context.getBean(ExchangeRateProvider.class), context.getBean(UserInterface.class)).app();
    }
}
