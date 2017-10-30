package restaurante.aplicacion;

import restaurante.datos.Lista;
import restaurante.datos.ListaOrdenes;
import restaurante.dominio.Mesa;
import restaurante.dominio.Mozo;
import restaurante.dominio.Orden;
import restaurante.dominio.Producto;

public interface InterfazDeUsuario {

	Mozo buscarMozo(Lista<Mozo> lista);

	void notificarMozoEncontrado(Mozo mozo);

	Mesa buscarMesaEn(Lista<Mesa> listaMesas);

	void notificarOrdenCreada(Orden orden);

	Orden buscarOrdenEn(ListaOrdenes listaOrdenes);

	Producto buscarProductoEn(Lista<Producto> listaProductos);

	void notificarProductoAgregado(Producto productoEncontrado);

	boolean masProductos();

	int getNumeroTarjeta();

	String getNombreTitular();

	int getMontoRecibido();

	void seleccionarFormaDePago(Orden ordenAPagar);

	void mostrarTotalAPagar(double total);

	void mostrarTotalImpuestos(double impuestos);

	void mostrarLineaPago(String nombreProducto, int cantidad, double subtotal);

}