
package com.mycompany.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;



public class CConexion {
  
   Connection conectar = null;
   String usuario = "root";
   String contraseña = "1";
   String db = "dbescuela";
   String ip = "localhost";
   String puerto = "33060";
   
   String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + db;
    
   
   public Connection EstablecerConexion (){
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           conectar = DriverManager.getConnection(cadena , usuario , contraseña);
          // JOptionPane.showMessageDialog(null , "Conexion exitosa");
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null , "Error al conectar a la base de datos"+ e);
       }
       return conectar;
   }
}
    

