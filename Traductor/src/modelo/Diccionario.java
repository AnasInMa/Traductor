package modelo;

import java.io.*;
import java.util.*;

public class Diccionario extends HashMap<String, String> {

	private static final long serialVersionUID = -4638813271690390845L;

	private File archivo;

	public Diccionario() {

		archivo = new File("./src/modelo/Diccionario.txt");

		añadePalabrasADiccionario();
	}

	/**
	 * Metodo que añade las palabras que se pasan, tanto al fichero como al
	 * diccionario
	 * 
	 * @param palabraEspañol
	 * @param palabraIngles
	 */
	public boolean añadePalabras(String palabraEspañol, String palabraIngles) {

		boolean existe = this.existePalabra(palabraEspañol);

		if (!existe) {

			try (BufferedWriter bw = new BufferedWriter(
					new FileWriter(new File("./src/modelo/Diccionario.txt"), true))) {	//true para que en vez de estar creandose y destruyendose todo el rato, solo añada las palabras

				bw.write(palabraEspañol + "-" + palabraIngles); // añade las palabras al fichero
				bw.newLine();
				this.put(palabraEspañol, palabraIngles); // añade las palabras al diccionario

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return existe;

	}

	private void añadePalabrasADiccionario() {

		try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

			String fila = br.readLine();
			String[] palabras;

			while (fila != null) {

				palabras = fila.split("-"); // divide la fila creando un array (de dos elementos) que se separa por '-'

				this.put(palabras[0], palabras[1]); // como siempre hay dos palabras, pues una se utiliza como clave y
													// la otra como vlaor

				fila = br.readLine();
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Metodo al que se le pasa la clave o palabra en español, la busca en el
	 * diccionario, y si la encuentra devuelve true, si no devuelve false
	 * 
	 * @param palabraEspañol
	 * @return encontrado
	 */
	public boolean existePalabra(String palabraEspañol) {

		boolean encontrado = false;

		for (String clave : this.keySet()) {

			if (palabraEspañol.equalsIgnoreCase(clave)) {

				encontrado = true;
			}
		}

		return encontrado;
	}

	/**
	 * Metodo que busca la traduccion de una palabra en español, y devuelve la
	 * palabra traducida al ingles. Si no se encuentra, devuelve un null
	 * 
	 * @param palabraEspañol
	 * @return
	 */
	public String buscaPalabraEnEspañol(String palabraEspañol) {

		String palabraIngles = null;

		for (String clave : this.keySet()) {

			if (palabraEspañol.equalsIgnoreCase(clave)) {

				palabraIngles = this.get(clave);
			}
		}

		return palabraIngles;
	}

	/**
	 * Metodo que busca la traduccion de una palabra en ingles, y devuelve la
	 * palabra traducida al español. Si no se encuentra, devuelve un null
	 * 
	 * @param palabraIngles
	 * @return
	 */
	public String buscaPalabraEnIngles(String palabraIngles) {

		String palabraEspañol = null;

		for (String clave : this.keySet()) {

			if (palabraIngles.equalsIgnoreCase(this.get(clave))) {

				palabraEspañol = clave;
			}
		}

		return palabraEspañol;
	}

	@Override
	public String toString() {

		String cadena = "\t";

		for (String palabraEspañol : this.keySet()) {

			cadena += palabraEspañol + "-" + this.get(palabraEspañol) + "\n\t";
		}

		return cadena;
	}

	public File getArchivo() {
		return archivo;
	}
}