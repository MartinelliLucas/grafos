package grafos;

import java.util.concurrent.ThreadLocalRandom;

public class Arista implements Comparable<Arista>{
	int verticeOrigen;
	int verticeDestino;
	double peso;
	
	public Arista(int verticeOrigen, int verticeDestino ) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.peso = ThreadLocalRandom.current().nextDouble(0, 1);
	}
	
	public Arista(int verticeOrigen, int verticeDestino, double peso) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.peso = peso;
	}
	public double getPeso() {
		return this.peso;
	}
	@Override
	public int compareTo(Arista e) {
		int ret = 0;
		if (this.getPeso() < e.getPeso())
			ret = -1;
		if (this.getPeso() > e.getPeso())
			ret = 1;
		return ret;
	}
}
