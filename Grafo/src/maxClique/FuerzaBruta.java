package maxClique;

import java.util.HashSet;
import java.util.Set;

import grafos.Grafo;

public class FuerzaBruta {

	private Grafo grafo;

	//Mayor clique hasta el momento
	private Set <Integer> mayor;
	// Auxiliar para la recursion
	private Set<Integer> actual;

	public FuerzaBruta(Grafo g) {

		this.grafo = g;
	}

	/**
	 * 
	 * @param grafo
	 * @return set con la clique maxima, es decir el subconjunto con mayor cantidad
	 *         de vertices que sean clique en O(n²*2^n)
	 *    
	 */
	public Set <Integer> cliqueMaxima() {
		mayor = new HashSet <Integer>();
		actual = new HashSet<Integer>();
		
		generarDesde(0);
		return mayor;
	}

	private void generarDesde(int vertice) {
		if (vertice == grafo.tamanio()) {
			if (Auxiliares.esClique(grafo,actual) && actual.size() > mayor.size()) {
				mayor = clonar(actual);
			}
		} 
		else {
			actual.add(vertice);
			generarDesde(vertice + 1);

			actual.remove(vertice);
			generarDesde(vertice + 1);
		}
	}

	private Set<Integer> clonar(Set<Integer> conjunto) {
		Set <Integer> ret = new HashSet <Integer>();
		for (Integer integer : conjunto) {
			ret.add(integer);
		}
		return ret;
	}

}
