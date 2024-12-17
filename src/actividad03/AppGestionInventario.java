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

	   // Función genérica para pedir los datos de un producto y devolver un objeto GestionInventario
    public static GestionInventario introducirDatosProducto() {
        System.out.print("Introduce el nombre del producto: ");
        String nombre = sc.nextLine();
        System.out.print("Introduce la cantidad de stock: ");
        int stock = sc.nextInt();
        sc.nextLine(); // Limpiar búfer
        System.out.print("Introduce el precio: ");
        double precio = sc.nextDouble();
        sc.nextLine(); // Limpiar búfer
        return new GestionInventario(nombre, stock, precio);
    }

    // Función para nuevo inventario (opción 1)
    public static void nuevoInventario() {
        for (int i = 0; i < MAX_PRODUCTOS; i++) {
            productos[i] = introducirDatosProducto(); // Reutilizamos la función
        }
        contProductos = MAX_PRODUCTOS; // Ajustamos el contador al tamaño máximo del array
        System.out.println("Nuevo inventario creado con éxito.");
    }

    // Función para nuevo producto (opción 2)
    public static void nuevoProducto() {
        if (contProductos >= MAX_PRODUCTOS) {
            System.out.println("Inventario lleno. No se pueden añadir más productos.");
            return;
        }
        productos[contProductos] = introducirDatosProducto(); // Reutilizamos la función
        contProductos++;
        System.out.println("Producto añadido al inventario con éxito.");
    }

    // Función para buscar y modificar un producto
    public static void buscaModifProducto() {
        System.out.print("Introduce el nombre del producto a modificar: ");
        String nombreMod = sc.nextLine();
        for (int i = 0; i < contProductos; i++) {
            if (productos[i].getNombre().equalsIgnoreCase(nombreMod)) {
                System.out.println("PRODUCTO ENCONTRADO, PROCEDA A SU MODIFICACIÓN: ");
                modifProducto(productos[i]);
                return;
            }
        }
        System.out.println("ERROR. Producto no encontrado en el inventario.");
    }

    // Función para la modificación de producto
    public static void modifProducto(GestionInventario producto) {
        System.out.print("Introduce la nueva cantidad de stock: ");
        int stock = sc.nextInt();
        producto.setStock(stock);
        sc.nextLine(); // Limpiar búfer
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
                for (int j = i; j < contProductos - 1; j++) {
                    productos[j] = productos[j + 1];
                }
                contProductos--;
                productos[contProductos] = null; // Elimina la referencia duplicada
                System.out.println("Producto eliminado con éxito.");
                return;
            }
        }
        System.out.println("ERROR. Producto no encontrado en el inventario.");
    }

    // Función para mostrar el valor total del inventario (opción 5)
    public static void valorTotal() {
        double valorTotal = 0;
        for (int i = 0; i < contProductos; i++) {
            valorTotal += productos[i].valorProducto();
        }
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("El valor total del inventario es de " + df.format(valorTotal) + "€");
    }

    // Función para mostrar el informe de rotura de stock
    public static void roturaStock() {
        boolean encontrado = false;
        System.out.println("Informe de rotura de stock: ");
        for (int i = 0; i < contProductos; i++) {
            if (productos[i].getStock() < STOCK_SEGURIDAD) {
                System.out.println("Producto: " + productos[i].getNombre() + " -- Stock: " + productos[i].getStock() + " uds");
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No hay ningún producto cuyo stock esté por debajo del stock de seguridad.");
        }
    }
}
