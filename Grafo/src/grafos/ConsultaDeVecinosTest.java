package grafos;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConsultaDeVecinosTest {

	// fuera de rango
	@Test(expected = IllegalArgumentException.class)
	public void verticeNegativoTest() {
		Grafo grafo = new Grafo(5);
		grafo.vecinos(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void verticeExcedidoTest() {
		Grafo grafo = new Grafo(5);
		grafo.vecinos(5);
	}

	// en rango
	@Test
	public void todosAisladosTest() {
		Grafo grafo = new Grafo(5);
		assertEquals(0, grafo.vecinos(2).size()); // primero valor esperado desp valor obtenido

	}

	@Test
	public void verticeUniversalTest() {
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(1, 0);
		grafo.agregarArista(1, 2);
		grafo.agregarArista(1, 3);

		int[] esperado = { 0, 2, 3 };
		
		Asserts.iguales(esperado, grafo.vecinos(1));
	}

	@Test
	public void verticeNormal() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(1, 3);
		grafo.agregarArista(2, 3);
		grafo.agregarArista(2, 4);

		int[] esperado = { 1, 2 };
		Asserts.iguales(esperado, grafo.vecinos(3));
	}

}
