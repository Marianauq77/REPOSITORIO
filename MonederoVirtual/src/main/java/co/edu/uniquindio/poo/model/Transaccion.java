package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public abstract class Transaccion {
    private final String codigo;
    private final LocalDate fecha;
    private final double monto;
    private  boolean atipica;
    private EstadoTransaccion estado;
    public Transaccion(String codigo, LocalDate fecha, double monto) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.monto = monto;
        this.estado= EstadoTransaccion.COMPLETADA;
    }

    public String getCodigo() {
        return codigo;
    } //metodos generales

    public LocalDate getFecha() {
        return fecha;
    }

    public double getMonto() {
        return monto;
    }

    public EstadoTransaccion getEstado() {
        return estado;
    }

    public void setEstado(EstadoTransaccion estado) {
        this.estado = estado;
    }

    public boolean esAtipica() {
        return atipica;
    }

    public void setAtipica(boolean atipica) {
        this.atipica = atipica;
    }

    public abstract void aplicar();
    public abstract int calcularPuntos(); //Los metodos abstractos no tienen cuerpo porque cada subclase los ejerce segun la necesidad
    public abstract void determinarAtipica();
}
