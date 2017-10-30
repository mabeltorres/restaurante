package restaurante.dominio;

public class Mesa {

	private int numero;

	public Mesa(int numero) {
		this.numero = numero;
	}

	public boolean tieneNumero(int unNumero) {
		return this.numero == unNumero;
	}

	public int getNumero() {
		return numero;
	}
	
}
