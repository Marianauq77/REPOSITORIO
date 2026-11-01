package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Optional;

public class Usuario {
    private final String documentoIdentidad;
    private final String nombreCompleto;
    private String telefono;
    private String correo;
    private Rango rango;
    private String contrasenia;
    private int puntosAcumulados;
    ArrayList<Monedero> listaMonederos;
    ArrayList<Notificacion> listaNotificaciones;
    public Usuario(String documentoIdentidad, String nombreCompleto, String telefono, String correo, String contrasenia) {
        this.documentoIdentidad = documentoIdentidad;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.correo = correo;
        this.contrasenia=contrasenia;
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

    public Rango getRango() {
        return rango;
    }

    public void setRango(Rango rango) {
        this.rango = rango;
    }

    public int getPuntosAcumulados() {
        return puntosAcumulados;
    }

    public void setPuntosAcumulados(short puntosAcumulados) {
        this.puntosAcumulados = puntosAcumulados;
    }

    public ArrayList<Monedero> getListaMonederos() {
        return listaMonederos;
    }

    public void setListaMonederos(ArrayList<Monedero> listaMonederos) {
        this.listaMonederos = listaMonederos;
    }

    public ArrayList<Notificacion> getListaNotificaciones() {
        return listaNotificaciones;
    }

    public void setListaNotificaciones(ArrayList<Notificacion> listaNotificaciones) {
        this.listaNotificaciones = listaNotificaciones;
    }
    public boolean verificarContraseña(String contrasenia){
        return contrasenia.equals(this.contrasenia);
    }
    public void agregarMonedero(Monedero monedero){
        listaMonederos.add(monedero);
    }
    public Optional<Monedero> buscarMonederoUsuario(String codigo){
        return listaMonederos.stream().filter(m -> codigo.equals(m.getCodigo())).findFirst();
    }
    public boolean detectarTransaccionesAtipicas(double monto){
        double suma=0;
        int contadorTransacciones=0;
        double promedio=0;
        for(Monedero m: listaMonederos){
            for(Transaccion t: m.getListaTransacciones()){
                contadorTransacciones++;
                suma+=t.getMonto();
            }
        }
        if(contadorTransacciones<=3){
            return false;
        }
        promedio= suma/contadorTransacciones;
        double desviacionEstandar=0;
        double valorMenosPromedio=0;

        for(Monedero m: listaMonederos){
            for(Transaccion t: m.getListaTransacciones()){
                valorMenosPromedio+= Math.pow(t.getMonto()-promedio, 2);
            }
        }
        desviacionEstandar= Math.sqrt(valorMenosPromedio/contadorTransacciones);
        double limite= promedio + 2*desviacionEstandar;
        if(monto>limite){
            return true;
        }
        return false;
    }
}

