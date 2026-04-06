package org.example.Ejercicio17;



public class Cola<T> extends ListaEnlazada<T> implements TDACola<T>  {
    public Nodo<T> frente;
    protected int size = 0; //tuvimos que crear un nuevo size porque no heredaba bien de lista enlazada.
    
    @Override
    public T frente() {
        return frente.dato;
    }

    @Override
    public boolean poneEnCola(T dato) {
        Nodo<T> nodoNuevo = new Nodo<T>(dato, null);
        if (frente == null){
            frente = nodoNuevo;
            this.head = nodoNuevo;
        }
        else{
            frente.siguiente = nodoNuevo;
            frente = nodoNuevo;
        }
        this.size++;
        return frente.siguiente == null;
    }

    @Override
    public T quitaDeCola() {
        Nodo<T> nodoEliminado = head;
        head = head.siguiente;
        nodoEliminado.siguiente = null;
        this.size--;
        return nodoEliminado.dato;
    }

    public Nodo<T> devolverPrimero()
    {
        return head;
    }

    public int devolverTamano(){
        return this.size;
    }
   

}
