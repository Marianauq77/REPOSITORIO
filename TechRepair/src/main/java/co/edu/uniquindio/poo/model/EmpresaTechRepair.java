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
    private final ArrayList<OrdenServicio> listaOrdenes = new ArrayList<>();
    private final ArrayList<Servicio> listaServicios = new ArrayList<>();
    private final ArrayList<Repuesto> inventarioRepuestos = new ArrayList<>();

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
        return listaTecnicos;
    }

    public ArrayList<OrdenServicio> getOrdenes() {
        return listaOrdenes;
    }

    //CRUDS
    public String registrarCliente(Cliente cliente) {
        Optional<Cliente> clienteEncontrado = buscarClientePorDocumento(cliente.getDocumento());
        if (clienteEncontrado.isEmpty()) {
            listaClientes.add(cliente);
            return "El cliente ha sido registrado exitosamente";
        }
        return "No se pudo registrar, ya existe un cliente con esa informacion";
    }

    public Optional<Cliente> buscarClientePorDocumento(String documento) {
        return listaClientes.stream().filter(c -> documento.equals(c.getDocumento())).findFirst();
    }

    public String registrarEquipo(Cliente cliente, Equipo equipo) {
        Optional<Equipo> equipoEncontrado = buscarEquipoPorCodigo(equipo.getCodigo());
        if (equipoEncontrado.isEmpty()) {
            listaEquipos.add(equipo);
            cliente.registrarEquipo(equipo);
            return "Equipo registrado y asociado al cliente exitosamente";
        }
        return "Ya existe un equipo con esa información";
    }

    public Optional<Equipo> buscarEquipoPorCodigo(String codigo) {
        return listaEquipos.stream().filter(e -> codigo.equals(e.getCodigo())).findFirst();
    }

    public String registrarTecnico(Tecnico tecnico) {
        Optional<Tecnico> tecnicoEncontrado = buscarTecnicoPorDocumento(tecnico.getDocumento());
        if (tecnicoEncontrado.isEmpty()) {
            listaTecnicos.add(tecnico);
            return "El tecnico fue registrado exitosamente";
        }
        return "Ya existe un tecnico con esa informacion";
    }
    public Optional<Tecnico> buscarTecnicoAutorizado(Especialidad especialidadRequerida) {
        return listaTecnicos.stream().filter(t -> t.estaAutorizado(especialidadRequerida)).min(Comparator.comparingInt(Tecnico::cantidadDetallesSignados));
        //Primero filtra los que esten autorizados y asigna el que menos detalles asigandos tiene
    }
    public String asignarTecnicoADetalle(String codigoOrden, String codigoDetalle) {
        Optional<OrdenServicio> ordenEncontrada = buscarOrdenPorCodigo(codigoOrden);
        if (ordenEncontrada.isEmpty()) {
            return "No existe una orden con el código " + codigoOrden;
        }
        OrdenServicio orden= ordenEncontrada.get();

        Optional<DetalleServicio> detalleOpt = orden.buscarDetallePorCodigo(codigoDetalle);
        if (detalleOpt.isEmpty()) {
            return "No existe un detalle con el código " + codigoDetalle;
        }
        DetalleServicio detalle = detalleOpt.get();

        Especialidad especialidadRequerida = detalle.getEquipo().getEspecialidadRequerida();

        Optional<Tecnico> tecnicoAutorizado = buscarTecnicoAutorizado(especialidadRequerida);

        if (tecnicoAutorizado.isEmpty()) {
            return "Error: No hay ningún técnico activo y autorizado para atender la especialidad "
                    + especialidadRequerida;
        }

        Tecnico tecnico = tecnicoAutorizado.get();

        // Se añade el técnico al detalle y se añade a su lista de asignaciones
        detalle.setTecnico(tecnico);
        tecnico.agregarDetalleAsignado(detalle);

        return "Técnico " + tecnico.getNombre() + " (Doc: " + tecnico.getDocumento()
                + ") asignado exitosamente al detalle " + codigoDetalle;
    }

    public Optional<Tecnico> buscarTecnicoPorDocumento(String documento) {
        return listaTecnicos.stream().filter(t -> documento.equals(t.getDocumento())).findFirst();
    }

    public String generarOrdenServicio(String documentoCliente, OrdenServicio ordenservicio) {
        //Busca el cliente y si lo encuentra genera la orden y tambien lo agrega a cliente (ya esta el metodo en cliente)
        return "";
    }

    public String agregarDetalleAOrden(String codigoOrden, DetalleServicio detalle) {
        //Busca el orden servicio y si lo encuentra le mete el detalle para que ella lo agregue (ya esta el metodo en la orden)
        return "";
    }

    public Optional<OrdenServicio> buscarOrdenPorCodigo(String codigoOrden) {
        return null;
    }

    public String consultarEquiposPendientes() {
        String mensaje = "";
        ArrayList<Equipo> listaEquiposPendientesCompleta = new ArrayList<>();
        for (OrdenServicio o : listaOrdenes) {
            for (Equipo e : o.obtenerEquiposPendientes()) {
                listaEquiposPendientesCompleta.add(e);
            }
        }
        if (listaEquiposPendientesCompleta.isEmpty()) {
            return "No hay equipos sin finalizar";
        }
        for (Equipo e : listaEquiposPendientesCompleta) {
            mensaje += e.toString() + "\n";
        }
        return mensaje;
    }

    public String generarReporteServicios() {
        if(listaOrdenes.isEmpty()){
            return "Todavia no hay ordenes de servicio";
        }
        int contadorDiag = 0;
        int contadorMan = 0;
        int contadorRep = 0;
        double totalDiag = 0;
        double totalMan = 0;
        double totalRep = 0;

        for (OrdenServicio o : listaOrdenes) {
            for (DetalleServicio d : o.getListaDetalles()) {
                if (d.getServicio() instanceof Diagnostico) {
                    contadorDiag++;
                    totalDiag += d.calcularValorTotalDetalle();
                } else if (d.getServicio() instanceof MantenimientoPreventivo) {
                    contadorMan++;
                    totalMan += d.calcularValorTotalDetalle();
                } else if (d.getServicio() instanceof ReparacionCorrectiva) {
                    contadorRep++;
                    totalRep += d.calcularValorTotalDetalle();
                }

            }

        }
        return "Servicio por tipo:\n" +
                "Cantidad de servicios de tipo Diagnostico:" + contadorDiag + "\n" + "Total facturado:" + totalDiag + "\n" +
                "Cantidad de servicios de tipo Mantenimiento Preventivo:" + contadorMan + "\n" + "Total facturado:" + totalMan + "\n" +
                "Cantidad de servicios de tipo Reparaciones correctivas:" + contadorRep + "\n" + "Total facturado:" + totalRep + "\n";

    }
    public String generarReporteTecnicos(){
        if(listaTecnicos.isEmpty()){
            return "No hay tecnicos registrados";
        }
        String mensaje="";
        for(Tecnico t: listaTecnicos){
            mensaje+=t.getNombre()+":\n"+
                    "Cantidad de intervenciones finalizadas:"+ t.contarDetallesFinalizados()+"\n"+
                    "Valor de los servicios atendidos:"+ t.calcularTotalFinalizados()+"\n";

        }
        return mensaje;
    }public String consultarInvetarioCritico(){
        if(inventarioRepuestos.isEmpty()){
            return "Aun no hay repuestos en el inventario";
        }
        int umbralCritico=5;
        String mensaje="Lista de repuestos en cantidad critica:\n";
        for(Repuesto r: inventarioRepuestos){
            if(r.getCantidadDisponible()<= umbralCritico){
                mensaje+="Repuesto:"+r.getNombre()+"\n"+
                          "Codigo:"+ r.getCodigo()+"\n"+
                          "Cantidad:"+ r.getCantidadDisponible()+"\n";

            }
        }
        return mensaje;
    }
        public String GeneraReporteDeServicios () {
            return "";
        }
        public String GenerarReporteDeTecnicos () {
            return "";
        }
    }

