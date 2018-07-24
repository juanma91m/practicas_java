package swing_componentes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class E01CuadrosDeTexto0102 extends JDialog {

	private JTextField TFcorreo;
	private JButton boton1;
	private JLabel resultado;
	private JPanel panel;

	public E01CuadrosDeTexto0102(JFrame f_ppal) {
		super(f_ppal, ModalityType.APPLICATION_MODAL);
		setTitle("Video 86, 87 - cuadros de texto. Comprobacion emails.");
		setBackground(SystemColor.window);
		setSize(500, 400);
		setLocationRelativeTo(f_ppal);

		panel = new JPanel();
		cargarComponentes();
		add(panel);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void cargarComponentes() {
		panel.setLayout(new BorderLayout());
		JPanel lamina2 = new JPanel();
		lamina2.setLayout(new FlowLayout());
		panel.add(lamina2, BorderLayout.NORTH);

		/*
		 * campo1 = new JTextField("          Texto de prueba"); add(campo1);
		 * System.out.println(campo1.getText().trim()); // trim saca espacios repetidos
		 */
		JLabel email = new JLabel("Email");
		lamina2.add(email);
		TFcorreo = new JTextField(25);
		lamina2.add(TFcorreo);
		TFcorreo.setText("");
		TFcorreo.setSelectedTextColor(Color.BLUE);

		boton1 = new JButton("Comprobar");
		boton1.addActionListener(new Oyente());
		lamina2.add(boton1);

		resultado = new JLabel("", JLabel.CENTER);
		resultado.setVisible(false);
		panel.add(resultado, BorderLayout.CENTER);
	}

	class Oyente implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (comprobarPuntos(TFcorreo.getText())) {
				resultado.setText("CORRECTO");
				resultado.setForeground(Color.GREEN);
			} else {
				resultado.setText("INCORRECTO");
				resultado.setForeground(Color.RED);
			}
			resultado.setVisible(true);
		}

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