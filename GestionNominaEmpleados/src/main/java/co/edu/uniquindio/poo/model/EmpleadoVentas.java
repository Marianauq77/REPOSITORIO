package co.edu.uniquindio.poo.model;

public class EmpleadoVentas extends Empleado {
    private float totalVentas;
    private float porcentajeComision;

    public EmpleadoVentas(String nombre, String documento, int edad, float salarioBase, CategoriaEmpleado categoria, float descuentoSalud, float descuentoPension, float totalVentas, float porcentajeComision) {
        super(nombre, documento, edad, salarioBase, categoria, descuentoSalud, descuentoPension);
        if (porcentajeComision < 0 || porcentajeComision > 100) {
            throw new IllegalArgumentException("La comision no puede ser menor que o ni mayor que 100");
        }
            this.totalVentas = totalVentas;
            this.porcentajeComision = porcentajeComision;
        }

    @Override
    public String toString() {
        return "EmpleadoVentas{" +
                "totalVentas=" + totalVentas +
                ", porcentajeComision=" + porcentajeComision +
                '}';
    }

    @Override
        public float calcularSalarioBruto () {
            float resultado = salarioBase + this.calcularBonificacionCategoria() + (totalVentas * porcentajeComision /100f);
            return resultado;
        }
    public ResumenPago generarResumenPago(){
        ResumenPago resumenPago=new ResumenPago(documento, nombre, "Ventas", this.calcularSalarioBruto(), this.calcularDescuentos(), this.calcularSalarioNeto());
        return resumenPago;
    }
}
