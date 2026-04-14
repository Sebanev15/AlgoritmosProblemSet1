package org.example;


import org.example.Ejercicio17.Pila;
import org.example.ejercicio23.RegistroSucursales;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        IO.println(String.format("Hello and welcome!"));
        RegistroSucursales registro = new RegistroSucursales();
        //registro.listarSucursales();   
        //System.out.println(registro.devolverTotal());
        System.out.println(registro.buscarSucursal("Hong Kong").siguiente);


        //pila
        Pila<String> pila= new Pila<String>();
        pila.mete("primer dato");
        pila.mete("segundo dato");
        pila.mete("tercer dato");
        System.out.println(pila.tope());
        System.out.println(pila.saca());
        System.out.println(pila.tope());
        
        //Prueba que efectivamente borre el ultimo dato
        Pila<String> pila1 = new Pila<String>();
        pila1.mete("unico dato");
        System.out.println(pila1.tope());
        System.out.println(pila1.saca());

        try {
            Pila<String> pila2 = new Pila<String>();
            pila1.mete("unico dato");
            System.out.println(pila2.saca());
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Tira Excepcion");
        }

    }
}
