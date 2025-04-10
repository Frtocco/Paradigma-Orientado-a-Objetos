package ar.edu.UADE.controladores;

import ar.edu.UADE.excepciones.EstacionException;
import ar.edu.UADE.excepciones.LineaException;
import ar.edu.UADE.modelo.SistemaSubte;

public class agrePrincipal {
	
	public static void main(String argas[]) {
		
		SistemaSubte subtesDeLaCiudad=SistemaSubte.getInstance();
		subtesDeLaCiudad.crearLineaSubte("Linea D");
		subtesDeLaCiudad.crearLineaSubte("Linea H");
		subtesDeLaCiudad.crearEstacion("Catedral", 90);
		subtesDeLaCiudad.crearEstacion("Santa Fe", 100);
		subtesDeLaCiudad.crearEstacion("Congreso", 110);
		subtesDeLaCiudad.crearEstacion("Plaza de Mayo", 120);
		
		try {
			System.out.println("Agregado de vagones Alemanes a la linea D");
			for(int i=0;i<3;i++) {
				subtesDeLaCiudad.agregarVagonAleman("Linea D");
			}
			
			System.out.println("Agregado de vagones Argentinos a la linea H");
			for(int i=0;i<3;i++) {
				subtesDeLaCiudad.agregarVagonArgentino("Linea H");
			}
		
		
			subtesDeLaCiudad.agregarEstacionLinea("Plaza de Mayo", "Linea D");
			subtesDeLaCiudad.agregarEstacionLinea("Congreso", "Linea D");
			subtesDeLaCiudad.agregarEstacionLinea("Santa Fe", "Linea D");
			subtesDeLaCiudad.agregarEstacionLinea("Catedral", "Linea D");
			subtesDeLaCiudad.agregarEstacionLinea("Santa Fe", "Linea H");
			
			/*Vagon distinto al de la formacion*/
			System.out.println("Agregando un vagon distinto a la linea D");
			subtesDeLaCiudad.agregarVagonArgentino("Linea D");
			
			
			/*Estacion con capacidad menor a la formacion*/
			subtesDeLaCiudad.crearEstacion("Puerto Madero", 50);
			System.out.println("Agregando una linea de mayor capacidad");
			subtesDeLaCiudad.agregarEstacionLinea("Puerto Madero", "Linea D");
			
		} catch (EstacionException | LineaException ex) {
			ex.printStackTrace();
		}
		
	}
}
