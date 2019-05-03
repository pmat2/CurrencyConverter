package pl.ml.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.ml.model.Currencies;

import java.io.IOException;
import java.net.URL;

/**
 * @author pmatusiak
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyService {
    private String api;

    public Currencies getCurrency(String baseCurrency) throws IOException {
        String finalURL = api;
        ObjectMapper mapper = new ObjectMapper();
        URL url = new URL(finalURL + baseCurrency);
        Currencies currencies = mapper.readValue(url, Currencies.class);
        return currencies;
    }
}
