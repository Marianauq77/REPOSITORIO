package co.edu.uniquindio.poo.empresajfx.controller;

import co.edu.uniquindio.poo.empresajfx.model.Empleado;
import co.edu.uniquindio.poo.empresajfx.model.Empresa;

import java.util.Collection;

public class EmpleadoController {
    Empresa empresa;

    public EmpleadoController(Empresa empresa) {
        this.empresa = empresa;
    }
    public Collection<Empleado> obtenerListaEmpleados(){
        return empresa.getEmpleados();
    }
    public boolean crearEmpleado(Empleado empleado){
       return empresa.agregarEmpleado(empleado); //retorna tambien un booleano
    }
    public boolean eliminarEmpleado (String cedula){
        return empresa.eliminarEmpleado(cedula);
    }
    public boolean actualizarEmpleado(String cedula, Empleado actualizado){
        return empresa.actualizarEmpleado(cedula, actualizado);
    }
}
