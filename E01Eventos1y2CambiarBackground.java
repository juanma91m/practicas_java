package eventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class E01Eventos1y2CambiarBackground extends JDialog implements ActionListener {

	private JButton btAzul, btAmarillo, btRojo;
	private JPanel panel;

	public E01Eventos1y2CambiarBackground(JFrame f_ppal) {
		super(f_ppal, ModalityType.APPLICATION_MODAL);
		setTitle("Eventos I, II y III - cambiar color de fondo siendo la clase misma oyente");
		panel = new JPanel();
		cargarComponentes();
		add(panel);
		setSize(400, 400);
		setLocationRelativeTo(f_ppal);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true); // Set visible siempre a lo último en los JDialog. Por alguna razón no carga
							// componentes si la hacemos antes.
	}

	public void cargarComponentes() {
		setBackground(SystemColor.window);
		btAzul = new JButton("Azul");
		btAmarillo = new JButton("Amarillo");
		btRojo = new JButton("Rojo");

		panel.add(btAzul);
		panel.add(btAmarillo);
		panel.add(btRojo);

		btAzul.addActionListener(this);
		btAmarillo.addActionListener(this);
		btRojo.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object botonPulsado = e.getSource();
		if (botonPulsado == btAzul) {
			panel.setBackground(Color.BLUE);
		} else {
			if (botonPulsado == btAmarillo) {
				panel.setBackground(Color.YELLOW);
			} else
				panel.setBackground(Color.RED);
		}

	}

}
