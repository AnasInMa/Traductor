package controlador;

import java.awt.event.*;

import javax.swing.JOptionPane;

import modelo.Diccionario;
import vista.*;

public class ControladorInglesEspañol implements FocusListener, ActionListener{

		private Vista vista;
		private VistaInglesEspañol vInglesEspañol;
		
		private Diccionario diccionario;
		
		private String textoEspañol, textoIngles;
		
		public ControladorInglesEspañol(Vista vista, VistaInglesEspañol v) {
			
			this.vista = vista;
			
			diccionario = new Diccionario();
			
			vInglesEspañol = v;
			
			vInglesEspañol.control(this);
			
			textoEspañol = vInglesEspañol.getTaEspañol().getText();
			textoIngles = vInglesEspañol.getTaIngles().getText();
		}
		
		@Override
		public void focusGained(FocusEvent e) {
			
			if(e.getSource() == vInglesEspañol.getTaEspañol() && vInglesEspañol.getTaEspañol().getText().equals(textoEspañol)) {
			
				vInglesEspañol.getTaEspañol().setText("");
				
			} else if(e.getSource() == vInglesEspañol.getTaIngles() && vInglesEspañol.getTaIngles().getText().equals(textoIngles)) {
				
				vInglesEspañol.getTaIngles().setText("");
			}
			
			
		}

		@Override
		public void focusLost(FocusEvent e) {
			
			if(e.getSource() == vInglesEspañol.getTaEspañol() && vInglesEspañol.getTaEspañol().getText().isEmpty()) {
				
				vInglesEspañol.getTaEspañol().setText(textoEspañol);
				
			} else if(e.getSource() == vInglesEspañol.getTaIngles() && vInglesEspañol.getTaIngles().getText().isEmpty()){
				
				vInglesEspañol.getTaIngles().setText(textoIngles);
			}
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getSource() == vInglesEspañol.getbTraducir()) {

				//System.out.println("boton traducir pulsado");
				this.vInglesEspañol.getTaEspañol().setText(diccionario.buscaPalabraEnIngles(vInglesEspañol.getTaIngles().getText()));

			}  else if (e.getSource() == vInglesEspañol.getbIntercambiar()) {

				vista.intercambiarPaneles();

			} else {

				// System.out.println("boton añadir pulsado");

				String palabraIngles = JOptionPane.showInputDialog(vista, "Esriba la palabra en ingles", "Añadir palabra",
						JOptionPane.QUESTION_MESSAGE);

				if (palabraIngles == null || palabraIngles.isEmpty()) {

					JOptionPane.showMessageDialog(vista, "No se ha detectado ningua palabra");

				} else {

					String palabraEspañol = JOptionPane.showInputDialog(vista,
							"Esriba la traduccion al español de '" + palabraIngles + "'", "Añadir palabra",
							JOptionPane.QUESTION_MESSAGE);

					if (!palabraEspañol.isEmpty() || palabraEspañol != null) {

						boolean existe = diccionario.añadePalabras(palabraEspañol, palabraIngles); // si todo esta correcto, añade la palabra al
																					// diccionario y al fichero, por lo
																					// tanto, ahora se puede utilizar en el traductor
						if(!existe) {

							JOptionPane.showMessageDialog(vista, "Las palabras " + palabraIngles
									+ " y " + palabraEspañol + " se han añadido al diccionario correctamente");

						} else {

							JOptionPane.showMessageDialog(vista, "Las palabras " + palabraIngles
									+ " y " + palabraEspañol + " ya existen en el diccionario");
						}
					}
				}

			}
		}


}
