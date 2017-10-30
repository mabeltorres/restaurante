package restaurante.dominio;

public class Mozo {
	
	private int legajo;
	private String nombre;
	
	public Mozo(int legajo, String nombre) {
		this.legajo = legajo;
		this.nombre = nombre;
	}

	public boolean tieneLegajo(int unLegajo) {
		return this.legajo == unLegajo;
	}

	public String getNombre() {
		return nombre;
	}
	
}
