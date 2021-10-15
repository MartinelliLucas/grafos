package algoritmos;

import bfs.BFS;
import grafos.Arista;
import grafos.Grafo;

public class Kruskal {

//	public static Grafo aplicarKruskal(Grafo grafo) {
//
//		Grafo AGM = new Grafo(grafo.tamanio());
//		int i = 1;
//		int posX = 0;
//		int posY = 0;
//
//		while (i <= grafo.tamanio() - 1) {
//			for (int k = 0; k < grafo.tamanio(); k++) {
//				for (int j = 0; j < grafo.tamanio(); j++) {
//					if (k == j) {
//						continue;
//					}
//					if (grafo.pesoArista(k, j) < pesoMin && k != j) {
//						pesoMin = grafo.pesoArista(k, j);
//						posX = k;
//						posY = j;
//
//						if (!BFS.alcanzables(AGM, posX).contains(posY)) {
//							AGM.agregarAristaConPeso(posX, posY, pesoMin);
//						}
//					}
//				}
//			}
//			i++;
//		}
//
//		return AGM;
//	}

	public Grafo KruskalBFS(Grafo grafo) {

		if (!BFS.esConexo(grafo))
			throw new IllegalArgumentException("El grafo ingresado no es conexo, por lo tanto no posee AGM");

		Grafo AGM = new Grafo(grafo.tamanio());
		int i = 1;
		
		while (i <= grafo.tamanio() - 1) {
			for (Arista arista : grafo.getAristas()) {
				
				int verticeDestino = arista.getVerticeDestino();
				int verticeOrigen = arista.getVerticeOrigen();
				double peso = arista.getPeso();

				if (!BFS.alcanzables(grafo, verticeOrigen).contains(verticeDestino)) {
					AGM.agregarAristaConPeso(verticeOrigen, verticeDestino, peso);
				}
				i++;
			}
		}
		return AGM;
	}

}
