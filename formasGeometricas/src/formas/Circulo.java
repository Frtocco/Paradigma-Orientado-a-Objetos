package formas;

public class Circulo extends FormaGeometrica{	
	double radio;
	
	public Circulo(double radio) {
		this.radio = radio;
	}
	
	public double calcularArea() {
		return((3.14)*radio);
	}
	
	public double calcularPerimetro() {
		return((2*3.14)*radio);
	}
}
