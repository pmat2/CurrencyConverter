package pl.ml;

import pl.ml.service.CurrencyService;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author pmatusiak
 */
public class Main {



    private static DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Podaj walutę bazową");
        String baseCurrency = sc.nextLine();

        System.out.println("Podaj walutę kwotowaną");
        String quoteCurrency = sc.nextLine();

        System.out.println("Podaj ilość");
        double amount = sc.nextDouble();

        CurrencyService cs = new CurrencyService();

        System.out.println(amount + " " + baseCurrency + " to " + df.format(cs.getExchange(baseCurrency, quoteCurrency, amount)) + " " + quoteCurrency);

        sc.close();
    }
}
