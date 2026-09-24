package co.edu.uniquindio.poo.app;
import co.edu.uniquindio.poo.model.Curso;
import javax.swing.*;

public class Main {
    static void main() {
        JOptionPane.showMessageDialog(null,
                "Bienvenidos al sistema de gestión academica");
        String nombreCurso=JOptionPane.showInputDialog(null,
                "Por favor ingrese el nombre del curso");
        String codigo=JOptionPane.showInputDialog(null,
                "Por favor ingrese el nombre del curso");

        Curso curso= new Curso(nombreCurso,codigo);
        int opcion;
        do{
            opcion=Integer.valueOf(JOptionPane.showInputDialog(null,
                    "Ingrese la opcion:"+"\n"+"==MENÚ==\n"+
                    "1.Agregar estudiante"));
            switch(opcion){
                case 1:
                    crearEstudiante(curso);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null,
                            "Muchas gracias por usar nuestro programa");
                default:
                    JOptionPane.showMessageDialog( null,
                            "Opción no válida");
            }

        }while(opcion!=0);
    }
    public  static void crearEstudiante (Curso curso){ //Aca estoy como haciedno que el usuario ingrese los parametros
        //Hace que el usuario mismo usuario ingrese los datos del estudiante
        String nombre=JOptionPane.showInputDialog(null,
                "Porfavor ingrese el nombre del estudiante");
        String apellido=JOptionPane.showInputDialog(null,
                "Porfavor ingrese el apellido del estudiante");
        String identificacion=JOptionPane.showInputDialog(null,
                "Porfavor ingrese la identificación del estudiante");
        String edad=JOptionPane.showInputDialog(null,
                "Porfavor ingrese la edad del estudiante");
        Byte edadEstudiante=Byte.valueOf(edad); //convierte en el dato que necesitamos
        String correo=JOptionPane.showInputDialog(null,
                "Porfavor ingrese el correo del estudiante");
        String telefono=JOptionPane.showInputDialog(null,
                "Porfavor ingrese el telefono del estudiante");
        String resultado=curso.ingresarEstudiante(nombre,apellido,identificacion,
                edadEstudiante, correo,telefono); //aqui utilizo el parametro curso

        JOptionPane.showMessageDialog(null,resultado);

    }
}
