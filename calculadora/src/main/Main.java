package main;

import calculadoras.Calculadora;
import calculadoras.CalculadoraAvanzada;

public class Main {

	public static void main(String[] args) {
		
		CalculadoraAvanzada calculadoraAvanzada = new CalculadoraAvanzada();
		
		int resultadoSuma = Calculadora.sumar(5,3);
		int resultadoResta = Calculadora.restar(5, 2);
		int resultadoMultiplicacion = Calculadora.multiplicar(5, 2);
		int resultadoDivision = Calculadora.dividir(6,2);
		System.out.println(resultadoSuma);
		System.out.println(resultadoResta);
		System.out.println(resultadoMultiplicacion);
		System.out.println(resultadoDivision);
		System.out.println();		
		System.out.println(calculadoraAvanzada.modulo(-5));
		System.out.println(calculadoraAvanzada.potencia(4,2));
		System.out.println(calculadoraAvanzada.raizCuadrada(8));
		
	}

}
