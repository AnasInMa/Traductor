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
		
		textoEspañol = vista.getTaEspañol().getText();
		textoIngles = vista.getTaIngles().getText();
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		
		if(e.getSource() == vista.getTaEspañol() && vista.getTaEspañol().getText().equals(textoEspañol)) {
		
			vista.getTaEspañol().setText("");
			
		} else if(e.getSource() == vista.getTaIngles() && vista.getTaIngles().getText().equals(textoIngles)) {
			
			vista.getTaIngles().setText("");
		}
		
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		
		if(e.getSource() == vista.getTaEspañol() && vista.getTaEspañol().getText().isEmpty()) {
			
			vista.getTaEspañol().setText(textoEspañol);
			
		} else if(e.getSource() == vista.getTaIngles() && vista.getTaIngles().getText().isEmpty()){
			
			vista.getTaIngles().setText(textoIngles);
		}
		
	}

}
