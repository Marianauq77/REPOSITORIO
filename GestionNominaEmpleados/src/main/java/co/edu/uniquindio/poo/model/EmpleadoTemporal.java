package co.edu.uniquindio.poo.model;

public class EmpleadoTemporal extends Empleado{
    private int diasTrabajados;
    private float valorDia;

    public EmpleadoTemporal(String nombre, String documento, int edad, float salarioBase, CategoriaEmpleado categoria, float descuentoSalud, float descuentoPension, int diasTrabajados, float valorDia) {
        super(nombre, documento, edad, salarioBase, categoria, descuentoSalud, descuentoPension);
        if (diasTrabajados<0) {
            throw new IllegalArgumentException("Los dias trabajados no pueden ser negativos"); //Despues del throw el codigo no se ejecuta
        }
        this.diasTrabajados = diasTrabajados;
        this.valorDia = valorDia;
    }

    @Override
    public String toString() {
        return "EmpleadoTemporal{" +
                super.toString()+
                "diasTrabajados=" + diasTrabajados + '\n' +
                ", valorDia=" + valorDia + '\n' +
                '}';
    }

    @Override
    public float calcularSalarioBruto() {
        float resultado=(diasTrabajados*valorDia)+this.calcularBonificacionCategoria();
        return resultado;
    }
    public ResumenPago generarResumenPago(){
        ResumenPago resumenPago=new ResumenPago(documento,nombre,"Temporal", this.calcularSalarioBruto(), this.calcularDescuentos(), this.calcularSalarioNeto());
        return resumenPago;
    }
}
