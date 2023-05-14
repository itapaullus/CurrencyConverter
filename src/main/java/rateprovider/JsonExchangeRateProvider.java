package rateprovider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import model.CurrencyPair;
import org.json.JSONObject;
import org.json.JSONArray;
import repository.CurrencyRateRepository;
import repository.InMemoryCurrencyRateRepository;

public class JsonExchangeRateProvider implements ExchangeRateProvider {
    private final String filename;
    private CurrencyRateRepository rates;

    public JsonExchangeRateProvider(String filename) {
        this.filename = filename;
        parseExchangeRates();
    }

    @Override
    public Double getRate(CurrencyPair pair) {
        return rates.getRate(pair);
    }

    @Override
    public Double getRate(String curFrom, String curTo) {
        return getRate(new CurrencyPair(curFrom, curTo));
    }

    private void parseExchangeRates() {
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get(filename));
            Map<CurrencyPair, Double> exchangeRates = new HashMap<>();
            JSONArray rates = new JSONArray(new String(jsonData));
            for (int i = 0; i < rates.length(); i++) {
                JSONObject rate = rates.getJSONObject(i);
                exchangeRates.put(new CurrencyPair(
                        rate.getString("curFrom"),
                        rate.getString("curTo")),
                        rate.getDouble("value"));
            }
            this.rates = new InMemoryCurrencyRateRepository(exchangeRates);
        } catch (IOException e) {
            throw new RuntimeException("Invalid path");
        }
    }
}
