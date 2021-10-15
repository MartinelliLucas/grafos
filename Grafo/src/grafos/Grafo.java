package grafos;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Grafo {

	// grafos por matriz de adyacencia
	private Arista[][] A;
	private Set<Arista> E;

	// la cantidad de vertices esta predeterminada desde el constructor
	public Grafo(int vertices) {
		A = new Arista[vertices][vertices]; // all null, no aristas
		E = new TreeSet<Arista>();
	}

	// Agrega arista con un peso double random entre 0 y 1
	public void agregarArista(int i, int j) {
		
		verificarVertice(i);
		verificarVertice(j);
		verificarLoop(i, j);

		Arista nueva = new Arista(i, j);
		A[i][j] = nueva;
		A[j][i] = nueva;
		E.add(nueva);
	}

	// Agrega arista con peso predefinido por parametro
	public void agregarAristaConPeso(int i, int j, double peso) {
		verificarVertice(i);
		verificarVertice(j);
		verificarLoop(i, j);

		Arista nueva = new Arista(i, j, peso); 
		A[i][j] = A[j][i] = nueva;
		E.add(nueva);
	}

	public double pesoArista(int i, int j) {
		return A[i][j].getPeso();
	}

	private void verificarLoop(int i, int j) {
		if (i == j) {
			throw new IllegalArgumentException("No se permiten loops: (" + i + ", " + j + ")");
		}
	}

	// Verifica que sea un vertice válido
	private void verificarVertice(int i) {
		if (i < 0 || i >= A.length) {
			throw new IllegalArgumentException("El vertice no puede exceder los limites del grafo: " + i);
		}
	}

	public void eliminarArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		verificarLoop(i, j);
		if (this.existeArista(i, j))
			E.remove(A[i][j]);
		A[i][j] = null;
		A[j][i] = null;
		
	}

	public int tamanio() {
		return A.length;
	}

	// Vecinos de un vertice
	public Set<Integer> vecinos(int i) {

		verificarVertice(i);
		Set<Integer> ret = new HashSet<Integer>();

		for (int j = 0; j < this.tamanio(); j++)
			if (i != j) {
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
		
		return A[i][j] != null;
	}

	public boolean esConexoBFS(int inicial) {
		verificarVertice(inicial);

		Set<Integer> marcados = new HashSet<Integer>();
		List<Integer> pendientes = new LinkedList<Integer>();
		pendientes.add(inicial);

		while (pendientes.size() != 0) {
			// obtenemos el primero de la lista.
			int vertice = pendientes.get(0);
			// marco al vertice obtenido.
			marcados.add(vertice);

			// agregamos a la lista de pendientes a todos sus vecinos no marcados.
			for (Integer elem : this.vecinos(vertice)) {
				if (!marcados.contains(elem))
					pendientes.add(elem);
			}
			// eliminamos de pendientes al vertice obtenido.
			pendientes.remove(0);
		}
		// si la cant de vertices alcanzados es igual a los vertices del grafo, es
		// conexo.
		return marcados.size() == this.tamanio();
	}

	public Set<Arista> getAristas() {
		return E;
	}
}
