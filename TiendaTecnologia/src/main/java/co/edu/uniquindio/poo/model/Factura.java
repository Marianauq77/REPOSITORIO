package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public record Factura(String codigo, LocalDate fecha, double total,
                      EstadoFactura estadoFactura, MetodoPago metodoPago, Cliente cliente,
                      ArrayList<DetalleFactura> listaDetallesFactura, Tienda ownedByTienda) {
    // CONSTRUCTOR SECUNDARIO: No pide la lista al crear la Factura
    public Factura(String codigo, LocalDate fecha, double total,
                   EstadoFactura estadoFactura, MetodoPago metodoPago,
                   Cliente cliente, Tienda ownedByTienda) {
        // Redirige al constructor principal pasando 'new ArrayList<>()' automáticamente
        this(codigo, fecha, total, estadoFactura, metodoPago, cliente, new ArrayList<>(), ownedByTienda);
    }

    public void agregarDetalleFactura(DetalleFactura detalleFactura) { //lo que haria desde el main es crea la factura, en la tienda la busca y si no la encuentra la añade y desde alli  crea  y agrega el detalle factura
        this.listaDetallesFactura.add(detalleFactura);
    }

    public void eliminarDetalleFactura(DetalleFactura detalleFactura) {
        listaDetallesFactura.remove(detalleFactura);
    }

    public Optional<DetalleFactura> buscarDetalle(String codigoProducto) {
        return this.listaDetallesFactura.stream()
                .filter(d -> d.getProducto().getCodigo().equals(codigoProducto))
                .findFirst();
    }

    public boolean tieneClienteConR() {

        boolean resultado = false;
        resultado = cliente.verificarNombreConR();
        return resultado;

    }

    public boolean tieneProductoIphone16ProMax() {
        for (DetalleFactura aux : listaDetallesFactura) {
            if(aux.Verificar16ProMax())
                return true;
        }
        return false;
    }
    public boolean tieneClienteJuan() {

        boolean resultado = false;
        resultado = cliente.verificarNombreJuan();
        return resultado;

    }
}

