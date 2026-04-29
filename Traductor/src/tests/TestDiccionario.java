package tests;

import java.io.File;

import modelo.Diccionario;

public class TestDiccionario {

	public static void main(String[] args) {
		
		Diccionario diccionario = new Diccionario(new File("./src/tests/testDiccionario.txt"));
		
		System.out.println(diccionario);
		
		System.out.println("Valor de la clave 'house': " + diccionario.get("house"));
		
		System.out.println("Elemento borrado: " + diccionario.remove("house"));
		
		System.out.println(diccionario);

	}

}
