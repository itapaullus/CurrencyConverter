import currencyconverter.converter.CurrencyConverter;
import org.springframework.stereotype.Component;
import currencyconverter.rateprovider.ExchangeRateProvider;
import currencyconverter.rateprovider.NoRateException;
import currencyconverter.ui.Action;
import currencyconverter.ui.InvalidAction;
import currencyconverter.ui.UserInterface;
@Component
public class ConverterApp {
    private final CurrencyConverter converter;
    private final ExchangeRateProvider provider;
    private final UserInterface ui;

    public ConverterApp(CurrencyConverter converter,
                        ExchangeRateProvider provider,
                        UserInterface ui) {
        this.provider = provider;
        this.converter = converter;
        this.ui = ui;
    }

    public void app() {
        while (true) {
            try {
                ui.showMenu();
                Action action = ui.getAction();
                if (action.equals(Action.QUIT)) {
                    break;
                } else if (action.equals(Action.EXCHANGE)) {
                    String curFrom = ui.getCurrency("Enter currency to convert from");
                    String curTo = ui.getCurrency("Enter currency to convert to");
                    double result = converter.convert(ui.getAmount("enter Amount"), provider.getRate(curFrom, curTo));
                    ui.showMessage("Your converted amount is " + curTo + " " + result);
                }
            } catch (IllegalArgumentException | NoRateException | InvalidAction e) {
                ui.showMessage(e.getMessage());
            }
        }
    }
}
