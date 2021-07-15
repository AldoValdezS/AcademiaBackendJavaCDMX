/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author valde
 */
public class Main {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int opcion=0;
        do {            
            System.out.println("---------------");
            System.out.println("Aplicacion de mensajes");
            System.out.println("1. Crear mensaje");
            System.out.println("2. Listar mensajes");
            System.out.println("3. Eliminar mensaje");
            System.out.println("4. Editar mensaje");
            System.out.println("5. Salir");
            
            //leer opcion del usuario
            opcion = sc.nextInt();
            switch(opcion){
                case 1:
                    MensajesService.crearMensaje();
                    break;
                case 2:
                    MensajesService.listarMensajesDB();
                    break;
                case 3:
                    MensajesService.borrarMensajeDB(opcion);
                    break;
                case 4:
                    MensajesService.actualizarMensajeDB();
                    break;
                default:
                    break;
            }
            
        } while (opcion!=5);
                      
    }
    
}
