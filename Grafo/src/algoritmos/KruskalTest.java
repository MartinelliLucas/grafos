package algoritmos;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import bfs.BFS;
import grafos.Arista;
import grafos.Grafo;

public class KruskalTest {

	private Grafo crearGrafo() {
		Grafo g = new Grafo(5);
		g.agregarAristaConPeso(0, 1, 5);
		g.agregarAristaConPeso(0, 2, 25);
		g.agregarAristaConPeso(1, 2, 10);
		g.agregarAristaConPeso(2, 3, 15);
		g.agregarAristaConPeso(2, 4, 30);
		g.agregarAristaConPeso(3, 4, 20);

		return g;
	}

	@Test(expected = IllegalArgumentException.class)
	public void grafoNoConexo() {
		Grafo g = crearGrafo();
		g.eliminarArista(2, 4);
		g.eliminarArista(3, 4);

		Kruskal.kruskalBFS(g);
	}

	@Test(expected = IllegalArgumentException.class)
	public void grafoNoExistente() {
		Kruskal.kruskalBFS(null);
	}

	// verifica que cant aristas = cant vertices -1 y que el AGM sea conexo.
	@Test
	public void esAGMBFS() {
		Grafo g = crearGrafo();
		Grafo AGM = Kruskal.kruskalBFS(g);

		assertEquals(g.tamanio() - 1, AGM.getAristas().size());
		assertTrue(BFS.esConexo(AGM));
	}

	@Test
	public void esAGMUnionFind() {
		Grafo g = crearGrafo();
		Grafo AGM = Kruskal.kruskalUnionFind(g);

		assertEquals(g.tamanio() - 1, AGM.getAristas().size());
		assertTrue(BFS.esConexo(AGM));
	}

	@Test
	public void aristasMenorPesoBFSTest() {
		Grafo g = new Grafo(3);
		g.agregarAristaConPeso(0, 1, 2);
		g.agregarAristaConPeso(0, 2, 1);
		g.agregarAristaConPeso(1, 2, 3);
		Grafo AGM = Kruskal.kruskalBFS(g);

		Set<Arista> esperado = new TreeSet<Arista>();
		esperado.add(new Arista(0, 1, 2));
		esperado.add(new Arista(0, 2, 1));

		assertEquals(esperado, AGM.getAristas());
	}

	@Test
	public void aristasMenorPesoUnionFindTest() {
		Grafo g = new Grafo(3);
		g.agregarAristaConPeso(0, 1, 2);
		g.agregarAristaConPeso(0, 2, 1);
		g.agregarAristaConPeso(1, 2, 3);
		Grafo AGM = Kruskal.kruskalUnionFind(g);

		Set<Arista> esperado = new TreeSet<Arista>();
		esperado.add(new Arista(0, 1, 2));
		esperado.add(new Arista(0, 2, 1));

		assertEquals(esperado, AGM.getAristas());
	}
}
