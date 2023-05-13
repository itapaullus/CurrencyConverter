package repository;

import model.CurrencyPair;

public interface CurrencyRateRepository {
    double getRate(String curFrom, String CurTo);
    double getRate(CurrencyPair pair);
}
