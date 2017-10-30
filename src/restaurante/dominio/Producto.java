package restaurante.dominio;

public class Producto {
	
	private int codigo;
	private String nombre;
	private double precio;
	
	public Producto(int codigo, String nombre, double precio) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}

	public boolean tieneCodigo(int id) {
		return this.codigo == id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double getPrecio() {
		return precio;
	}

	@Override
	public int hashCode() {
		return Integer.hashCode(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto that = (Producto) obj;
		if (this.codigo != that.codigo)
			return false;
		return true;
	}
	
	
}
