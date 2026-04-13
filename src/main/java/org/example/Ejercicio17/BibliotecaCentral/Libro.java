package org.example.Ejercicio17.BibliotecaCentral;

public class Libro {
    //Agrego solo codigo y titulo a clase libro, porque precio y cantidad ejemplares no
    //parece ser responsabilidad de clase libro
    public int codigo;
    public String titulo;
    
    public Libro(int codigo, String titulo){
        this.codigo = codigo;
        this.titulo = titulo;
    }

    @Override
    public boolean equals(Object obj){
        if (this==obj) return true;

        if (obj==null || getClass() != obj.getClass()) return false;

        Libro otroLibro = (Libro) obj;

        return codigo == otroLibro.codigo;
    }
}
