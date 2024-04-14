package main;
import ioo.*;
import medio.*;
public class Main {

	public static void main(String[] args) {
		Ejercito azul = new Ejercito("Azul", new Avion(10.50), new Comando(), new Tanque(12.00));
		Ejercito rojo = new Ejercito("Rojo", new Helicoptero(13.45), new Soldado(), new Paracaidista());
		
		Tablero tablero = new Tablero(azul, rojo);
		
		tablero.enfrentar();
		
		Comando comando = new Comando();
		comando.emboscar();
		comando.dispararFusil();
		comando.emboscar();
		
		Avion avion = new Avion(10.50);
		System.out.println(avion.getCantidadCombustible());
	
	
	}
	

}
