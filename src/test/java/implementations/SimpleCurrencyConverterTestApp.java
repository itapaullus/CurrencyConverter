import converter.SimpleCurrencyConverter;
import rateprovider.JsonExchangeRateProvider;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCurrencyConverterTestApp {
    private SimpleCurrencyConverter converter;

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws IOException {
        converter = new SimpleCurrencyConverter(new JsonExchangeRateProvider("src/main/resources/rates/rates.json"));
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        converter = null;
    }

    @org.junit.jupiter.api.Test
    void convert() {
        //test converting USD to RUR
        double result = converter.convert("USD", "RUR", 1000.);
        assertEquals(82510.,result, 0.01);
        //test converting RUR to USD
        result = converter.convert("RUR","USD",1000.);
        assertEquals(12.0,result,0.01);
        //test converting invalid pair
        assertThrows(IllegalArgumentException.class, () -> converter.convert("JPY", "RUR", 123.));
    }
}