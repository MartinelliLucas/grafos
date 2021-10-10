package grafos;

import static org.junit.Assert.*;

import org.junit.Test;

public class pesos {


	@Test
	public void coincidePesoTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 3);
		assertTrue(grafo.pesoArista(2, 3)== grafo.pesoArista(3, 2));
		System.out.println(grafo.pesoArista(2, 3));
	}

}
