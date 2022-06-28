import java.util.Scanner;
public class Proyecto
{
   private String nombre;
   private String fechaFin;
   private String fechaInicio;
   private String lider;
   private double gastosOperativos;
   private Lista personal;
   Scanner sc=new Scanner(System.in);
   public Proyecto(String nombre, String fechaFin,String fechaInicio,String lider,double gastosOperativos){//CONSTRUCTOR DE LA CLASE PROYECTO
         this.nombre=nombre;
         this.fechaFin=fechaFin;
         this.fechaInicio=fechaInicio;
         this.lider=lider;
         this.gastosOperativos=gastosOperativos;
         personal=new Lista();
    }
   public Proyecto (String nombre ){//CONSTRUCTOR INVOCADO DESDE EL METODO "recorrerLista" DE LA CLASE CONSULTORAINFORMATICA
    this.nombre=nombre;
    }
   public void setNombre(String nombre){
       this.nombre=nombre;
    } 
   public void setFechaFin(String fechaFin){
       this.fechaFin=fechaFin;
    } 
   public void  setFechaInicio(String fechaInicio){
       this.fechaInicio= fechaInicio;
    }
   public void setLider(String lider){
       this.lider=lider;
    }
   public void setGastosOperativos(double gastos){
       this.gastosOperativos=gastos;
    }
   public String getNombre (){
       return nombre;
    }
   public String getFechaFin(){
       return fechaFin;
    }
   public String getFechaInicio(){
       return fechaInicio;
    }
   public String getLider(){
       return lider;
    }
   public double getGastosOperativos(){
       return gastosOperativos;
    }
   public void agregarPersonal(Personal p){
       this.personal.insertar(p);
    }
   public boolean equals (Object p){ //si el nombre del proyecto en la lista y del proyecto buscado son iguales devuelve verdadero                                 
       Proyecto p1=(Proyecto) p;
       return (this.nombre).equals(p1.getNombre());
   }
   public void modificarProyecto(){ 
      int t;
      boolean error;
      do {
       do { 
        error=false;
        System.out.println ("Ingrese 1 para modificar el nombre");
        System.out.println ("Ingrese 2 para modificar fecha de inicio");
        System.out.println ("Ingrese 3 para modificar fecha de fin");
        System.out.println ("Ingrese 4 para modificar el nombre del lider");
        System.out.println ("Ingrese 5 para modificar los gastos operativos");
        System.out.println ("Ingrese 6 para finalizar los cambios");
        t=sc.nextInt();
         switch (t){
            case 1: System.out.print("Ingrese el nuevo nombre:");
                    sc.nextLine();
                    nombre=sc.nextLine();
                    this.setNombre(nombre);
                    System.out.println("El nombre se ha modificado.");break;
            case 2: System.out.println("Ingrese la nueva fecha de inicio:");
                    sc.nextLine();
                    fechaInicio=sc.nextLine();
                    this.setFechaInicio(fechaInicio);
                    System.out.println("La fecha de inicio se ha modificado.");break;
            case 3: System.out.println("Ingrese la nueva fecha de fin:");
                    sc.nextLine();
                    fechaFin=sc.nextLine();
                    this.setFechaFin(fechaFin);
                    System.out.println("La fecha de fin se ha modificado.");break;
            case 4: System.out.println("Ingrese el nombre del nuevo lider:");
                    sc.nextLine();
                    lider=sc.nextLine();
                    this.setLider(lider);
                    System.out.println("El nombre del lider se ha modificado.");break;
            case 5: System.out.println("Ingrese el nuevo monto por gastos operativos:");
                    sc.nextLine();
                    gastosOperativos=sc.nextDouble();
                    this.setGastosOperativos(gastosOperativos);
                    System.out.println("El monto por gastos operativos se ha modificado.");break;
            case 6: System.out.println("Cambios finalizados.");break;//permite salir del switch y finalizar los cambios
                     default:error=true;
                    System.out.println("Opción incorrecta. Vuelva seleccionar una opción:");
        }
       }while (error==true );
    }while (t!=6);
    }
   public void agregarPersonal(){
    System.out.println("Ingrese los datos del nuevo personal del proyecto:");
    int i;//se usa para el corte del while de carga de personal
    do{    // PARA FINALIZAR LA CARGA DE PERSONAL
        System.out.println("NUEVO PERSONAL: ");                              
        System.out.println("DNI: ");
        int dni=sc.nextInt();
        sc.nextLine();
        System.out.println("Nombre y Apellido: ");
        String nya=sc.nextLine();
        System.out.println("Cantidad de horas trabajadas: ");
        double horas=sc.nextDouble();       
        int tipo;
        int nivel;
        String lenguaje;
        do{  //PARA VOLVER A PEDIR LOS DATOS SI SE INGRESA UNA OPCION NO VALIDA
            System.out.println("Ingrese 1 si el personal es desarrollador:"); 
            System.out.println("Ingrese 2 si el personal es tester:"); 
            tipo=sc.nextInt();
            switch (tipo){
                case 1: System.out.println("Lenguaje en el que se especializa: ");
                        lenguaje=sc.nextLine();
                        sc.nextLine();
                        System.out.println("Nivel(1/2/3): ");//falta repetir cuando el nivel es incorrecto
                        nivel=sc.nextInt();
                        Personal d=new Desarrollador( dni,  nya,  horas,  lenguaje,  nivel);
                        this.agregarPersonal(d);
                        break;
                case 2: Personal t=new Tester(dni,nya,horas);
                        this.agregarPersonal(t);
                        break;
                        default: System.out.println("El tipo ingresado no es valido, vuelva a intentarlo:");
                        break;        
            }    
        }while((tipo!=1) &&(tipo!=2));
        System.out.println("Ingrese 1 para continuar la carga del personal. Para finalizar ingrese cualquier otro numero.");
        i=sc.nextInt();
    }while (i==1);
    }
    public void imprimirPersonal(){
         this.personal.iniciarRecorrido();
         Personal p;
         System.out.println("LISTA DE PARTICIPANTES DEL PROYECTO:");
         while (!this.personal.llegueFinal()){
                p=(Personal)this.personal.elementoActual();
                p.imprimir();
                System.out.println("");//para separar la informacion de cada partcipante
                this.personal.siguiente();         
         }
    
    } 
    public void costoProyecto(){
          this.personal.iniciarRecorrido();
          double costo;double total=0;
          Personal p;
          while(!this.personal.llegueFinal()){
                p=(Personal)this.personal.elementoActual();
                costo=p.calcularCosto();
                total=total+costo;
                this.personal.siguiente();
          }
          total=total+this.getGastosOperativos();
          System.out.println ("El costo total del proyecto es: "+total);    
    }    
    
} 

