public class ConsultoraInformatica{
    private Lista proyectos;
    public ConsultoraInformatica(){
        proyectos=new Lista();
    }
    public void agregarProyecto(Proyecto p){
        this.proyectos.insertar(p);
    }
    public void recorrerLista(String nombre, int n){ // RECIBE UN ENTERO DESDE EL PROGRAMA PRINCIPAL PARA LLAMAR AL METODO CORRESPONDIENTE
        Proyecto p=new Proyecto(nombre);
        proyectos.iniciarRecorrido();
        while (!proyectos.llegueFinal() && !(proyectos.elementoActual()).equals(p)){ // RECORRE LA LISTA DE PROYECTO 
            proyectos.siguiente();
        }
        if (!proyectos.llegueFinal()){ // SI ES DISTINTO DE NULL ENCONTRO EL PROYECTO BUSCADO
            switch (n){ 
            case 2: ((Proyecto)(proyectos.elementoActual())).modificarProyecto();break;
            case 3: ((Proyecto)(proyectos.elementoActual())).agregarPersonal();break;
            case 4: ((Proyecto)(proyectos.elementoActual())).imprimirPersonal();break;
            case 5: ((Proyecto)(proyectos.elementoActual())).costoProyecto();break;
           } 
        }
        else{ 
           System.out.println("El proyecto no existe");
        }
    }    
}

