package main;

import calculadora.Calculadora; 

public class Main {

	public static void main(String[] args) {
		int resultadoSuma = Calculadora.sumar(5,3);
		int resultadoResta = Calculadora.restar(5, 2);
		int resultadoMultiplicacion = Calculadora.multiplicar(5, 2);
		int resultadoDivision = Calculadora.dividir(6,2);
		System.out.println(resultadoSuma);
		System.out.println(resultadoResta);
		System.out.println(resultadoMultiplicacion);
		System.out.println(resultadoDivision);
	}

}
