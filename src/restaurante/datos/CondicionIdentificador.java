package restaurante.datos;

public interface CondicionIdentificador<T> {
	boolean valor(int identificador, T elemento);
}