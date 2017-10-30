package restaurante.presentacion;

import java.util.Scanner;

public class Consola {

	private Scanner entrada = new Scanner(System.in);

	public void mostrar(String texto) {
		System.out.println(texto);
	}

	public int leerNumero(String texto) {
		System.out.print(texto);
		int legajo = entrada.nextInt();
		return legajo;
	}

	public boolean leerBooleano(String texto) {
		System.out.print(texto + "(S/N): ");
		return entrada.next().toLowerCase().matches("s");
	}

	public String leerString(String texto) {
		System.out.print(texto);
		entrada.next();
		return entrada.nextLine().trim();
	}

}
