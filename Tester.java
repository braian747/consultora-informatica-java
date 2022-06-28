public class Tester extends Personal // SUBCLASE DE PERSONAL
{
   public Tester(int dni, String nya, double horas){//CONSTRUCTOR DE LA CLASE TESTER
       super (dni,nya,horas);
   }
   public double calcularCosto(){
       return (super.getHoras()*100);
    }
   public void imprimir (){
       System.out.println("Nombre y apellido: "+ super.getNya());
       System.out.println("DNI: "+ super.getDni());
       System.out.println("Tipo: Tester");
       System.out.println("Horas de trabajo: "+ super.getHoras()); 
   } 
}
