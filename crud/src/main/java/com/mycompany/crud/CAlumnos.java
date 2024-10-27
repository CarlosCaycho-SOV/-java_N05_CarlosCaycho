
package com.mycompany.crud;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;





public class CAlumnos {
     int codigo;
     String nombreAlumnos;
     String apellidosAlumnos;
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreAlumnos() {
        return nombreAlumnos;
    }

    public void setNombreAlumnos(String nombreAlumnos) {
        this.nombreAlumnos = nombreAlumnos;
    }

    public String getApellidosAlumnos() {
        return apellidosAlumnos;
    }

    public void setApellidosAlumnos(String apellidosAlumnos) {
        this.apellidosAlumnos = apellidosAlumnos;
    }

    
        public void InsertarAlumno( JTextField paranNombres , JTextField paramApellidos) {
            
            setNombreAlumnos(paranNombres.getText());
            setApellidosAlumnos(paramApellidos.getText());
            
            CConexion objetocon = new CConexion();
            
            String consulta = "insert into alumnos (nombres , apellidos) values (?,?);";
            
            try {
                CallableStatement cs = objetocon.EstablecerConexion().prepareCall(consulta);
                cs.setString(1, nombreAlumnos);
                cs.setString(2, apellidosAlumnos);
                cs.execute();
                JOptionPane.showMessageDialog(null, "Alumno insertado Correctamente");
            } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "Alumno No insertado Correctamente , Error: " + e);
            }
        }
    
        
        public void MostrarAlumnos (JTable paramMostrar){
            
            CConexion con = new CConexion();
            
            DefaultTableModel modelo = new DefaultTableModel();
            
            TableRowSorter<DefaultTableModel> Ordenar = new TableRowSorter<DefaultTableModel>(modelo);

            paramMostrar.setRowSorter(Ordenar);
            
            String sql = "";
            
            modelo.addColumn("Id");
            modelo.addColumn("Nombre");
            modelo.addColumn("Alumno");
            
            paramMostrar.setModel(modelo);
            
            sql = "select * from alumnos;";
            
            
            String[] datos = new String[3];
            Statement st;
            try {
             st = con.EstablecerConexion().createStatement();
             ResultSet rs = st.executeQuery(sql);
             
                while (rs.next()) {                    
                    
                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(2);
                    datos[2] = rs.getString(3);
                    
                    modelo.addRow(datos);  
                }
                
                paramMostrar.setModel(modelo);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se pudo mostrar los Registros "+e);
                }

            
        }
        
        
         public void SelecionAlumno(JTable paramtabla , JTextField paramid , JTextField paramnombre , JTextField paramapellidos){
            
             
             
             try {
                 int fila = paramtabla.getSelectedRow();
                 
                 if (fila >= 0) {
                     
                     paramid.setText((paramtabla.getValueAt(fila, 0).toString()));
                     paramapellidos.setText((paramtabla.getValueAt(fila, 1).toString()));
                     paramnombre.setText((paramtabla.getValueAt(fila, 2).toString()));
                     
                 }
                 else{
                     JOptionPane.showMessageDialog(null, "EROR DE SELECCION DE FILA");
                 }
             } catch (Exception e) {
                   JOptionPane.showMessageDialog(null, "EROR DE SELECCION" + e);
             }
            }
        
         
         public void modificarAlumnos (JTextField paramcodigo , JTextField paramnombres , JTextField paramapellidos){
                    
             
             
             setCodigo(Integer.parseInt(paramcodigo.getText()));
             
             setNombreAlumnos(paramnombres.getText());
             
             setApellidosAlumnos(paramapellidos.getText());
             
             CConexion con = new CConexion();
             
             String  consulta = "update alumnos set alumnos.nombres= ? , alumnos.apellidos= ? where alumnos.id=?;";
        
             try {
                 CallableStatement cs = con.EstablecerConexion().prepareCall(consulta);
                 
                 cs.setString(1, getNombreAlumnos());
                 cs.setString(2, getApellidosAlumnos());
                 cs.setInt(3, getCodigo());
                 
                 cs.execute();
                 
                 JOptionPane.showMessageDialog(null, "Modificado");
             } catch (SQLException e) {
                  JOptionPane.showMessageDialog(null, "Error al modificar");
             }
         
         
         }
     
         
         public void EliminarAlumno(JTextField paramcodigo){
             
             setCodigo(Integer.parseInt(paramcodigo.getText()));
             
             CConexion con = new CConexion();
             
             String consulta = "delete from alumnos where alumnos.id=?;";
             
             try {
                 CallableStatement cs = con.EstablecerConexion().prepareCall(consulta);
                 cs.setInt(1,getCodigo());
                 cs.execute();
                 
                 JOptionPane.showMessageDialog(null , "Eliminado Correctamente");
                 
                 
             } catch (Exception e) {
                 JOptionPane.showMessageDialog(null , "NO Eliminado Correctamente");
                 
             }
         }
        
 }
 
      
 
 
               

        
  
        

