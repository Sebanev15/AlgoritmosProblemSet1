package org.example.Ejercicio17;



public class Cola<T> extends ListaEnlazada<T> implements TDACola<T>  {
    public Nodo<T> frente;
    @Override
    public T frente() {
        return frente.dato;
    }

    @Override
    public boolean poneEnCola(T dato) {
        Nodo<T> nodoNuevo = new Nodo<>(dato, null);
        frente.siguiente = nodoNuevo;
        frente = nodoNuevo;
        return frente.siguiente == null;
    }

    @Override
    public T quitaDeCola() {
        Nodo<T> nodoEliminado = head;
        head = head.siguiente;
        nodoEliminado.siguiente = null;
        return nodoEliminado.dato;
    }


}
