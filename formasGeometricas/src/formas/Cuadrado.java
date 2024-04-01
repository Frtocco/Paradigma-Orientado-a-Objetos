package formas;

public class Cuadrado extends FormaGeometrica{
	
	double lado;
	
	public Cuadrado(double lado) {
		this.lado = lado;
	}
	
	public double calcularArea() {
		return(lado*lado);
	}
	
	public double calcularPerimetro() {
		return(4*lado);
	}
}
