public abstract class Personal {  // SUPER CLASE 
   private int dni;
   private String nya;   //nombre y apellido
   private double horas;  //cantidad de horas trabajadas
   public Personal(int dni, String nya,double horas){//CONSTRUCTOR DE LA CLASE PERSONAL
        this.dni=dni;
        this.nya=nya;
        this.horas=horas;
   }
   public void setDni(int dni){
        this.dni=dni;
   }
   public void setNya(String nya){
        this.nya=nya;
   }
   public void setHoras(double horas){
        this.horas=horas;
   }
   public int getDni(){
       return dni;
    }
   public String getNya(){
       return nya;
   }
   public double getHoras(){
       return horas;
   }
   public abstract double calcularCosto(); // METODO ABSTRACTO QUE EJECUTAN LAS SUBCLASES
   public abstract void imprimir();// METODO ABSTRACTO QUE EJECUTAN LAS SUBCLASES
}
    
   
  

   

