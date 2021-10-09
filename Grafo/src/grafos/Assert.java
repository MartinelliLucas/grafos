package grafos;

import java.util.Set;
import static org.junit.Assert.*;

public class Assert {

	public static boolean iguales(int[] esperados, Set<Integer> alcanzables) {
		assertEquals(esperados.length, alcanzables.size());
		for (int elemento : esperados) {
			assertTrue(alcanzables.contains(elemento));
		}
		return false;
	}

}
