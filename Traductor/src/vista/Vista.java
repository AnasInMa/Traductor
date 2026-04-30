package vista;

import java.awt.CardLayout;

import javax.swing.*;

public class Vista extends JPanel{

	private static final long serialVersionUID = -5752211613049689258L;
	
	private VistaEspañolIngles vEspañolIngles;
	private VistaInglesEspañol vInglesEspañol;
	
	private CardLayout c;

	public Vista() {
		
		c = new CardLayout();
		
		this.setLayout(c);
		
		this.add(vEspañolIngles = new VistaEspañolIngles(), 0);
		this.add(vInglesEspañol = new VistaInglesEspañol(), 1); 
	}
	
	public void intercambiarPaneles() {
		
		c.next(this);
	}

	public VistaEspañolIngles getvEspañolIngles() {
		return vEspañolIngles;
	}

	public VistaInglesEspañol getvInglesEspañol() {
		return vInglesEspañol;
	}
	
}
