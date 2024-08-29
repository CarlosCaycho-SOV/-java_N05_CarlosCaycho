
package actividad3;

import javax.swing.JOptionPane;

public class Main {
    
    
  public static void main(String[ ] args){
   
 int n1= Integer.parseInt(JOptionPane.showInputDialog("Digiti el primer numero:")); 
  int n2= Integer.parseInt(JOptionPane.showInputDialog("Digiti el segundo numero:")); 
         
  
  operacion sumas = new operacion();
  int suma = sumas.sumar(n1,n2);
  sumas.mostrarDatos(suma);
  
  
  
  }
    
}