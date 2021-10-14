package bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import grafos.Grafo;

public class BFS {

	private static boolean[] marcados;
	private static ArrayList<Integer> L;

	public static boolean esConexo(Grafo grafo) {
		if (grafo == null) {
			throw new IllegalArgumentException("El grafo no existe! (null)");
		}
		if (grafo.vertices() == 0) {
			return true;
		}
		return alcanzables(grafo, 0).size() == grafo.vertices();
	}

	public static Set<Integer> alcanzables(Grafo g, int origen) {
		Set<Integer> ret = new HashSet<>();
		inicializar(g, origen);

		while (L.size() > 0) {
			int i = L.get(0);
			marcados[i] = true;
			ret.add(i);

			agregarVecinosPendientes(g, i);
			L.remove(0);
		}

		return ret;
	}

	private static void agregarVecinosPendientes(Grafo g, int i) {
		for (int vertice : g.vecinos(i)) {
			if (marcados[vertice] == false && L.contains(vertice) == false) {
				L.add(vertice);
			}
		}

	}

	private static void inicializar(Grafo g, int origen) {
		L = new ArrayList<Integer>();
		L.add(origen);
		marcados = new boolean[g.vertices()];
	}

}
