package grafos;

import java.util.HashSet;
import java.util.Set;

public class Grafo {

	// grafos por matriz de adyacencia
	private boolean[][] A;

	// la cantidad de vertices esta predeterminada desde el constructor
	public Grafo(int vertices) {
		A = new boolean[vertices][vertices]; // all false, no aristas
	}

	// getters and setters aristas

	public void agregarArista(int i, int j) {
		//mucho codigo defensivo para poco ccodigo de negocio esta muy desbalanceado
		verificarVertice(i);
		verificarVertice(j);
		verificarLoop(i, j);
		A[i][j] = A[j][i] = true;
	}

	private void verificarLoop(int i, int j) {
		if (i == j) {
			throw new IllegalArgumentException("No se permiten loops: (" + i + ", " + j + ")");
		}
	}
	//Verifica que sea un vertice válido
	private void verificarVertice(int i) {
		if (i < 0 || i >= A.length) {
			throw new IllegalArgumentException("El vertice no puede exceder los limites del grafo: " + i);
		}
	}

	public void eliminarArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		verificarLoop(i, j);
		
		A[i][j] = A[j][i] = false;
	}
	public int tamanio () {
		return A.length;
	}
	//Vecinos de un vertice
	public Set <Integer> vecinos (int i){
		
		verificarVertice(i);
		Set <Integer> ret = new HashSet <Integer>();
		
		for (int j = 0; j < this.tamanio(); j++) if (i != j) {
			if (this.existeArista(i, j)) {
				ret.add(j);
			}
		}
		return ret;
	}
	public boolean existeArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		verificarLoop(i, j);
		return A[i][j];
	}

	public int vertices() {
		return A.length;
	}
	
	
}
