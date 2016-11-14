/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alan
 */
public class Player {
    private String username;

    public Player() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean searchPlayer(String name){
        File pasta = new File("/home/alan/Downloads/Players");

        for (File player : pasta.listFiles()) {
            if(player.getName().equalsIgnoreCase(name)){
                System.out.println("Usuário " + name + " encontrado.");
                return true;
            }
        }

        return false;
    }

    public void createNewPlayer(String name){
        Runtime run = Runtime.getRuntime();
        String comando = "mkdir /home/alan/Downloads/Players/"+name;
        try {
            run.exec(comando);
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
