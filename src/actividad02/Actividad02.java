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
				venderPpal();
				break;
			case "platea":
				venderPlatea();
				break;
			case "vip":
				venderVip();
				break;
			default:
				System.out.println("ERROR. No ha introducido una zona válida.");
			}
		} else {
			System.out.println("Lo sentimos. No quedan más entradas disponibles a la venta.");
		}
	}

	// Venta de entradas de zona Principal
	public static void venderPpal() {
		System.out.println("¿Cuántas entradas desea comprar en la Zona Principal?: ");
		int compra = sc.nextInt();
		sc.nextLine(); // Limpiar búffer
		if ((entradasPpal - compra) < 0) { // Si la diferencia con la cantidad de entradas vendidas es negativa
			System.out.println("ERROR. No hay suficientes entradas disponibles para tal cantidad.");
		} else {
			entradasPpal -= compra;
			System.out.println("Se han vendido " + compra + " entradas de la Zona Principal con éxito.");
			numTotalEntradas -= compra; // Modifica el total de entradas con esta venta
		}
	}

	// Venta de entradas de zona Platea
	public static void venderPlatea() {
		System.out.println("¿Cuántas entradas desea comprar en la Zona Platea?: ");
		int compra = sc.nextInt();
		sc.nextLine(); // Limpiar búffer
		if ((entradasPlatea - compra) < 0) {
			System.out.println("ERROR. No hay suficientes entradas disponibles para tal cantidad.");
		} else {
			entradasPlatea -= compra;
			System.out.println("Se han vendido " + compra + " entradas de la Zona Platea con éxito.");
			numTotalEntradas -= compra;
		}
	}

	// Venta de entradas de zona VIP
	public static void venderVip() {
		System.out.println("¿Cuántas entradas desea comprar en la Zona VIP?: ");
		int compra = sc.nextInt();
		sc.nextLine(); // Limpiar búffer
		if ((entradasVip - compra) < 0) {
			System.out.println("ERROR. No hay suficientes entradas disponibles para tal cantidad.");
		} else {
			entradasVip -= compra;
			System.out.println("Se han vendido " + compra + " entradas de la Zona VIP con éxito.");
			numTotalEntradas -= compra;
		}
	}

}
