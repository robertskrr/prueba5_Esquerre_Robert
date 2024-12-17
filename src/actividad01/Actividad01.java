package actividad01;

import java.util.Scanner;

public class Actividad01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Introduce una frase: ");
		String frase = sc.nextLine();

		if (contPalabras(frase)>1) {
			System.out.println("La frase tiene " + contPalabras(frase) + " palabras.");
		}
		else {
			System.out.println("La frase tiene 1 palabra");
		}

		//palabraMax();
		//palabraMin();

		sc.close();

	}

	public static int contPalabras(String cad) {
		int contPalabras = 1; // Damos por hecho que la frase tendrá como mínimo una palabra

		for (int i = 1; i < cad.length(); i++) {
			// Si el caracter en la posicion i es una letra y el caracter anterior es un
			// espacio cuenta como una palabra más
			if (Character.isLetter(cad.charAt(i)) && Character.isWhitespace(cad.charAt(i - 1))) {
				contPalabras++;
			}
		}

		return contPalabras;
	}

	// No he sabido averiguar los métodos de máximo y mínimo :(, me gustaría repasarlo o ver la solución
	public static void palabraMax(String cad) {
		String palabraMax = "";
		int longCadMax = 0;
		for (int i = 0; i < cad.length(); i++) {
			if (Character.isLetter(cad.charAt(i))) {
				longCadMax++;
			}
		}
		System.out.println("La palabra de mayor longitud es: " + palabraMax + ", con " + longCadMax + " palabras");
	}

	public static void palabraMin(String cad) {
		String palabraMin = "";
		int longCadMin = 0;
		for (int i = 0; i < cad.length(); i++) {
			
		}
		System.out.println("La palabra de menor longitud es: " + palabraMin + ", con " + longCadMin + " palabras");
	}

}
