package ioo;

public class Tablero {
	private Ejercito ejercitoA, ejercitoB;
	
	public Tablero(Ejercito a, Ejercito b) {
		this.ejercitoA = a;
		this.ejercitoB = b;
	}
	
	public void enfrentar() {
		final int poderEjercitoA = ejercitoA.getPoderTotal();
		final int poderEjercitoB = ejercitoB.getPoderTotal();
		
		if (poderEjercitoA > poderEjercitoB) {
			System.out.println("Vencio el ejercito " + ejercitoA.getColor() + " con el poder " + poderEjercitoA);
		}else if (poderEjercitoA < poderEjercitoB) {
			System.out.println("Vencio el ejercito " + ejercitoB.getColor() + " con el poder " + poderEjercitoA);
		}else {
			System.out.println("Se produjo un empate");
		}
	}
	
}
