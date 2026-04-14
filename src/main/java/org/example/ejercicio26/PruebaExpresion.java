package org.example.ejercicio26;

import org.example.Ejercicio17.ListaEnlazada;
import org.example.Ejercicio17.TDALista;

//En esta clase, simplemento estoy probando diversar expresiones
//Seria la parte 2 del ejercicio
//La parte 3 seria hacer los Test en JUnit
public class PruebaExpresion {
    public static void main(String[] args) {
        Expresion exp = new Expresion();
        
        TDALista<Character> lista1 = new ListaEnlazada<>();
        lista1.agregar('{');
        System.out.println(exp.controlCorchetes(lista1)+", espero FALSE"); 

        TDALista<Character> lista2 = new ListaEnlazada<>();
        lista2.agregar('}');
        System.out.println(exp.controlCorchetes(lista2)+", espero FALSE"); 
        
        TDALista<Character> lista3 = new ListaEnlazada<>();
        lista3.agregar('{');
        lista3.agregar('{');
        lista3.agregar('}');
        lista3.agregar('{');
        lista3.agregar('}');
        lista3.agregar('}');
        System.out.println(exp.controlCorchetes(lista3)+", espero TRUE"); 

        TDALista<Character> lista4 = new ListaEnlazada<>();
        lista4.agregar('{');
        lista4.agregar('}');
        System.out.println(exp.controlCorchetes(lista4)+", espero TRUE"); 
    }
}
