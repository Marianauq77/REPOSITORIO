package co.edu.uniquindio.poo.model;

import java.util.Collections;
import java.util.List;

public class Cliente {
    private final String documentoIdentidad;
    private String nombreCompleto;
    private final String telefono;
    private final String correo;
    private final String ciudadResidencia;
    private final Tienda ownedByTienda;

    private final List<Factura> listaFacturas;

    public Cliente(String documentoIdentidad, String telefono, String correo, String ciudadResidencia, Tienda ownedByTienda, List<Factura> listaFacturas, String nombreCompleto) {
        this.documentoIdentidad = documentoIdentidad;
        this.telefono = telefono;
        this.correo = correo;
        this.ciudadResidencia = ciudadResidencia;
        this.ownedByTienda = ownedByTienda;
        this.listaFacturas = listaFacturas;
        this.nombreCompleto = nombreCompleto;
    }


    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public Tienda getOwnedByTienda() {
        return ownedByTienda;
    }

    public List<Factura> getListaFacturas() {
        return Collections.unmodifiableList(listaFacturas);
    }

    public boolean verificarNombreConR() {
        return nombreCompleto.startsWith("R");
    }
    public boolean verificarNombreJuan() {
        return nombreCompleto.toLowerCase().contains("juan"); // Se usa el contains por si lleva apellido o segundo nombre
    }

}

