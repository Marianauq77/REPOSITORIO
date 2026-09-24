package co.edu.uniquindio.poo.model;

public class Nota {
    private String nombre;
    private float valor;

    //CONSTRUCTOR
    public Nota (String nombre, float valor){
    this.nombre=nombre;
    this.valor=valor;
    }
    // Devuelve el nombre
    public String getNombre(){
        return nombre;
    }
    //Actualiza el nombre
    public void setNombre (String nombre){
        this.nombre= nombre;
}

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "nombre='" + nombre + '\'' +
                ", valor=" + valor +
                '}';
    }
}
