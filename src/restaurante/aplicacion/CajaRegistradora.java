package restaurante.aplicacion;

import restaurante.datos.ListaOrdenes;
import restaurante.dominio.Orden;
import restaurante.dominio.Producto;

public class CajaRegistradora {

	private InterfazDeUsuario ui;
	private ListaOrdenes listaOrdenes;

	public CajaRegistradora(InterfazDeUsuario ui, ListaOrdenes listaOrdenes) {
		this.ui = ui;
		this.listaOrdenes = listaOrdenes;
	}
	
	public void pagarServicio() {
		Orden ordenAPagar = ui.buscarOrdenEn(listaOrdenes);		
		for (Producto p : ordenAPagar.getProductos()) {
			ui.mostrarLineaPago(p.getNombre(), ordenAPagar.getCantidadDe(p), ordenAPagar.getSubtotalPara(p));
		}
		ui.mostrarTotalImpuestos(ordenAPagar.getValorImpuestos());
		ui.mostrarTotalAPagar(ordenAPagar.getTotal());
		
		ui.seleccionarFormaDePago(ordenAPagar);
	}

	public void pagoConTarjeta(Orden ordenAPagar) {
		int numero = ui.getNumeroTarjeta();
		String nombreTitular = ui.getNombreTitular();
		ordenAPagar.registrarPagoConTarjeta(numero, nombreTitular);
	}

	public void pagoEnEfectivo(Orden ordenAPagar) {
		double cantidad = ui.getMontoRecibido();
		ordenAPagar.registrarPagoEnEfectivo(cantidad);
	}

}
