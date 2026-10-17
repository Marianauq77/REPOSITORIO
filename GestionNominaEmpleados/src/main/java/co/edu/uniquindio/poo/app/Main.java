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
                    try {
                        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado");
                        String documento = JOptionPane.showInputDialog("Ingrese el documento del empleado");
                        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del empleado"));
                        float salarioBase = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el salario base"));
                        String IngresoCategoria = JOptionPane.showInputDialog("Ingrese la categoria del empleado, si la categoria requiere dos palabras separelas con guion bajo");
                        CategoriaEmpleado categoria = CategoriaEmpleado.valueOf(IngresoCategoria.toUpperCase()); //la categoria tiene que ser en mayuscula por eso se convierte
                        float descuentoSalud = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el descuento por salud"));
                        float descuentoPension = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el descuento por pension"));
                        String cargo = JOptionPane.showInputDialog("Ingrese el cargo del empleado");
                        int horasExtra = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de horas extra del empleado:"));
                        float valorHoraExtra = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor de la hora extra"));
                        float auxilioTransporte = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor de el auxilio de transporte"));
                        //Se crea el empleado solo si no presenta un error de excepcion antes
                        Empleado empleadoPlanta = new EmpleadoPlanta(nombre, documento, edad, salarioBase, categoria, descuentoSalud, descuentoPension, cargo, horasExtra, valorHoraExtra, auxilioTransporte);
                        String resultado = empresa.registrarEmpleado(empleadoPlanta);
                        JOptionPane.showMessageDialog(null, resultado);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Error: Debe ingresar un valor numérico válido.");
                    } catch (IllegalArgumentException e) {
                        JOptionPane.showMessageDialog(null, "Error de validación: " + e.getMessage());
                    }
                    break;
            case 2:
                try {
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado");
                    String documento = JOptionPane.showInputDialog("Ingrese el documento del empleado");
                    int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del empleado"));
                    float salarioBase = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el salario base"));
                    String IngresoCategoria = JOptionPane.showInputDialog("Ingrese la categoria del empleado, si la categoria requiere dos palabras separelas con guion bajo");
                    CategoriaEmpleado categoria = CategoriaEmpleado.valueOf(IngresoCategoria.toUpperCase()); //la categoria tiene que ser en mayuscula por eso se convierte
                    float descuentoSalud = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el descuento por salud"));
                    float descuentoPension = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el descuento por pension"));
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
                break;
            case 3:
                try {
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado");
                    String documento = JOptionPane.showInputDialog("Ingrese el documento del empleado");
                    int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del empleado"));
                    float salarioBase = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el salario base"));
                    String IngresoCategoria = JOptionPane.showInputDialog("Ingrese la categoria del empleado, si la categoria requiere dos palabras separelas con guion bajo");
                    CategoriaEmpleado categoria = CategoriaEmpleado.valueOf(IngresoCategoria.toUpperCase()); //la categoria tiene que ser en mayuscula por eso se convierte
                    float descuentoSalud = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el descuento por salud"));
                    float descuentoPension = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el descuento por pension"));
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
                break;
            case 4:
                String resultado=empresa.mostrarEmpleados();
                JOptionPane.showMessageDialog(null, resultado);
                break;
            case 5:
                String documento = JOptionPane.showInputDialog("Ingrese el documento del empleado que desea buscar:");
                Optional<Empleado> empleadoEncontrado=empresa.buscarEmpleado(documento);
                if(empleadoEncontrado.isEmpty()){
                    JOptionPane.showMessageDialog(null, "No se ecnontro ninfun empleado con ese documento de identificacion");
                }else{
                    String mensajeInfoEncontrado=empleadoEncontrado.get().toString(); // hay que sacara primero el empleaddo para aplicarle su metodo
                    JOptionPane.showMessageDialog(null, mensajeInfoEncontrado);
                }
                break;
            case 6:
                Optional<Empleado> empleadoMayorSueldo=empresa.buscarEmpleadoQueGanaMas();
                if(empleadoMayorSueldo.isEmpty()){
                    JOptionPane.showMessageDialog(null, "la lista de empleados se encuentra vacia");
                }else{
                    String mensaje= empleadoMayorSueldo.get().toString();
                    JOptionPane.showMessageDialog(null, mensaje);
                }
                break;
            case 7:
                Float nominaTotal= empresa.calcularNominaTotalEmpresa();
                JOptionPane.showMessageDialog(null, "La nomina total de la empresa es:"+ nominaTotal);
                break;
            case 8:
                String mesajeResumenes=empresa.mostrarResumenesPago();
                JOptionPane.showMessageDialog(null,mesajeResumenes);

                break;
            case 9:
                JOptionPane.showMessageDialog(null, "Gracias por usar el Sistema de gestión de nómina de empleados ");
                break;
           }
        }while(opcion!=9);
    }
}
