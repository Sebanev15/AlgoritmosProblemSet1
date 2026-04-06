 package org.example.Ejercicio17;

import java.util.function.Predicate;

public class Nodo<T> {
    public T dato;
    public Nodo<T> siguiente;
    public Nodo(T dato, Nodo<T> siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }
    //metodo equals que invoque el equals del dato tipo t.
    public Predicate<T> dato() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dato'");
    }
}