package clases;

public abstract class Vehiculo {
	 protected String id;
	 protected static int contador = 0;
	 
	 public Vehiculo(String prefijoId) {
		 contador ++;
		 this.id = prefijoId + contador;
	 }
	 
	 public boolean sosVehiculo(String idVehiculo) {
		 return(this.id.equals(idVehiculo));
	 }
	 
}
