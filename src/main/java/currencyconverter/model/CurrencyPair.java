package currencyconverter.model;

import lombok.Data;

@Data
public class CurrencyPair {
    String curFrom;
    String curTo;

    public CurrencyPair(String curFrom, String curTo) {
        this.curFrom = curFrom;
        this.curTo = curTo;
    }
}
