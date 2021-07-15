/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajes_app;

import java.util.Scanner;

/**
 *
 * @author valde
 */
public class MensajesService {
    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribte tu mensaje: ");
        String mensaje = sc.nextLine();
        System.out.println("Tu nombre: ");
        String autor = sc.nextLine();
        // crear el objeto registro
        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(autor);
        //ir a la capa dao y ejecutar la funcion
        MensajesDAO.crearMensaje(registro);

    }
    public static void listarMensajesDB(){
        MensajesDAO.leerMensaje();
        
    }
    public static void borrarMensajeDB(int id_mensaje){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba el id del mensaje que desea borrar: ");
        int id = sc.nextInt();
        MensajesDAO.borrarMensajeDB(id);
        
    }
    
    public static void actualizarMensajeDB(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el mensaje nuevo: ");
        String mensaje = sc.nextLine();
        System.out.println("Ingrese el id del mensaje a actualizar: ");
        int id_mensaje = sc.nextInt();
        
        // crear el objeto tipo mensaje
        Mensajes actualizacion = new Mensajes();
        actualizacion.setId_mensaje(id_mensaje);
        actualizacion.setMensaje(mensaje);
        MensajesDAO.actualizarMensajesDB(actualizacion);
        
        
    }
    
}
