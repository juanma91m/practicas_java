package practicas;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class E01ProcesadorTexto extends JDialog {

	private JPanel panel;
	private JTextPane hoja;

	private JMenuBar menuBar;

	private String fuente;
	private int tamano, estilo;
	
	private ButtonGroup g1,g2;
	
	public E01ProcesadorTexto(JFrame f_ppal) {
		super(f_ppal, ModalityType.APPLICATION_MODAL);
		setTitle("Video 101 al 106	- Procesador de Texto.");
		setBackground(SystemColor.window);

		panel = new JPanel();
		cargarComponentes();
		add(panel);

		setSize(500, 400);
		setLocationRelativeTo(f_ppal);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void cargarComponentes() {
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		menuBar = new JMenuBar();
		g1 = new ButtonGroup();
		g2 = new ButtonGroup();
		crearMenu("Fuente");
		crearSubMenu(menuBar.getMenu(0), "Arial", "Tipo de letra en Arial", 'A', 1);
		crearSubMenu(menuBar.getMenu(0), "Courier", "Tipo de letra en Courier", 'C', 1);
		crearSubMenu(menuBar.getMenu(0), "Verdana", "Tipo de letra en Verdana", 'V', 1);
		menuBar.getMenu(0).getItem(0).setSelected(true);
		crearMenu("Estilo");
		crearSubMenu(menuBar.getMenu(1), "Negrita", "Estilo en negrita", 'N', 0);
		crearSubMenu(menuBar.getMenu(1), "Cursiva", "Estilo en cursiva", 'K', 0);
		crearMenu("Tamaño");
		crearSubMenu(menuBar.getMenu(2), "12", "Tamaño de letra 12",1);
		crearSubMenu(menuBar.getMenu(2), "16", "Tamaño de letra 16",1);
		crearSubMenu(menuBar.getMenu(2), "20", "Tamaño de letra 20",1);
		crearSubMenu(menuBar.getMenu(2), "24", "Tamaño de letra 24",1);
		menuBar.getMenu(2).getItem(0).setSelected(true);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;// alto
		gbc.gridwidth = 1;// ancho
		gbc.insets = new Insets(0, 0, 15, 0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.weightx = 1.0;
		gbc.weighty = 0.0;
		panel.add(menuBar, gbc);

		hoja = new JTextPane();
		hoja.setAutoscrolls(true);
		JScrollPane scroll = new JScrollPane(hoja);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weighty = 1.0;
		gbc.insets = new Insets(0, 5, 5, 5);
		gbc.fill = GridBagConstraints.BOTH;
		panel.add(scroll, gbc);

		fuente = "Arial";
		tamano = 12;
		estilo = Font.PLAIN;

		hoja.setFont(new Font(fuente, estilo, tamano));
	}

	private void crearMenu(String titulo) {
		JMenu menu = new JMenu(titulo);
		menuBar.add(menu);
	}

	private void crearSubMenu(JMenu padre, String titulo, String desc, char atajo, int tipoSubMenu) {
		JMenuItem item;
		if (tipoSubMenu == 0) {
			item = new JCheckBoxMenuItem(new Accion(titulo, desc));
		} else {
			item = new JRadioButtonMenuItem(new Accion(titulo, desc));
			g1.add(item);
		}

		item.setAccelerator(KeyStroke.getKeyStroke(atajo, InputEvent.ALT_DOWN_MASK));
		padre.add(item);
	}

	private void crearSubMenu(JMenu padre, String titulo, String desc, int tipoSubMenu) {
		JMenuItem item;
		if (tipoSubMenu == 0) {
			item = new JCheckBoxMenuItem(new Accion(titulo, desc));
		} else {
			item = new JRadioButtonMenuItem(new Accion(titulo, desc));
			g2.add(item);
		}

		padre.add(item);
	}

	public class Accion extends AbstractAction {

		public Accion(String titulo, String desc) {
			super(titulo);
			putValue(SHORT_DESCRIPTION, desc);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			JMenuItem menuItem = (JMenuItem) e.getSource();

			// determinar JMenu padre
			JPopupMenu p = (JPopupMenu) menuItem.getParent();
			JMenu menu = (JMenu) p.getInvoker();

			if (menu.getText() == "Fuente") {
				fuente = menuItem.getText();
			} else if (menu.getText() == "Estilo") {
				switch (menuItem.getText()) {
				case "Negrita":
					estilo += ((estilo == 0) || (estilo == 2) ? Font.BOLD : -(Font.BOLD));
					break;
				case "Cursiva":
					estilo += ((estilo == 0) || (estilo == 1) ? Font.ITALIC : -(Font.ITALIC));
					break;
				}
			} else {
				tamano = Integer.parseInt(menuItem.getText());
			}

			hoja.setFont(new Font(fuente, estilo, tamano));
		}
	}

}
