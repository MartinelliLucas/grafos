package algoritmos;

public class UnionFind {

	
	static int find(int parent[], int i)
	{
	    if (parent[i] == -1)
	        return i;
	    return find(parent, parent[i]);
	}
	   
	
	static void Union(int parent[], int x, int y)
	{
	    int xset = find(parent, x);
	    int yset = find(parent, y);
	    parent[xset] = yset;
	}
}
