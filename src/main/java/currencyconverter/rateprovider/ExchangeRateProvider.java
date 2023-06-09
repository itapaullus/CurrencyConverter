package currencyconverter.rateprovider;

import org.springframework.stereotype.Component;

public interface ExchangeRateProvider {
    Double getRate(String curFrom, String curTo) throws NoRateException;
}
