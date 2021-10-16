package algoritmos;

import bfs.BFS;
import grafos.Arista;
import grafos.Grafo;

public class Kruskal {

	public static Grafo kruskalBFS(Grafo grafo) {


		verificarGrafo(grafo);

		Grafo AGM = new Grafo(grafo.tamanio());
		int i = 1;

		while (i <= grafo.tamanio() - 1) {
			for (Arista arista : grafo.getAristas()) {

				int verticeDestino = arista.getVerticeDestino();
				int verticeOrigen = arista.getVerticeOrigen();
				double peso = arista.getPeso();

				if (!BFS.alcanzables(AGM, verticeOrigen).contains(verticeDestino)) {
					AGM.agregarAristaConPeso(verticeOrigen, verticeDestino, peso);
				}
				i++;
			}
		}
		return AGM;
	}

	public static Grafo kruskalUnionFind(Grafo grafo) {

		verificarGrafo(grafo);

		Grafo AGM = new Grafo(grafo.tamanio());
		UnionFind UF = new UnionFind(grafo.tamanio());
		int i = 1;
		while (i <= grafo.tamanio() - 1) {
			for (Arista arista : grafo.getAristas()) {

				int verticeDestino = arista.getVerticeDestino();
				int verticeOrigen = arista.getVerticeOrigen();
				double peso = arista.getPeso();
				if (!UF.find(verticeOrigen, verticeDestino)) {
					UF.Union(verticeOrigen, verticeDestino);
					AGM.agregarAristaConPeso(verticeOrigen, verticeDestino, peso);
				}

			}
			i++;
		}
		return AGM;
	}

	private static void verificarGrafo(Grafo grafo) {
		if (!BFS.esConexo(grafo))
			throw new IllegalArgumentException("El grafo ingresado no es conexo, por lo tanto no posee AGM");

		if (grafo == null)
			throw new IllegalArgumentException("El grafo ingresado no existe (null)");
	}

}
