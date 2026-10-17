package co.edu.uniquindio.poo.model;

import java.util.ArrayList;

public class Tecnico {
    private final String codigo;
    private final String nombre;
    private final String documento;
    private Especialidad especialidad;
    private EstadoLaboral estadoLaboral;
    private ArrayList<DetalleServicio> listaDetallesAsigandos;
    private final EmpresaTechRepair ownedByEmpresaTechRepair;

    public Tecnico(String codigo, String nombre, String documento, Especialidad especialidad, EstadoLaboral estadoLaboral, EmpresaTechRepair ownedByEmpresaTechRepair) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.documento = documento;
        this.especialidad = especialidad;
        this.estadoLaboral = estadoLaboral;
        this.ownedByEmpresaTechRepair = ownedByEmpresaTechRepair;
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
    public boolean estaAutorizado(Especialidad especialidadRequerida){
        if(especialidad== especialidadRequerida || especialidad== Especialidad.SOPORTE_GENERAL){
            return true;
        }
        return false;
    }
    public void agregarDetalleAsignado(DetalleServicio detalle){
        listaDetallesAsigandos.add(detalle);
    }
    public int cantidadDetallesSignados(){
        int cantDetalles=listaDetallesAsigandos.size(); //size guarda un int
        return cantDetalles;
    }
    public String consultarTrabajos() {
        return "";
    }

}
