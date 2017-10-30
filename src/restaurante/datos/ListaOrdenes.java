package restaurante.datos;

import java.util.ArrayList;

import restaurante.dominio.Orden;

public class ListaOrdenes extends Lista<Orden> {

	public ListaOrdenes() {
		super(new ArrayList<>(), (id, orden) -> orden.estaAbierta() && orden.lePerteneceALaMesa(id));
	}

	public void guardarOrden(Orden orden) {
		elementos.add(orden);
	}

}
