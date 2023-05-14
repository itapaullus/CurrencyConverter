package converter;

import rateprovider.ExchangeRateProvider;

public class SimpleCurrencyConverter implements CurrencyConverter {
    private final ExchangeRateProvider provider;
    public SimpleCurrencyConverter(ExchangeRateProvider exchangeRateProvider) {
        this.provider = exchangeRateProvider;
    }

    @Override
    public double convert(String curFrom, String curTo, Double amount) throws IllegalArgumentException{
        Double rate = provider.getRate(curFrom, curTo);
        if (!rate.isNaN()) {
            return amount * rate;
        }
        else {
            throw new IllegalArgumentException("No such currency pair found!");
        }
    }
}
