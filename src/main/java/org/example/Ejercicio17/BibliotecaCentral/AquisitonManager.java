package org.example.Ejercicio17.BibliotecaCentral;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.example.ejercicio7.Ejercicio7;

public class AquisitonManager {
        public BufferedReader br;
        public BibliotecaUCU biblioteca;
        
        public AquisitonManager(){
            br = new BufferedReader(new InputStreamReader(Ejercicio7.class.getClassLoader().getResourceAsStream("adquisiciones.txt")));
            biblioteca = BibliotecaUCU.getBiblioteca();
        }
        public AquisitonManager(BufferedReader br, BibliotecaUCU biblioteca){
            this.br = br;
            this.biblioteca = biblioteca;
        }

    public void adquirirTodo(){
        try {
            String actual = br.readLine();//CODIGO_LIBRO, TITULO_LIBRO, PRECIO_REPOSICION, CANTIDA
            while (actual!=null) {
                adquisicion(actual);
                actual = br.readLine();//CODIGO_LIBRO, TITULO_LIBRO, PRECIO_REPOSICION, CANTIDA
        }
        } 
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        
    }
    public void adquirirUno(){
        try {
            String actual = br.readLine();//CODIGO_LIBRO, TITULO_LIBRO, PRECIO_REPOSICION, CANTIDAD
                adquisicion(actual);
        } 
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void adquisicion(String actual){           
            String[] mensaje = actual.split(", ");
            int cantidad = Integer.parseInt(mensaje[3]);
            float precio = Float.parseFloat(mensaje[2]);
            if (biblioteca.buscarLibro(mensaje[0]) == null){
                biblioteca.incorporarLibroCatalogo(mensaje[1], mensaje[0], precio, cantidad);
            }
            else{
                NodoLibro nodoActual = biblioteca.buscarLibro(mensaje[0]);
                nodoActual.modifyStock(cantidad);
            }
    }

}
