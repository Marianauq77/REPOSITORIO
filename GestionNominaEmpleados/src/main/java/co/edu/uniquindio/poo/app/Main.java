package co.edu.uniquindio.poo.app;


import co.edu.uniquindio.poo.model.*;

import javax.swing.*;

import java.util.Optional;

import static java.lang.Integer.parseInt;

public class Main {
    static void main() {
        Empresa empresa= new Empresa("Empresa", "KFH047393");

        int opcion=0;
        do {
            opcion = parseInt(JOptionPane.showInputDialog("Bienveido al Sistema de gestión de nómina de empleados\n" +
                            "Seleccione una opcion:\n" +
                            "===MENÚ==\n" +
                            "1.Agregar empleado de planta\n" +
                            "2.Agregar empleado de ventas\n" +
                            "3.Agregar empleado temporal\n" +
                            "4.Mostrar todos los empleados\n" +
                            "5.Buscar empleado por documento\n"+
                            "6.Mostrar empleado con mayor salario neto\n" +
                            "7.Mostrar nómina total\n" +
                            "8.Mostrar resumen de pagos\n" +
                            "9.Salir\n"));

            switch (opcion) {
                case 1:
                    registrarEmpleadoPlanta(empresa);
                    break;
            case 2:
                registrarEmpleadoVentas(empresa);
                break;
            case 3:
                registrarEmpleadoTemporal(empresa);
                break;
            case 4:
                mostrarEmpleados(empresa);
                break;
            case 5:
                buscarEmpleado(empresa);
                break;
            case 6:
                mostrarEmpleadoMayorSalario(empresa);
                break;
            case 7:
                mostrarNominaTotal(empresa);
                break;

            case 8:
                mostrarResumenPagos(empresa);
                break;
            case 9:
                JOptionPane.showMessageDialog(null, "Gracias por usar el Sistema de gestión de nómina de empleados ");
                break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida ");
           }
        }while(opcion!=9);
    }
    public static void registrarEmpleadoPlanta(Empresa empresa) {
        try {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado");
            String documento = JOptionPane.showInputDialog("Ingrese el documento del empleado");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad"));
            float salarioBase = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el salario base"));
            String ingresoCategoria = JOptionPane.showInputDialog("Ingrese la categoría. Si tiene dos palabras, separelas con guion bajo");
            CategoriaEmpleado categoria = CategoriaEmpleado.valueOf(ingresoCategoria.toUpperCase()); //la categoria tiene que ser en mayuscula por eso se convierte,
            // otra forma de hcaerlo es ingresando el numero de la  posicion del arreglo enum
            float descuentoSalud = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el porcentaje de descuento por salud"));
            float descuentoPension = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el porcentaje de descuento por pensión"));
            String cargo = JOptionPane.showInputDialog("Ingrese el cargo del empleado");
            int horasExtra = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las horas extra"));
            float valorHoraExtra = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor de la hora extra"));
            float auxilioTransporte = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el auxilio de transporte"));
            Empleado empleadoPlanta = new EmpleadoPlanta(nombre, documento, edad, salarioBase,
                    categoria, descuentoSalud, descuentoPension, cargo,
                    horasExtra, valorHoraExtra, auxilioTransporte);
            String resultado = empresa.registrarEmpleado(empleadoPlanta);
            JOptionPane.showMessageDialog(null, resultado);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Debe ingresar un valor numérico válido.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Error de validación: " + e.getMessage());
        }
    }
    public static void registrarEmpleadoVentas(Empresa empresa) {
        try {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado");
            String documento = JOptionPane.showInputDialog("Ingrese el documento del empleado");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del empleado"));
            float salarioBase = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el salario base"));
            String IngresoCategoria = JOptionPane.showInputDialog("Ingrese la categoria del empleado, si la categoria requiere dos palabras separelas con guion bajo");
            CategoriaEmpleado categoria = CategoriaEmpleado.valueOf(IngresoCategoria.toUpperCase());
            float descuentoSalud = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el porcentaje de descuento por salud"));
            float descuentoPension = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el porcentaje de descuento por pension"));
            float totalVentas = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el total en ventas del empleado"));
            Float porcentajeComision = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el la el procentaje de comision (0 - 100%)"));
            Empleado empleadoVentas = new EmpleadoVentas(nombre, documento, edad, salarioBase, categoria, descuentoSalud, descuentoPension, totalVentas, porcentajeComision);
            String resultado = empresa.registrarEmpleado(empleadoVentas);
            JOptionPane.showMessageDialog(null, resultado);
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Error: Debe ingresar un valor numérico válido.");
        }catch (IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, "Error de validación: " + e.getMessage());
        }
    }
    public static void registrarEmpleadoTemporal(Empresa empresa) {
        try {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado");
            String documento = JOptionPane.showInputDialog("Ingrese el documento del empleado");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del empleado"));
            float salarioBase = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el salario base"));
            String IngresoCategoria = JOptionPane.showInputDialog("Ingrese la categoria del empleado, si la categoria requiere dos palabras separelas con guion bajo");
            CategoriaEmpleado categoria = CategoriaEmpleado.valueOf(IngresoCategoria.toUpperCase());
            float descuentoSalud = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el porcentaje de descuento por salud"));
            float descuentoPension = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el porcentaje de descuento por pension"));
            int diasTrabajados=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de dias trabajados por el empleado:"));
            float valorDia=Float.parseFloat(JOptionPane.showInputDialog("Ingrese el el valor del dia de trabajo"));
            Empleado empleadoTemporal = new EmpleadoTemporal(nombre, documento, edad, salarioBase, categoria, descuentoSalud, descuentoPension, diasTrabajados, valorDia);
            String resultado = empresa.registrarEmpleado(empleadoTemporal);
            JOptionPane.showMessageDialog(null, resultado);
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Error: Debe ingresar un valor numérico válido.");
        }catch (IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, "Error de validación: " + e.getMessage());
        }
    }
    public static void mostrarEmpleados(Empresa empresa) {
        String resultado=empresa.mostrarEmpleados();
        JOptionPane.showMessageDialog(null, resultado);
    }
    public static void buscarEmpleado(Empresa empresa) {
        String documento = JOptionPane.showInputDialog("Ingrese el documento del empleado que desea buscar:");
        Optional<Empleado> empleadoEncontrado=empresa.buscarEmpleado(documento);
        if(empleadoEncontrado.isEmpty()){
            JOptionPane.showMessageDialog(null, "No se ecnontro ninfun empleado con ese documento de identificacion");
        }else{
            String mensajeInfoEncontrado=empleadoEncontrado.get().toString(); // hay que sacara primero el empleaddo para aplicarle su metodo
            JOptionPane.showMessageDialog(null, mensajeInfoEncontrado);
        }
    }
    public static void mostrarEmpleadoMayorSalario(Empresa empresa) {
        Optional<Empleado> empleadoMayorSueldo=empresa.buscarEmpleadoQueGanaMas();
        if(empleadoMayorSueldo.isEmpty()){
            JOptionPane.showMessageDialog(null, "la lista de empleados se encuentra vacia");
        }else{
            String mensaje= empleadoMayorSueldo.get().toString();
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }
    public static void mostrarNominaTotal(Empresa empresa) {
        Float nominaTotal= empresa.calcularNominaTotalEmpresa();
        JOptionPane.showMessageDialog(null, "La nomina total de la empresa es:"+ nominaTotal);
    }
    public static void mostrarResumenPagos(Empresa empresa) {
        String mesajeResumenes=empresa.mostrarResumenesPago();
        JOptionPane.showMessageDialog(null,mesajeResumenes);
    }
}
