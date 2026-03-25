package org.example.Ejercicio17;

import java.util.Comparator;
import java.util.function.Predicate;


public class ListaEnlazada<T> implements TDALista<T> 
{
    
    private Nodo<T> head;
    private int size;

    public ListaEnlazada() 
    {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void agregar(T elemento)
    {
        if (this.head == null) 
        {
            this.head = new Nodo<>(elemento, null);  
        } 
        else 
        {
            Nodo actual = this.head;
            while (actual.siguiente != null) 
            {
                actual = actual.siguiente;
            }
            actual.siguiente = new Nodo<T>(elemento, null);
            
        }
        this.size ++;
    }

    @Override
    public void agregarConIndice(int indice, T elemento)
    {
        Nodo<T> actual = this.head;
        for (i = 0, i = indice - 2, i++)
        {
            actual = actual.siguiente;
        } 
        temporal = actual.siguiente;
        actual.siguiente = new Nodo(elemento, temporal.siguiente);
    }

    @Override
    public T obtener(int index)
    {
        Nodo<T> actual = this.head;
        for (i = 0, i = index - 1, i++)
        {
            actual = actual.siguiente;
        }
        return actual.dato;
    }

    @Override
    public T remover(int index)
    {
        Nodo<T> actual = this.head;
        int i;
        for (i = 0, i = index - 2, i++)
        {
            actual = actual.siguiente;
        }
        temporal = actual.siguiente;
        actual.siguiente = temporal.siguiente;
        return temporal.dato; 
    }

    @Override
    public boolean remover(T elemento)
    {
        Nodo<T> actual = this.head;
        do 
        {
            actual = actual.siguiente;
        }
        while(actual.dato != elemento);

        if (actual.dato != null)
        {
            Nodo<T> temporal = actual.siguiente;
            actual.siguiente = temporal.siguiente;
            return (boolean) temporal.dato; 
        }
        else{
            return false;
        }
        
    }

    

}