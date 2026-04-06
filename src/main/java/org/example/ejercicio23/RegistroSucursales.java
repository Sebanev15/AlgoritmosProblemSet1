package org.example.ejercicio23;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.example.Ejercicio17.Cola;
import org.example.Ejercicio17.Nodo;
import org.example.ejercicio7.Ejercicio7;




public class RegistroSucursales {
    InputStream inputStream = Ejercicio7.class.getClassLoader().getResourceAsStream("sucursales.txt"); //El archivo .txt debe estar en resources
    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
    public Cola<String> registro = new Cola<String>();

    public RegistroSucursales(){
        try{
            String linea = br.readLine();
            while (linea != null) {
                registro.poneEnCola(linea);
                linea = br.readLine();
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void agregarLinea(String texto) {
    try (FileWriter fw = new FileWriter("src\\main\\resources\\sucursales.txt", true);
         BufferedWriter bw = new BufferedWriter(fw)) {
        bw.write(texto);
        bw.newLine(); // Agrega un salto de línea dependiente del sistema
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    public void vaciarArchivo() {
    try {
        Files.write(Paths.get("src\\main\\resources\\sucursales.txt"), new byte[0]);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public boolean agregarSucursal(String sucursal){
        agregarLinea(sucursal);
        return registro.poneEnCola(sucursal);
    }

    public boolean buscarSucursal(String sucursal){
        return registro.contiene(sucursal);
    }
    
    public void quitarSucursal(String sucursal){
        registro.remover(sucursal);
        vaciarArchivo();
        Nodo<String> nodoActual = registro.frente;
        while (nodoActual != null) {
            agregarLinea(nodoActual.dato);
            nodoActual = nodoActual.siguiente;
        }
    }
    
    public void listarSucursales(){
        Nodo<String> nodoActual = registro.frente;
        while (nodoActual != null) {
            System.out.println(nodoActual.dato);
            nodoActual = nodoActual.siguiente;
        }
    }

}
