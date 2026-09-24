package co.edu.uniquindio.poo;

public class Proyecto1Poo {
    public static void main(String[] args) {
        // Crear curso
        Curso curso1 = new Curso("Programacion I", "PROGI");
        // Crear estudiante
        Estudiante estudiante1 = new Estudiante("Mariana", "Suarez", "1092459145", (byte) 18, "mariana@gamil.com", "348696755985");
        // Guardar estudante en el curso
        curso1.agregarEstudiante(0, estudiante1);
        //Crear nota
        Nota nota1 = new Nota("Parcial", 5.0f);
        Nota nota2 = new Nota("Taller", 4.0f);
        Nota nota3 = new Nota("Tarea", 5.0f);
        Nota nota4 = new Nota("Quiz", 4.6f);
        Nota nota5 = new Nota("Parcial2", 5.0f);
        //Guardar nota
        estudiante1.agregarNota(0, nota1);
        estudiante1.agregarNota(1, nota2);
        estudiante1.agregarNota(2, nota3);
        estudiante1.agregarNota(3, nota4);
        estudiante1.agregarNota(44, nota5);
    }
}

class Nota {
    private String nombre;
    private float valor;

    public Nota(String nombre, float valor) {
        this.nombre = nombre;
        this.valor = valor;
    }
}

class Estudiante {
    private String nombre;
    private String apellidos;
    private String identificacion;
    private byte edad;
    private String correo;
    private String telefono;
    private Nota[]notas;

    public Estudiante(String nombre, String apellidos, String identificacion, byte edad, String correo, String telefono) {
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.identificacion=identificacion;
        this.edad=edad;
        this.correo=correo;
        this.telefono=telefono;
        this.notas= new Nota[5];
    }
    public void agregarNota(int posicion, Nota nota){
        notas[posicion]=nota;
    }
}
class Curso{
    private String nombre;
    private String codigo;
    private Estudiante [] estudiantes;
     public Curso(String nombre, String codigo){
         this.nombre=nombre;
         this.codigo=codigo;
         this.estudiantes=new Estudiante [30];
    }
    public  void agregarEstudiante(int posicion, Estudiante estudiante){
         estudiantes[posicion]=estudiante;

    }
}

