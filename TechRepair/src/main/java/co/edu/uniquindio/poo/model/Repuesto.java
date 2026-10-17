package co.edu.uniquindio.poo.model;

public class Repuesto {
    private final String codigo;
    private final String nombre;
    private final String descripcion;
    private double precioUnitario;
    private int cantidadDisponible;
    private CategoriaCompatibilidad categoria;
    private final TechRepair ownedByTechRepair;

    public Repuesto(String codigo, String nombre, String descripcion, TechRepair ownedByTechRepair, CategoriaCompatibilidad categoria, int cantidadDisponible, double precioUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ownedByTechRepair = ownedByTechRepair;
        this.categoria = categoria;
        this.cantidadDisponible = cantidadDisponible;
        this.precioUnitario = precioUnitario;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public CategoriaCompatibilidad getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaCompatibilidad categoria) {
        this.categoria = categoria;
    }
    public boolean verificarDisponibilidad(){
        return false;
    }
    public void descontarUnidades(){}
}
