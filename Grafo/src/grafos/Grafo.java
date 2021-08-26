package grafos;

public class Grafo {
	// grafos por matriz de adyacencia
	
	

	private boolean[][] A;

	public Grafo(int vertices) {
		A = new boolean[vertices][vertices]; // all false, no aristas
	}

	// getters and setters aristas

	public void agregarArista(int i, int j) {
		A[i][j] = A[j][i] = true;
	}

	public void eliminarArista(int i, int j) {
		A[i][j] = A[j][i] = false;
	}

	public boolean existeArista(int i, int j) {
		return A[i][j];

	}

}
