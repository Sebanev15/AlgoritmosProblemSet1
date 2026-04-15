package org.example.Ejercicio17.BibliotecaCentral;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.example.ejercicio7.Ejercicio7;

public class PrestamoManager {
    public InputStream inputStream = Ejercicio7.class.getClassLoader().getResourceAsStream("prestamos.txt"); //El archivo .txt debe estar en resources
    public BufferedReader br;
    public BibliotecaUCU biblioteca;

    public PrestamoManager(){
        this.biblioteca = BibliotecaUCU.getBiblioteca();
        br = new BufferedReader(new InputStreamReader(inputStream));
    }

    public PrestamoManager(BufferedReader br, BibliotecaUCU biblioteca){
        this.br = br;
        this.biblioteca = biblioteca;
    }
    
    public void read(){
        try {
            String actual = br.readLine();//CODIGO_LIBRO, tipo, CANTIDAD
            String[] mensaje = actual.split(", ");
            int cantidad = Integer.parseInt(mensaje[2]);
            if (mensaje[1].equals("PRESTAMO")){
                prestamo(mensaje[0], cantidad);
            }
            if (mensaje[1].equals("DEVOLUCION")){
                devolucion(mensaje[0], cantidad);
            }
        } 
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readAll(){
        try {
            String actual = br.readLine();//CODIGO_LIBRO, tipo, CANTIDAD
            while (actual != null){
            String[] mensaje = actual.split(", ");
            int cantidad = Integer.parseInt(mensaje[2]);
            if (mensaje[1].equals("PRESTAMO")){
                prestamo(mensaje[0], cantidad);
            }
            if (mensaje[1].equals("DEVOLUCION")){
                devolucion(mensaje[0], cantidad);
            }
            actual = br.readLine();
        }
        } 
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void prestamo(String codigo, int cantidad){
        biblioteca.prestamo(codigo, cantidad);
    }

    public void devolucion(String codigo, int cantidad){
        biblioteca.devolucion(codigo, cantidad);
    }

    /*public static void main(String [] args){
        AquisitonManager admin2 = new AquisitonManager();
        PrestamoManager admin = new PrestamoManager();
        admin2.adquirirTodo();
        admin.biblioteca.listar();
        admin.read();
    }*/

}