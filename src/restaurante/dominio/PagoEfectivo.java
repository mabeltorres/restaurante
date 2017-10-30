package restaurante.dominio;

public class PagoEfectivo extends Pago {

	private double cantidad;

	public PagoEfectivo(double cantidad) {
		this.cantidad = cantidad;
	}
	
	public double getCantidad() {
		return cantidad;
	}

}
