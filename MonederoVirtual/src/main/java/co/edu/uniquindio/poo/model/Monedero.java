package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Collections;

public class Monedero {
    private final String codigo;
    private final String nombre;
    private double saldo;
    private final TipoMonedero tipoMonedero;
    private ArrayList<Transaccion> listaTransacciones;
    private ArrayList<TransaccionProgramada> listaTransaccionesProgramadas;

    public Monedero(String codigo, String nombre, TipoMonedero tipoMonedero, double saldo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipoMonedero = tipoMonedero;
        this.saldo = saldo;
        this.listaTransacciones=new ArrayList<>();
        this.listaTransaccionesProgramadas=new ArrayList<>();

    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public TipoMonedero getTipo() {
        return tipoMonedero;
    }

    public ArrayList<Transaccion> getListaTransacciones() {
        return Collections.unmodifiableList(listaTransacciones);
    }

    public void setListaTransacciones(ArrayList<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }

    public ArrayList<TransaccionProgramada> getListaTransaccionesProgramadas() {
        return Collections.unmodifiableList(listaTransaccionesProgramadas);
    }

    public void setListaTransaccionesProgramadas(ArrayList<TransaccionProgramada> listaTransaccionesProgramadas) {
        this.listaTransaccionesProgramadas = listaTransaccionesProgramadas;
    }
}
