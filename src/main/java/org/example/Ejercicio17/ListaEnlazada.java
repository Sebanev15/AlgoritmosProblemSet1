package org.example.Ejercicio17;

import java.util.Comparator;
import java.util.function.Predicate;

public class ListaEnlazada<T> implements TDALista<T> 
{
    
    protected Nodo<T> head;
    protected int size;

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

    public Nodo<T> getHead(){
        return head;
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
    public boolean remover(T elemento)//borra el siguiente, no el que queremos. 
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
    @Override
    public boolean contiene(T elemento){
        Nodo<T> actual=this.head;
        while (actual!= null) {
            if (actual.dato.equals(elemento)){
                return true;
            }
            actual=actual.siguiente;   
        } 
            return false;
        }
    public Nodo<T> contieneNodo(T elemento){
        Nodo<T> actual=this.head;
        while (!actual.dato.equals(elemento) && !actual.dato.equals(null)) {
            actual=actual.siguiente;   
        } 
        if (actual.dato.equals(elemento)){
            return actual;
            
        }
        else {
            return null;
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

    public TDALista<T> ordenar(Comparator<T> comparator){
        ListaEnlazada<T> listaOrdenada= new ListaEnlazada<>();
        Nodo<T> actual = this.head;

        while (actual != null)
        {
            insertarOrdenado(listaOrdenada, actual.dato, comparator);
            actual = actual.siguiente;
        }


        return listaOrdenada;
    }
    public int tamaño(){
        int size = 0;
        Nodo<T> actual = head;
        if(actual==null){
            return size;
        }
        size++;
        while(actual.siguiente!=null){
            size++;
            actual =  actual.siguiente;
        }
        return size;
    }

    public boolean esVacio(){
       
        return (head == null);
    }
    public void vaciar(){
        Nodo<T> actual = head;

        while (actual != null){
            Nodo<T> temporal = actual.siguiente;
            actual.siguiente = null;
            actual = temporal;
        }
    }
    //Funcion auxiliar para el ordenar
    private void insertarOrdenado(ListaEnlazada<T> lista, T elemento, Comparator<T> comparator){   
    Nodo<T> nuevo = new Nodo<>(elemento, null);

    if (lista.head == null || comparator.compare(elemento, lista.head.dato) < 0)
    {
        nuevo.siguiente = lista.head;
        lista.head = nuevo;
        return;
    }

    Nodo<T> actual = lista.head;

    while (actual.siguiente != null &&
           comparator.compare(elemento, actual.siguiente.dato) >= 0)
    {
        actual = actual.siguiente;
    }

    nuevo.siguiente = actual.siguiente;
    actual.siguiente = nuevo;
    }

}

    
  

