package converter;

import rateprovider.ExchangeRateProvider;

public class SimpleCurrencyConverter implements CurrencyConverter {
    private final ExchangeRateProvider provider;
    public SimpleCurrencyConverter(ExchangeRateProvider exchangeRateProvider) {
        this.provider = exchangeRateProvider;
    }

    @Override
    public double convert(String curFrom, String curTo, Double amount) {
        Double rate = provider.getRate(curFrom, curTo);
        return amount * rate;
    }
}
