package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class OrdenServicio {
    private final String codigo;
    private final LocalDate fechaCreacion;
    private final Cliente cliente;
    private final ArrayList<DetalleServicio> listaDetalles=new ArrayList<>();
    private EstadoOrden estado;

    public OrdenServicio(String codigo, LocalDate fechaCreacion, Cliente cliente) {
        this.codigo = codigo;
        this.fechaCreacion = fechaCreacion;
        this.cliente = cliente;
    }

    public String getCodigo() {
        return codigo;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<DetalleServicio> getListaDetalles() {
        return listaDetalles;
    }

    public EstadoOrden getEstado() {
        return estado;
    }

    public void setEstado(EstadoOrden estado) {
        this.estado = estado;
    }
    public void agregarDetalle (DetalleServicio detalleServicio){

    }
    public void calcularvalorTotalOrden(){

    }
    public void finalizar(){}


}
