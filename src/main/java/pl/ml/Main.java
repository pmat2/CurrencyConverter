package pl.ml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * @author pmatusiak
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/root.fxml"));
        loader.load();

        Parent root = loader.getRoot();
        primaryStage.getIcons().add(new Image("/currencyConverterIcon.png"));
        primaryStage.setTitle("Currency converter");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
