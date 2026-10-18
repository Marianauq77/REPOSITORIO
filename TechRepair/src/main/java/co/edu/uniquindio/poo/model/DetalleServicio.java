package co.edu.uniquindio.poo.model;

public class DetalleServicio {
    private final String codigo;
    private final Equipo equipo;
    private final Servicio servicio;
    private final Tecnico tecnicoAsignado;
    private final String observaciones;
    private EstadoIntervencion estadoIntervencion;
    private final EmpresaTechRepair ownedByEmpresaTechRepair;

    public DetalleServicio(String codigo, Equipo equipo, Servicio servicio, Tecnico tecnicoAsignado, String observaciones, EmpresaTechRepair ownedByEmpresaTechRepair, EstadoIntervencion estado) {
        this.codigo = codigo;
        this.equipo = equipo;
        this.servicio = servicio;
        this.tecnicoAsignado = tecnicoAsignado;
        this.observaciones = observaciones;
        this.ownedByEmpresaTechRepair = ownedByEmpresaTechRepair;
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

    @Override
    public String toString() {
        return "DetalleServicio{" + "\n"+
                "codigo='" + codigo + "\n"+
                "equipo=" + equipo.getCodigo() + "\n"+
                "marca del equipo=" + equipo.getMarca() + "\n"+
                "modelo del equipo=" + equipo.getModelo() + "\n"+
                "servicio=" + servicio.getCodigo()+ "\n"+
                "tecnicoAsignado=" + tecnicoAsignado.getNombre() + "\n"+
                "observaciones='" + observaciones + "\n"+
                "estadoIntervencion=" + estadoIntervencion.name() + "\n"+
                "valor=" + calcularValorTotalDetalle()+ "\n"+
                '}'+ "\n";
    }

    public void asignarTecnico(){

    }
    public void agregarRepuesto(){

    }
    public float calcularValorTotalDetalle(){
        return 0f;
    }
    public void actualizarEstadoIntervencion (){

    }

}
