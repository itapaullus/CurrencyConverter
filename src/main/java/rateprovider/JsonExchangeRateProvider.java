package rateprovider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import model.Currency;
import model.CurrencyPair;
import org.json.JSONObject;
import org.json.JSONArray;
import repository.CurrencyRateRepository;
import repository.InMemoryCurrencyRateRepository;
import repository.NoRateException;

public class JsonExchangeRateProvider implements ExchangeRateProvider {
    private final String filename;
    private CurrencyRateRepository rates;

    public JsonExchangeRateProvider(String filename) {
        this.filename = filename;
        parseExchangeRates();
    }

    private Double getRate(CurrencyPair pair) throws NoRateException {
        return rates.getRate(pair);
    }

    @Override
    public Double getRate(Currency curFrom, Currency curTo) throws NoRateException {
        return getRate(new CurrencyPair(curFrom, curTo));
    }

    private void parseExchangeRates() {
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get(filename));
            Map<CurrencyPair, Double> exchangeRates = new HashMap<>();
            JSONArray rates = new JSONArray(new String(jsonData));
            for (int i = 0; i < rates.length(); i++) {
                JSONObject rate = rates.getJSONObject(i);
                Currency curFrom = Currency.fromString(rate.getString("curFrom"));
                Currency curTo = Currency.fromString(rate.getString("curTo"));
                exchangeRates.put(
                        new CurrencyPair(curFrom, curTo),
                        rate.getDouble("value"));
            }
            this.rates = new InMemoryCurrencyRateRepository(exchangeRates);
        } catch (IOException e) {
            throw new RuntimeException("Invalid path");
        }
    }
}
