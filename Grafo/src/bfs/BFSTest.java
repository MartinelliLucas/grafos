package bfs;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import grafos.Assert;
import grafos.Grafo;

public class BFSTest {

	private Grafo inicializarGrafo() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(2, 3);
		return grafo;
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNull() {
		BFS.esConexo(null);
	}

	@Test
	public void vacioTest() {
		Grafo g = new Grafo(0);

		assertTrue(BFS.esConexo(g));
	}

	@Test
	public void alcanzablesTest() {
		Grafo g = inicializarGrafo();
		Set<Integer> alcanzables = BFS.alcanzables(g, 0);
		int[] esperados = { 0, 1, 2, 3 };
		Assert.iguales(esperados, alcanzables);
	}

	@Test
	public void conexoTest() {
		Grafo g = inicializarGrafo();
		g.agregarArista(3, 4);

		assertTrue(BFS.esConexo(g));
	}

	@Test
	public void noConexoTest() {
		Grafo g = inicializarGrafo();

		assertFalse(BFS.esConexo(g));
	}
}
