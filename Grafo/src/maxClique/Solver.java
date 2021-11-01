package maxClique;

import java.util.HashSet;
import java.util.Set;

import grafos.Grafo;

public class Solver {

	private Grafo grafo;

	// Mayor clique hasta el momento
	private Set<Integer> mayor;
	// Auxiliar para la recursion
	private Set<Integer> actual;

	public Solver(Grafo g) {

		this.grafo = g;
	}

	/**
	 * 
	 * @param grafo
	 * @return set con la clique maxima, es decir el subconjunto con mayor cantidad
	 *         de vertices que sean clique en O(n²*2^n)
	 * 
	 */
	public Set<Integer> cliqueMaxima() {
		mayor = new HashSet<Integer>();
		actual = new HashSet<Integer>();

		generarDesde(0);
		return mayor;
	}

	private void generarDesde(int vertice) {
		// caso base 1 : llegamos a una hoja
		if (vertice == grafo.tamanio()) {
			if (actual.size() > mayor.size()) {
				mayor = clonar(actual);
			}
			return;
		}
		//caso recursivo
		actual.add(vertice);
		// caso base 2 : no es clique
		if (Auxiliares.esClique(grafo, actual)) {
			
			generarDesde(vertice + 1);
		}
			actual.remove(vertice);
			generarDesde(vertice + 1);
		
	}

	private Set<Integer> clonar(Set<Integer> conjunto) {
		Set<Integer> ret = new HashSet<Integer>();
		for (Integer integer : conjunto) {
			ret.add(integer);
		}
		return ret;
	}

}
