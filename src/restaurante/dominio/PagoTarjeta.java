package restaurante.dominio;

public class PagoTarjeta extends Pago {

	private int numeroTarjeta;
	private String nombreTitular;

	public PagoTarjeta(int numeroTarjeta, String nombreTitular) {
		this.numeroTarjeta = numeroTarjeta;
		this.nombreTitular = nombreTitular;
	}

	public int getNumeroTarjeta() {
		return numeroTarjeta;
	}
	
	public String getNombreTitular() {
		return nombreTitular;
	}
}
