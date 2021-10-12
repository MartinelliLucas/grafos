package algoritmos;

import java.util.HashSet;
import java.util.Set;

import bfs.BFS;
import grafos.Grafo;

public class Kruskal {

	public Grafo aplicarKruskal(Grafo grafo) {
		
		Grafo BGM = new Grafo(grafo.tamanio());
		int i = 1;
		int posX=0;
		int posY=0;
		double pesoMin = grafo.pesoArista(0, 0);
		while (i <= grafo.tamanio() - 1) {
			for (int k = 0; k < grafo.tamanio(); k++) {
				for (int j = 0; j < grafo.tamanio(); j++) {
					if (grafo.pesoArista(k, j)< pesoMin) {
						pesoMin = grafo.pesoArista(k, j);
						posX = k;
						posY = j;
					}
				}
			}
			if (!BFS.alcanzables(BGM, 0).contains(posY)) { // nose que valor se usa para chequear si esta contenido en alcanzables.
				BGM.agregarArista(posX, posY);
			}
		}
		
		return BGM;
	}

}
