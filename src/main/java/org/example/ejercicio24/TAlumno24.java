package org.example.ejercicio24;

public class TAlumno24  implements Comparable<TAlumno24>{
     private int cedula;
        private String nombre;
        private String apellido;
    public TAlumno24(int cedula, String nombre, String apellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    public int getCedula() {
        return cedula;
    }
    public int compareTo(TAlumno24 otro){       // letra pide que los conjuntos deben de estar ordenados
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
        if(!(obj instanceof TAlumno24)){
            return false;
        }
        TAlumno24 otro = (TAlumno24) obj;
        return this.cedula == otro.cedula;
    }

    
    
}
