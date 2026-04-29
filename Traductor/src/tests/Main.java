package tests;

import javax.swing.*;

import controlador.Controlador;
import vista.Vista;

public class Main {

	public static void main(String[] args) {
		
		Vista v = new Vista();
		new Controlador(v);
		
		JFrame f = new JFrame("Traductor");
		f.setContentPane(v);
		
		f.setIconImage(new ImageIcon("./src/imgs/icono.png").getImage());
		
		//f.setPreferredSize(new Dimension(720, 420));
		f.pack();
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
