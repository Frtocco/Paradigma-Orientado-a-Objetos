package medio;

public class Tanque extends Vehiculo{

	public Tanque(double cantidadCombustible) {
		super(cantidadCombustible);
	}

	@Override
	public int getPoderCombate() {
		return (int) Math.round(4 * cantidadCombustible);
	}

}
