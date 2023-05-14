package repository;

import model.CurrencyPair;

import java.util.Map;

public class InMemoryCurrencyRateRepository implements CurrencyRateRepository {
    private final Map<CurrencyPair, Double> rates;

    public InMemoryCurrencyRateRepository(Map<CurrencyPair, Double> rates) {
        this.rates = rates;
    }

    @Override
    public double getRate(String curFrom, String curTo) {
        return getRate(new CurrencyPair(curFrom, curTo));
    }

    @Override
    public double getRate(CurrencyPair pair) {
        try {
            return rates.get(pair);
        } catch (NullPointerException e) {
            return Double.NaN;
        }
    }
}
