package co.edu.uniquindio.poo.model;


public class Habitacion {
    private byte numeroHabitacion;
    private String tipoHabitacion;   // Individual, Doble, Suite
    private byte piso;
    private byte capacidadMaxima;
    private double precioNoche;
    private String estado;           // Disponible, Reservada, Ocupada

    public Habitacion(byte numeroHabitacion, String tipoHabitacion, byte piso,
                      byte capacidadMaxima, double precioNoche, String estado) {
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.piso = piso;
        this.capacidadMaxima = capacidadMaxima;
        this.precioNoche = precioNoche;
        this.estado = estado;
    }

    public byte getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(byte numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public byte getPiso() {
        return piso;
    }

    public void setPiso(byte piso) {
        this.piso = piso;
    }

    public byte getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(byte capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "numeroHabitacion=" + numeroHabitacion +
                ", tipoHabitacion='" + tipoHabitacion + '\'' +
                ", piso=" + piso +
                ", capacidadMaxima=" + capacidadMaxima +
                ", precioNoche=" + precioNoche +
                ", estado='" + estado + '\'' +
                '}';
    }
    public boolean estaDisponible (){
        return estado.equalsIgnoreCase("Disponible");

    }
}
