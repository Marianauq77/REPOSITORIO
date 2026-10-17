package co.edu.uniquindio.poo.model;

public class ComptadorEscritorio extends Equipo{
    private String procesador;
    private int ramGB;
    private int almacenamientoGB;
    private boolean graficaDedicada;

    public ComptadorEscritorio(String codigo, String numeroSerie, String marca, String modelo, String añoFabricacion, String descripcionEstadoFisico, String procesador, int ramGB, int almacenamientoGB, boolean graficaDedicada) {
        super(codigo, numeroSerie, marca, modelo, añoFabricacion, descripcionEstadoFisico);
        this.procesador = procesador;
        this.ramGB = ramGB;
        this.almacenamientoGB = almacenamientoGB;
        this.graficaDedicada = graficaDedicada;
    }
}
