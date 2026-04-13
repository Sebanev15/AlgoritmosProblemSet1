package org.example.Ejercicio17.BibliotecaCentral;

import java.util.function.Predicate;

import org.example.Ejercicio17.ListaEnlazada;
import org.example.Ejercicio17.TDALista;

public class BibliotecaUCU {
    private ListaEnlazada<NodoLibro> catalogo;

    

    public BibliotecaUCU(){
        this.catalogo = new ListaEnlazada<NodoLibro>();
    }

    public void incorporarLibroCatalogo(String titulo,int codigo,float precio){
        NodoLibro libro = new NodoLibro(titulo, codigo, precio);
        catalogo.agregar(libro);
    }

    private NodoLibro buscarLibro(int codigo){
        Predicate<NodoLibro> predicadoCodigo = n -> n.getCodigo()==codigo;
        NodoLibro actual = catalogo.buscar(predicadoCodigo);
        return actual;
    }

    public boolean agregarEjemplares(int codigo, int cantidad){
        NodoLibro actual =buscarLibro(codigo);
        if (actual == null){
            return false;
        }
        actual.cantidadEjemplares += cantidad;
        return true;
    }

    public boolean retirarLibro(int codigo){
        NodoLibro actual =buscarLibro(codigo);
        if (actual == null){
            return false;
        }
        return catalogo.remover(actual);
    }

    public int consultarExistencias(int codigo)  {
        NodoLibro actual =buscarLibro(codigo);
        if (actual != null) {
            return actual.cantidadEjemplares;
        }
        else{
            throw new IllegalArgumentException("codigo invalido/no encontrado");
        }
    }
    //No esta terminado, es totalmente provicional
    //No estoy seguro a que se refiere la letra con listar
    //Falta devolver el stock
    public TDALista<NodoLibro> ordenarPorTitulo(){
        return catalogo.ordenar((l1, l2) -> l1.getTitulo().compareTo(l2.getTitulo()));
    }
}
