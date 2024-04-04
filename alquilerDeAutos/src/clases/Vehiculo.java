package clases;

public abstract class Vehiculo {
	 protected String id;
	 private boolean estaDisponible;
	 public abstract double calcularCosto(String f1, String f2);
	 private double costoBase;
	 protected static int contador = 0;
	 
	 public Vehiculo(String prefijoId) {
		 contador ++;
		 this.id = prefijoId + contador;
	 }
	 
}
