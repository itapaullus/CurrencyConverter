package currencyconverter.converter;

import org.springframework.stereotype.Component;

public interface CurrencyConverter {
    double convert (Double Amount, Double rate);
}
