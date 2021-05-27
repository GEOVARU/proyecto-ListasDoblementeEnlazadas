/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BACKEND;

/**
 *
 * @author geovanni
 */
public class clsListas {
    
    ///////*****************grado
    
    private clsGrado ptrInicio, ptrFinal;   
    //estudiante
      private clsEstudiante ptrInicioe, ptrFinale; 

    public clsListas() {
          ptrInicio = null;
          ptrFinal = null;
          //ESTUDIANTES
         ptrInicioe = null;
         ptrFinale = null;
    }
    
    public boolean ListaVacia(){
        boolean Resp = false;
        if(ptrInicio == null){
            Resp = true;
        }
        return Resp;
    } 
    
    public void Insertar(int pcodigo, String pseccion, String pgrado, int pnivel, String pprofesor){
        /*Creación del nodo*/
        clsGrado objGrado = new clsGrado();
        objGrado.codigo = pcodigo; 
        objGrado.seccion = pseccion; //DATOS
        objGrado.grado = pgrado;
        objGrado.nivel = pnivel;
        objGrado.profesor = pprofesor;
        
        objGrado.ptrAdelante = null;
        objGrado.ptrAtras = null;
        boolean Salir = false;
        
        if(ListaVacia()==true){  // Lista Vacia
            ptrInicio = objGrado;
            ptrFinal = objGrado;
        }else{  //La lista tiene registros 
            clsGrado ptrAuxSig = ptrInicio;
            clsGrado ptrAuxAnt = null;
        
            while(ptrAuxSig!= null  && Salir == false){
                
                if(ptrAuxSig.codigo < pcodigo && ptrAuxSig.codigo != pcodigo ){
                    ptrAuxAnt = ptrAuxSig;  //SACO COPIA
                    ptrAuxSig = ptrAuxSig.ptrAdelante;
                }else
                {
                    if(ptrAuxSig == ptrInicio){  //VALIDO SI ES EL INICIO DE LA LISTA
                         if( ptrAuxSig.codigo == pcodigo ){
                            System.out.println("DATO YA EXISTENTE");
                            Salir = true;
                        }else{
                        objGrado.ptrAdelante = ptrAuxSig;
                        ptrAuxSig.ptrAtras = objGrado;
                        ptrInicio = objGrado;
                        System.out.println("primer dato");
                        Salir = true;
                        
                         }
                        
                        
                    }else{
                        if( ptrAuxSig.codigo == pcodigo ){
                            System.out.println("DATO YA EXISTENTE");
                            Salir = true;
                        }else{
                            System.out.println("SOlo entra si ya hay registros y si son mayores, AQUI RETROCEDE");
                            objGrado.ptrAdelante = ptrAuxSig;
                            objGrado.ptrAtras = ptrAuxAnt;
                            ptrAuxAnt.ptrAdelante = objGrado;
                            ptrAuxSig.ptrAtras = objGrado;
                            Salir = true;
                        }
                    }
                }
            }  
            if(ptrAuxAnt==ptrFinal){  // El codigo del nodo es superior a todos los de la lista
                objGrado.ptrAtras = ptrAuxAnt;
                ptrAuxAnt.ptrAdelante = objGrado;
                ptrFinal = objGrado;
            }
        }    
     }
    
    public int ExtraerCola(){
        int Resp = 0;
     /*   if(!ListaVacia()){
            Resp = ptrInicio.Valor;
            if(ptrInicio == ptrFinal){
                ptrInicio = null;
                ptrFinal = null;
            }else{
                ptrInicio = ptrInicio.ptrSiguiente;
            }
        }
         */
        return Resp;
    }    
    
    public String Mostrar(){
        String Resp = "";
        String ES  = "";
        clsGrado objGrado = ptrInicio;
        //revisamos que haya por lo menos un dato en la lista
        while(objGrado!= null){
            //System.out.println(String.valueOf(objGrado.codigo));
            if(Resp.equals("")){
                Resp = String.valueOf(objGrado.codigo) + "-"+ String.valueOf(objGrado.seccion) + "-" +  String.valueOf(objGrado.grado)+ "-" +  String.valueOf(objGrado.nivel)+ "-" +  String.valueOf(objGrado.profesor) ;           
            }else{
           
                Resp = Resp + "     " + String.valueOf(objGrado.codigo) + "-"+ String.valueOf(objGrado.seccion) + "-" +  String.valueOf(objGrado.grado)+ "-" +  String.valueOf(objGrado.nivel)+ "-" +  String.valueOf(objGrado.profesor);
            }
            objGrado = objGrado.ptrAdelante;
           
        }
        return Resp;
    }
    
    
    public String MostrarInverso(){
        String Resp ="";
        clsGrado objGrado = ptrFinal;
        while(objGrado!= null){
            if(Resp.equals("")){
                Resp = String.valueOf(objGrado.codigo);           
            }else{
                Resp = Resp + ", " + String.valueOf(objGrado.codigo);
            }
            objGrado = objGrado.ptrAtras;
        }
        //System.out.println(Resp);
        return Resp;
    }
    
    
    //////////***************estudiante
    
    
    
    
    
    //estudiantes
  
    
  
    /** funciones **/
    public boolean ListaVaciae(){
        boolean Resp = false;
        if(ptrInicioe == null){
            Resp = true;
        }
        return Resp;
    } 
    public void Insertare(int pclave, String pnombre, String pfecha, String pcorreo, String pdireccion, int pgrado, String pseccion){
        
        
        /*Creación del nodo*/
        clsEstudiante objEstudiante = new clsEstudiante();
        objEstudiante.clave = pclave; 
        objEstudiante.nombre = pnombre; //DATOS
        objEstudiante.fecha = pfecha;
        objEstudiante.correo = pcorreo;
        objEstudiante.direccion = pdireccion;
        objEstudiante.grado = pgrado;
        objEstudiante.seccion = pseccion;
        //punteros
        objEstudiante.ptrArriba = null;
        objEstudiante.ptrAbajo = null;
        boolean Salir = false;
        //imprimir que valores vienen - tiene que venir los mismos valores
        //System.out.println(pclave);
        //System.out.println(objEstudiante.clave);
            if(ListaVaciae()==true){  // Lista Vacia estudiante
                ptrInicioe = objEstudiante;
                ptrFinale = objEstudiante;
            }else{  //La lista tiene registros 
                
                //estudiante
                clsEstudiante ptrAuxSig = ptrInicioe;
                clsEstudiante ptrAuxAnt = null;

                while(ptrAuxSig!= null  && Salir == false){
                    if(ptrAuxSig.clave < pclave && ptrAuxSig.clave != pclave ){
                    ptrAuxAnt = ptrAuxSig;  //SACO COPIA
                    ptrAuxSig = ptrAuxSig.ptrAbajo;
                    System.out.println("es mayor a todos");
                    
                    
                    }else{
                        if(ptrAuxSig == ptrInicioe){  //VALIDO SI ES EL INICIO DE LA LISTA
                            if( ptrAuxSig.clave == pclave ){
                                System.out.println("DATO YA EXISTENTE");
                                Salir = true;
                            }else{
                                objEstudiante.ptrAbajo = ptrAuxSig;
                                ptrAuxSig.ptrArriba = objEstudiante;
                                ptrInicioe = objEstudiante;
                                System.out.println("Es el menor de todos");
                                Salir = true;
                            }
                        }else{
                            if( ptrAuxSig.clave == pclave ){
                              System.out.println("DATO YA EXISTENTE");
                              Salir = true;
                            }else{
                                System.out.println("SOlo entra si ya hay registros y si son mayores, AQUI RETROCEDE");
                                objEstudiante.ptrAbajo = ptrAuxSig;
                                objEstudiante.ptrArriba = ptrAuxAnt;
                                ptrAuxAnt.ptrAbajo = objEstudiante;
                                ptrAuxSig.ptrArriba = objEstudiante;
                                Salir = true;
                               
                            }
                        }  
                    }
                }
                
                if(ptrAuxAnt==ptrFinale){  // El codigo del nodo es superior a todos los de la lista
                    objEstudiante.ptrArriba = ptrAuxAnt;
                    ptrAuxAnt.ptrAbajo = objEstudiante;
                    ptrFinale = objEstudiante;
            }    
        }
     }
    public int ExtraerColae(){
        int Resp = 0;
     /*   if(!ListaVacia()){
            Resp = ptrInicioe.Valor;
            if(ptrInicioe == ptrFinale){
                ptrInicioe = null;
                ptrFinale = null;
            }else{
                ptrInicioe = ptrInicioe.ptrSiguiente;
            }
        }
         */
        return Resp;
    }    
    public String MostrarInversoe(){
        String Resp ="";
        clsEstudiante objEstudiante = ptrFinale;
        while(objEstudiante!= null){
            if(Resp.equals("")){
                Resp = String.valueOf(objEstudiante.clave);           
            }else{
                Resp = Resp + ", " + String.valueOf(objEstudiante.clave);
            }
            objEstudiante = objEstudiante.ptrArriba;
        }
        return Resp;
    }
     public String Mostrare(){
        String Resp = "";
        String ES  = "";
        clsEstudiante objEstudiante = ptrInicioe;
        while(objEstudiante!= null){
            //System.out.println(String.valueOf(objEstudiante.codigo));
            if(Resp.equals("")){
                Resp = String.valueOf(objEstudiante.clave) + "-"+ String.valueOf(objEstudiante.nombre) + "-" +  String.valueOf(objEstudiante.fecha)+ "-" +  String.valueOf(objEstudiante.correo)+ "-" +  String.valueOf(objEstudiante.direccion)+ "-" +  String.valueOf(objEstudiante.grado)+ "-" +  String.valueOf(objEstudiante.seccion) ;           
            }else{
           
                Resp = Resp + "     " + String.valueOf(objEstudiante.clave) + "-"+ String.valueOf(objEstudiante.nombre) + "-" +  String.valueOf(objEstudiante.fecha)+ "-" +  String.valueOf(objEstudiante.correo)+ "-" +  String.valueOf(objEstudiante.direccion)+ "-" +  String.valueOf(objEstudiante.grado)+ "-" +  String.valueOf(objEstudiante.seccion);
            }
            objEstudiante = objEstudiante.ptrAbajo;
            
            System.out.println(Resp);
        }
        return Resp;
    }
     
    
     public String mostrarTodo(){
          String Resp = "";
            String Respe = "";
        String ES  = "";
        clsGrado objGrado = ptrInicio;
        //revisamos que haya por lo menos un dato en la lista
        while(objGrado!= null){
            //System.out.println(String.valueOf(objGrado.codigo));
            if(Resp.equals("")){
                Resp = String.valueOf(objGrado.codigo) + "-"+ String.valueOf(objGrado.seccion) + "-" +  String.valueOf(objGrado.grado)+ "-" +  String.valueOf(objGrado.nivel)+ "-" +  String.valueOf(objGrado.profesor) ;           
            }else{
           
                Resp = Resp + "     " + String.valueOf(objGrado.codigo) + "-"+ String.valueOf(objGrado.seccion) + "-" +  String.valueOf(objGrado.grado)+ "-" +  String.valueOf(objGrado.nivel)+ "-" +  String.valueOf(objGrado.profesor);
            }
            objGrado = objGrado.ptrAdelante;
               System.out.println(Resp);
        }
      
        clsEstudiante objEstudiante = ptrInicioe;
        while(objEstudiante!= null){
            //System.out.println(String.valueOf(objEstudiante.codigo));
            if(Respe.equals("")){
                Respe = String.valueOf(objEstudiante.clave) + "-"+ String.valueOf(objEstudiante.nombre) + "-" +  String.valueOf(objEstudiante.fecha)+ "-" +  String.valueOf(objEstudiante.correo)+ "-" +  String.valueOf(objEstudiante.direccion)+ "-" +  String.valueOf(objEstudiante.grado)+ "-" +  String.valueOf(objEstudiante.seccion) ;           
            }else{
           
                Respe = Respe + "     " + String.valueOf(objEstudiante.clave) + "-"+ String.valueOf(objEstudiante.nombre) + "-" +  String.valueOf(objEstudiante.fecha)+ "-" +  String.valueOf(objEstudiante.correo)+ "-" +  String.valueOf(objEstudiante.direccion)+ "-" +  String.valueOf(objEstudiante.grado)+ "-" +  String.valueOf(objEstudiante.seccion);
            }
            objEstudiante = objEstudiante.ptrAbajo;
            
            System.out.println(Respe);
        }
        return Respe + Resp;
    }
    
    
    
    
    
    
    
    
    
}
