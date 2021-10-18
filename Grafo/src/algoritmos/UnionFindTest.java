package algoritmos;

import static org.junit.Assert.*;
import org.junit.Test;

public class UnionFindTest {


	@Test
	public void testUnion() {
		UnionFind unionFind = new UnionFind(10);
		assertEquals(unionFind.root(1), 1);
	}

	@Test
	public void testSuccessfulFind() {
		UnionFind unionFind = new UnionFind(12);
		unionFind.Union(1, 2);

		assertTrue(unionFind.find(1, 2));
	}

	@Test
	public void testFailureFind() {
		UnionFind unionFind = new UnionFind(16);
		unionFind.Union(1, 2);

		assertFalse(unionFind.find(1, 3));
	}

	@Test
	public void testRoot() {
		UnionFind unionFind = new UnionFind(6);
		unionFind.Union(2, 1);
		assertEquals(unionFind.root(2), 1);
	}

}
