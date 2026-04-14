package org.example.Ejercicio17.BibliotecaCentral;
//Clase que tiene un libro y informacion que deberia tener cada nodo del catalogo
//podria haberlo metido dentro de libro, pero me parecio que no es responsabilidad del propio
//libro saber su precio y cantidad de stock
public class NodoLibro {
    
    public Libro libro;
    private float precio;
    private int cantidadEjemplares;

    public NodoLibro(String titulo, String codigo, float precio, int cantidad){
        this.libro = new Libro(codigo, titulo);
        this.precio =(precio <= 0) ? 0 : precio;
        this.cantidadEjemplares = (cantidad <= 0) ? 0 : cantidad;
    }

    public String getCodigo(){
        return libro.codigo;
    }

    public int getStock(){
        return cantidadEjemplares;
    }

    public int modifyStock(int cantidad){
        if (cantidadEjemplares+cantidad < 0){
            cantidadEjemplares = 0;
        }
        else{
            cantidadEjemplares= cantidadEjemplares + cantidad;
        }
        return cantidadEjemplares;
    }

    public float getPrecio(){
        return precio;
    }

    public float modifyPrice(int precio){
        if (0 <= precio){
            this.precio= precio;
        }
        return this.precio;
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
