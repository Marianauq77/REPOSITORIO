package co.edu.uniquindio.poo.model;

import java.util.*;

public class EmpresaEnvios {
    private String nombre;
    private List<Envio> listaEnvios= new LinkedList<>();

    public EmpresaEnvios(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Envio> getListaEnvios() {
        return Collections.unmodifiableList(listaEnvios);
    }

    public void setListaEnvios(List<Envio> listaEnvios) {
        this.listaEnvios = listaEnvios;
    }
    public String registrarEnvio(Envio envio){
        Optional<Envio> EnvioEncontrado=buscarEnvio(envio.getCodigo());
        if(EnvioEncontrado.isEmpty()){
            listaEnvios.add(envio);
            return "Se registro exitosamente el envio";
        }
        return "No se pudo registrar el envio, ya existe uno con ese codigo";
    }
    public Optional<Envio> buscarEnvio(String codigo){
        return listaEnvios.stream().filter(e -> codigo.equals(e.getCodigo())).findFirst();
    }
    public Optional <Envio> encontrarEnvioMasCaro(){
        return  listaEnvios.stream().max(Comparator.comparing(Envio:: calcularCostoTotal));
    }
}
