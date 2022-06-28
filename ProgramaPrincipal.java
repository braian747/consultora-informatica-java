import java.util.Scanner;
public class ProgramaPrincipal
{
   public static void main (){
       Scanner sc=new Scanner(System.in);
       ConsultoraInformatica ci=new ConsultoraInformatica();
       String nombre;
       String fechaFin;
       String fechaInicio;
       String lider;
       double gastosOperativos;
       System.out.println("        CONSULTORA INFORMÁTICA - OPERACIONES");
       System.out.println("Ingrese 1 para crear un nuevo proyecto.");
       System.out.println("Ingrese 2 para modificar los datos de un proyecto.");
       System.out.println("Ingrese 3 agregar personal a un proyecto ya existente.");
       System.out.println("Ingrese 4 para imprimir la informacion de los participantes de un proyecto.");
       System.out.println("Ingrese 5 para calcular el costo de un proyecto.");
       System.out.println("Ingrese 6 para salir del programa. ");
       int indice= sc.nextInt();
       sc.nextLine();
       while (indice!=6){  // control para salir del menu 
           switch (indice){
               case 1 :   System.out.println("Ingrese los datos del Proyecto:");
                          System.out.println("Nombre: ");
                          nombre=sc.nextLine();
                          System.out.println("Fecha de inicio: ");
                          fechaInicio=sc.nextLine();
                          System.out.println("Fecha de Final: ");
                          fechaFin=sc.nextLine();
                          System.out.println("Lider a cargo: ");
                          lider=sc.nextLine();
                          System.out.println("Gastos operativos: ");
                          gastosOperativos=sc.nextDouble();
                          Proyecto p=new Proyecto( nombre,  fechaFin, fechaInicio, lider, gastosOperativos);
                          System.out.println("Ingrese los datos del personal que participa del proyecto:");
                          int i;//se usa para el corte del while de carga de personal
                          do{    // PARA FINALIZAR LA CARGA DE PERSONAL
                              System.out.println("NUEVO PERSONAL: ");                              
                              System.out.println("DNI: ");
                              int dni=sc.nextInt();
                              System.out.println("Nombre y Apellido: ");
                              sc.nextLine();
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
                              switch (tipo){ // seleccion tipo de empleado 
                                   case 1:  System.out.println("Lenguaje en el que se especializa: ");
                                            sc.nextLine();
                                            lenguaje=sc.nextLine();
                                            do{ // repite hasta que se ingrese un nivel valido
                                                System.out.println("Nivel(1/2/3): ");
                                                nivel=sc.nextInt();
                                                if(nivel!=1&&nivel!=2&&nivel!=3){ // aparece un mensaje en pantalla si el nivel es incorrecto
                                                     System.out.println("El nivel ingresado es incorrrecto.");
                                                }
                                            }while(nivel!=1&&nivel!=2&&nivel!=3);
                                            Personal d=new Desarrollador( dni,  nya,  horas,  lenguaje,  nivel);
                                            p.agregarPersonal(d);
                                            break;
                                   case 2:  Personal t=new Tester(dni,nya,horas);
                                            p.agregarPersonal(t);
                                            break;
                                   default: System.out.println("El tipo ingresado no es valido, vuelva a intentarlo:");
                                            break;        
                              }    
                            }while((tipo!=1) &&(tipo!=2)); 
                              System.out.println("Ingrese 1 para continuar la carga del personal. Para finalizar ingrese cualquier otro numero.");
                              i=sc.nextInt();
                          }while (i==1); // si el numero ingresado es diferente de 1 sale de la carga de personal
                          ci.agregarProyecto(p);//agrega el proyecto a la lista
                          break;
               case 2:    System.out.println("Ingrese el nombre del proyecto a buscar:");
                          nombre=sc.nextLine();
                          ci.recorrerLista(nombre,2);
                          break;
               case 3:    System.out.println("Ingrese el nombre del proyecto a buscar:");
                          nombre=sc.nextLine();
                          ci.recorrerLista(nombre,3);
                          break;
               case 4:    System.out.println("Ingrese el nombre del proyecto a buscar:");
                          nombre=sc.nextLine();
                          ci.recorrerLista(nombre,4);
                          break;
               case 5:    System.out.println("Ingrese el nombre del proyecto a buscar:");
                          nombre=sc.nextLine();
                          ci.recorrerLista(nombre,5); 
                          break;
               default :  System.out.println("La opción no es valida, intente nuevamente."); break;        
           }
            System.out.println("Ingrese 1 para crear un nuevo proyecto.");
            System.out.println("Ingrese 2 para modificar los datos de un proyecto.");
            System.out.println("Ingrese 3 para agregar personal a un proyecto ya existente.");
            System.out.println("Ingrese 4 para imprimir la informacion de los participantes de un proyecto.");
            System.out.println("Ingrese 5 para calcular el costo de un proyecto.");
            System.out.println("Ingrese 6 para salir del programa. ");
            indice= sc.nextInt();
            sc.nextLine();
    }
    System.out.println("El programa se ha finalizado con éxito. ");
   }
}

