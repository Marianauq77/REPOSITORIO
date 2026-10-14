package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Collections;

public class Cliente {
    private final String documentoIdentidad;
    private final String nombreCompleto;
    private String telefono;
    private String correo;
    private int puntosAcumulados;
    private Rango rango;
    private String contraseña;
    ArrayList<Monedero> listaMonederos;
    ArrayList<Notificacion> listaNotificaciones;
    public Cliente(String documentoIdentidad, String nombreCompleto, String telefono, String correo, String contraseña) {
        this.documentoIdentidad = documentoIdentidad;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.correo = correo;
        this.contraseña=contraseña;
        this.listaMonederos=new ArrayList<>();
        this.listaNotificaciones=new ArrayList<>();
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getPuntosAcumulados() {
        return puntosAcumulados;
    }

    public void setPuntosAcumulados(int puntosAcumulados) {
        this.puntosAcumulados = puntosAcumulados;
    }

    public Rango getRango() {
        return rango;
    }

    public void setRango(Rango rango) {
        this.rango = rango;
    }

    public ArrayList<Monedero> getListaMonederos() {
        return Collections.unmodifiableList(listaMonederos);
    }

    public void setListaMonederos(ArrayList<Monedero> listaMonederos) {
        this.listaMonederos = listaMonederos;
    }

    public ArrayList<Notificacion> getListaNotificaciones() {
        return Collections.unmodifiableList(listaNotificaciones);
    }

    public void setListaNotificaciones(ArrayList<Notificacion> listaNotificaciones) {
        this.listaNotificaciones = listaNotificaciones;
    }
    public boolean verificarContraseña(String contraseña){
        return contraseña.equals(this.contraseña);
    }
}
