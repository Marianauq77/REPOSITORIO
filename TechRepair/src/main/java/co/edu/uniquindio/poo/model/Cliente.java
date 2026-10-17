package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Optional;

public class Cliente {
    private final String documento;
    private  final String nombreCompleto;
    private String telefono;
    private final String correo;
    private String direccion;
    private ArrayList<Equipo> listaequipos= new ArrayList<>();
    private final TechRepair ownedByTechRepair;

    public Cliente(String documento, String nombreCompleto, String correo, TechRepair ownedByTechRepair,  String direccion, String telefono) {
        this.documento = documento;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.ownedByTechRepair = ownedByTechRepair;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getDocumento() {
        return documento;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }
    //CRUDS
    public String registrarEquipo(Equipo equipo) {
        return "";
    }
    public Optional<Equipo> buscarEquipo(String codigoEquipo) {
        return null;
    }
    public void agregarOrden(){

    }
    public String consultarOrdenes(){
        return "";
    }

}
