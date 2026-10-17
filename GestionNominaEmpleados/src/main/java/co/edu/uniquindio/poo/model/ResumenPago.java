package co.edu.uniquindio.poo.model;

public record ResumenPago(String documento, String nombre, String tipoEmpleado, float salarioBruto, float descuentos, float salarioNeto){
    @Override
    public String toString() {
        return "ResumenPago{" +
                "documento='" + documento + '\'' +
                ", nombre='" + nombre + '\'' +
                ", tipoEmpleado='" + tipoEmpleado + '\'' +
                ", salarioBruto=" + salarioBruto +
                ", descuentos=" + descuentos +
                ", salarioNeto=" + salarioNeto +
                '}';
    }
}
