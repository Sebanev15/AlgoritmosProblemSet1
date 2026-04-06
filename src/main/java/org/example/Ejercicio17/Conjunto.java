package org.example.Ejercicio17;

public class Conjunto<T extends Comparable<T>> extends ListaEnlazada<T> implements TDAConjunto<T>{
    public Conjunto() {
    }
    
    @Override
    public TDAConjunto<T> union(TDAConjunto<T> otrConjunto){
        TDAConjunto<T> resultado= new Conjunto<>();
        Nodo<T> nodoActual=this.head;

        while (nodoActual!= null){
            resultado.agregar(nodoActual.dato);
            nodoActual=nodoActual.siguiente;
        }


        return null;
    }
    public TDAConjunto<T> interseccion(TDAConjunto<T> otrConjunto){
        TDAConjunto<T> resultado =new Conjunto<>();
        Nodo<T> nodoActual=this.head;
        while(nodoActual!=null){
            if (otrConjunto.buscar(nodoActual.dato()) != null){
                resultado.agregar(nodoActual.dato);
            }
            nodoActual=nodoActual.siguiente;
        }
        return resultado;
    }
    public TDAConjunto<T> diferencia (TDAConjunto<T> otrConjunto){
        TDAConjunto<T> resultado= new Conjunto<>();
        Nodo<T> nodoActual=this.head;
        while (nodoActual!=null){
            if (otrConjunto.buscar(nodoActual.dato())== null){
                resultado.agregar(nodoActual.dato);
            }
            nodoActual=nodoActual.siguiente;
        }
        return resultado;
    }
    
    
}
