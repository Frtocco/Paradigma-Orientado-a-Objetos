package ioo;
import medio.Medio;
import medio.MedioCombate;


public class Ejercito {
	private String color;
	private Medio [] medios;
	
	public Ejercito(String color, MedioCombate medio1, MedioCombate medio2, MedioCombate medio3) {
		this.color = color;
		medios = new Medio[] {medio1, medio2, medio3};
	}
	
	public String getColor() {
		return(color);
	}
	
	public int getPoderTotal() {
		int poder = 0;
		for(int i=0;i<medios.length;i++) {
			poder += medios[i].getPoderCombate();
		}
		return poder;
	}
	
}
