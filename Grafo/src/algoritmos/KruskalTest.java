package algoritmos;

import org.junit.Assert;
import org.junit.Test;

import bfs.BFS;
import grafos.Grafo;

public class KruskalTest {

	@Test
	public void kruskalTest() {
		Grafo g = new Grafo(3);
		g.agregarAristaConPeso(0, 1, 1.5);
		g.agregarAristaConPeso(0, 2, 2.5);
		g.agregarAristaConPeso(1, 2, 3.5);
		double[][] expected = new double[3][3];
		expected[0][1] = 1.5;
		expected[0][2] = 2.5;
		expected[1][0] = 1.5;
		expected[2][0] = 2.5;

		Grafo nuevo = Kruskal.aplicarKruskal(g);
		Assert.assertArrayEquals(expected, nuevo.damePesos());

	}

	@Test
	public void conexoKruskalTest() {
		Grafo g = new Grafo(3);
		g.agregarAristaConPeso(0, 1, 2.5);
		g.agregarAristaConPeso(0, 2, 1.5);
		g.agregarAristaConPeso(1, 2, 3.5);
		double[][] expected = new double[3][3];
		expected[0][1] = 2.5;
		expected[0][2] = 1.5;
		expected[1][0] = 2.5;
		expected[2][0] = 1.5;

		Grafo nuevo = Kruskal.aplicarKruskal(g);
		Assert.assertTrue(BFS.esConexo(nuevo));
	}

}
