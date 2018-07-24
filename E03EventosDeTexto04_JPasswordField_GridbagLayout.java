package swing_componentes;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

@SuppressWarnings("serial")
public class E03EventosDeTexto04_JPasswordField_GridbagLayout extends JDialog {

	private JLabel usuario, contrasena;
	private JTextField TFusuario;
	private JPasswordField TFcontrasena;
	private JButton BTenviar;
	private JPanel panel;

	public E03EventosDeTexto04_JPasswordField_GridbagLayout(JFrame f_ppal) {
		super(f_ppal, ModalityType.APPLICATION_MODAL);
		setTitle("Video 89 - Eventos de texto. Comprobacion de contraseñas.");
		setBackground(SystemColor.window);

		panel = new JPanel();
		cargarComponentes();
		Document docTFcontrasena = TFcontrasena.getDocument();
		docTFcontrasena.addDocumentListener(new Oyente_texto());
		add(panel);

		pack(); // ajustar ventana a lo que tiene adentro
		setMinimumSize(getSize()); // no se puede achicar
		setLocationRelativeTo(f_ppal);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void cargarComponentes() {
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = 1; // todos ancho 1 en columnas
		gbc.gridheight = 1; // todos alto 1 en columnas
		gbc.weightx = 0.0; // todo se estira horizontalmente con proporcion 0 (no se estira)
		gbc.weighty = 0.0; // todo se estira verticalmente con proporcion 0 (no se estira)
		gbc.fill = GridBagConstraints.NONE; // no se estira en ninguna posicion (solo TextFields)

		usuario = new JLabel("Usuario");
		gbc.gridx = 0; // posicion fila 0
		gbc.gridy = 0; // posicion columna 0
		gbc.insets = new Insets(15, 15, 0, 0); // (top,left,bottom,right) - el componente tendra una separacion
												// respecto
												// a la celda de 15 en el alto y 15 a la izquierda
		gbc.anchor = GridBagConstraints.EAST; // posicionar el componente en la parte este (centro-derecha de la
												// celda)
		panel.add(usuario, gbc);

		contrasena = new JLabel("Contraseña");
		gbc.gridx = 0; // posicion fila 0
		gbc.gridy = 1; // posicion columna 1
		gbc.insets = new Insets(15, 15, 0, 0);
		gbc.anchor = GridBagConstraints.EAST; // posicionar el componente en la parte este (centro-derecha de la
												// celda)
		panel.add(contrasena, gbc);

		TFusuario = new JTextField();

		gbc.gridx = 1; // posicion fila 1
		gbc.gridy = 0; // posicion columna 0
		gbc.ipadx = 100; // tamaño inicial del componente
		gbc.insets = new Insets(15, 15, 0, 15); // (top,left,bottom,right) - el componente tendra una separacion
												// respecto a la celda de 15 en el alto y 15 a la izquierda y 15
												// derecha
		gbc.anchor = GridBagConstraints.NORTHWEST; // posicionar el componente en la parte noroeste
													// (arriba-izquierda de
													// la celda)
		gbc.weightx = 1.0; // aumenta el ancho del componente proporcional al tamaño de la venta
		gbc.fill = GridBagConstraints.HORIZONTAL; // solo crece horizontalmente
		panel.add(TFusuario, gbc);

		TFcontrasena = new JPasswordField();
		gbc.gridx = 1; // posicion fila 1
		gbc.gridy = 1; // posicion columna 1
		gbc.ipadx = 100; // tamaño inicial del componente
		gbc.insets = new Insets(15, 15, 0, 15); // (top,left,bottom,right) - el componente tendra una separacion
												// respecto a la celda de 15 en el alto, 15 a la izquierda y 15
												// derecha
		gbc.anchor = GridBagConstraints.NORTHWEST; // posicionar el componente en la parte noroeste
													// (arriba-izquierda de
													// la celda)
		gbc.weightx = 1.0; // aumenta el ancho del componente proporcional al tamaño de la venta
		gbc.fill = GridBagConstraints.HORIZONTAL; // solo crece horizontalmente
		panel.add(TFcontrasena, gbc);

		BTenviar = new JButton("Enviar");
		gbc.gridx = 1; // posicion fila 1
		gbc.gridy = 2; // posicion columna 2
		gbc.ipadx = 0; // reseteamos el tamaño inicial del componente
		gbc.insets = new Insets(15, 0, 15, 15); // (top,left,bottom,right) - el componente tendra una separacion
												// respecto a la celda de 15 en el alto, 15 a la izquierda y 15
												// derecha
		gbc.anchor = GridBagConstraints.NORTHEAST; // posicionar el componente en la parte nordeste (arriba-derecha
													// de
													// la celda)
		// se posiciona a la arriba de la celda para que no se aleje del resto de la
		// interfaz al agrandar la ventana
		gbc.weighty = 0.1; // se usa para que al agrandar la ventana no agrande la fila 1, sino la final y
							// no se alejen los componentes de la parte superior de la ventana
		gbc.fill = GridBagConstraints.NONE; // no crece para ningun lado al crecer la ventana
		panel.add(BTenviar, gbc);
	}

	class Oyente_texto implements DocumentListener {

		@Override
		public void insertUpdate(DocumentEvent e) {
			String contrasena = new String(TFcontrasena.getPassword()); // getPassword devuelve un char[], se lo
																		// pasamos de parametro al constructor de
																		// Strings y nos devuelve un string
			System.out.println(contrasena);
			if (e.getDocument().getLength() < 8)
				TFcontrasena.setForeground(Color.RED);
			else
				TFcontrasena.setForeground(Color.BLACK);
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			System.out.println(TFcontrasena.getPassword());
			if (e.getDocument().getLength() < 8)
				TFcontrasena.setForeground(Color.RED);
			else
				TFcontrasena.setForeground(Color.BLACK);

		}

		@Override
		public void changedUpdate(DocumentEvent e) {
		}
	}
}