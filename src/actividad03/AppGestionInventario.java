package actividad03;

import java.util.Scanner;
import java.text.DecimalFormat;

public class AppGestionInventario {
	private static final int STOCK_SEGURIDAD = 50;
	private static final int MAX_PRODUCTOS = 100;
	private static GestionInventario[] productos = new GestionInventario[MAX_PRODUCTOS];
	private static int contProductos = 0;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int opcion = 0;

		do {
			System.out.println("--GESTIÓN DE INVENTARIO--");
			System.out.println("1. Introducir datos nuevo inventario");
			System.out.println("2. Nuevo producto");
			System.out.println("3. Buscar producto y modificar información");
			System.out.println("4. Eliminar producto");
			System.out.println("5. Mostrar valor total del inventario");
			System.out.println("6. Informe rotura de stock");
			System.out.println("7. Salir");

			opcion = sc.nextInt();
			sc.nextLine(); // Limpiar búffer

			switch (opcion) {
			case 1:
				nuevoInventario();
				break;
			case 2:
				nuevoProducto();
				break;
			case 3:
				buscaModifProducto();
				break;
			case 4:
				eliminarProducto();
				break;
			case 5:
				valorTotal();
				break;
			case 6:
				roturaStock();
				break;
			case 7:
				System.out.println("PROGRAMA FINALIZADO");
				break;
			default:
				System.out.println("ERROR. Elija una opción correcta por favor.");
			}
		} while (opcion != 7);

		sc.close();
	}

	// Función para nuevo inventario (opción 1)
	public static void nuevoInventario() {
		for (int i = 0; i < productos.length; i++) {
			newProducto(productos[i]);
		}
		// He intentado reutilizar código pero no he sabido que manera era la más óptima
		// así que prefiero revisarlo en clase e ir a lo seguro ahora mismo
		System.out.println("Nuevo inventario creado con éxito.");
	}

	// Función para añadir productos de la opción 1
	public static GestionInventario newProducto(GestionInventario producto) {
		System.out.print("Introduce el nombre del producto: ");
		String nombre = sc.nextLine();
		System.out.print("Introduce la cantidad de stock: ");
		int stock = sc.nextInt();
		sc.nextLine(); // Limpiar búffer
		System.out.print("Introduce el precio: ");
		double precio = sc.nextDouble();
		sc.nextLine();

		return new GestionInventario(nombre, stock, precio);
	}

	// Función para añadir nuevo producto para la opción 2
	public static void nuevoProducto() {
		if (contProductos >= MAX_PRODUCTOS) {
			System.out.println("Inventario lleno. No se pueden añadir más productos.");
			return; // Sale del método
		}
		cargarProducto();
	}

	// Función para nuevoProducto()
	public static void cargarProducto() {
		System.out.print("Introduce el nombre del producto: ");
		String nombre = sc.nextLine();
		System.out.print("Introduce la cantidad de stock: ");
		int stock = sc.nextInt();
		sc.nextLine(); // Limpiar búffer
		System.out.print("Introduce el precio: ");
		double precio = sc.nextDouble();
		sc.nextLine();

		productos[contProductos] = new GestionInventario(nombre, stock, precio);
		contProductos++;
		System.out.println("Producto añadido al inventario con éxito.");
	}

	// Función para buscar y modificar un producto
	public static void buscaModifProducto() {
		System.out.print("Introduce el nombre del producto a modificar: ");
		String nombreMod = sc.nextLine();
		for (int i = 0; i < contProductos; i++) {
			if (productos[i].getNombre().equalsIgnoreCase(nombreMod)) { // Si el nombre coincide con el introducido se
																		// modifica
				System.out.println("PRODUCTO ENCONTRADO, PROCEDA A SU MODIFICACIÓN: ");
				modifProducto(productos[i]);
				return; // Sale del método
			}
		}
		System.out.println("ERROR. Producto no encontrado en el inventario.");
	}

	// Función para la modificación de producto
	public static void modifProducto(GestionInventario producto) {
		System.out.print("Introduce la nueva cantidad de stock: ");
		int stock = sc.nextInt();
		producto.setStock(stock);
		sc.nextLine(); // Limpiar búffer
		System.out.print("Introduce el nuevo precio: ");
		double precio = sc.nextDouble();
		producto.setPrecio(precio);
		System.out.println("Producto modificado con éxito.");
	}

	// Función para eliminar un producto del inventario (opción 4)
	public static void eliminarProducto() {
		System.out.print("Introduce el nombre del producto a eliminar: ");
		String nombreElim = sc.nextLine();

		for (int i = 0; i < contProductos; i++) {
			if (productos[i].getNombre().equalsIgnoreCase(nombreElim)) {
				// Eliminamos el objeto mediante un desplazamiento del array
				for (int j = i; j < contProductos - 1; j++) { // Desplazamos a partir del producto que queremos eliminar
					productos[j] = productos[j + 1];
				}
				contProductos--; // Decrementamos contador ya que hay un objeto menos
				productos[contProductos] = null; // Asignamos null al índice del contador ya que esta duplicado con
													// [contProductos-1]
				System.out.println("Producto eliminado con éxito.");
				return; // Sale del método
			}
		}
		System.out.println("ERROR. Producto no encontrado en el inventario.");
	}

	// Función para mostrar el valor total del inventario (opción 5)
	public static void valorTotal() {
		double valorTotal = 0;
		for (int i = 0; i < contProductos; i++) {
			valorTotal += productos[i].valorProducto(); // Suma al total el valor de cada producto (precio*stock)
		}
		DecimalFormat df = new DecimalFormat("0.00"); // Para mostrar siempre dos decimales
		System.out.println("El valor total del inventario es de " + df.format(valorTotal) + "€");
	}

	// Función para mostrar el informe de rotura de stock
	public static void roturaStock() {
		boolean encontrado = false;
		System.out.println("Informe de rotura de stock: ");
		for (int i = 0; i < contProductos; i++) {
			if (productos[i].getStock() < STOCK_SEGURIDAD) { // Si el stock del producto es menor que 50 (seguridad)
				System.out.println("Producto: " + productos[i].getNombre() + " -- Stock: " + productos[i].getStock() + " uds");
				encontrado = true;
			}
		}
		if (!encontrado) {
			System.out.println("No hay ningún producto cuyo stock esté por debajo del stock de seguridad.");
		}
	}
}
