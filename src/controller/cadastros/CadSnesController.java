package controller.cadastros;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Games;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by alan on 14/11/16.
 */
public class CadSnesController implements Initializable {

    public TextField txtNomeJogo;
    public DatePicker dataLancamentoPicker;
    public TextArea txtAreaDescricao;
    public Button btnEscolheCapa;
    public Button btnCadastrar;
    public Button btnLimpar;
    public String imagem;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnCadastrar.setOnAction(event -> cadastrar());
        imagem = escolherCapa();
    }

    public String escolherCapa() {

        btnEscolheCapa.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image files", "*.png", "*.jpg");
            fileChooser.getExtensionFilters().add(extFilter);

            Stage stage = new Stage();
            File file = fileChooser.showOpenDialog(stage);
            imagem = file.getName();

            System.out.println(imagem);
        });

        return imagem;
    }

    public void cadastrar(){
        Games jogo = new Games();
        jogo.setConsole("SNES");
        jogo.setNameGame(txtNomeJogo.getText());
        jogo.setReleaseDate(String.valueOf(dataLancamentoPicker.getValue()));
        jogo.setDesc(txtAreaDescricao.getText());
        jogo.setImage(imagem);

        System.out.println(jogo);
    }
}
