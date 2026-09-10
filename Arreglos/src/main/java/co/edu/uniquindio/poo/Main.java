package co.edu.uniquindio.poo;
public class Main {
    public static void main(String[] args) {
        int[] numeros = {1, 4, 6, 7};
        int sumatoria=sumarNumeros(numeros);
        System.out.println(sumatoria);
        int numero=5;
        boolean seEncontroNumero = encontrarNumero(numeros, numero);
        System.out.println(seEncontroNumero);
        int [] numeros1={1,4,8,9,8,7,8};
        int numeroRepetido=encontrarNumeroRepetido(numeros1);
        System.out.print(numeroRepetido);
        saludar("Mariana");
        String [] habitaciones={"blanco", "blanco","blanco", "blanco"};
        String mensaje= mostrarArreglo(habitaciones);
        System.out.print(mensaje);
        String color= "amarillo";
        cambiarColor(habitaciones, color);
        String mensaje1= mostrarArreglo(habitaciones);
        System.out.print(mensaje1);
        String mensaje2=mostrarArreglo2(habitaciones);
        System.out.print(mensaje2);

    }
    public static int sumarNumeros(int []numeros){  //sumar numeros del arrego
        int suma=0;
        for(int i=0; i<numeros.length; i++){
           suma+=numeros[i] ;
        }
        return suma;
    }


    public static boolean encontrarNumero(int[] numeros, int numero){  //Encontrar un numero en el arreglo
        for (int i=0; i<numeros.length; i++) {
            if ( numeros[i]== numero) {
                return true;
            }
        }
        return false;
    }
    // Encuentra el numero mas repetido (el profe explico algo nuevo en la condición)
    public static int encontrarNumeroRepetido(int[] numeros1){
        int numeroRepetido=0;
        int vecesRepetido=0;
        for(int i=0; i<numeros1.length;i++){
            int contador=0;
            for(int j=0; j<numeros1.length;j++){
                if(numeros1[i]==numeros1[i]){
                    contador++;
                }
            }
            // solo si encuentra un nuevo record de un numero que se repite mas
            if(contador>vecesRepetido){
                vecesRepetido = contador;
                numeroRepetido=numeros1[i];
            }
        }
        return numeroRepetido;
    }
    public static void saludar (String nombre){  //Metodo sin retorno
        System.out.println("Hola"+nombre);
    }
    public static void cambiarColor(String [] habitaciones, String color){ // Metodo sin retorno pero cambia un arreglo
        for(int i=0; i< habitaciones.length; i++){
            habitaciones[i]= color;
        }
    }
    public static String mostrarArreglo(String [] habitaciones){ //Mostrar arreglo for each
        String mensaje="Los colores de las habitaciones son:"+"\n";
        for(String habitacionColor: habitaciones){
            mensaje+=habitacionColor+"\n";
        }
        return mensaje;
    }
    public static String mostrarArreglo2(String [] habitaciones){ //mostrar arrreglo normal (tambien se podria nmostar con un metodo void son sizo)
        String mensaje="Los colores de las habitaciones son:"+"\n";
        for(int i=0; i<habitaciones.length; i++){
            mensaje+=habitaciones[i]+"\n";
        }
        return mensaje;
    }

}