package controlador;

import vista.*;

public class Controlador {

	private Vista vista;
	
	public Controlador(Vista v) {
		
		vista = v;
		
		new ControladorEspañolIngles(vista, vista.getvEspañolIngles());
		new ControladorInglesEspañol(vista, vista.getvInglesEspañol());
	}

}
