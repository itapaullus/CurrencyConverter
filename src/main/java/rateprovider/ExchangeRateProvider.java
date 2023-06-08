package rateprovider;

import org.springframework.stereotype.Component;

@Component
public interface ExchangeRateProvider {
    Double getRate(String curFrom, String curTo) throws NoRateException;
}
