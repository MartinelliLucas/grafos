package algoritmos;

import java.util.HashSet;
import java.util.Set;

import bfs.BFS;
import grafos.Grafo;

public class Kruskal {

	public static Grafo aplicarKruskal(Grafo grafo) {

		Grafo BGM = new Grafo(grafo.tamanio());
		int i = 1;
		int posX = 0;
		int posY = 0;
		double pesoMin = 100.0;
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

						if (!BFS.alcanzables(BGM, posX).contains(posY)) { 
							BGM.agregarAristaConPeso(posX, posY, pesoMin);
						}
					}
				}

			}
			i++;
		}

		return BGM;
	}

}
