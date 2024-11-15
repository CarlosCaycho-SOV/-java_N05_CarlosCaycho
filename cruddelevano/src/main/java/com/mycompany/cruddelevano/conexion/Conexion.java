
package com.mycompany.cruddelevano.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
    
    Connection conectar = null;
    String usuario = "admin";
    String contraseña = "kuduroff12";
    String ip = "carlosdbs.c3eo2yqiuu2x.us-east-1.rds.amazonaws.com";
    String db = "banco_db";
    String puerto = "3306   ";
    
    String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + db;
    
    
    public Connection Establecerconexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena , usuario , contraseña);
           // JOptionPane.showMessageDialog(null ,"Conexion exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog( null ,"Error al conectar a la base de datos" + e.toString());
        }
        return conectar;
    }
            
}
