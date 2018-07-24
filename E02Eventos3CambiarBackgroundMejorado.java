package eventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class E02Eventos3CambiarBackgroundMejorado extends JDialog {

	private JButton btAzul, btAmarillo, btRojo;
	private JPanel panel;

	public E02Eventos3CambiarBackgroundMejorado(JFrame f_ppal) {
		super(f_ppal, ModalityType.APPLICATION_MODAL);
		setTitle("Eventos IV - cambiar color de fondo declarando clase oyente");
		panel = new JPanel();
		cargarComponentes();
		add(panel);
		setSize(400, 400);
		setLocationRelativeTo(f_ppal);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void cargarComponentes() {
		panel.setBackground(SystemColor.window);
		btAzul = new JButton("Azul");
		btAmarillo = new JButton("Amarillo");
		btRojo = new JButton("Rojo");
		
		panel.add(btAzul);
		panel.add(btAmarillo);
		panel.add(btRojo);

		// El objeto fuente btColor desencadena el evento click (addActionListener)
		// enviando como parámetro una instancia del objeto oyente
		btAzul.addActionListener(new ColorFondo(Color.BLUE));
		btAmarillo.addActionListener(new ColorFondo(Color.YELLOW));
		btRojo.addActionListener(new ColorFondo(Color.RED));
	}

	// clase interna declara como oyente
	class ColorFondo implements ActionListener {
		private Color color;

		public ColorFondo(Color c) {
			this.color = c;
		}

		public void actionPerformed(ActionEvent e) {
			// las clases internas pueden acceder a los métodos de la clase
			// que las contiene
			panel.setBackground(color);
		}
	}

}
