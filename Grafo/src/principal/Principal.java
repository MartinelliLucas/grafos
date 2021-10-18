package principal;

import algoritmos.Kruskal;
import bfs.BFS;
import grafos.Grafo;

public class Principal {

	public static void main (String [] args) {
		
		Grafo grafoAleatorio = new Grafo(5, 2);
		System.out.println("Grafo Conexo: " + BFS.esConexo(grafoAleatorio));
		
		Long antesKruskalBFS = System.currentTimeMillis();
		Grafo grafoKruskalBFS = Kruskal.kruskalBFS(grafoAleatorio);
		Long despuesKruskalBFS = System.currentTimeMillis();
		Long tiempoEjecucionKruskalBFS = (despuesKruskalBFS - antesKruskalBFS);
		
		System.out.println("El tiempo de ejecucion de Kruskal con BFS fue de: " + tiempoEjecucionKruskalBFS + " milisegundos.");
		
		Long antesKruskalUnionFind = System.currentTimeMillis();
		Grafo grafoKruskalUnionFind = Kruskal.kruskalUnionFind(grafoAleatorio);
		Long despuesKruskalUnionFind = System.currentTimeMillis();
		Long tiempoEjecucionKruskalUnionFind = despuesKruskalUnionFind - antesKruskalUnionFind;
		
		System.out.println("El tiempo de ejecucion de Kruskal con Union Find fue de: " + tiempoEjecucionKruskalUnionFind + " milisegundos.");
	
	}
}
