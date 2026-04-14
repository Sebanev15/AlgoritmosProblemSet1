package org.example.ejercicio26;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.example.Ejercicio17.ListaEnlazada;
import org.example.Ejercicio17.TDALista;
import org.junit.jupiter.api.Test;

public class ExpresionTest {

    private TDALista<Character> crearLista(String texto){
        TDALista<Character> nuevaLista = new ListaEnlazada<Character>();
        for (Character c : texto.toCharArray()) {
            nuevaLista.agregar(c);
        }
        return nuevaLista;
    }


    @Test
    void testListaVacia() {
        Expresion expresion = new Expresion();
        TDALista<Character> lista = new ListaEnlazada<>();

        assertFalse(expresion.controlCorchetes(lista));
    }

    @Test
    public void testCorchetesCorrectos(){
        Expresion expresion = new Expresion();
        TDALista<Character> lista = crearLista("{}");

        assertTrue(expresion.controlCorchetes(lista));
    }

    @Test
    public void testCorchetesAnidadosCorrectos(){
        Expresion expresion = new Expresion();
        TDALista<Character> lista = crearLista("{{{}}}");

        assertTrue(expresion.controlCorchetes(lista));
    }

    @Test
    public void testFaltaCerrar(){
        Expresion expresion = new Expresion();
        TDALista<Character> lista = crearLista("{{}");

        assertFalse(expresion.controlCorchetes(lista));
    }

    @Test
    public void testFaltaAbrir(){
        Expresion expresion = new Expresion();
        TDALista<Character> lista = crearLista("{}}");

        assertFalse(expresion.controlCorchetes(lista));
    }

    @Test
    public void testCaracterInvalido(){
        Expresion expresion = new Expresion();
        TDALista<Character> lista = crearLista("{a}");

        assertFalse(expresion.controlCorchetes(lista));
    }

    @Test
    public void testSoloApertura(){
        Expresion expresion = new Expresion();
        TDALista<Character> lista = crearLista("{{{{");

        assertFalse(expresion.controlCorchetes(lista));
    }

    @Test
    public void testSoloCierre(){
        Expresion expresion = new Expresion();
        TDALista<Character> lista = crearLista("}}}}");

        assertFalse(expresion.controlCorchetes(lista));
    }

    @Test
    public void testListaNull(){
        Expresion expresion = new Expresion();

        assertThrows( IllegalArgumentException.class,
            () -> expresion.controlCorchetes(null));
    }
}
