package co.edu.uniquindio.poo.model;

public class EmpleadoPlanta extends Empleado {
    private String cargo;
    private int horasExtra;
    private float valorHoraExtra;
    private float auxilioTransporte;

    public EmpleadoPlanta(String nombre, String documento, int edad, float salarioBase, CategoriaEmpleado categoria, float descuentoSalud, float descuentoPension, String cargo, int horasExtra, float valorHoraExtra, float auxilioTransporte) {
        super(nombre, documento, edad, salarioBase, categoria, descuentoSalud, descuentoPension);
        if (horasExtra < 0) {
            throw new IllegalArgumentException("Las horas extra no pueden ser negativas.");
        }
        if (valorHoraExtra < 0) {
            throw new IllegalArgumentException("El valor de la hora extra no puede ser negativo.");
        }
        if (auxilioTransporte < 0) {
            throw new IllegalArgumentException("El auxilio de transporte no puede ser negativo.");
        }
        this.cargo = cargo;
        this.horasExtra = horasExtra;
        this.valorHoraExtra = valorHoraExtra;
        this.auxilioTransporte = auxilioTransporte;
    }

    @Override
    public String toString() {
        return "EmpleadoPlanta{" +
                super.toString()+ // llama al toString de los atributos que tienen todos los empleados en comun
                "cargo='" + cargo + '\n' +
                ", horasExtra=" + horasExtra +'\n' +
                ", valorHoraExtra=" + valorHoraExtra +'\n' +
                ", auxilioTransporte=" + auxilioTransporte +'\n' +
                '}';
    }

    @Override
    public float calcularSalarioBruto() {
        float resultado=salarioBase+this.calcularBonificacionCategoria()+(horasExtra*valorHoraExtra)+auxilioTransporte;
        return resultado;
    }
    public ResumenPago generarResumenPago(){
        ResumenPago resumenPago=new ResumenPago(documento,nombre, "Planta", this.calcularSalarioBruto(), this.calcularDescuentos(), this.calcularSalarioNeto());
        return resumenPago;
    }
}
