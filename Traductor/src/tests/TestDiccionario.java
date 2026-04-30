package tests;

import modelo.Diccionario;

public class TestDiccionario {

	public static void main(String[] args) {
		
		Diccionario diccionario = new Diccionario();
		
		System.out.println(diccionario);
		
		System.out.println("Valor de la clave 'casa': " + diccionario.get("casa"));
		
		System.out.println("Elemento borrado: " + diccionario.remove("casa"));
		
		System.out.println(diccionario);

	}

}
