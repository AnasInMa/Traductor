package vista;

import javax.swing.*;
import javax.swing.border.*;

import controlador.Controlador;

public class Vista extends JPanel{

	private static final long serialVersionUID = -5752211613049689258L;

	private static final int bordeVacioAlto, bordeVacioAncho, filasAreaTexto, columnasAreaTexto;
	
	private JTextArea taEspañol, taIngles;
	
	private JButton bIntercambiar, bTraducir;

	static {
		
		bordeVacioAlto = 25;
		bordeVacioAncho = 20;
		
		filasAreaTexto = 10;
		columnasAreaTexto = 30;
	}
	
	public Vista() {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(new EmptyBorder(bordeVacioAlto,bordeVacioAncho,bordeVacioAlto,bordeVacioAncho));
		
		JPanel panel1 = new JPanel();
		panel1.add(panelEspañol());
		panel1.add(panelIngles());
		
		this.add(panel1);
		this.add(panelBotones());
	}
	
	public void control(Controlador c) {
		
		this.taEspañol.addFocusListener(c);
		this.taIngles.addFocusListener(c);
	}
	
	private JPanel panelEspañol() {
		
		JPanel panel = new JPanel();
		
		panel.add(new JScrollPane(taEspañol = añadeAreaTexto("Español", "Introduzca aqui el texto")));
		
		return panel;
	}
	
	private JPanel panelIngles() {
		
		JPanel panel = new JPanel();
		
		panel.add(new JScrollPane(taIngles = añadeAreaTexto("Inglés", "Traduccion")));
		
		return panel;
	}
	
	private JTextArea añadeAreaTexto(String titulo, String textoInicial) {
		
		JTextArea ta = new JTextArea(textoInicial, filasAreaTexto, columnasAreaTexto);
		
		ta.setBorder(new TitledBorder(titulo));
		
		return ta;
	}
	
	private JPanel panelBotones() {
		
		JPanel panel = new JPanel();
		//panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		bIntercambiar = new JButton("🔁");
		bIntercambiar.setToolTipText("Intercambiar");
		
		bTraducir = new JButton("TRADUCIR");
		
		panel.add(bIntercambiar);
		panel.add(new JSeparator());
		panel.add(bTraducir);
		
		return panel;
	}
	
	public JTextArea getTaEspañol() {
		return taEspañol;
	}
	
	public JTextArea getTaIngles() {
		return taIngles;
	}
}
