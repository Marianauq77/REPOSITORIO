package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class Empresa {
    private final String nombres;
    private final String nit;
    private ArrayList<Empleado> listaEmpleados;

    public Empresa(String nombres, String nit) {
        this.nombres = nombres;
        this.nit = nit;
        this.listaEmpleados = new ArrayList<>();
    }

    public String getNombres() {
        return nombres;
    }

    public String getNit() {
        return nit;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public String registrarEmpleado(Empleado empleado) {
        Optional<Empleado> empleadoEncontrado = buscarEmpleado(empleado.getDocumento());
        if (empleadoEncontrado.isEmpty()) {
            listaEmpleados.add(empleado);
            return "El empleado fue registrado exitosamente";
        }
        return "No se puede registrar, ya existe un cliente con esa informacion registrado anteriormente.";
    }

    public Optional<Empleado> buscarEmpleado(String documento) {
        if (listaEmpleados.isEmpty()) {
            return Optional.empty();
        }
        return listaEmpleados.stream().filter(e -> documento.equals(e.getDocumento())).findFirst();
    }

    public Optional<Empleado> buscarEmpleadoQueGanaMas() {
        if (listaEmpleados.isEmpty()) {
            return Optional.empty();
        }
        return listaEmpleados.stream().max(Comparator.comparingDouble(Empleado::calcularSalarioNeto)); // no hay un comparingFloat pero igual sirve porque Java lo convierte, además de que igual retorna un objeto empleado
    }

    public float calcularNominaTotalEmpresa() {
        return (float) listaEmpleados.stream().mapToDouble(Empleado::calcularSalarioNeto).sum(); //El mapToDouble extrae cada valor numerico, pero los conviertene en double por eso en return se convierte a floa otra vez
    }

    public String mostrarResumenesPago() {
        if (listaEmpleados.isEmpty()) {
            return "No hay empleados registrados aún";
        }
        String mensaje = "";
        for (Empleado e : listaEmpleados) {
            mensaje += e.generarResumenPago().toString() + "\n";
        }
        return mensaje;
    }

    public String mostrarEmpleados() {
        if (listaEmpleados.isEmpty()) {
            return "No hay empleados registrados aún";
        }
        String mensaje = "";
        for (Empleado e : listaEmpleados) {
            mensaje += e.toString() + "\n";
        }
        return mensaje;
    }

}

