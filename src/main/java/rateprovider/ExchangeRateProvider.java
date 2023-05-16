package rateprovider;

import model.Currency;
import model.CurrencyPair;
import repository.NoRateException;

public interface ExchangeRateProvider {
    Double getRate(Currency curFrom, Currency curTo) throws NoRateException;
}
