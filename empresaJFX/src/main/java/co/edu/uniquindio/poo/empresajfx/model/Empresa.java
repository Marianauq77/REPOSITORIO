package co.edu.uniquindio.poo.empresajfx.model;

import java.util.Collection;
import java.util.LinkedList;

public class Empresa {
    private String nombre;
    private Collection<Cliente> clientes;
    private Collection<Empleado> empleados;

    public Empresa(String nombre) {
        this.nombre = nombre;
        clientes = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Collection<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Collection<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Collection<Empleado> empleados) {
        this.empleados = empleados;
    }

    public boolean agregarCliente(Cliente cliente) {
        boolean centinela = false;
        if (!verificarCliente(cliente.getCedula())) {
            clientes.add(cliente);
            centinela = true;
        }
        return centinela;
    }
    public boolean eliminarCliente(String cedula) {
        boolean centinela = false;
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                clientes.remove(cliente);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarCliente(String cedula, Cliente actualizado) {
        boolean centinela = false;
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                cliente.setCedula(actualizado.getCedula());
                cliente.setNombre(actualizado.getNombre());
                cliente.setApellido(actualizado.getApellido());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean verificarCliente(String cedula) {
        boolean centinela = false;
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                centinela = true;
            }
        }
        return centinela;
    }
    public boolean agregarEmpleado(Empleado empleado){
        boolean centinela=false;
        if(!verificarEmpleado(empleado.getCedula())){
            empleados.add(empleado);
            centinela=true;
        }
        return centinela;
    }
    public boolean eliminarEmpleado(String cedula){
        boolean centinela= false;
        for(Empleado empleado: empleados){
            if(empleado.getCedula().equals(cedula)){
                empleados.remove(empleado);
                centinela=true;
                break;
            }
        }
        return centinela;
    }
    public boolean actualizarEmpleado(String cedula, Empleado actualizado){
        boolean centinela= false;
        for(Empleado empleado: empleados){
            if(empleado.getCedula().equals(cedula)){
                empleado.setCedula(actualizado.getCedula());
                empleado.setNombre(actualizado.getNombre());
                empleado.setApellido(actualizado.getApellido());
                centinela=true;
                break;

            }
        }
        return centinela;
    }
    public boolean verificarEmpleado (String cedula){
        boolean centinela= false;
        for(Empleado empleado: empleados){
            if(empleado.getCedula().equals(cedula)){
                centinela=true;
            }
        }
        return centinela;
    }
}

