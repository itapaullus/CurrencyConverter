package interfaces;

import java.io.IOException;

public interface CurrencyConverter {
    double convert (String curFrom, String curTo, Double Amount) throws IOException;
}
