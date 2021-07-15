package com.mycompany.gatosapp;

import com.google.gson.Gson;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
public class GatosService {
    public static void verGatos() throws IOException{
        //traer datos de la api
        OkHttpClient client = new OkHttpClient();
                
        Request request = new Request.Builder().url("https://api.thecatapi.com/v1/images/search").get().build();
        
        Response response = client.newCall(request).execute();
        String elJson = response.body().string();
        //quitar los corchetes
        elJson= elJson.substring(1,elJson.length());
        elJson =elJson.substring(0,elJson.length()-1);
        //Crear un obejeto de la clase Gson
        Gson gson = new Gson();
        Gatos gatos = gson.fromJson(elJson, Gatos.class);
        //Redimensionar la imagen
        Image image = null;
        try {
            URL url = new URL(gatos.getUrl());
            image = ImageIO.read(url);
            ImageIcon fondoGato = new ImageIcon(image);
            if(fondoGato.getIconWidth()>800){
                Image fondo = fondoGato.getImage();
                Image modificada = fondo.getScaledInstance(800, 600, java.awt.Image.SCALE_SMOOTH);
                fondoGato = new ImageIcon(modificada);                                
            }
            
            String menu = "Opciones: \n"+
                    "1. Ver otra imagen\n"+
                    "2. Favorito\n"+
                    "3. Volver\n";
            String[] botones = {"1. Ver otra imagen","2. Favorito","3. Volver" };
            String id_gato = gatos.getId();
            String opcion = (String) JOptionPane.showInputDialog(null, menu, id_gato,JOptionPane.INFORMATION_MESSAGE,fondoGato, botones, botones[0]);
            int seleccion = -1;
            for (int i = 0; i < botones.length ; i++) {
                if(opcion.equals(botones[i])){
                    seleccion=i;                    
                }
            }
            switch(seleccion){
                case 0:
                    verGatos();
                    break;
                case 1:
                    favoritoGato(gatos);
                    break;
                default:
                    break;
            }
            
        } catch (IOException e) {
            System.out.println(e);
        }
                
        
    }
    
    public static void favoritoGato(Gatos gato){
        try {
            OkHttpClient client = new OkHttpClient();
              MediaType mediaType = MediaType.parse("application/json");
              RequestBody body = RequestBody.create(mediaType, "{\r\n    \"image_id\":\""+gato.getId()+"\"\r\n}");
              Request request = new Request.Builder()
                .url("https://api.thecatapi.com/v1/favourites")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("x-api-key", gato.getApikey())
                .build();
              Response response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }  
    }

    static void verFavorito(String api_key) throws IOException {
       
            OkHttpClient client = new OkHttpClient();
          Request request = new Request.Builder()
            .url("https://api.thecatapi.com/v1/favourites")
            .get()
            .addHeader("Content-type", "aplication/json")
            .addHeader("x-api-key",api_key)
            .build();
          Response response = client.newCall(request).execute();
          //guardar el string con la respuesta
          String elJson = response.body().string();
          //crear el objeto json
          Gson gson = new Gson();
          GatosFav[] gatosArray = gson.fromJson(elJson,GatosFav[].class);
          if(gatosArray.length > 0){
              int min =1;
              int max=gatosArray.length;
              int aleatorio = (int) (Math.random() * ((max-min)+1)) + min;
                int indice = aleatorio-1;
              GatosFav gatofav = gatosArray[indice];              
              
            Image image = null;
            try {
                URL url = new URL(gatofav.image.getUrl());
                image = ImageIO.read(url);
                ImageIcon fondoGato = new ImageIcon(image);
                if(fondoGato.getIconWidth()>800){
                    Image fondo = fondoGato.getImage();
                    Image modificada = fondo.getScaledInstance(800, 600, java.awt.Image.SCALE_SMOOTH);
                    fondoGato = new ImageIcon(modificada);                                
                }

                String menu = "Opciones: \n"+
                        "1. Ver otra imagen\n"+
                        "2. Eliminar favorito\n"+
                        "3. Volver\n";
                String[] botones = {"1. Ver otra imagen","2. Eliminar favorito","3. Volver" };
                String id_gato = gatofav.getId();
                String opcion = (String) JOptionPane.showInputDialog(null, menu, id_gato,JOptionPane.INFORMATION_MESSAGE,fondoGato, botones, botones[0]);
                int seleccion = -1;
                for (int i = 0; i < botones.length ; i++) {
                    if(opcion.equals(botones[i])){
                        seleccion=i;                    
                    }
                }
                switch(seleccion){
                    case 0:
                        verFavorito(api_key);
                        break;
                    case 1:
                        borrarFavorito(gatofav);
                        break;
                    default:
                        break;
                }

            } catch (IOException e) {
                System.out.println("Fallo al traer la imagen");
                System.out.println(e);
            }
          }
            
    }

    private static void borrarFavorito(GatosFav gatofav) {
        try {
            OkHttpClient client = new OkHttpClient();
          MediaType mediaType = MediaType.parse("text/plain");
          RequestBody body = RequestBody.create(mediaType, "");
          Request request = new Request.Builder()
            .url("https://api.thecatapi.com/v1/favourites/"+gatofav.id)
            .delete(null)
            .addHeader("x-api-key", "fb70ce42-c6b6-4ebe-a8bb-614ccc2e8f8e")
            .build();
          Response response = client.newCall(request).execute();
            
            
        } catch (Exception e) {
        }
        
    }
    
    
}
