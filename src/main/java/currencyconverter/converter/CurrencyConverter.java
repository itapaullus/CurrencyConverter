package currencyconverter.converter;

import org.springframework.stereotype.Component;

@Component
public interface CurrencyConverter {
    double convert (Double Amount, Double rate);
}
