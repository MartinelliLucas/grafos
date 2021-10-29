package maxClique;

import java.util.Set;

import grafos.Grafo;

public class Auxiliares {
	
	/**
	 * 
	 * @param grafo
	 * @param conjunto
	 * @return determina si un conjunto de vertices forma una clique
	 */
	public static boolean esClique(Grafo grafo , Set<Integer> conjunto) {
		for (Integer i : conjunto) {
			for (Integer j : conjunto) {
				if (i != j && !grafo.existeArista(i, j)) {
					return false;
				}
			}
		}
		return true;
	}
}
