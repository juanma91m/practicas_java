package swing_componentes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class E06JComboBox extends JDialog implements ActionListener {

	JPanel panel;
	JLabel lbCambioFuente1, lbCambioFuente2;
	JComboBox<String> cbFuentes1, cbFuentes2;

	public E06JComboBox(JFrame f_ppal) {
		super(f_ppal, ModalityType.APPLICATION_MODAL);
		setTitle("Video 95 - JComboBox");
		setBackground(SystemColor.window);

		panel = new JPanel();
		cargarComponentes();
		add(panel);

		setSize(240, 200);
		setLocationRelativeTo(f_ppal);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void cargarComponentes() {
		panel.setLayout(new BorderLayout());
		JPanel panel2 = new JPanel();

		cbFuentes1 = new JComboBox<String>();
		panel2.add(cbFuentes1);
		cbFuentes1.setEditable(true);
		cbFuentes1.addItem("Arial");
		cbFuentes1.addItem("Serif");
		cbFuentes1.addItem("Monospaced");
		cbFuentes1.addItem("Dialog");
		cbFuentes1.addActionListener(this);

		lbCambioFuente1 = new JLabel("Este es un texto...");
		panel2.add(lbCambioFuente1);

		GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] listaFuentes = environment.getAvailableFontFamilyNames();
		cbFuentes2 = new JComboBox<String>(listaFuentes);
		cbFuentes2.addActionListener(this);
		panel2.add(cbFuentes2);

		lbCambioFuente2 = new JLabel("Este es otro texto...");
		panel2.add(lbCambioFuente2);
		panel.add(panel2, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		@SuppressWarnings("unchecked")
		JComboBox<String> miCombo = (JComboBox<String>) e.getSource();
		if (miCombo.equals(cbFuentes1)) {
			Font f = lbCambioFuente1.getFont();
			lbCambioFuente1.setFont(new Font(miCombo.getSelectedItem().toString(), Font.PLAIN, f.getSize()));
		} else if (miCombo.equals(cbFuentes2)) {
			Font f = lbCambioFuente2.getFont();
			lbCambioFuente2.setFont(new Font(miCombo.getSelectedItem().toString(), Font.PLAIN, f.getSize()));
		}
	}
}
