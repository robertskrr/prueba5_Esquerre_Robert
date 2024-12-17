package actividad02;

import java.util.Scanner;

public class Actividad02 {

	// Variables para contar las entradas disponibles
	private static int entradasPpal = 1000;
	private static int entradasPlatea = 200;
	private static int entradasVip = 25;
	private static int numTotalEntradas = entradasPpal + entradasPlatea + entradasVip;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int opcion = 0;

		// Bucle de menú que se repite hasta que opción sea 3
		do {
			System.out.println("--ENTRADAS CONCERTSALA--");
			System.out.println("1. Mostrar número de entradas libres");
			System.out.println("2. Vender entradas");
			System.out.println("3. Salir");

			opcion = sc.nextInt();
			sc.nextLine(); // Limpiar búffer

			switch (opcion) {
			case 1:
				mostrarEntradasLibres();
				break;
			case 2:
				venderEntradas();
				break;
			case 3:
				System.out.println("PROGRAMA FINALIZADO");
				break;
			default:
				System.out.println("ERROR. Eliga una opción correcta por favor.");
				break;
			}

		} while (opcion != 3);

		sc.close();

	}

	// Función que muestra las entradas libres
	public static void mostrarEntradasLibres() {
		if (numTotalEntradas > 0) { // Valida que haya entradas disponibles
			System.out.println("En total, quedan: " + numTotalEntradas + " entradas libres.");
			System.out.println("ZONA PRINCIPAL: " + entradasPpal + " entradas.");
			System.out.println("ZONA PLATEA: " + entradasPlatea + " entradas.");
			System.out.println("ZONA VIP: " + entradasVip + " entradas.");
		} else {
			System.out.println("No quedan más entradas libres de ninguna zona.");
		}
	}

	public static void venderEntradas() {
		if (numTotalEntradas > 0) { // Valida que haya entradas disponibles
			System.out.println("¿Para que zóna quiere comprar las entradas (Principal, Platea o VIP)?");
			String zona = sc.nextLine();

			// Depende de la zona
			switch (zona.toLowerCase()) { // Lo pasamos a minúscula para evitar confusiones
			case "principal":
				venderZona("Principal");
				break;
			case "platea":
				venderZona("Platea");
				break;
			case "vip":
				venderZona("VIP");
				break;
			default:
				System.out.println("ERROR. No ha introducido una zona válida.");
			}
		} else {
			System.out.println("Lo sentimos. No quedan más entradas disponibles a la venta.");
		}
	}

	public static void venderZona(String zona) {
	    int entradasDisponibles = 0;

	    // Determinar qué variable se va a modificar
	    switch (zona.toLowerCase()) {
	        case "principal":
	            entradasDisponibles = entradasPpal;
	            break;
	        case "platea":
	            entradasDisponibles = entradasPlatea;
	            break;
	        case "vip":
	            entradasDisponibles = entradasVip;
	            break;
	    }

	    System.out.println("¿Cuántas entradas desea comprar en la zona " + zona + "?: ");
	    int compra = sc.nextInt();
	    sc.nextLine(); // Limpiar búfer

	    if (compra > entradasDisponibles) {
	        System.out.println("ERROR. Solo quedan " + entradasDisponibles + " entradas disponibles.");
	    } else {
	        // Restar las entradas compradas a la variable correcta
	        switch (zona.toLowerCase()) {
	            case "principal":
	                entradasPpal -= compra;
	                break;
	            case "platea":
	                entradasPlatea -= compra;
	                break;
	            case "vip":
	                entradasVip -= compra;
	                break;
	        }
	        numTotalEntradas -= compra;
	        System.out.println("Se han vendido " + compra + " entradas de la zona " + zona + " con éxito.");
	    }
	}

}
