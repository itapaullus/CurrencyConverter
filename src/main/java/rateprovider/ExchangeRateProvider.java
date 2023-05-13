package rateprovider;

import model.CurrencyPair;

public interface ExchangeRateProvider {
    Double getRate(CurrencyPair pair);
    Double getRate(String curFrom, String curTo);
}
