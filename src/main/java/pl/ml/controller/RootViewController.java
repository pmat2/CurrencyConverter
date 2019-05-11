package pl.ml.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import pl.ml.service.CurrencyService;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import static java.lang.Double.valueOf;

/**
 * @author pmatusiak
 */
public class RootViewController implements Initializable {
    @FXML
    public ComboBox<String> baseCurrency;

    @FXML
    public ComboBox<String> quoteCurrency;

    @FXML
    public Button convertButton;

    @FXML
    public Label message;

    @FXML
    public TextField amount;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        baseCurrency.getItems().addAll("AUD", "BGN", "BRL", "CAD", "CHF", "CNY",
                "CZK", "DKK", "EUR", "GBP", "HKD", "HRK", "HUF",
                "IDR", "ILS", "INR", "ISK", "JPY", "KRW", "LTL", "LVL", "MXN",
                "MYR", "NOK", "NZD", "PHP", "PLN", "RON", "RUB",
                "SEK", "SGD", "THB", "TRY", "USD", "ZAR");
        quoteCurrency.getItems().addAll("AUD", "BGN", "BRL", "CAD", "CHF", "CNY",
                "CZK", "DKK", "EUR", "GBP", "HKD", "HRK", "HUF",
                "IDR", "ILS", "INR", "ISK", "JPY", "KRW", "LTL", "LVL", "MXN",
                "MYR", "NOK", "NZD", "PHP", "PLN", "RON", "RUB",
                "SEK", "SGD", "THB", "TRY", "USD", "ZAR");
    }

    private static DecimalFormat df = new DecimalFormat("0.00");

    private CurrencyService cs = new CurrencyService();

    private String replaceIllegalCharacters() {
        String amountToConvert = amount.getText();
        String amountRefactored = null;
        if (amountToConvert.contains(",")) {
            amountRefactored = amountToConvert.replace(",", ".");
            amount.setText(amountRefactored);
        }
        return amountRefactored;
    }

    private boolean checkIfPositive() {
        return Double.valueOf(amount.getText()) > 0;
    }

    private void checkIfBaseCurrencySelected() {
        if (baseCurrency.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("No base currency selected!");
            alert.setHeaderText("Please chose corresponding base currency.");
            alert.showAndWait();
        }
    }

    private void checkIfQuoteCurrencySelected() {
        if (baseCurrency.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("No quote currency selected!");
            alert.setHeaderText("Please chose corresponding quote currency.");
            alert.showAndWait();
        }
    }

    public void convert() {
        checkIfBaseCurrencySelected();
        checkIfQuoteCurrencySelected();

        String amountToConvert = replaceIllegalCharacters();
        try {
            if (!checkIfPositive()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Wrong value");
                alert.setHeaderText("Please enter positive value.");
                alert.showAndWait();
            } else {
                double result = cs.getExchange(baseCurrency.getValue(),
                        quoteCurrency.getValue(),
                        valueOf(amountToConvert));

                message.setText(amountToConvert + " " +
                        baseCurrency.getValue() + " is worth " +
                        df.format(result) + " " +
                        quoteCurrency.getValue());
            }
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
            System.out.println("Złapany!");
        }
    }
}
