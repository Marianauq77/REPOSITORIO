package co.edu.uniquindio.poo.model;

import java.util.Arrays;

/**
        * Esta clase representa un curso universidad
 * Autor: Mariana Suarez
 * Fecha:17/09/16
        */
public class Estudiante {
    private String nombres;
    private String apellido;
    private String identificacion;
    private byte edad;
    private String correo;
    private String telefono;

    private Curso ownedByCurso;
    private Nota [] listaNotas;

    public Estudiante(String nombres,String apellido,String identificacion,byte edad,
                      String correo,String telefono, Curso ownedByCurso){// ==>debe ir el ownedBy
        this.nombres=nombres;
        this.apellido=apellido;
        this.identificacion=identificacion;
        this.edad=edad;
        this.correo=correo;
        this.telefono=telefono;
        this.ownedByCurso=ownedByCurso;

        this.listaNotas=new Nota[5]; //==> Lo inicializo acá
    }
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido() {

        return apellido;
    }

    public void setApellido(String apellido) {

        this.apellido = apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {

        this.identificacion = identificacion;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Curso getOwnedByCurso() {
        return ownedByCurso;
    }

    public void setOwnedByCurso(Curso ownedByCurso) {
        this.ownedByCurso = ownedByCurso;
    }

    public Nota[] getListaNotas() {
        return listaNotas;
    }

    public void setListaNotas(Nota[] listaNotas) {
        this.listaNotas = listaNotas;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombres='" + nombres + '\'' +
                ", apellido='" + apellido + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", edad=" + edad +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", ownedByCurso=" + ownedByCurso +
                ", listaNotas=" + Arrays.toString(listaNotas) +
                '}';
    }
}
