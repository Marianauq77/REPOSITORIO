package co.edu.uniquindio.poo.model;

public abstract class Equipo {
    private final String codigo;
    private final String numeroSerie;
    private final String marca;
    private final String modelo;
    private final String añoFabricacion;
    private String descripcionEstadoFisico;

    public Equipo(String codigo, String numeroSerie, String marca, String modelo, String añoFabricacion, String descripcionEstadoFisico) {
        this.codigo = codigo;
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.modelo = modelo;
        this.añoFabricacion = añoFabricacion;
        this.descripcionEstadoFisico = descripcionEstadoFisico;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getAñoFabricacion() {
        return añoFabricacion;
    }

    public String getDescripcionEstadoFisico() {
        return descripcionEstadoFisico;
    }

    public void setDescripcionEstadoFisico(String descripcionEstadoFisico) {
        this.descripcionEstadoFisico = descripcionEstadoFisico;
    }
}
