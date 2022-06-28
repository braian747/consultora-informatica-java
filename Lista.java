public class Lista
{
    class Nodo 
    {
        private Object dato;
        private Nodo sig;
        
        public Nodo(Object dato)
        {
            this.dato = dato;
            this.sig = null;
        }

        public void dato(Object  objeto)
        {
            this.dato = objeto;
        }
        
        public void sig(Nodo nod) 
        {
            this.sig = nod;
        }
        
        public Object dato() 
        {
            return this.dato;
        }
    
        public Nodo sig() 
        {  
            return this.sig;
        }
    }
    
    private  Nodo pri;
    private  Nodo actual;
    private  int cantidad;
   
    public Lista () 
    {
        this.pri = null;
        this.actual = null;
        this.cantidad = 0;
    }
    
    public void insertar(Object  elemento) 
    {
        Nodo  nuevo = new Nodo(elemento);
        nuevo.sig(this.pri);
        this.pri = nuevo;
        this.cantidad = this.cantidad + 1;
    }
    
    public Object elementoActual()    
    {
        return this.actual.dato();        
    }
    
    public void iniciarRecorrido()  
    {
        this.actual =  this.pri;
    }

    public void siguiente() 
    {
        this.actual = this.actual.sig();
    }
    
    public  boolean  llegueFinal() 
    {
        return  (this.actual == null);
    }
 
    public  int cantidadElementos() 
    {
        return  this.cantidad;
    }   
}