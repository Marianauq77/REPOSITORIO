package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

public class SistemaMonedero {
    private final String nombre;
    private ArrayList <Monedero> listaMonederos;
    private ArrayList <Cliente> listaClientes;
    private ArrayList <Beneficio> listaBeneficios;

    public SistemaMonedero(String nombre) {
        this.nombre = nombre;
        this.listaMonederos = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.listaBeneficios = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Cliente> getListaClientes() {
        return Collections.unmodifiableList(listaClientes);
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    //CRUD CLIENTE
    public String crearCliente(Cliente cliente){
        if(buscarClienteDocumentoIdentidad(cliente.getDocumentoIdentidad()).isEmpty()){
            listaClientes.add(cliente);
            return "Cliente registrado con exito";
        }
        return  "Ya hay un cliente con esa información, por favor verifique el documento de identidad";
    }
    public Optional<Cliente> buscarClienteDocumentoIdentidad(String documentoIdentidad){
        return listaClientes.stream().filter(cliente ->documentoIdentidad.equals(cliente.getDocumentoIdentidad())).findFirst();
    }
    //CRUD BENEFICIO
    public void crearBeneficios(Beneficio beneficio100, Beneficio beneficio500, Beneficio beneficio1000){
        listaBeneficios.add(beneficio100);
        listaBeneficios.add(beneficio500);
        listaBeneficios.add(beneficio1000);
    }
}
