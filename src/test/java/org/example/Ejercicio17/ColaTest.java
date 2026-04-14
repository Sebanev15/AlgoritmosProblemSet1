package org.example.Ejercicio17;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ColaTest {

    @Test
    public void testInsertar() {
        Cola<Integer> cola = new Cola<>();

        cola.poneEnCola(5);

        assertEquals(5, cola.frente());
    }

    @Test
    public void testFIFO() {
        Cola<Integer> cola = new Cola<>();

        cola.poneEnCola(1);
        cola.poneEnCola(2);
        cola.poneEnCola(3);

        assertEquals(1, cola.quitaDeCola());
        assertEquals(2, cola.quitaDeCola());
        assertEquals(3, cola.quitaDeCola());
    }

    @Test
    public void testTamano() {
        Cola<Integer> cola = new Cola<>();

        cola.poneEnCola(1);
        cola.poneEnCola(2);

        assertEquals(2, cola.devolverTamano());
    }

    @Test
    public void testQuitar() {
        Cola<Integer> cola = new Cola<>();

        cola.poneEnCola(10);
        cola.poneEnCola(20);

        cola.quitaDeCola();

        assertEquals(20, cola.frente());
    }
}