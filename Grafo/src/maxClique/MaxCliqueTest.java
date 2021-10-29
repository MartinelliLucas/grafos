package maxClique;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;

import grafos.Asserts;
import grafos.Grafo;

class MaxCliqueTest {


	@Test
	public void cliqueTresTest() {
		FuerzaBruta resolver = new FuerzaBruta(trianguloConAntena());
		Set <Integer> obtenido = resolver.cliqueMaxima();
		int [] esperado = {0, 1, 2};
		
		Asserts.iguales(esperado, obtenido);	
	}
	@Test
	public void aisladoTest() {
		Grafo aislado = new Grafo (5);
		FuerzaBruta resolver = new FuerzaBruta(aislado);
		Set <Integer> obtenido = resolver.cliqueMaxima();
		
		
		assertEquals(1, obtenido.size());
		
	}
	@Test
	public void completoTest() {

		FuerzaBruta resolver = new FuerzaBruta(completo());
		Set <Integer> obtenido = resolver.cliqueMaxima();
		int [] esperado = {0, 1, 2, 3};

		Asserts.iguales(esperado, obtenido);	
	}
	
	private Grafo completo() {
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(0, 3);
		grafo.agregarArista(1, 2);
		grafo.agregarArista(1, 3);
		grafo.agregarArista(2, 3);
		
		return grafo;
	}
	private Grafo trianguloConAntena() {
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(1, 2);
		grafo.agregarArista(3, 1);
		return grafo;
	}

}
