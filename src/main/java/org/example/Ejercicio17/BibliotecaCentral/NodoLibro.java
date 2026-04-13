package org.example.Ejercicio17.BibliotecaCentral;
//Clase que tiene un libro y informacion que deberia tener cada nodo del catalogo
//podria haberlo metido dentro de libro, pero me parecio que no es responsabilidad del propio
//libro saber su precio y cantidad de stock
public class NodoLibro {
    
    public Libro libro;
    public float precio;
    public int cantidadEjemplares;

    public NodoLibro(String titulo, int codigo, float precio){
        this.libro = new Libro(codigo, titulo);
        this.precio = precio;
        this.cantidadEjemplares = 0;
    }

    public int getCodigo(){
        return libro.codigo;
    }

    public String getTitulo(){
        if (libro.titulo!= null){
            return libro.titulo;
        }
        throw new IllegalArgumentException("Titulo no valido");
    }
 
    @Override
    public boolean equals(Object obj){
        if (this==obj) return true;

        if (obj==null || getClass() != obj.getClass()) return false;

        NodoLibro otroNodoLibro = (NodoLibro) obj;
        

        return libro.equals(otroNodoLibro.libro);
    }
}
