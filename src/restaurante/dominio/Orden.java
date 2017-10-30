package restaurante.dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Orden {

	private Date fechaHora;
	private Mozo mozo;
	private Mesa mesa;
	private List<Producto> productos = new ArrayList<>();
	private Pago pago;

	public Orden(Date fechaHora, Mozo mozo, Mesa mesa) {
		this.fechaHora = fechaHora;
		this.mozo = mozo;
		this.mesa = mesa;
	}

	public void agregarProducto(Producto unProducto) {
		productos.add(unProducto);
	}
	
	public boolean estaAbierta() {
		return pago == null;
	}
	
	public boolean lePerteneceALaMesa(int nroMesa) {
		return mesa.tieneNumero(nroMesa);
	}

	public Set<Producto> getProductos() {
		return new HashSet<>(productos);
	}

	public int getCantidadDe(Producto unProducto) {
		int cantidad = 0;
		for (Producto p : productos) {
			if (p.equals(unProducto))
				cantidad++;
		}
		return cantidad;
	}

	public double getSubtotalPara(Producto unProducto) {
		return this.getCantidadDe(unProducto) * unProducto.getPrecio();
	}

	public double getValorImpuestos() {
		return 0.05 * getTotalProductos();
	}

	private double getTotalProductos() {
		double total = 0;
		for (Producto p : getProductos()) {
			total += getSubtotalPara(p);
		}
		return total;
	}

	public double getTotal() {
		return getTotalProductos() + getValorImpuestos();
	}

	public void registrarPagoEnEfectivo(double cantidad) {
		pago = new PagoEfectivo(cantidad);
	}

	public void registrarPagoConTarjeta(int numero, String nombreTitular) {
		pago = new PagoTarjeta(numero, nombreTitular);
	}

	public int getNumeroDeMesa() {
		return mesa.getNumero();
	}

	public Mozo getMozo() {
		return mozo;
	}
	
	public Date getFechaHora() {
		return fechaHora;
	}
}
