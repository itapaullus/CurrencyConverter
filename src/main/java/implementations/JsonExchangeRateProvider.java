package implementations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import model.CurrencyPair;

import interfaces.ExchangeRateProvider;
import org.json.*;

public class JsonExchangeRateProvider implements ExchangeRateProvider {
    private final String filename;

    public JsonExchangeRateProvider(String filename) {
        this.filename = filename;
    }

    @Override
    public Map<CurrencyPair, Double> getExchangeRates() throws IOException {
        byte[] jsonData = Files.readAllBytes(Paths.get(filename));
        Map<CurrencyPair, Double> exchangeRates = new HashMap<>();
        JSONArray rates = new JSONArray(new String(jsonData));
        for (int i = 0; i < rates.length(); i++) {
            JSONObject rate = rates.getJSONObject(i);
            exchangeRates.put(new CurrencyPair(rate.getString("curFrom"),
                            rate.getString("curTo")),
                    rate.getDouble("value"));
        }
        return exchangeRates;
    }
}
