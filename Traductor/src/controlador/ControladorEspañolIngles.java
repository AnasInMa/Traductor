package controlador;

import java.awt.event.*;

import javax.swing.JOptionPane;

import modelo.Diccionario;
import vista.*;

public class ControladorEspañolIngles implements FocusListener, ActionListener {

	private Vista vista;
	private VistaEspañolIngles vEspañolIngles;

	private Diccionario diccionario;

	private String textoEspañol, textoIngles;

	public ControladorEspañolIngles(Vista vista, VistaEspañolIngles v) {

		this.vista = vista;

		diccionario = new Diccionario();

		vEspañolIngles = v;

		vEspañolIngles.control(this);

		textoEspañol = vEspañolIngles.getTaEspañol().getText();
		textoIngles = vEspañolIngles.getTaIngles().getText();
	}

	@Override
	public void focusGained(FocusEvent e) {

		if (e.getSource() == vEspañolIngles.getTaEspañol()
				&& vEspañolIngles.getTaEspañol().getText().equals(textoEspañol)) {

			vEspañolIngles.getTaEspañol().setText("");

		} else if (e.getSource() == vEspañolIngles.getTaIngles()
				&& vEspañolIngles.getTaIngles().getText().equals(textoIngles)) {

			vEspañolIngles.getTaIngles().setText("");
		}

	}

	@Override
	public void focusLost(FocusEvent e) {

		if (e.getSource() == vEspañolIngles.getTaEspañol() && vEspañolIngles.getTaEspañol().getText().isEmpty()) {

			vEspañolIngles.getTaEspañol().setText(textoEspañol);

		} else if (e.getSource() == vEspañolIngles.getTaIngles() && vEspañolIngles.getTaIngles().getText().isEmpty()) {

			vEspañolIngles.getTaIngles().setText(textoIngles);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == vEspañolIngles.getbTraducir()) {

			// System.out.println("boton traducir pulsado");
			this.vEspañolIngles.getTaIngles()
					.setText(diccionario.buscaPalabraEnEspañol(vEspañolIngles.getTaEspañol().getText()));

		} else if (e.getSource() == vEspañolIngles.getbIntercambiar()) {

			vista.intercambiarPaneles();

		} else {

			// System.out.println("boton añadir pulsado");

			String palabraEspañol = JOptionPane.showInputDialog(vista, "Esriba la palabra en español", "Añadir palabra",
					JOptionPane.QUESTION_MESSAGE);

			if (palabraEspañol == null || palabraEspañol.isEmpty()) {

				JOptionPane.showMessageDialog(vista, "No se ha detectado ningua palabra");

			} else {

				String palabraIngles = JOptionPane.showInputDialog(vista,
						"Esriba la traduccion al ingles de '" + palabraEspañol + "'", "Añadir palabra",
						JOptionPane.QUESTION_MESSAGE);

				if (!palabraIngles.isEmpty() || palabraIngles != null) {

					boolean existe = diccionario.añadePalabras(palabraEspañol, palabraIngles); // si todo esta correcto, añade la palabra al
																				// diccionario y al fichero, por lo
																				// tanto, ahora se puede utilizar en el traductor
					if(!existe) {

						JOptionPane.showMessageDialog(vista, "Las palabras " + palabraEspañol
								+ " y " + palabraIngles + " se han añadido al diccionario correctamente");

					} else {

						JOptionPane.showMessageDialog(vista, "Las palabras " + palabraEspañol
								+ " y " + palabraIngles + " ya existen en el diccionario");
					}
				}
			}

		}
	}

}
