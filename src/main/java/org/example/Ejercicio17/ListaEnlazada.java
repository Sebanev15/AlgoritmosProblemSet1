package org.example.Ejercicio17;

import java.util.Comparator;
import java.util.function.Predicate;


public class ListaEnlazada<T> implements TDALista<T> {
    private Nodo<T> head;
    private int size;

    public ListaEnlazada(Nodo<T> head) {
        this.head = head;
        this.size = 1;
    }

    @Override
    public void agregar()
}
