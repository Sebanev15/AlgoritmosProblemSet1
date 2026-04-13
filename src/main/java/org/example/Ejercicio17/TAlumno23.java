package org.example.Ejercicio17;

public class TAlumno23  implements Comparable<TAlumno23>{
     private int cedula;
        private String nombre;
        private String apellido;
    public TAlumno23(int cedula, String nombre, String apellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    public int getCedula() {
        return cedula;
    }
    public int compareTo(TAlumno23 otro){       // letra pide que los conjuntos deben de estar ordenados
        return Integer.compare(this.cedula, otro.cedula);
    }
    @Override
    public String toString() {
        return cedula + " " + nombre + " " + apellido;
    }
    // para que el ocnjunto no tenga duplicados se compara la cedula.
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if(!(obj instanceof TAlumno23)){
            return false;
        }
        TAlumno23 otro = (TAlumno23) obj;
        return this.cedula == otro.cedula;
    }

    
    
}
