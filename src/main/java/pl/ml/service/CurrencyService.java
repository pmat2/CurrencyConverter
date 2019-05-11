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

    private Currencies getCurrency(String baseCurrency) throws IOException {
        String finalURL = api;
        ObjectMapper mapper = new ObjectMapper();
        URL url = new URL(finalURL + baseCurrency);
        return mapper.readValue(url, Currencies.class);
    }

    public double getExchange(String baseCurrency, String quoteCurrency, double amount) throws IOException {
        CurrencyService currencyService = new CurrencyService("https://api.exchangeratesapi.io/latest?base=");

        Currencies currencies = currencyService.getCurrency(baseCurrency);

        double rate = 0;

        switch (quoteCurrency) {
            case "BGN":
                rate = currencies.getRates().getBGN();
                break;
            case "NZD":
                rate = currencies.getRates().getNZD();
                break;
            case "ILS":
                rate = currencies.getRates().getILS();
                break;
            case "RUB":
                rate = currencies.getRates().getRUB();
                break;
            case "CAD":
                rate = currencies.getRates().getCAD();
                break;
            case "USD":
                rate = currencies.getRates().getUSD();
                break;
            case "PHP":
                rate = currencies.getRates().getPHP();
                break;
            case "CHF":
                rate = currencies.getRates().getCHF();
                break;
            case "AUD":
                rate = currencies.getRates().getAUD();
                break;
            case "JPY":
                rate = currencies.getRates().getJPY();
                break;
            case "TRY":
                rate = currencies.getRates().getTRY();
                break;
            case "HKD":
                rate = currencies.getRates().getHKD();
                break;
            case "MYR":
                rate = currencies.getRates().getMYR();
                break;
            case "HRK":
                rate = currencies.getRates().getHRK();
                break;
            case "CZK":
                rate = currencies.getRates().getCZK();
                break;
            case "IDR":
                rate = currencies.getRates().getIDR();
                break;
            case "DKK":
                rate = currencies.getRates().getDKK();
                break;
            case "NOK":
                rate = currencies.getRates().getNOK();
                break;
            case "HUF":
                rate = currencies.getRates().getHUF();
                break;
            case "GBP":
                rate = currencies.getRates().getGBP();
                break;
            case "MXN":
                rate = currencies.getRates().getMXN();
                break;
            case "THB":
                rate = currencies.getRates().getTHB();
                break;
            case "ISK":
                rate = currencies.getRates().getISK();
                break;
            case "ZAR":
                rate = currencies.getRates().getZAR();
                break;
            case "BRL":
                rate = currencies.getRates().getBRL();
                break;
            case "SGD":
                rate = currencies.getRates().getSGD();
                break;
            case "PLN":
                rate = currencies.getRates().getPLN();
                break;
            case "INR":
                rate = currencies.getRates().getINR();
                break;
            case "KRW":
                rate = currencies.getRates().getKRW();
                break;
            case "RON":
                rate = currencies.getRates().getRON();
                break;
            case "CNY":
                rate = currencies.getRates().getCNY();
                break;
            case "SEK":
                rate = currencies.getRates().getSEK();
                break;
            case "EUR":
                rate = currencies.getRates().getEUR();
                break;
            case "LVL":
                rate = currencies.getRates().getLVL();
                break;
            case "LTL":
                rate = currencies.getRates().getLTL();
                break;
            case "EEK":
                rate = currencies.getRates().getEEK();
                break;
        }
        return amount * rate;
    }
}
