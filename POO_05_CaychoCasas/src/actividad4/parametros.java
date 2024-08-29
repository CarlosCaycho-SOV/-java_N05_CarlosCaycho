
package actividad4;

public class parametros {
        int suma;
        int resta;
        
        
        public void sumar(int numero1 , int numero2){
            
            suma = numero1 + numero2;
            
        }
        
         public void restar(int numero1 , int numero2){
            
            resta = numero1 / numero2;
            
        }
         
         
         public void mostarDatos(){
             System.out.println("la suma es: "+ suma);
             System.out.println("la resta es: "+ resta);
             
         }
     
  
    
}
