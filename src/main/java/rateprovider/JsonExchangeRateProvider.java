package rateprovider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import model.CurrencyPair;
import org.json.JSONObject;
import org.json.JSONArray;

public class JsonExchangeRateProvider implements ExchangeRateProvider {
    private final String filename;
    private Map<CurrencyPair, Double> rates;

    public JsonExchangeRateProvider(String filename) {
        this.filename = filename;
        this.rates = new HashMap<>();
    }

    private Double getRate(CurrencyPair pair) throws NoRateException {
        Double result = rates.get(pair);
        if (result == null) {
            parseExchangeRates();
        }
        result = rates.get(pair);
        if (result == null) {
            throw new NoRateException("Currency pair "+pair.curFrom()+"/"+pair.curTo()+" doesn't exists");
        }
        else {
            return result;
        }
    }

    @Override
    public Double getRate(String curFrom, String curTo) throws NoRateException {
        return getRate(new CurrencyPair(curFrom, curTo));
    }

    private void parseExchangeRates() {
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get(filename));
            JSONArray jsonArray = new JSONArray(new String(jsonData));
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject rate = jsonArray.getJSONObject(i);
                String curFrom = rate.getString("curFrom");
                String curTo = rate.getString("curTo");
                rates.put(
                        new CurrencyPair(curFrom, curTo),
                        rate.getDouble("value"));
            }
        } catch (IOException e) {
            throw new RuntimeException("Invalid path");
        }
    }
}
