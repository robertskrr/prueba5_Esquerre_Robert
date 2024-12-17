package actividad01;

import java.util.Scanner;

public class Actividad01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Introduce una frase: ");
		String frase = sc.nextLine();

		System.out.println("La frase tiene " + contPalabras(frase) + " palabras.");

		palabraMax(frase);
		palabraMin(frase);

		sc.close();

	}

	public static int contPalabras(String cad) {
		 // Validación inicial: si la cadena es nula o solo contiene espacios, devolvemos 0
	    if (cad == null || cad.trim().isEmpty()) {
	        return 0;
	    }

	    int contador = 0;
	    boolean dentroPalabra = false;

	    // Recorremos la cadena caracter por caracter
	    for (int i = 0; i < cad.length(); i++) {
	        char c = cad.charAt(i);

	        if (!Character.isWhitespace(c)) { 
	            // Estamos en un carácter que no es un espacio
	            if (!dentroPalabra) {
	                contador++;
	                dentroPalabra = true; // Marcamos que estamos dentro de una palabra
	            }
	        } else {
	            // Encontramos un espacio, salimos de una palabra
	            dentroPalabra = false;
	        }
	    }

	    return contador;
	}

	// No he sabido averiguar los métodos de máximo y mínimo :(, me gustaría repasarlo o ver la solución
	public static void palabraMax(String cad) {
        String palabraActual = "";
        String palabraMax = "";
        int longCadMax = 0;

        for (int i = 0; i < cad.length(); i++) {
            char c = cad.charAt(i);

            if (Character.isLetter(c)) {
                // Acumulamos letras en la palabra actual
                palabraActual += c;
            } else {
                // Fin de una palabra, la evaluamos
                if (!palabraActual.isEmpty() && palabraActual.length() > longCadMax) {
                    palabraMax = palabraActual;
                    longCadMax = palabraActual.length();
                }
                // Reiniciamos la palabra actual
                palabraActual = "";
            }
        }

        // Evaluamos la última palabra, por si no termina en espacio
        if (!palabraActual.isEmpty() && palabraActual.length() > longCadMax) {
            palabraMax = palabraActual;
            longCadMax = palabraActual.length();
        }

        System.out.println("La palabra de mayor longitud es: \"" + palabraMax + "\", con " + longCadMax + " caracteres.");
	}

	public static void palabraMin(String cad) {
		String palabraActual = "";
        String palabraMin = "";
        int longCadMin = Integer.MAX_VALUE; // Inicializamos con un valor muy grande

        for (int i = 0; i < cad.length(); i++) {
            char c = cad.charAt(i);

            if (Character.isLetter(c)) {
                // Acumulamos letras en la palabra actual
                palabraActual += c;
            } else {
                // Fin de una palabra, la evaluamos
                if (!palabraActual.isEmpty() && palabraActual.length() < longCadMin) {
                    palabraMin = palabraActual;
                    longCadMin = palabraActual.length();
                }
                // Reiniciamos la palabra actual
                palabraActual = "";
            }
        }

        // Evaluamos la última palabra, por si no termina en espacio
        if (!palabraActual.isEmpty() && palabraActual.length() < longCadMin) {
            palabraMin = palabraActual;
            longCadMin = palabraActual.length();
        }

        System.out.println("La palabra de menor longitud es: \"" + palabraMin + "\", con " + longCadMin + " caracteres.");
	}

}
