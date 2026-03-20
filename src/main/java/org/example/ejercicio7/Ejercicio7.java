package org.example.ejercicio7;
import java.io.*;

/*

* */
public class Ejercicio7 {
    public static void main(String[] args) {
        InputStream inputStream = Ejercicio7.class.getClassLoader()
                .getResourceAsStream("archivoEjercicio7.txt"); //El archivo .txt debe estar en resources
        BufferedReader br = new BufferedReader(
                new InputStreamReader(inputStream)
        );


        try {
            String primeraLinea = br.readLine();
            int N = Integer.parseInt(primeraLinea);
            int[] arreglo = new int[N];
            for (int i = 0; i<N; i++){
                String linea = br.readLine();
                System.out.println("Linea " + i + ": " + linea);
                arreglo[i] = Integer.parseInt(linea);
            }
            int contadorIntercambios = 0;
            int sentenciasIfs = 0;
            for(int i =0; i < N-1; i++){
                for(int j = N; j > i+1; j--){
                    sentenciasIfs ++;
                    if(arreglo[j-1] < arreglo[j-2]){
                        contadorIntercambios ++;
                        int temp = arreglo[j-1];
                        arreglo[j-1] = arreglo[j-2];
                        arreglo[j-2] = temp;
                    }
                }
            }
            for (int i = 0; i<N; i++){
                System.out.println(arreglo[i]);
            }

            System.out.println("\nCantidad de ifs: " + sentenciasIfs + "\n");
            System.out.println("Cantidad de intercambios realizados: " + contadorIntercambios);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
