package grafos;

import static org.junit.Assert.*;

import org.junit.Test;

public class AristasTest {

	// casos en los que se lanza excepcion
	@Test(expected = IllegalArgumentException.class)
	public void primerVerticeNegativo() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(-1, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void segundoVerticeNegativo() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void primerVerticeExcedido() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(5, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void segundoVerticeExcedido() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(1, 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void agregarLoop() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 2);
	}

	@Test
	public void aristaExistente() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 3);
		assertTrue(grafo.existeArista(2, 3)); // esta linea significa que lo qe hay dentro del parentesis debe dar true

	}

	@Test
	public void aristaOpuestaTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 3);
		assertTrue(grafo.existeArista(3, 2));

	}

	@Test
	public void aristaInexistente() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 3);
		assertFalse(grafo.existeArista(1, 4)); // esta linea significa que lo qe hay dentro del parentesis debe dar
												// false
	}

	@Test
	public void eliminarAristaExistente() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 3);
		grafo.eliminarArista(2, 3);
		assertFalse(grafo.existeArista(2, 3));
	}

	@Test
	public void eliminarAristaInexistente() {
		Grafo grafo = new Grafo(5);
		grafo.eliminarArista(2, 3);
		assertFalse(grafo.existeArista(3, 2));
	}

	@Test
	public void eliminarAristaExistenteDosVeces() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 3);

		grafo.eliminarArista(2, 3);
		grafo.eliminarArista(2, 3);
		assertFalse(grafo.existeArista(2, 3));
	}

	@Test
	public void agregarAristaDosVeces() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 3);
		grafo.agregarArista(2, 3);

		assertTrue(grafo.existeArista(2, 3));
	}

}
