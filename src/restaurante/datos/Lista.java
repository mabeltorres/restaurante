package restaurante.datos;

import java.util.List;

public class Lista<T> {
	
	protected List<T> elementos;
	private CondicionIdentificador<T> condicion;

	public Lista(List<T> elementos, CondicionIdentificador<T> condicion) {
		this.elementos = elementos;
		this.condicion = condicion;
	}

	public T buscar(int identificador) {
		for (T elemento : elementos) {
			if (condicion.valor(identificador, elemento)) {
				return elemento;
			}
		}
		return null;
	}
}