
package BACKEND;


public class clsEstudiante {

    int clave;
    
    String nombre;
    String fecha;
    String correo;
    String direccion;
    int grado;
    String seccion;
    
    clsEstudiante ptrAbajo;
     clsEstudiante  ptrArriba;
   
    
    public clsEstudiante() {
        
        ptrAbajo = null;
        ptrArriba = null;
    }
    
}
