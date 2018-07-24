package layouts;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Layout1_FlowLayout extends JDialog {

	JPanel miLamina;

	public Layout1_FlowLayout(JFrame f_ppal) {
		super(f_ppal, ModalityType.APPLICATION_MODAL);
		setTitle("Layout FlowLayout");
		setBackground(SystemColor.window);
		setLocationRelativeTo(f_ppal);

		miLamina = new JPanel();
		cargarComponentes();
		add(miLamina);
		pack();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void cargarComponentes() {
		// Layout de tipo FlowLayout:
		// FlowLayout(Alineacion,separacionHorizontal,separacionVertical)
		miLamina.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
		miLamina.add(new JButton("Amarillo"));
		miLamina.add(new JButton("Rojo"));
		miLamina.add(new JButton("Azul"));
	}
}