package co.edu.uniquindio.poo.model;

import java.util.ArrayList;

/**
 * Esta clase representa un curso universidad
 * Autor: Mariana Suarez
 * Fecha:17/09/16
 */

public class Curso { //nombre de la clase en mayuscula
    // Declaración de atributos
    //modificador de acceso=> tipo de dato=> nombre del atributo
    private String nombre;
    private String codigo;

    //Declarar las relaciones
    private ArrayList<Estudiante> listaEstudiantes;

    //Contructor: Inicializa las variables
    public Curso(String nombre, String codigo){
        this.nombre=nombre;
        this.codigo=codigo;
        this.listaEstudiantes= new ArrayList<>();
    }
    // set y gen
    public void setNombre(String nombre){
        this.nombre=nombre; // para actualizar por si digamos  me equivoque e ingrese mal el nombre
    }
    public String getNombre(){// no necesita parametro
        return nombre;
    }

    //CRUDD DEL ESTUDIANTE
    public String ingresarEstudiante(String nombres,String apellidos,String identificacion,
                                      byte edad,String correo,String telefono){
        String mensaje = "";
        Estudiante buscado = buscarEstudiante(identificacion); // va retornar un estudiante en esa variable si lo cuentra
        if(buscado != null){
            return "Error el estudiante que usted desea registra ya se encuentra registrado";
        }else{
            Estudiante estudianteNuevo = new Estudiante(nombres,apellidos,identificacion //aqui estoy creando un estudiante
                    ,edad,correo,telefono,this);
            listaEstudiantes.add(estudianteNuevo); // aca los estoy ingresando realmente a la lista
            mensaje = "Estudiante registrado con exito";
        }
        return mensaje;
    }
    public Estudiante buscarEstudiante (String identificacion){
        for(Estudiante aux : listaEstudiantes){
            if(aux.getIdentificacion().equals(identificacion)){ // va recorriendo la lista de estudiantes en aux
                return aux;
            }
        }
        return null;
    }


}
