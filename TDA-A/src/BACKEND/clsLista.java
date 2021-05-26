package BACKEND;


public class clsLista {
    private clsGrado ptrInicio, ptrFinal;   

    public clsLista() {
          ptrInicio = null;
          ptrFinal = null;
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
                        objGrado.ptrAdelante = ptrAuxSig;
                        ptrAuxSig.ptrAtras = objGrado;
                        ptrInicio = objGrado;
                         System.out.println("primer dato");
                        Salir = true;
                    }else{
                        if( ptrAuxSig.codigo == pcodigo ){
                            System.out.println("DATO YA EXISTENTE");
                            Salir = true;
                        }else{
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
              System.out.println(Resp);
        }
        System.out.println(Resp);
        return Resp;
    }
    
}
