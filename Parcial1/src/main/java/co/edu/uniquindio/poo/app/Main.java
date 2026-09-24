package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.Habitacion;
import co.edu.uniquindio.poo.model.Hotel;
import co.edu.uniquindio.poo.model.Huesped;

import javax.swing.*;

/**
 * @version 1.0
 * @autor:Mariana Suarez
 * @fecha:22/09/26
 */
public class Main {
    static void main() {
        //Datos quemados
        String nombreComercial = "StayPlus";
        String nit = "900.123.456-7";
        String direccion = "Carrera 1, Calle 2, Esquina, Bocagrande, Cartagena de Indias, Bolívar, Colombia.";
        String telefono = "605 7898";
        Hotel hotel = new Hotel(nombreComercial, nit, direccion, telefono, (byte) 12, (byte) 12);
        JOptionPane.showMessageDialog(null, "Bienvenidos al sistema de gestion de reservas StayPlus");
        hotel.registrarHabitacion((byte) 101, "Individual", (byte) 1, (byte) 1, 80000, "Disponible", 0);
        hotel.registrarHabitacion((byte) 102, "Doble", (byte) 1, (byte) 2, 120000, "Ocupada", 1);
        hotel.registrarHabitacion((byte) 201, "Suite", (byte) 2, (byte) 4, 250000, "Disponible", 2);
        hotel.registrarHabitacion((byte) 202, "Doble", (byte) 2, (byte) 2, 130000, "Mantenimiento", 3);
        hotel.registrarHabitacion((byte) 301, "Individual", (byte) 3, (byte) 1, 90000, "Disponible", 4);


        int opcion = 0;
        do {
            JOptionPane.showMessageDialog(null, "===MENÚ===\n");
            opcion = Integer.valueOf(JOptionPane.showInputDialog(null,
                    "Por favor seleccione una opcion :\n" +
                            "1. Registrar huesped\n" +
                            "2. Registrar reserva\n" +
                            "3. Consultar huésped\n" +
                            "4. Consultar disponibilidad\n" +
                            "5. Matriz de ocupación\n" +
                            "6. Reservas especiales \n" +
                            "7. Consultar ingresos\n" +
                            "0. Salir del programa\n"
            ));

            switch (opcion) {
                case 1:
                    registrarHuesped(hotel);
                    break;
                case 2:
                    registrarReserva(hotel);
                    break;
                case 3:
                    consultarHuespedPorTelefono(hotel);
                    break;
                case 4:
                    mostrarDisponibilidad(hotel);
                    break;
                case 5:
                    mostrarMatrizOcupacion(hotel);
                    break;
                case 6:
                    mostrarReservasEspeciales(hotel);
                    break;
                case 7:
                    consultarIngresos(hotel);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema StayPlus");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
            }
        } while (opcion != 0);
    }

    public static void registrarHuesped(Hotel hotel) {
        String nombre = JOptionPane.showInputDialog(null, "Nombre completo del huesped:");
        String documento = JOptionPane.showInputDialog(null, "Documento de identidad:");
        byte edad = Byte.parseByte(JOptionPane.showInputDialog(null, "Edad:"));
        String telefono = JOptionPane.showInputDialog(null, "Telefono:");
        String ciudad = JOptionPane.showInputDialog(null, "Ciudad de procedencia:");
        String resultado = hotel.registrarHuesped(nombre, documento, edad, telefono, ciudad);
        JOptionPane.showMessageDialog(null, resultado);
    }

    public static void registrarReserva(Hotel hotel) {
        String telefono = JOptionPane.showInputDialog(null, "Telefono del huesped que reserva:");
        Huesped huesped = hotel.consultarHuespedPorTelefono(telefono);
        if (huesped == null) {
            JOptionPane.showMessageDialog(null, "No existe un huesped con ese telefono. " +
                    "Registrelo primero (opcion 1).");
        }
        int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Codigo de reserva"));
        String estado = "Confirmada";
        String fecha = JOptionPane.showInputDialog(null, "Fecha de la reserva (dd/mm/aaaa):");
        byte noches = Byte.parseByte(JOptionPane.showInputDialog(null, "Numero de noches:"));
        byte cantHuespedes = Byte.parseByte(JOptionPane.showInputDialog(null, "Cantidad de huespedes:"));
        String metodoPago = JOptionPane.showInputDialog(null, "Metodo de pago" +
                " (Efectivo/Tarjeta/Transferencia):");
        byte numHabitacion = Byte.parseByte(JOptionPane.showInputDialog(null,
                "Numero de la habitacion a incluir:"));
        String resultado = hotel.registrarReserva(codigo, estado, fecha, noches, cantHuespedes, huesped,
                metodoPago, numHabitacion);
        JOptionPane.showMessageDialog(null, resultado);
    }

    public  static void consultarHuespedPorTelefono(Hotel hotel) {
        String telefono = JOptionPane.showInputDialog(null, "Telefono del huesped que reserva:");
        Huesped huesped = hotel.consultarHuespedPorTelefono(telefono);
        if (huesped == null) {
            JOptionPane.showMessageDialog(null, "No existe un huesped con ese telefono en el sistema. ");
        } else { // si se encuentra
            JOptionPane.showMessageDialog(null, huesped.toString());
        }
    }

    public static void mostrarDisponibilidad(Hotel hotel) {
        Habitacion mayor = hotel.buscarHabitacionMayorPrecio();
        Habitacion menor = hotel.buscarHabitacionMenorPrecio();

        String info = "Disponibles: " + hotel.contarHabitacionesDisponibles() +
                "\nOcupadas: " + hotel.contarHabitacionesOcupadas() +
                "\nEn mantenimiento: " + hotel.contarHabitacionesMantenimiento() +
                "\nMayor precio: " + (mayor != null ? mayor.toString() : "N/A") +
                "\nMenor precio: " + (menor != null ? menor.toString() : "N/A");
        JOptionPane.showMessageDialog(null, info);
    }
}


