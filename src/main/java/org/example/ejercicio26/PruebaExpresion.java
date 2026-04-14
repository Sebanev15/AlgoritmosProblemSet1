package org.example.ejercicio26;

import java.util.List;


//En esta clase, simplemento estoy probando diversar expresiones
//Seria la parte 2 del ejercicio
//La parte 3 seria hacer los Test en JUnit
public class PruebaExpresion {
    public static void main(String[] args) {
        
        List<Character> lista1 = List.of('{');
        System.out.println(Expresion.controlCorchetes(lista1)+", espero FALSE"); 

        List<Character> lista2 = List.of('}');
        
        System.out.println(Expresion.controlCorchetes(lista2)+", espero FALSE"); 
        
        List<Character> lista3 = List.of('{','{','}','{','}','}');
        System.out.println(Expresion.controlCorchetes(lista3)+", espero TRUE"); 

        List<Character> lista4 = List.of('{','}');
        System.out.println(Expresion.controlCorchetes(lista4)+", espero TRUE"); 
    }
}
