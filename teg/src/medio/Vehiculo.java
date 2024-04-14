package medio;

public abstract class Vehiculo extends MedioCombate{
	protected double cantidadCombustible;
	
	protected Vehiculo(double cantidadCombustible) {
		this.cantidadCombustible = cantidadCombustible;
	}

	public double getCantidadCombustible() {
		return cantidadCombustible;
	}

	public void setCantidadCombustible(double cantidadCombustible) {
		this.cantidadCombustible = cantidadCombustible;
	}
}
