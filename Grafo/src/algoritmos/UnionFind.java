package algoritmos;

public class UnionFind {

	private int[] parent;

	public UnionFind(int n) {
		parent = new int[n];
		for (var i = 0; i < n; i++) {
			parent[i] = i;
		}
	}

	// Busca la raiz del elemento dado por parametro
	public int root(int x) {
		if (x == parent[x]) {
			return x;
		}
		// path compression
		return parent[x] = root(parent[x]);
	}

	// Hace que la raiz de una de las componentes conexas
	// pasadas por parametro apunte a la raiz de la otra
	public void Union(int x, int y) {
		int px = root(x);
		int py = root(y);
		if (px != py) {
			parent[px] = py;
		}
	}

	// Determina si los elementos
	// pasados por parametros se encuentran en la misma componente conexa
	public boolean find(int i, int j) {

		return root(i) == root(j);

	}

}
