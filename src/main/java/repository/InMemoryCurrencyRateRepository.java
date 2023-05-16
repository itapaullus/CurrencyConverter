package repository;

import model.CurrencyPair;

import java.util.Map;

public class InMemoryCurrencyRateRepository implements CurrencyRateRepository {
    private final Map<CurrencyPair, Double> rates;

    public InMemoryCurrencyRateRepository(Map<CurrencyPair, Double> rates) {
        this.rates = rates;
    }

    @Override
    public double getRate(CurrencyPair pair) throws NoRateException {
        try {
            return rates.get(pair);
        } catch (NullPointerException e) {
            throw new NoRateException("Exchange rate for currency pair "+pair.curFrom()+"/"+pair.curTo()+" doesn't exist");
        }
    }
}
