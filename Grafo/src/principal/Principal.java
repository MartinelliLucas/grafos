package principal;

import algoritmos.Kruskal;
import bfs.BFS;
import grafos.Grafo;

public class Principal {

	public static void main(String[] args) {

		tiemposDeEjecucion(3, 3);
		tiemposDeEjecucion(10, 45);
		tiemposDeEjecucion(25, 80);
		tiemposDeEjecucion(50, 160);
		tiemposDeEjecucion(100, 320);
		tiemposDeEjecucion(200, 640);
	}

	private static void tiemposDeEjecucion(int vertices, int aristas) {
		Grafo grafo1 = new Grafo(vertices, aristas);
		System.out.println("El grafo de tamaño " + grafo1.tamanio() + " es conexo: " + BFS.esConexo(grafo1));

		medicionBFS(grafo1);
		medicionUnionFind(grafo1);
	}

	private static void medicionUnionFind(Grafo grafo) {
		Long antesKruskalUnionFind = System.currentTimeMillis();
		Grafo grafoKruskalUnionFind = Kruskal.kruskalUnionFind(grafo);
		Long despuesKruskalUnionFind = System.currentTimeMillis();
		Long tiempoEjecucionKruskalUnionFind = despuesKruskalUnionFind - antesKruskalUnionFind;

		System.out.println("El tiempo de ejecucion de Kruskal con Union Find fue de: " + tiempoEjecucionKruskalUnionFind
				+ " milisegundos.");
	}

	private static void medicionBFS(Grafo grafo) {

		Long antesKruskalBFS = System.currentTimeMillis();
		Grafo grafoKruskalBFS = Kruskal.kruskalBFS(grafo);
		Long despuesKruskalBFS = System.currentTimeMillis();
		Long tiempoEjecucionKruskalBFS = (despuesKruskalBFS - antesKruskalBFS);

		System.out.println(
				"El tiempo de ejecucion de Kruskal con BFS fue de: " + tiempoEjecucionKruskalBFS + " milisegundos.");
	}
}
