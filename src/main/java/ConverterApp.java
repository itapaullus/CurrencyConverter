import converter.CurrencyConverter;
import model.Currency;
import rateprovider.ExchangeRateProvider;
import repository.NoRateException;
import ui.Action;
import ui.UserInterface;

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
                } else if (action.equals(Action.EXCHANGE_CURRENCY)) {
                    Currency curFrom = ui.getCurrency("Enter currency to convert from");
                    Currency curTo = ui.getCurrency("Enter currency to convert to");
                    double result = converter.convert(ui.getAmount("enter Amount"), provider.getRate(curFrom, curTo));
                    ui.showMessage("Your converted amount is " + curTo + " " + result);
                }
            } catch (IllegalArgumentException | NoRateException e) {
                ui.showMessage(e.getMessage());
            }
        }
    }
}
