package medio;

public class Helicoptero extends Vehiculo{

	public Helicoptero(double cantidadCombustible) {
		super(cantidadCombustible);
	}

	public int getPoderCombate() {
		return (int) Math.round(8 * cantidadCombustible + 50);
	}

}
