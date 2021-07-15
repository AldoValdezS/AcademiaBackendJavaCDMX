package com.mycompany.gatosapp;


import java.io.IOException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author valde
 */
public class Main {
    public static void main(String[] args) throws IOException{
        int opcion_menu = -1;
        String[] botones = {"1. ver gatos", "2. Ver favoritos","3. Salir"};
        do {            
            String opcion =(String) JOptionPane.showInputDialog(null, "Gatitos Java", "Menú principal", JOptionPane.INFORMATION_MESSAGE,
                    null, botones, botones[0]);
            for (int i = 0; i < botones.length; i++) {
                if(opcion.equals(botones[i])){
                    opcion_menu=i;
                }
            }
            switch(opcion_menu){
                case 0:
                    GatosService.verGatos();
                    break;
                case 1:
                    Gatos gato = new Gatos();
                    
                    GatosService.verFavorito(gato.getApikey());
                    break;
               default:
                   break;
            }
           
        } while (opcion_menu !=2);
    }
}
