package co.edu.uniquindio.poo.model;

public record ResumenPago(String documento, String nombre, String tipoEmpleado, float salarioBruto, float descuentos, float salarioNeto){
    @Override
    public String toString() {
        return "ResumenPago{" +
                "documento='" + documento + '\n' +
                ", nombre='" + nombre + '\n' +
                ", tipoEmpleado='" + tipoEmpleado + '\'' +
                ", salarioBruto=" + salarioBruto +'\n' +
                ", descuentos=" + descuentos + '\n' +
                ", salarioNeto=" + salarioNeto + '\n' +
                '}';
    }
}
