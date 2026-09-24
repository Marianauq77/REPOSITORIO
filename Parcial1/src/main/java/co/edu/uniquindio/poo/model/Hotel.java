package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Hotel {
    private String nombreComercial;
    private String nit;
    private String direccion;
    private String telefono;
    private ArrayList<Huesped> listaHuespedes;
    private Habitacion[] habitaciones;
    private ArrayList<Reserva> reservas;
    private char [][] matrizOcupacion;

    public Hotel(String nombreComercial,String nit,String direccion,
                      String telefono, byte numHabitaciones, byte numReservas){
        this.nombreComercial=nombreComercial;
        this.nit=nit;
        this.direccion=direccion;
        this.telefono=telefono;
        this.listaHuespedes=new ArrayList<>();
        this.habitaciones=new Habitacion [numHabitaciones];
        this.reservas= new ArrayList<>();
        this.matrizOcupacion=new char[numHabitaciones][7];
    }
    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Huesped> getListaHuespedes() {
        return listaHuespedes;
    }

    public void setListaHuespedes(ArrayList<Huesped> listaHuespedes) {
        this.listaHuespedes = listaHuespedes;
    }

    public Habitacion[] getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(Habitacion[] habitaciones) {
        this.habitaciones = habitaciones;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }


    public char[][] getMatrizOcupacion() {
        return matrizOcupacion;
    }

    public void setMatrizOcupacion(char[][] matrizOcupacion) {
        this.matrizOcupacion = matrizOcupacion;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "nombreComercial='" + nombreComercial + '\'' +
                ", nit='" + nit + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", listaHuespedes=" + listaHuespedes +
                ", habitaciones=" + Arrays.toString(habitaciones) +
                ", reservas=" + reservas +
                ", matrizOcupacion=" + Arrays.toString(matrizOcupacion) +
                '}';
    }
    public void registrarHabitacion(byte numeroHabitacion, String tipoHabitacion, byte piso,
                              byte capacidadMaxima, double precioNoche, String estado,int pos){

        Habitacion habitacion = new Habitacion(numeroHabitacion, tipoHabitacion,piso,capacidadMaxima,precioNoche,
                estado);
        habitaciones[pos]=habitacion;
    }
    public String registrarHuesped(String nombre, String documento, byte edad, String telefono, String ciudad ){
        String mensaje = "";
        Huesped huespedNuevo = new Huesped(nombre, documento, edad, telefono, ciudad);
        listaHuespedes.add(huespedNuevo);
        mensaje= "Huesped registrado con exito";
        return mensaje;
    }
    public Huesped consultarHuespedPorTelefono (String telefono){
        for(Huesped aux : listaHuespedes){  // Le da la lista de huespedes y si encuentra uno con el telefono lo duevuelve
            if(aux.getTelefono().equals(telefono)){
                return aux;
            }
        }
        return null; // si retorna null es porque no encontro un huesped con ede telefono
    }
    public String registrarReserva(int codigo,String estado, String fecha, byte noches, byte cantHuespedes, Huesped huesped,
                                   String metodoPago, byte numHabitacion){
        if (huesped == null) {
            return "No se puede registrar la reserva: el huesped no existe";
        }

        Habitacion habitacionSeleccionada = null; // pone un espacio null
        for (Habitacion aux : habitaciones) {
            if (aux != null && aux.getNumeroHabitacion() == numHabitacion && aux.estaDisponible()) {
                habitacionSeleccionada = aux; // lo rrellena con la habitacion que eligió el huesped
                break;
            }
        }

        if (habitacionSeleccionada == null) {
            return "Esa habitacion no existe o no esta disponible";
        }

        Reserva reservaNueva = new Reserva(codigo, estado, fecha, noches, cantHuespedes, huesped, metodoPago);
        reservaNueva.agregarHabitacion(habitacionSeleccionada); // calcula el valorTotal y actualiza el estado de la habitacion

        reservas.add(reservaNueva); //añade la reserva a la lista de reservas del hotel
        huesped.agregarReserva(reservaNueva); // se pasa la MISMA reserva, no una nueva

        return "Reserva registrada con exito. Valor total: $" + reservaNueva.getValorTotal();
    }
    public Habitacion buscarHabitacionMayorPrecio() {
        Habitacion mayor = null;
        for (Habitacion aux : habitaciones) {
            if (aux != null && (mayor == null || aux.getPrecioNoche() > mayor.getPrecioNoche())) { //Puede ser null porque es la primera habitacion valida, entonces no hay con quien comparar
                mayor = aux;
            }
        }
        return mayor;
    }
    public Habitacion buscarHabitacionMenorPrecio() {
        Habitacion mayor = null;
        for (Habitacion aux : habitaciones) {
            if (aux != null && (mayor == null || aux.getPrecioNoche() > mayor.getPrecioNoche())) {
                mayor = aux;
            }
        }
        return mayor;
    }
    public int contarHabitacionesDisponibles() {
        int contador = 0;
        for (Habitacion aux : habitaciones) {
            if (aux!=null && aux.getEstado().equalsIgnoreCase("Disponible")) { // El aux accede a una habitacion
                contador++;
            }
        }
        return contador;
    }
    public int contarHabitacionesOcupadas() {
        int contador = 0;
        for (Habitacion aux : habitaciones) {
            if (aux!=null && aux.getEstado().equalsIgnoreCase("Ocupada")) { // El aux accede a una habitacion
                contador++;
            }
        }
        return contador;
    }
    public int contarHabitacionesMantenimiento() {
        int contador = 0;
        for (Habitacion aux : habitaciones) {
            if (aux!=null && aux.getEstado().equalsIgnoreCase("Mantenimiento")) { // El aux accede a una habitacion
                contador++;
            }
        }
        return contador;
    }

}
