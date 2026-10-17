package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class EmpresaTechRepair {
    private final String nombreEmpresa;
    private final String nit;
    private final String telefono;
    private final String direccion;
    private final ArrayList<Cliente> listaClientes = new ArrayList<>();
    private final ArrayList<Equipo> listaEquipos = new ArrayList<>();
    private final ArrayList<Tecnico> listaTecnicos = new ArrayList<>();
    private final ArrayList<OrdenServicio> ordenes = new ArrayList<>();
    private final ArrayList<Servicio> listaServicios = new ArrayList<>();

    public EmpresaTechRepair(String nombreEmpresa, String nit, String telefono, String direccion) {
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
        return listaClientes;
    }

    public ArrayList<Tecnico> getTecnicos() {
        return tecnicos;
    }

    public ArrayList<OrdenServicio> getOrdenes() {
        return ordenes;
    }

    //CRUDS
    public String registrarCliente(Cliente cliente) {
        Optional<Cliente>clienteEncontrado=buscarClientePorDocumento(cliente.getDocumento());
        if(clienteEncontrado.isEmpty()){
            listaClientes.add(cliente);
            return "El cliente ha sido registrado exitosamente";
        }
        return "No se pudo registrar, ya existe un cliente con esa informacion";
    }

    public Optional <Cliente> buscarClientePorDocumento(String documento) {
         return listaClientes.stream().filter(c-> documento.equals(c.getDocumento())).findFirst();
    }
    public String registrarEquipo(Cliente cliente, Equipo equipo) {
        Optional <Equipo> equipoEncontrado=buscarEquipoPorCodigo(equipo.getCodigo());
        if(equipoEncontrado.isEmpty()) {
            listaEquipos.add(equipo);
            cliente.registrarEquipo(equipo);
            return "Equipo registrado y asociado al cliente exitosamente";
        }
        return "Ya existe un equipo con esa información";
    }
    public Optional <Equipo> buscarEquipoPorCodigo(String codigo) {
        return listaEquipos.stream().filter(e -> codigo.equals(e.getCodigo())).findFirst();
    }

    public String registrarTecnico (Tecnico tecnico) {
        Optional <Tecnico> tecnicoEncontrado=buscarTecnicoPorDocumento(tecnico.getDocumento());
        if(tecnicoEncontrado.isEmpty()) {
            listaTecnicos.add(tecnico);
            return "El tecnico fue registrado exitosamente";
        }
        return "Ya existe un tecnico con esa informacion";
    }
    public Optional <Tecnico> buscarTecnicoPorDocumento(String documento) {
        return listaTecnicos.stream().filter(t-> documento.equals(t.getDocumento())).findFirst();
    }

    public String generarOrdenServicio(String documentoCliente, OrdenServicio ordenservicio) {
        //Busca el cliente y si lo encuentra genera la orden y tambien lo agrega a cliente (ya esta el metodo en cliente)
        return "";
    }

    public String  agregarDetalleAOrden(String codigoOrden, DetalleServicio detalle) {
        //Busca el orden servicio y si lo encuentra le mete el detalle para que ella lo agregue (ya esta el metodo en la orden)
        return "";
    }
    public Optional<Tecnico> buscarTecnicoAutorizado (Especialidad especialidadRequerida){
        return listaTecnicos.stream().filter(t -> t.estaAutorizado(especialidadRequerida)).min(Comparator.comparingInt(Tecnico::cantidadDetallesSignados));
        //Primero filtra los que esten autorizados y asigna el que menos detalles asigandos tiene
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

