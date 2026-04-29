package modelo;

import java.io.*;
import java.util.*;

public class Diccionario extends HashMap<String, String> implements Serializable{	//el serializable para que no se este creando y destruyendo el diccionario cada vez que se ejecute

	private static final long serialVersionUID = -4638813271690390845L;

	public Diccionario(File archivo) {
		
		añadePalabrasADiccionario(archivo);
	}
	
	private void añadePalabrasADiccionario(File archivo) {
		
		try(BufferedReader br = new BufferedReader(new FileReader(archivo))) {
			
			String fila = br.readLine();
			String[] palabras;
			
			while (fila != null) {
				
				palabras = fila.split("-");	//divide la fila creando un array que se separa por '-'

				this.put(palabras[0], palabras[1]);	//como siempre hay dos palabras, pues una se utiliza como clave y la otra como vlaor
				
				fila = br.readLine();
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
}
