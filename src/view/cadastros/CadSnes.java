package view.cadastros;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by alan on 14/11/16.
 */
public class CadSnes extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/CadSnes.fxml"));
        primaryStage.setTitle("Cadastro de Jogos de SNES");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
