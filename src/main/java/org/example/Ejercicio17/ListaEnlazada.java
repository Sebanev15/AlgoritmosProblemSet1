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
            Nodo<T> actual = this.head;
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
        int i ;
        Nodo<T> actual = this.head;
        for (  i = 0; i < indice -1; i++)
        {
            actual = actual.siguiente;
        } 
        Nodo<T>temporal = actual.siguiente;
        actual.siguiente = new Nodo<T>(elemento, temporal.siguiente);
    }

    @Override
    public T obtener(int index)
    {
        int i;
        Nodo<T> actual = this.head;
        for (i = 0; i < index ; i++)
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
        for (i = 0; i < index - 1; i++)
        {
            actual = actual.siguiente;
        }
        Nodo<T> temporal = actual.siguiente;
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
            return true; 
        }
        else{
            return false;
        }
        
    }
    public boolean contiene(T elemento){
        Nodo<T> actual=this.head;
        while (!actual.dato.equals(elemento) && !actual.dato.equals(null)) {
            actual=actual.siguiente;   
        } 
        if (actual.dato.equals(elemento)){
            return true;
            
        }
        else {
            return false;
        }
    }
    public int indiceDe(T elem){
        Nodo<T> actual= this.head;
        int contador=0;
        while (!actual.dato.equals(elem) && !actual.dato.equals(null)) {
            actual=actual.siguiente;
            contador++;
        }
        if (actual.dato.equals(elem)){
            return contador;
        }
        else{
            return -1;
        }
    }
    public T buscar(Predicate<T> criterio){
        Nodo<T> actual = head;
        while (actual != null){
            if (criterio.test(actual.dato)){
                return actual.dato;
            }
            actual = actual.siguiente;
        }
        return null;
    }
    

}