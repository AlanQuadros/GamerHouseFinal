package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import model.Games;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by alan on 10/11/16.
 */
public class ListaJogosSNESController implements Initializable{

    public ListView listView;
    public ImageView capaJogo;
    public Label txtData;
    public Label txtDescricao;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        listaJogosSnes();
    }

    public void listaJogosSnes(){

        ArrayList<Games> jogosSnes = new ArrayList<>();
        String local = "/home/alan/Downloads/JogosSNES/lista.txt";
        ObservableList listaJogos = FXCollections.observableArrayList();

        File pasta = new File(local);
        try {
            List<String> jogos = Files.readAllLines(Paths.get(local));

            for(int i = 0; i < jogos.size(); i+=3){
                if(i+3 < jogos.size()){
                    Games umJogo = new Games();
                    umJogo.setNameGame(jogos.get(i));

                    listaJogos.add(jogos.get(i));

                    umJogo.setDesc(jogos.get(i+1));
                    umJogo.setReleaseDate(jogos.get(i+2));
                    jogosSnes.add(umJogo);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

//        for (File game : pasta.listFiles()) {
//            Games umJogo = new Games();
//
//            if(game.getName().contains(".smc")) {
//                umJogo.setNameGame(game.getName().replace(".smc", ""));
//                umJogo.setImage(game.getName().replace(".smc", ".jpg"));
//                listaJogos.add(umJogo.getNameGame());
//
//                jogosSnes.add(umJogo);
//            }
//        }

        listView.setItems(listaJogos.sorted());

        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String imageName = String.valueOf(listView.getSelectionModel().getSelectedItems()).replace("[", "").replace("]", "");
//            System.out.println(listView.getSelectionModel().getSelectedItem());
            File img = null;
            String imagem;
            for (Games g : jogosSnes) {
                if(g.getNameGame().equals(imageName)){
                    imagem = "/home/alan/Downloads/JogosSNES/"+imageName+".jpg";
                    img = new File(imagem);
                    Image image = new Image(img.toURI().toString());
                    capaJogo.setImage(image);
                    txtData.setText("Lançamento: "+g.getReleaseDate());
                    txtDescricao.setText(g.getDesc());
                }
            }
        });

        listView.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.SPACE){
                System.out.println(listView.getSelectionModel().getSelectedItem());
                Games.execucao((String) listView.getSelectionModel().getSelectedItem());
            }
        });
    }
}
