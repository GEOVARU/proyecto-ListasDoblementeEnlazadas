
package BACKEND;


public class clsGrado {

        int codigo;
        String seccion;
        String grado;
        int nivel;
        String profesor;
        clsGrado ptrAdelante;
        clsGrado ptrAtras;
        
    public clsGrado() {
        ptrAdelante = null;
        ptrAtras = null;
    }
    
}
