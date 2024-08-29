
package actividad5;

public class alumno {
    String nombre;
    String apellido;
    
    public alumno(String _nombre , String _apellido ){
    
            nombre = _nombre;
            apellido = _apellido;
           
    }
    
    
    public void mostrarDatos(){
        System.out.println("su nombre es "+ nombre);
        System.out.println("su apellido es "+ apellido);
    }
    
    
}
