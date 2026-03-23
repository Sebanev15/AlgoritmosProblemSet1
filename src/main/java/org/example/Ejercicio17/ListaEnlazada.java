package org.example.Ejercicio17;

import java.util.Comparator;
import java.util.function.Predicate;


public class ListaEnlazada<T> implements TDALista<T> {
    private Nodo<T> head;
    private int size;

    public ListaEnlazada() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void agregar(T elem) {
        agregar(size, elem);
    }

    @Override
    public void agregar(int index, T elem) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }
        if (index == 0) {
            head = new Nodo<>(elem, head);
        } else {
            Nodo<T> prev = getNodo(index - 1);
            prev.siguiente = new Nodo<>(elem, prev.siguiente);
        }
        size++;
    }

    @Override
    public T obtener(int index) {
        return getNodo(index).dato;
    }

    @Override
    public T remover(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }
        T dato;
        if (index == 0) {
            dato = head.dato;
            head = head.siguiente;
        } else {
            Nodo<T> prev = getNodo(index - 1);
            dato = prev.siguiente.dato;
            prev.siguiente = prev.siguiente.siguiente;
        }
        size--;
        return dato;
    }

    private Nodo<T> getNodo(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }
        Nodo<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.siguiente;
        }
        return current;
    }

    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        Nodo(T dato, Nodo<T> siguiente) {
            this.dato = dato;
            this.siguiente = siguiente;
        }
    }

    @Override
    public boolean remover(T elem) {
        
        return false;
    }

    @Override
    public boolean contiene(T elem) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contiene'");
    }

    @Override
    public int indiceDe(T elem) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'indiceDe'");
    }

    @Override
    public T buscar(Predicate<T> criterio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscar'");
    }

    @Override
    public TDALista<T> ordenar(Comparator<T> comparator) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ordenar'");
    }

    @Override
    public int tamaño() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tamaño'");
    }

    @Override
    public boolean esVacio() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'esVacio'");
    }

    @Override
    public void vaciar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'vaciar'");
    }

}
