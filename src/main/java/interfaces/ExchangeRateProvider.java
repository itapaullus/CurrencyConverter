package interfaces;

import model.CurrencyPair;

import java.io.IOException;
import java.util.Map;

public interface ExchangeRateProvider {
    Map<CurrencyPair, Double> getExchangeRates() throws IOException;
}

