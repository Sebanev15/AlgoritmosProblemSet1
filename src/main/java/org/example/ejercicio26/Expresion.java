package org.example.ejercicio26;
import java.util.List;
import java.util.Stack;

public class Expresion {
    public static boolean controlCorchetes(List<Character> listaDeEntrada){
        Stack<Character> corchetesPila = new Stack<>();
        int indice = 0;
        while(indice<listaDeEntrada.size()){
            Character caracterActual = listaDeEntrada.get(indice);
            if (caracterActual.equals('{')){
                corchetesPila.push(caracterActual);
            }
            if (caracterActual.equals('}')){
                if (corchetesPila.isEmpty()){
                    return false;
                }
                corchetesPila.pop();
            }
            indice++;
        }
        return corchetesPila.isEmpty();
    }
}
