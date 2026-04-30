package vista;

import java.awt.Color;

import javax.swing.*;
import javax.swing.border.*;

import controlador.ControladorInglesEspañol;

public class VistaInglesEspañol extends JPanel{

	private static final long serialVersionUID = -5752211613049689258L;

	private static final int bordeVacioAlto, bordeVacioAncho, filasAreaTexto, columnasAreaTexto;
	
	private JTextArea taEspañol, taIngles;
	
	private JButton bIntercambiar, bTraducir, bAñadir;
	
	private static Color colorFondo, colorBotones, colorAreaTexto;

	static {
		
		bordeVacioAlto = 25;
		bordeVacioAncho = 20;
		
		filasAreaTexto = 10;
		columnasAreaTexto = 30;
		
		colorAreaTexto = new Color(246, 240, 215);
		colorBotones = new Color(156, 171, 132);
		colorFondo = new Color(197, 216, 157);
	}
	
	public VistaInglesEspañol() {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(new EmptyBorder(bordeVacioAlto, bordeVacioAncho, bordeVacioAlto, bordeVacioAncho));
		
		JPanel panel1 = new JPanel();
		panel1.add(panelIngles());
		panel1.add(panelEspañol());
		
		panel1.setBackground(colorFondo);
		
		this.add(panel1);
		this.add(panelBotones());
		this.add(panelAñadir());
		
		this.setBackground(colorFondo);
	}
	
	public void control(ControladorInglesEspañol c) {
		
		this.taEspañol.addFocusListener(c);
		this.taIngles.addFocusListener(c);
		
		this.bTraducir.addActionListener(c);
		this.bIntercambiar.addActionListener(c);
		this.bAñadir.addActionListener(c);
	}

	private JPanel panelEspañol() {
		
		JPanel panel = new JPanel();
		
		panel.add(new JScrollPane(taEspañol = añadeAreaTexto("Español", "Traduccion", false)));
		
		panel.setBackground(colorFondo);
		
		return panel;
	}
	
	private JPanel panelIngles() {
		
		JPanel panel = new JPanel();
		
		panel.add(new JScrollPane(taIngles = añadeAreaTexto("Inglés", "Introduzca aqui el texto", true)));
		
		panel.setBackground(colorFondo);
		
		return panel;
	}
	
	private JTextArea añadeAreaTexto(String titulo, String textoInicial, boolean editable) {
		
		JTextArea ta = new JTextArea(textoInicial, filasAreaTexto, columnasAreaTexto);
		ta.setBackground(colorAreaTexto);
		
		ta.setBorder(new TitledBorder(titulo));
		
		if(!editable) ta.setEnabled(false);
		
		return ta;
	}
	
	private JPanel panelBotones() {
		
		JPanel panel = new JPanel();
		//panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		bIntercambiar = new JButton("🔁");
		bIntercambiar.setToolTipText("Intercambiar");	//Muestra el texto 'Intercambiar' cuando se deja el cursor encima
		bIntercambiar.setBackground(colorBotones);
		
		bTraducir = new JButton("TRADUCIR");
		bTraducir.setBackground(colorBotones);
		
		panel.add(bIntercambiar);
		panel.add(new JSeparator());
		panel.add(bTraducir);
		
		panel.setBackground(colorFondo);
		
		return panel;
	}
	
	private JPanel panelAñadir() {
		
		JPanel panel = new JPanel();
		
		panel.setBackground(colorFondo);
		
		bAñadir = new JButton("¿Quieres añadir una nueva palabra? Pulsa aqui!");
		bAñadir.setContentAreaFilled(false); //quita el azul del boton
		bAñadir.setBorderPainted(false);	//quita el borde
		bAñadir.setFocusable(false); //para que cada vez que se pulse no se ponga el bordecito negro
		
		panel.add(bAñadir);
		
		return panel;
	}
	
	public JTextArea getTaEspañol() {
		return taEspañol;
	}
	
	public JTextArea getTaIngles() {
		return taIngles;
	}
	
	public JButton getbIntercambiar() {
		return bIntercambiar;
	}

	public JButton getbTraducir() {
		return bTraducir;
	}

}
