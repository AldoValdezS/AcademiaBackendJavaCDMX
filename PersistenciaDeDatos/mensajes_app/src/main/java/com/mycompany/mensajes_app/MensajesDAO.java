/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author valde
 */
public class MensajesDAO {
    public static void crearMensaje(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.get_connection()){
            PreparedStatement ps = null;
            try {
                String query ="INSERT INTO `mensajes`(`mensaje`, `autor_mensaje`)"
                        + "VALUES (?,?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1,mensaje.getMensaje());
                ps.setString(2,mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("Mensaje creado");
                
            } catch (Exception e) {
                System.out.println("Falla al guardar mensaje");
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    public static void leerMensaje(){
        Conexion db_connect = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs =null;
        try (Connection conexion = db_connect.get_connection()){
            String query ="SELECT * FROM mensajes";
            ps=conexion.prepareStatement(query);
            rs =ps.executeQuery();
            while(rs.next()){
                System.out.println(
                        "ID: " + rs.getInt("id_mensaje")+
                        " Autor: "+rs.getString("autor_mensaje")+
                        " -> Mensaje: "+rs.getString("mensaje")+
                        " Fecha: "+rs.getString("fecha_mensaje"));
                System.out.println("");
            }
        } catch (SQLException e) {
            System.out.println("No se pudo obtener los mensajes");
            e.printStackTrace();
        }
        
    }
    public static void borrarMensajeDB(int id_mensaje){
        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.get_connection()){
            PreparedStatement ps =null;
            try {
                String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, id_mensaje);
                ps.executeUpdate();
                System.out.println("El mensaje con id "+id_mensaje+" ha sido borrado");
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.out.println("No se pudo borrar el mensaje");
            e.printStackTrace();
        }
        
    }
    public static void actualizarMensajesDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.get_connection()){
            PreparedStatement ps = null;
            try {
                String query ="UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getId_mensaje());
                ps.executeUpdate();
                System.out.println("Mensaje actualizado");
                
            } catch (SQLException e) {
                System.out.println("No se pudo editar el mensaje");
                e.printStackTrace();
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
