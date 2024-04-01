package main;

import formas.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		FormaGeometrica cuadrado = new Cuadrado(5);
		FormaGeometrica triangulo = new Triangulo(2,2,2);
		FormaGeometrica circulo = new Circulo(4);
		
		List<FormaGeometrica> formas = new ArrayList<>();
		formas.add(circulo);
		formas.add(triangulo);
		formas.add(cuadrado);
		
		for (FormaGeometrica forma: formas) {
			System.out.println(forma.calcularArea());
			System.out.println(forma.calcularPerimetro());
		}
	}

}
