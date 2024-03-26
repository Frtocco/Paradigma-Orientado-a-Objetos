package formas;
import java.lang.Math;

public class Triangulo {
	
	double lado1;
	double lado2;
	double lado3;
	
	public Triangulo(double x, double y, double z) {
		this.lado1 = x;
		this.lado2 = y;
		this.lado3 = z;
	}
	
	public double calcularPerimetro() {
		return(lado1 + lado2 + lado3);
	}
	
	public double calcularArea() {
		double sP = calcularPerimetro()/2;
		return(Math.sqrt(sP*(sP-lado1)*(sP-lado2)*(sP-lado3))); //Formula de Herón.
	}
	
}
