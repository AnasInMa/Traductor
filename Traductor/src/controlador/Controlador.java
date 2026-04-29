package controlador;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import vista.Vista;

public class Controlador implements FocusListener{

	Vista vista;
	
	String textoEspañol, textoIngles;
	
	public Controlador(Vista v) {
		
		vista = v;
		
		vista.control(this);
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		
		if(e.getSource() == vista.getTaEspañol()) {
		
			textoEspañol = vista.getTaEspañol().getText();
			
			vista.getTaEspañol().setText("");
			
		} else {
			
			textoIngles = vista.getTaIngles().getText();
			
			vista.getTaIngles().setText("");
		}
		
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		
		if(e.getSource() == vista.getTaEspañol()) {
			
			vista.getTaEspañol().setText(textoEspañol);
			
		} else {
			
			vista.getTaIngles().setText(textoIngles);
		}
		
	}

}
