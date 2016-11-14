package controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Player;
import model.Util;
import view.CadastroJogos;
import view.ListaSnes;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class LoginController implements Initializable{

    public TextField textFieldLogin;
    public Button btnConfirmar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnConfirmar.setOnAction(event -> {

            Player player = new Player();
            boolean existePlayer;

            player.setUsername(textFieldLogin.getText());

            existePlayer = player.searchPlayer(player.getUsername());

            if(!existePlayer){
                if(player.getUsername().equals("adminmaster")){
                    //Chama tela de cadastro de jogos
                    CadastroJogos cadastroJogos = new CadastroJogos();
                    Stage stage = new Stage();
                    try {
                        cadastroJogos.start(stage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Criar novo usuário");
                    alert.setHeaderText("Deseja criar um novo usuário?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if(result.get() == ButtonType.OK){
                        player.createNewPlayer(player.getUsername());
                        System.out.println("Novo player criado!");

                        Alert info = new Alert(Alert.AlertType.INFORMATION);
                        info.setTitle("Novo usuário");
                        info.setHeaderText(null);
                        info.setContentText("Novo usuário criado");
                        info.showAndWait();
                        existePlayer = true;
                    }
                }
            }

            if(existePlayer){
                Util.modifyXML(player.getUsername());

                ListaSnes listaSnes = new ListaSnes();
                try {
                    Stage stage = new Stage();
                    //stage.setFullScreen(true);
//                    stage.setMaximized(true);
                    listaSnes.start(stage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
