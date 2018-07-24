package layouts;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Layout2_BorderLayout extends JDialog {

	JPanel miLamina;

	public Layout2_BorderLayout(JFrame f_ppal) {
		super(f_ppal, ModalityType.APPLICATION_MODAL);
		setTitle("Layout BorderLayout");
		setBackground(SystemColor.window);
		setSize(400, 400);
		setLocationRelativeTo(f_ppal);

		miLamina = new JPanel();
		cargarComponentes();
		add(miLamina);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void cargarComponentes() {
		// Layout de tipo BorderLayout:
		// BorderLayout(separacionHorizontal,separacionVertical)
		miLamina.setLayout(new BorderLayout(20, 20));
		miLamina.add(new JButton("Norte"), BorderLayout.NORTH);
		miLamina.add(new JButton("Sur"), BorderLayout.SOUTH);
		miLamina.add(new JButton("Oeste"), BorderLayout.WEST);
		miLamina.add(new JButton("Este"), BorderLayout.EAST);
		miLamina.add(new JButton("Centro"), BorderLayout.CENTER);
	}
}