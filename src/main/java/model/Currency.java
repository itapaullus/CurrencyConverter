package model;

import java.util.HashMap;
import java.util.Map;

public enum Currency {
    USD("USD"),
    EUR("EUR"),
    RUR("RUR");
    // Add more currencies here

    private static final Map<String, Currency> currencyMap = new HashMap<>();

    static {
        for (Currency currency : Currency.values()) {
            currencyMap.put(currency.value, currency);
        }
    }

    private final String value;

    Currency(String value) {
        this.value = value;
    }

    public static Currency fromString(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }

        Currency currency = currencyMap.get(value.toUpperCase());
        if (currency == null) {
            throw new IllegalArgumentException("Invalid Currency value: " + value);
        }

        return currency;
    }
}
