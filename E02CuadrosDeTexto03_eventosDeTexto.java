package swing_componentes;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

@SuppressWarnings("serial")
public class E02CuadrosDeTexto03_eventosDeTexto extends JDialog {

	private JTextField TFcorreo;
	private JLabel resultado;
	private JPanel panel;

	public E02CuadrosDeTexto03_eventosDeTexto(JFrame f_ppal) {
		super(f_ppal, ModalityType.APPLICATION_MODAL);
		setTitle("Video 88 - Eventos de texto. Comprobacion emails.");
		setBackground(SystemColor.window);
		setSize(400, 400);
		setLocationRelativeTo(f_ppal);

		panel = new JPanel();
		cargarComponentes();
		add(panel);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void cargarComponentes() {
			panel.setLayout(new BorderLayout());
			JPanel lamina2 = new JPanel();
			lamina2.setLayout(new FlowLayout());
			panel.add(lamina2, BorderLayout.NORTH);

			JLabel email = new JLabel("Email");
			lamina2.add(email);
			TFcorreo = new JTextField(25);
			lamina2.add(TFcorreo);

			Document docTFcorreo = TFcorreo.getDocument();
			docTFcorreo.addDocumentListener(new OyenteTexto());

			resultado = new JLabel("", JLabel.CENTER);
			resultado.setVisible(false);
			panel.add(resultado, BorderLayout.CENTER);
		}

	private class OyenteTexto implements DocumentListener {

		@Override
		public void insertUpdate(DocumentEvent e) {
			if (comprobarPuntos(TFcorreo.getText())) {
				resultado.setText("CORRECTO");
				resultado.setForeground(Color.GREEN);
			} else {
				resultado.setText("INCORRECTO");
				resultado.setForeground(Color.RED);
			}
			resultado.setVisible(true);
			System.out.println("Insertaste texto.");

		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			if (comprobarPuntos(TFcorreo.getText())) {
				resultado.setText("CORRECTO");
				resultado.setForeground(Color.GREEN);
			} else {
				resultado.setText("INCORRECTO");
				resultado.setForeground(Color.RED);
			}
			resultado.setVisible(true);
			System.out.println("Borraste texto.");
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
		} // se usa cuando el texto cambia de propiedades. Ej: que se ponga en negritas, o
			// cambie de tamaño,

		public boolean comprobarArrobas(String correo) {
			int cantidadArrobas = 0;

			for (int i = 0; i < correo.length(); i++) {
				if (correo.charAt(i) == '@' && i > 0)
					cantidadArrobas += 1;
			}

			if (cantidadArrobas == 1)
				return true;
			else
				return false;
		}

		public boolean comprobarPuntos(String correo) {
			if (!comprobarArrobas(correo))
				return false;

			int i = 0;
			int posArroba = 0;
			while (i < correo.length() && posArroba == 0) {
				if (correo.charAt(i) == '@')
					posArroba = i;
				i++;
			}

			int e = 0;
			boolean hayPunto = false;
			while (e < correo.length()) {
				if (correo.charAt(e) == '.') {
					if (e == posArroba + 1)
						return false;
					else
						hayPunto = true;
				}
				e++;
			}
			return hayPunto;
		}
	}
}