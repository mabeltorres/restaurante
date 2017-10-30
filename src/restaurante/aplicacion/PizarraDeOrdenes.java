package restaurante.aplicacion;

import java.util.Date;

import restaurante.datos.Lista;
import restaurante.datos.ListaOrdenes;
import restaurante.dominio.Mesa;
import restaurante.dominio.Mozo;
import restaurante.dominio.Orden;
import restaurante.dominio.Producto;

public class PizarraDeOrdenes {
	
	private InterfazDeUsuario ui;
	private ListaOrdenes listaOrdenes;
	private Lista<Mozo> listaMozos;
	private Lista<Mesa> listaMesas;
	private Lista<Producto> listaProductos;

	public PizarraDeOrdenes(InterfazDeUsuario ui, Lista<Mozo> listaMozos, Lista<Mesa> listaMesas, Lista<Producto> listaProductos, ListaOrdenes listaOrdenes) {
		this.ui = ui;
		this.listaMozos = listaMozos;
		this.listaMesas = listaMesas;
		this.listaProductos = listaProductos;
		this.listaOrdenes = listaOrdenes;
	}
	
	public void asignarMesa() {
		Mozo mozo = ui.buscarMozo(listaMozos);		
		ui.notificarMozoEncontrado(mozo);
		
		Mesa mesa = ui.buscarMesaEn(listaMesas);
		
		Orden orden = new Orden(new Date(), mozo, mesa);
		listaOrdenes.guardarOrden(orden);
		
		ui.notificarOrdenCreada(orden);
	}

	public void registrarOrden() {
		Orden ordenActual = ui.buscarOrdenEn(listaOrdenes);		
		do {
			Producto productoEncontrado = ui.buscarProductoEn(listaProductos);
			ordenActual.agregarProducto(productoEncontrado);
			ui.notificarProductoAgregado(productoEncontrado);	
		} while (ui.masProductos());
	}

}
