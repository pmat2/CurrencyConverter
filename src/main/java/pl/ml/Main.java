package pl.ml;

import pl.ml.model.Currencies;
import pl.ml.service.CurrencyService;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author pmatusiak
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj walutę");

        String currencyBase = sc.nextLine();
        CurrencyService currencyService = new CurrencyService("https://api.exchangeratesapi.io/latest?base=");

        Currencies currencies = currencyService.getCurrency(currencyBase);

        System.out.println(currencies.getRates().toString());
        sc.close();
    }
}
