package restaurante.presentacion;

import restaurante.aplicacion.CajaRegistradora;
import restaurante.aplicacion.InterfazDeUsuario;
import restaurante.aplicacion.PizarraDeOrdenes;
import restaurante.datos.Lista;
import restaurante.datos.ListaOrdenes;
import restaurante.dominio.Mesa;
import restaurante.dominio.Mozo;
import restaurante.dominio.Orden;
import restaurante.dominio.Producto;

public class PresentadorConsola implements InterfazDeUsuario {
	
	private Consola consola;
	private CajaRegistradora registradora;
	private PizarraDeOrdenes pizarraOrdenes;
	
	public PresentadorConsola(Consola consola) {
		this.consola = consola;
	}

	public void setControladorOrdenes(PizarraDeOrdenes pizarra) {
		this.pizarraOrdenes = pizarra;
	}

	public void setControladorPagos(CajaRegistradora registradora) {
		this.registradora = registradora;
	}
	
	public void iniciar() {
		while (true) {
			mostrarMenu();
			int opcionSeleccionada = consola.leerNumero("Ingrese la opción: ");
			switch (opcionSeleccionada) {
			case 1:
				pizarraOrdenes.asignarMesa();
				break;
			case 2: 
				pizarraOrdenes.registrarOrden();
				break;
			case 3:
				registradora.pagarServicio();
				break;
			default:
				consola.mostrar("Opción no válida");
			}
			consola.mostrar("");
		}
	}

	private void mostrarMenu() {
		consola.mostrar("---------------");
		consola.mostrar("      MENU     ");
		consola.mostrar("---------------");
		consola.mostrar("1. Asignar mesa");
		consola.mostrar("2. Registrar orden");
		consola.mostrar("3. Pagar servicio");
	}


	@Override
	public void seleccionarFormaDePago(Orden ordenAPagar) {
		consola.mostrar("Seleccione la forma de pago:");
		consola.mostrar("1. Efectivo");
		consola.mostrar("2. Tarjeta");
		int opcionSeleccionada = consola.leerNumero("Ingrese la opción: ");
		switch (opcionSeleccionada) {
		case 1:
			registradora.pagoEnEfectivo(ordenAPagar);
			consola.mostrar("Pago registrado");
			break;
		case 2: 
			registradora.pagoConTarjeta(ordenAPagar);
			consola.mostrar("Pago registrado");
			break;
		default:
			consola.mostrar("Opción no válida");
		}
		consola.mostrar("");
	}

	@Override
	public void mostrarTotalAPagar(double total) {
		mostrarLinea("Total", total);
	}

	@Override
	public void mostrarTotalImpuestos(double impuestos) {
		mostrarLinea("Impuestos", impuestos);
	}

	@Override
	public void mostrarLineaPago(String nombreProducto, int cantidad, double subtotal) {
		mostrarLinea(nombreProducto + " x" + cantidad, subtotal);
	}

	@Override
	public int getMontoRecibido() {
		return consola.leerNumero("Ingrese el monto recibido: ");
	}

	@Override
	public String getNombreTitular() {
		return consola.leerString("Ingrese el nombre del titular: ");
	}

	@Override
	public int getNumeroTarjeta() {
		return consola.leerNumero("Ingrese el número de la tarjeta: ");
	}

	@Override
	public boolean masProductos() {
		return consola.leerBooleano("Agregar otro producto?");
	}

	@Override
	public void notificarOrdenCreada(Orden orden) {
		consola.mostrar("Orden abierta en mesa " + orden.getNumeroDeMesa());
	}

	@Override
	public void notificarMozoEncontrado(Mozo mozoEncontrado) {
		consola.mostrar("Hola " + mozoEncontrado.getNombre());
	}

	@Override
	public void notificarProductoAgregado(Producto productoEncontrado) {
		consola.mostrar("Producto agregado: " + productoEncontrado.getNombre() + ", " + dinero(productoEncontrado.getPrecio()));
	}

	@Override
	public Producto buscarProductoEn(Lista<Producto> listaProductos) {
		return buscarElemento(listaProductos, "Ingrese el código del producto: ", "Producto no encontrado");
	}

	@Override
	public Orden buscarOrdenEn(ListaOrdenes listaOrdenes) {
		return buscarElemento(listaOrdenes, "Ingrese el número de mesa que le corresponde a la orden: ", "Orden no encontrada");
	}
	
	@Override
	public Mozo buscarMozo(Lista<Mozo> listaMozos) {
		return buscarElemento(listaMozos, "Ingrese su legajo: ", "Legajo no encontrado");
	}
	
	@Override
	public Mesa buscarMesaEn(Lista<Mesa> listaMesas) {
		return buscarElemento(listaMesas, "Ingrese el número de mesa: ", "Mesa no encontrada");
	}
	
	private <T> T buscarElemento(Lista<T> lista, String etiquetaIdentificador, String mensajeNoEncontrado) {
		T elementoEncontrado = null;
		while(elementoEncontrado == null) {
			int identificador = consola.leerNumero(etiquetaIdentificador);
			
			elementoEncontrado = lista.buscar(identificador);
			
			if (elementoEncontrado == null) {
				consola.mostrar(mensajeNoEncontrado);
			}
		}
		return elementoEncontrado;
	}
	
	private void mostrarLinea(String concepto, double subtotal) {
		int largoLinea = 28;
		String contenido = concepto + dinero(subtotal);
		String separador = "";
		for (int i = 0; i < largoLinea - contenido.length(); i++) {
			separador += ".";
		}
		
		consola.mostrar(concepto + separador + dinero(subtotal));
	}
	
	private String dinero(double monto) {
		return String.format("$%.02f", monto);
	}

}
