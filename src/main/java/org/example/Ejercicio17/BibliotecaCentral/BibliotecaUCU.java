package org.example.Ejercicio17.BibliotecaCentral;

import java.util.function.Predicate;

import org.example.Ejercicio17.ListaEnlazada;
import org.example.Ejercicio17.Nodo;

public class BibliotecaUCU {
    private ListaEnlazada<NodoLibro> catalogo;

    

    public BibliotecaUCU(){
        this.catalogo = new ListaEnlazada<NodoLibro>();
    }

    public void incorporarLibroCatalogo(String titulo,int codigo,float precio){
        NodoLibro libro = new NodoLibro(titulo, codigo, precio);
        catalogo.agregar(libro);
    }

    

    public boolean agregarEjemplares(int codigo, int cantidad){
        Predicate<NodoLibro> predicadoCodigo = n -> n.getCodigo()==codigo;
        NodoLibro actual = catalogo.buscar(predicadoCodigo);
        actual.cantidadEjemplares += cantidad;
        return true;
    }
}
