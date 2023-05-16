package repository;

import model.Currency;
import model.CurrencyPair;

public interface CurrencyRateRepository {
    double getRate(CurrencyPair pair) throws NoRateException;
}
