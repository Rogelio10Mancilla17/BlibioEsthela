/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.*;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Rogelio
 */
public class Conexion {

    public Connection Conectar() {
       Connection con = null;
        try{
        Statement sentencia;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection("jdbc:sqlserver://ROGELIO-PC:1433;databaseName=Libreria", "sa", "123");
        
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "No se a Conectado a la base de Datos "+e);
           System.exit(0);
       }
       return con; 
    }

}
