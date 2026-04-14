package org.example.ejercicio26;

import org.example.Ejercicio17.Pila;
import org.example.Ejercicio17.TDALista;

public class Expresion {
    //Consideramos una lista vacia como no valida
    //La lista vacio solo puede contener "{" o "}"
    public boolean controlCorchetes(TDALista<Character>listaDeEntrada){
        if (listaDeEntrada == null){
            throw new IllegalArgumentException("La lista no puede ser null");
        }

        if (listaDeEntrada.esVacio()){
            return false;
        }

        Pila<Integer> pila = new Pila<Integer>();
        int size = listaDeEntrada.tamaño();
        int i;
        for (i = 0; i<size; i++){
            Character actual =listaDeEntrada.obtener(i);
            if (actual == '{'){
                pila.mete(1);
            }
            else if (actual == '}'){
                if (!pila.esVacio()){
                    pila.saca();
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        return pila.esVacio();
    }

}
