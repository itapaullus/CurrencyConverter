package implementations;

import interfaces.CurrencyConverter;
import interfaces.ExchangeRateProvider;
import model.CurrencyPair;

import java.io.IOException;
import java.util.Map;

public class SimpleCurrencyConverter implements CurrencyConverter {
    private final Map<CurrencyPair, Double> rates;

    public SimpleCurrencyConverter(ExchangeRateProvider exchangeRateProvider) throws IOException {
        this.rates = exchangeRateProvider.getExchangeRates();
    }

    @Override
    public double convert(String curFrom, String curTo, Double amount) throws IOException {
        CurrencyPair pair = new CurrencyPair(curFrom,curTo);
        if (!rates.containsKey(pair)) {
            throw new IllegalArgumentException("Invalid Currency Pair!");
        }
        Double rate = rates.get(new CurrencyPair(curFrom, curTo));
        return amount*rate;
    }
}
