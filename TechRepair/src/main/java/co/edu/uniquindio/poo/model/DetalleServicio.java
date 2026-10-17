package co.edu.uniquindio.poo.model;

public class DetalleServicio {
    private final String codigo;
    private final Equipo equipo;
    private final Servicio servicio;
    private final Tecnico tecnicoAsignado;
    private final String observaciones;
    private EstadoIntervencion estadoIntervencion;
    private final TechRepair ownedByTechRepair;

    public DetalleServicio(String codigo, Equipo equipo, Servicio servicio, Tecnico tecnicoAsignado, String observaciones, TechRepair ownedByTechRepair, EstadoIntervencion estado) {
        this.codigo = codigo;
        this.equipo = equipo;
        this.servicio = servicio;
        this.tecnicoAsignado = tecnicoAsignado;
        this.observaciones = observaciones;
        this.ownedByTechRepair = ownedByTechRepair;
        this.estadoIntervencion = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public Tecnico getTecnicoAsignado() {
        return tecnicoAsignado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public EstadoIntervencion getEstado() {
        return estadoIntervencion;
    }

    public void setEstado(EstadoIntervencion estado) {
        this.estadoIntervencion = estado;
    }
    public void asignarTecnico(){

    }
    public void agregarRepuesto(){

    }
    public void calcularValorTotalDetalle(){

    }
    public void actualizarEstadoIntervencion (){

    }

}
