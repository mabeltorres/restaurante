package restaurante;

import static java.util.Arrays.asList;

import restaurante.aplicacion.CajaRegistradora;
import restaurante.aplicacion.PizarraDeOrdenes;
import restaurante.datos.Lista;
import restaurante.datos.ListaOrdenes;
import restaurante.dominio.Mesa;
import restaurante.dominio.Mozo;
import restaurante.dominio.Producto;
import restaurante.presentacion.Consola;
import restaurante.presentacion.PresentadorConsola;

public class Main {
	
	private static Lista<Mozo> listaMozos = new Lista<Mozo>(asList(
					new Mozo(1, "Juan"),
					new Mozo(2, "María")
			), (id, mozo) -> mozo.tieneLegajo(id));
	private static Lista<Mesa> listaMesas = new Lista<Mesa>(asList(
					new Mesa(1),
					new Mesa(2)
			), (id, mesa) -> mesa.tieneNumero(id));
	private static Lista<Producto> listaProductos = new Lista<Producto>(asList(
			new Producto(1, "Milanesa", 100.00),
			new Producto(2, "Hamburguesa", 80.25),
			new Producto(3, "Fanta 2L", 30.50)
	), (id, producto) -> producto.tieneCodigo(id));
	private static ListaOrdenes listaOrdenes = new ListaOrdenes();
	
	public static void main(String[] args) {
		PresentadorConsola presentadorConsola = new PresentadorConsola(new Consola());
		PizarraDeOrdenes pizarra = new PizarraDeOrdenes(presentadorConsola,
				listaMozos, listaMesas, listaProductos, listaOrdenes);
		CajaRegistradora registradora = new CajaRegistradora(presentadorConsola, listaOrdenes);
		presentadorConsola.setControladorOrdenes(pizarra);
		presentadorConsola.setControladorPagos(registradora);
		presentadorConsola.iniciar();
	}
	
}
