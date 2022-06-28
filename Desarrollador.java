public class Desarrollador extends Personal{ // SUBCLASE DE PERSONAL 
    private String lenguaje;
    private int nivel;
    public Desarrollador(int dni, String nya, double horas, String lenguaje, int nivel){//CONSTRUCTOR DE LA CLASE DESARROLLADOR
       super (dni,nya,horas);
       this.lenguaje=lenguaje;
       this.nivel=nivel;
    }
    public void setLenguaje(String Lenguaje){
        this.lenguaje=lenguaje;
    }
    public void setNivel(int nivel){
        this.nivel=nivel;
    }
    public String getLenguaje(){
        return lenguaje;
    }
    public int getNivel(){
        return nivel;
    }
    public double calcularCosto(){
        double costo=0;
        switch (nivel){
            case 1: costo= (super.getHoras()*180); break;
            case 2: costo=(super.getHoras()*220); break;
            case 3: costo=(super.getHoras()*300); break;

        }return costo;
    }
    public void imprimir(){
        System.out.println("Nombre y apellido:"+ super.getNya());
        System.out.println("DNI: "+ super.getDni());
        System.out.println("Tipo: Desarrollador");
        System.out.println("Horas de Trabajo: "+ super.getHoras());
        System.out.println("Lenguaje de trabajo: "+ this.getLenguaje());
        System.out.println("Nivel de trabajo: "+ this.getNivel());
    }
}