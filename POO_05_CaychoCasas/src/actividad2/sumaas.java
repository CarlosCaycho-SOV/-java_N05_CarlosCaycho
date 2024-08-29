
package actividad2;
import javax.swing.JOptionPane;

public class sumaas {
   int numero1;
     int numero2;
      int sumar;
      public void leernumeros (){
          numero1=Integer.parseInt(JOptionPane.showInputDialog("DIGITE UN NUMERO:"));
          numero2=Integer.parseInt(JOptionPane.showInputDialog("DIGITE UN NUMERO:"));
      }
      
      public void SUMAR (){
          sumar = numero1+numero2;
      }
      
      
      public void mostrarDato(){
          System.out.println("la suma es: "+ sumar);
      } 
}
