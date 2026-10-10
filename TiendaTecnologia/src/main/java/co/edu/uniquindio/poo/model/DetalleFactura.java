package co.edu.uniquindio.poo.model;

public class DetalleFactura {
    private int cantidadComprada;
    private final Producto producto;
    private double subTotal;

    private Factura ownedByFactura;

    public DetalleFactura(Producto producto, int cantidadComprada, float subTotal, Factura ownedByFactura) {
        this.producto = producto;
        this.cantidadComprada = cantidadComprada;
        this.subTotal = subTotal;
        this.ownedByFactura = ownedByFactura;
    }

    public int getCantidadComprada() {
        return cantidadComprada;
    }

    public void setCantidadComprada(int cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    public Producto getProducto() {
        return producto;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public Factura getOwnedByFactura() {
        return ownedByFactura;
    }

    public void setOwnedByFactura(Factura ownedByFactura) {
        this.ownedByFactura = ownedByFactura;
    }

    public double calcularSubTotal(){
        subTotal= cantidadComprada*getProducto().getValor();
        return subTotal;
    }
    public boolean Verificar16ProMax(){
        return producto.getNombre().equalsIgnoreCase("Iphone 16 Pro Max");
    }
}
