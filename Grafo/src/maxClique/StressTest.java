package maxClique;

import java.util.Random;

import grafos.Grafo;

public class StressTest {

	public static void main(String[] args) {

		for (int n = 2; n < 500; n++) {
			long inicio = System.currentTimeMillis();
			Solver resolver = new Solver(aleatorio(n));
			resolver.cliqueMaxima();
			long fin = System.currentTimeMillis();
			double tiempo = (fin - inicio) / 1000.0;
			
			System.out.println("n= " + n + ": " + tiempo + " seg.");
		}

	}

	private static Grafo aleatorio(int n) {
		Grafo grafo = new Grafo(n);
		Random random = new Random(0);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i!=j && random.nextDouble() < 0.3) {
					grafo.agregarArista(i, j);
				}
			}
		}
		return grafo;
	}
}
