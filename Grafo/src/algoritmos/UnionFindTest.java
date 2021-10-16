package algoritmos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UnionFindTest {

	@BeforeEach
	void setUp() throws Exception {
	}

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
