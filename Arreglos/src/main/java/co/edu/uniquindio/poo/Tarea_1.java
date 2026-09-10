package co.edu.uniquindio.poo;
public class Tarea_1 {
    public static void main(String[] args) {
        int matriz[][] = {{32, 2, 1},
                          {47, 8, 9},
                          {20, 6, 8}};
        String mensaje = imprimirMatriz(matriz);
        System.out.println("La matriz es:"+"\n"+mensaje);
        int sumatoria1 = sumarNumerosMatriz(matriz);
        System.out.println("La sumatoria de la matriz es:" + sumatoria1);
        int sumatoria2 = sumarDiagonal(matriz);
        System.out.println("La sumatoria de la diagonal de la matriz es:" + sumatoria2);
        int matrizEspiral[][] = dibujarEspiral();
        String mensaje2=mostrarMatrizEspiral(matrizEspiral);
        System.out.println("La matriz Espiral es:"+"\n"+mensaje2);
        int matrizDibujarX [][] =dibujarX();
        String mensaje3= mostrarMatrizDibujadaX(matrizDibujarX);
        System.out.println("La matriz dibujada x es:"+"\n"+mensaje3);
        int matrizSuperior[][]=hacerCuadroSuperior();
        String mensaje4= mostrarMatrizSuperior(matrizSuperior);
        System.out.println("La matriz superior es:"+"\n"+mensaje4);





        //1. Imprimir matriz
    }
        public static String imprimirMatriz(int matriz[][]) {
            String mensaje = "";
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    mensaje += matriz[i][j]+" ";
                }
                mensaje += "\n";
            }
            return mensaje;
        }
        //2. Sumar numeros matriz

    public static int sumarNumerosMatriz(int matriz[][]) {
        int suma = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                suma += matriz[i][j];
            }
        }
        return suma;
    }

    //3. Sumar numeros de la diagonal
    public static int sumarDiagonal(int matriz[][]) {
        int suma = 0;
        for (int i = 0; i < matriz.length; i++) {
            suma += matriz[i][i];
        }
        return suma;
    }

    //4. Dinujar en una matriz un espiral de numeros
    public static int[][] dibujarEspiral() {
        int matriz[][] = new int[3][3];
        int numero = 0;
        int inicioFila = 0;
        int finFila = matriz.length - 1;
        int inicioColumna = 0;
        int finColumna = matriz[0].length - 1;


        //(El while indica que se sigue haciendo el espiral de numeros mientras que aun queden filas y columnas por recorrer)
        while (inicioFila <= finFila && inicioColumna <= finColumna) {
            for(int i=inicioColumna; i<=finColumna; i++){  //Iteran las columnas, misma fila
                matriz[inicioFila][i]=numero++;  //Usa el numero y lo suma para el siguiente
            }
            inicioFila++;
            for(int i=inicioFila; i<=finFila; i++){ //Iteran las filas, misma columna
                matriz[i][finColumna]=numero++;
            }
            finColumna--;
            for(int i=finColumna; i>=inicioColumna; i--){ //Iteranlas columnas;misma fila
               matriz[finFila][i]=numero++;
            }
            finFila--;
            for(int i=finFila; i>=inicioFila; i--){ //Iteran las filas, misma columna
                matriz[i][inicioColumna]=numero++;
            }
            inicioColumna++;

        }
        return matriz;
    }
    //Mostrar matriz espiral
    public static String mostrarMatrizEspiral(int matrizEspiral[][]) {
        String mensaje = "";
        for (int i = 0; i < matrizEspiral.length; i++) {
            for (int j = 0; j < matrizEspiral[i].length; j++) {
                mensaje += matrizEspiral[i][j]+" ";
            }
            mensaje += "\n";
        }
        return mensaje;
    }
    // Dinujar X en una matriz
    public static int [][] dibujarX(){
        int matriz[][]= new int [3][3];
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                if(i==j || i+j==matriz.length-1){
                    matriz[i][j]=7;
                }
            }
        }
        return matriz;
    }
    // Mostrar matriz dibujada x
    public static String mostrarMatrizDibujadaX(int matrizDibujarX [][]) {
        String mensaje = "";
        for (int i = 0; i < matrizDibujarX.length; i++) {
            for (int j = 0; j < matrizDibujarX[i].length; j++) {
                mensaje += matrizDibujarX[i][j]+" ";
            }
            mensaje += "\n";
        }
        return mensaje;
    }
    // Cuadro superior en una matriz
    public static int [][] hacerCuadroSuperior (){
        int matriz[][]=new int [3][3];
        for(int i=0; i<matriz.length; i++){
            for(int j=0;j<matriz[i].length; j++){
                if(j>i){
                    matriz[i][j]=1;
                }
            }
        }
        return matriz;
    }
    public static String mostrarMatrizSuperior(int matrizSuperior [][]) {
        String mensaje = "";
        for (int i = 0; i < matrizSuperior.length; i++) {
            for (int j = 0; j < matrizSuperior[i].length; j++) {
                mensaje += matrizSuperior[i][j] + " ";
            }
            mensaje += "\n";
        }
        return mensaje;
    }



}