package maxClique;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import grafos.Grafo;

class AuxiliaresTest {


	@Test
	void grafoAisladoTest() {
		int [] c = {2, 3, 4};
		Grafo grafo = new Grafo(5);
		
		assertFalse(Auxiliares.esClique(grafo, toSet(c)));
	}
	
	@Test
	void vacioTest() {
		int [] c = {};
		Grafo grafo = new Grafo(5);
		
		assertTrue(Auxiliares.esClique(grafo, toSet(c)));
	}
	
	@Test
	void trianguloTest() {
		int [] c = {0, 1, 2};
		Grafo grafo = trianguloConAntena();	
		
		assertTrue(Auxiliares.esClique(grafo, toSet(c)));
	}
	
	@Test
	void noTrianguloTest() {
		int [] c = {0, 1, 3};
		Grafo grafo = trianguloConAntena();	
			
		assertFalse(Auxiliares.esClique(grafo, toSet(c)));
	}
	
	@Test
	void soloUnaAristaTest() {
		int [] c = {1, 3};
		Grafo grafo = trianguloConAntena();	
		
		assertTrue(Auxiliares.esClique(grafo, toSet(c)));
	}
	
	private Grafo trianguloConAntena() {
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(1, 2);
		grafo.agregarArista(3, 1);
		return grafo;
	}
	
	private Set<Integer> toSet (int [] valores){
		Set<Integer> ret = new HashSet <Integer>();
		for (Integer i : valores) {
			ret.add(i);
		}
		return ret;
	}
}
