package calculadoras;
import java.lang.Math;

public class CalculadoraAvanzada {
	public static int sumar(int x, int y) {
		return(x+y);
	}
	
	public static int restar(int x, int y) {
		return(x-y);
	}
	
	public static int multiplicar(int x, int y) {
		return(x*y);
	}
	
	public static int dividir(int x, int y) {
		return(x/y);
	}
	
	public int potencia(int valor, int exponente) {
		int resultado = 1;
		for(int i = 0; i < exponente; i++) {
			resultado = valor * resultado;
		}
		return resultado;
	}
	
	public int modulo(int x) {
		if(x < 0) {
			return(-x);
		}else {
			return(x);
		}
	}
	
	public double raizCuadrada(double x) {
		return(Math.sqrt(x));
	}
	
}
