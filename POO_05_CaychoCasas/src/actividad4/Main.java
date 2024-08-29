
package actividad4;
import javax.swing.JOptionPane;
public class Main {

   
    public static void main(String[] args) {
      int n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero: "));
       int n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero: "));
       
       parametros op = new parametros();
       
       op.restar(n1,n2);
       op.sumar(n1,n2);
       op.mostarDatos();
       
    }
    
}
