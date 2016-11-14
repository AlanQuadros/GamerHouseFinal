package controller;

import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import view.cadastros.CadSnes;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by alan on 13/11/16.
 */
public class CadastroJogosController implements Initializable{

    public MenuItem menuSnes;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        menuSnes.setOnAction(event -> {
            CadSnes cadSnes = new CadSnes();
            Stage stage = new Stage();
            try {
                cadSnes.start(stage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
