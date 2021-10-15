package algoritmos;

import static org.junit.Assert.*;

import org.junit.Test;

import bfs.BFS;
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
	@Test (expected = IllegalArgumentException.class)
	public void grafoNoConexo() {
		Grafo g = crearGrafo();
		g.eliminarArista(2, 4);
		g.eliminarArista(3, 4);
		
		Kruskal.kruskalBFS(g);
	}
	
	@Test
	public void esAGM() {
		Grafo g = crearGrafo();
		Grafo AGM = Kruskal.kruskalBFS(g);
	
		assertEquals(g.tamanio(),  AGM.tamanio());
		assertTrue(BFS.esConexo(AGM));
	}
}
