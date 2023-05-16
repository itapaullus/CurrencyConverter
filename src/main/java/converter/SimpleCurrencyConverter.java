package converter;

public class SimpleCurrencyConverter implements CurrencyConverter {

    @Override
    public double convert(Double amount, Double rate) {
        return amount * rate;
    }
}
