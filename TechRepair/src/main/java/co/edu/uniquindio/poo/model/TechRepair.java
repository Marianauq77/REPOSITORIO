package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TechRepair {
    private final String nombreEmpresa;
    private final String nit;
    private final String telefono;
    private final String direccion;
    private final ArrayList<Cliente> clientes = new ArrayList<>();
    private final ArrayList<Tecnico> tecnicos = new ArrayList<>();
    private final ArrayList<OrdenServicio> ordenes = new ArrayList<>();
    private final ArrayList<Servicio> listaServicios = new ArrayList<>();

    public TechRepair(String nombreEmpresa, String nit, String telefono, String direccion) {
        this.nombreEmpresa = nombreEmpresa;
        this.nit = nit;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getNit() {
        return nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Tecnico> getTecnicos() {
        return tecnicos;
    }

    public ArrayList<OrdenServicio> getOrdenes() {
        return ordenes;
    }

    //CRUDS
    public String registrarCliente(Cliente cliente) {
        return "";
    }

    public Optional <Cliente> buscarClientePorDocumento(String documento) {
        return null;
    }
    public String registrarEquipo(String documento, Equipo equipo) {
        //tambien se añade al cliente
        return "";
    }
    public Optional <Equipo> buscarEquipoPorCodigo(String codigo) {
        return null;
    }

    public String registrarTecnico(Tecnico tecnico) {
        return "";
    }
    public Optional <Tecnico> buscarTecnicoPorDocumento(String documento) {
        return null;
    }

    public String generarOrdenServicio(String documentoCliente, OrdenServicio ordenservicio) {
        //Busca el cliente y si lo encuentra genera la orden y tambien lo agrega a cliente (ya esta el metodo en cliente)
        return "";
    }

    public String  agregarDetalleAOrden(String codigoOrden, DetalleServicio detalle) {
        //Busca el orden servicio y si lo encuentra le mete el detalle para que ella lo agregue (ya esta el metodo en la orden)
        return "";
    }

    public Optional<OrdenServicio> buscarOrdenPorCodigo(String codigoOrden) {
        return null;
}
    public String consultarEquiposPendientes() {
        return "";
    }
    public String GeneraReporteDeServicios(){
        return "";
    }
    public String GenerarReporteDeTecnicos(){
        return "";
    }
}

