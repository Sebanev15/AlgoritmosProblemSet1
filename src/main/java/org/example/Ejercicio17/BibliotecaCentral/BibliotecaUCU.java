package org.example.Ejercicio17.BibliotecaCentral;

import java.util.function.Predicate;

import org.example.Ejercicio17.ListaEnlazada;
import org.example.Ejercicio17.TDALista;

public class BibliotecaUCU {
    private ListaEnlazada<NodoLibro> catalogo;
    private static BibliotecaUCU biblioteca = null;

    public BibliotecaUCU(){
        this.catalogo = new ListaEnlazada<NodoLibro>();
    }

    public static BibliotecaUCU getBiblioteca()
    {
        if (biblioteca == null){
            biblioteca = new BibliotecaUCU();
        }
        return biblioteca;

    }

    public void incorporarLibroCatalogo(String titulo,String codigo,float precio, int cantidad){
        NodoLibro libro = new NodoLibro(titulo, codigo, precio, cantidad);
        catalogo.agregar(libro);
    }

    public NodoLibro buscarLibro(String codigo){
        Predicate<NodoLibro> predicadoCodigo = nodo -> nodo.getCodigo().equals(codigo);
        NodoLibro actual = catalogo.buscar(predicadoCodigo);
        return actual;
    }

    public boolean retirarLibro(String codigo){
        NodoLibro actual =buscarLibro(codigo);
        if (actual == null){
            return false;
        }
        return catalogo.remover(actual);
    }

    public boolean prestamo(String codigo, int cantidad){
        NodoLibro actual = buscarLibro(codigo);
        if (actual.getStock() > 0){
            actual.modifyStock(-cantidad);
            System.out.println(cantidad + " de copias del libro " + actual.getTitulo() + " fueron prestadas.");
            return true;
        }
        return false;
    }

    public boolean devolucion(String codigo, int cantidad){
        NodoLibro actual = buscarLibro(codigo);
        if (actual != null){
            actual.modifyStock(cantidad);
            System.out.println(cantidad + " copias del libro " + actual.getTitulo() + " fueron devueltas.");
            return true;
        }
        return false;
    }

    public int consultarExistencias(String codigo)  {
        NodoLibro actual =buscarLibro(codigo);
        if (actual != null) {
            return actual.getStock();
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

    /*public void ordenarPorTitulo(){
        
        catalogo = catalogo.ordenar((l1, l2) -> l1.getTitulo().compareTo(l2.getTitulo()));
    }*/

    public void listar(){
        int tamaño = catalogo.tamaño();
        for (int i = 0; i < tamaño; i++){
            NodoLibro actual = catalogo.obtener(i);
            System.out.println("-" + actual.getTitulo() + ", " + actual.getStock());
        }
    }
}
