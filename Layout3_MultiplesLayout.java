package layouts;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Layout3_MultiplesLayout extends JDialog {

	public Layout3_MultiplesLayout(JFrame f_ppal) {
		super(f_ppal, ModalityType.APPLICATION_MODAL);
		setTitle("Layout Multiples Layout");
		setSize(400, 400);
		setLocationRelativeTo(f_ppal);

		Lamina miLamina = new Lamina(new FlowLayout(FlowLayout.LEFT, 10, 10));
		Lamina2 miLamina2 = new Lamina2(new BorderLayout(20, 20));
		add(miLamina, BorderLayout.NORTH);
		add(miLamina2, BorderLayout.SOUTH);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	class Lamina extends JPanel {

		public Lamina(FlowLayout disposicion) {
			setLayout(disposicion);
			add(new JButton("Amarillo"));
			add(new JButton("Rojo"));
			add(new JButton("Azul"));
		}
	}

	class Lamina2 extends JPanel {

		public Lamina2(BorderLayout disposicion) {
			setLayout(disposicion);
			add(new JButton("Centro"), BorderLayout.CENTER);
			add(new JButton("Norte"), BorderLayout.NORTH);
			add(new JButton("Sur"), BorderLayout.SOUTH);
			add(new JButton("Este"), BorderLayout.EAST);
			add(new JButton("Oeste"), BorderLayout.WEST);
		}
	}
}