package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Optional;

public class MonederoVirtual {
    private final String nombre;
    private final String nit;
    private ArrayList <Monedero> listaMonederos;
    private ArrayList <Usuario> listaUsuarios;
    private ArrayList <Beneficio> listaBeneficios;

    public MonederoVirtual(String nombre, String nit) {
        this.nombre = nombre;
        this.nit=nit;
        this.listaMonederos = new ArrayList<>();
        this.listaUsuarios = new ArrayList<>();
        this.listaBeneficios = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Usuario> getListaClientes() {
        return listaUsuarios;
    }

    public void setListaClientes(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    //CRUD USUARIO
    public String crearUsuario(Usuario usuario){
        if(buscarUsuarioDocumentoIdentidad(usuario.getDocumentoIdentidad()).isEmpty()){
            listaUsuarios.add(usuario);
            return "Cliente registrado con exito";
        }
        return  "Ya hay un cliente con esa información, por favor verifique el documento de identidad";
    }
    public Optional<Usuario> buscarUsuarioDocumentoIdentidad(String documentoIdentidad){
        return listaUsuarios.stream().filter(usuario ->documentoIdentidad.equals(usuario.getDocumentoIdentidad())).findFirst();
    }
    //CRUD BENEFICIO
    public void crearBeneficios(Beneficio beneficio100, Beneficio beneficio500, Beneficio beneficio1000){
        listaBeneficios.add(beneficio100);
        listaBeneficios.add(beneficio500);
        listaBeneficios.add(beneficio1000);
    }
    public boolean verificarCodigoMonederoExiste(String codigo){
        for(Monedero aux: listaMonederos){
            if(codigo.equals(aux.getCodigo())){
                return true;
            }
        }
        return false;
    }
}
