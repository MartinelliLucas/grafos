package grafos;

import static org.junit.Assert.*;

import java.util.Set;


public class Asserts {

	//verifica que sean iguales como sets
	public static void iguales(int[] esperado, Set<Integer> obtenido) {
		assertEquals(esperado.length, obtenido.size());

		for (int i = 0; i < esperado.length; i++) {
			assertTrue(obtenido.contains(esperado[i]));

		}

	}
}
