package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public abstract class Transaccion { //es como un molde para sus subclases y los obejtos se crean desde las sublcases
    private final String codigo;
    private final LocalDate fecha;
    private final double monto;

    public Transaccion(String codigo, LocalDate fecha, double monto) { //Las subclases heredan los atributos y metodos de la clase abstracta, pero pueden tener diferente información
        this.codigo = codigo;
        this.fecha = fecha;
        this.monto = monto;
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
    public abstract void aplicar();
    public abstract int calcularPuntos(); //Los metodos abstractos no tienen cuerpo porque cada subclase los ejerce segun la necesidad
}
