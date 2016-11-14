package model;

import java.io.IOException;

/**
 * Created by alan on 08/11/16.
 */
public class Games {

    private String nameGame;
    private String image;
    private String desc;
    private String releaseDate;

    public Games() {
    }

    public String getNameGame() {
        return nameGame;
    }

    public void setNameGame(String nameGame) {
        this.nameGame = nameGame;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Games{" +
                "nameGame='" + nameGame + '\'' +
                ", image='" + image + '\'' +
                ", desc='" + desc + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }

    public static void execucao(String nameGame){
        String[] comando = {"snes9x-gtk", "/home/alan/Downloads/JogosSNES/"+nameGame+".smc"};
        System.out.println(comando);
        try {
            Runtime.getRuntime().exec(comando);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
