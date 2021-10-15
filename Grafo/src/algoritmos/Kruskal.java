package algoritmos;

import bfs.BFS;
import grafos.Grafo;

public class Kruskal {

	public static Grafo aplicarKruskal(Grafo grafo) {

		Grafo AGM = new Grafo(grafo.tamanio());
		int i = 1;
		int posX = 0;
		int posY = 0;
		
		while (i <= grafo.tamanio() - 1) {
			for (int k = 0; k < grafo.tamanio(); k++) {
				for (int j = 0; j < grafo.tamanio(); j++) {
					if (k == j) {
						continue;
					}
					if (grafo.pesoArista(k, j) < pesoMin && k != j) {
						pesoMin = grafo.pesoArista(k, j);
						posX = k;
						posY = j;


						if (!BFS.alcanzables(AGM, posX).contains(posY)) {
							AGM.agregarAristaConPeso(posX, posY, pesoMin);
						}
					}
				}
			}
			i++;
		}

		return AGM;
	}
	
	public Grafo KruskalBFS (Grafo grafo) {
		Grafo AGM = new Grafo(grafo.tamanio());
	}

}
