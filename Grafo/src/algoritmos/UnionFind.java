package algoritmos;

public class UnionFind {
	
	private static int [] A ;
	
	public UnionFind (int vertices) {
		int i= 0;
		while (i < vertices) {
			A[i]= i;
			i++;
		}
		
	}
	static int root (int i) {
		while (A[i]!= i) {
			i = A[i];
		}
		return i;
	}
	
	boolean find (int i, int j) {
		return root(i) == root (j);
	}
	
	static void Union(int i, int j)
	{
		int ri = root(i);
		int rj = root (j);
		A[ri] = rj;
	}
}
