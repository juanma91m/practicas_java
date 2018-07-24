package eventos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class E07EventosDeFoco10 extends JDialog implements FocusListener {

	JTextField TF1, TF2;

	public E07EventosDeFoco10(JFrame f_ppal) {
		super(f_ppal, ModalityType.APPLICATION_MODAL);
		setTitle("Eventos IV - eventos de Foco");
		setBackground(SystemColor.window);
		setSize(400, 400);
		setLocationRelativeTo(f_ppal);

		add(new Lamina());

		TF1.addFocusListener(this);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	class Lamina extends JPanel {

		public Lamina() { // debería hacer esto en el método painComponent(Graphics g){} pero tiene //
							// errores en cuanto al pase de foco.
			setLayout(null);
			TF1 = new JTextField();
			TF2 = new JTextField();
			TF1.setBounds(110, 20, 150, 20);
			TF2.setBounds(110, 60, 150, 20);
			add(TF1);
			add(TF2);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.drawString("e-mail", 53, 35);
			g.drawString("contraseña", 20, 73);
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		String email = TF1.getText();
		if (!(email.contains("@") && email.contains(".")))
			System.out.println("El correo es incorrecto");
		else
			System.out.println("El correo es correcto");
	}

	@Override
	public void focusGained(FocusEvent e) {
	}
}
