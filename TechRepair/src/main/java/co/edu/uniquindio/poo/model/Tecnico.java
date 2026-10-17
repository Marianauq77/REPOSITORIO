package co.edu.uniquindio.poo.model;

public class Tecnico {
    private final String codigo;
    private final String nombre;
    private final String documento;
    private Especialidad especialidad;
    private EstadoLaboral estadoLaboral;
    private final TechRepair ownedByTechRepair;

    public Tecnico(String codigo, String nombre, String documento, Especialidad especialidad, EstadoLaboral estadoLaboral, TechRepair ownedByTechRepair) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.documento = documento;
        this.especialidad = especialidad;
        this.estadoLaboral = estadoLaboral;
        this.ownedByTechRepair = ownedByTechRepair;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public EstadoLaboral getEstadoLaboral() {
        return estadoLaboral;
    }

    public void setEstadoLaboral(EstadoLaboral estadoLaboral) {
        this.estadoLaboral = estadoLaboral;
    }
    public boolean estaAutorizado(){
        return false;
    }
    public String consultarTrabajos() {
        return "";
    }

}
