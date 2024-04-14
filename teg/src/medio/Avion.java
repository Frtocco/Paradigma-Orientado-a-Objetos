package medio;

public class Avion extends Vehiculo{

	public Avion(double cantidadCombustible) {
		super(cantidadCombustible);
	}

	public int getPoderCombate() {
		return (int) Math.round(10 * cantidadCombustible + 100);
	}
	
	
}
