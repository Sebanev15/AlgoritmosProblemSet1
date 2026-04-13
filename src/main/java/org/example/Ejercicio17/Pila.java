package org.example.Ejercicio17;

public class Pila <T> extends ListaEnlazada<T> implements TDAPila<T> {

    public int size =0;

    @Override
    public T tope() {
        if (head != null){
            return head.dato;
        }
        return null;
    }

    @Override
    public T saca() {
        T elementoEliminar= tope();
            Nodo<T> nodoEliminado= head;
            
        
         if(head.siguiente!=null){
            head= head.siguiente;
            nodoEliminado.siguiente=null;
        }
        
        return elementoEliminar;

        
    }

    @Override
    public void mete(T dato) {
        Nodo<T> nuevoNodo= new Nodo<T>(dato, head);
        head= nuevoNodo;
        
    }


    
}
