package actividad03;

import java.text.DecimalFormat;

public class GestionInventario {
	private String nombre;
	private int stock;
	private double precio;

	// Constructor
	public GestionInventario(String nombre, int stock, double precio) {
		this.nombre = nombre;
		this.stock = stock;
		this.precio = precio;
	}

	// Función para obtener el valor de cada producto
	public double valorProducto() {
		double valor = this.stock * this.precio;
		return valor;
	}

	// Getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00"); // Para mostrar siempre dos decimales
		return nombre + ", " + stock + " uds, " + df.format(precio) + "€";
	}

}
