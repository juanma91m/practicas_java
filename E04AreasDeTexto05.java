package swing_componentes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class E04AreasDeTexto05 extends JDialog implements ActionListener {

	private JTextArea TA1;
	private JButton BTmostrar, BTagregar, BTsalir;
	private JPanel panel;

	public E04AreasDeTexto05(JFrame f_ppal) {
		super(f_ppal, ModalityType.APPLICATION_MODAL);
		setTitle("Video 90 - Areas de texto");
		setBackground(SystemColor.window);
		panel = new JPanel();
		cargarComponentes();
		add(panel);

		pack();

		// esto se hace porque sino el area de texto desaparece
		/*
		 * int alto = getSize().height + 7; int ancho = getSize().width; Dimension
		 * dimMin = new Dimension(ancho, alto); setMinimumSize(dimMin); //SE HIZO CON
		 * JFRAME, CON JDIALOG NO PASA
		 */
		setResizable(false);
		setLocationRelativeTo(f_ppal);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void cargarComponentes() {
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = 1;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;

		TA1 = new JTextArea(6, 15); // alto , ancho
		JScrollPane scroll = new JScrollPane(TA1);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 3;
		gbc.insets = new Insets(15, 15, 15, 0);
		gbc.anchor = GridBagConstraints.NORTHWEST;
		panel.add(scroll, gbc);

		BTagregar = new JButton("Agregar");
		gbc.gridx = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(15, 15, 0, 15);
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel.add(BTagregar, gbc);

		BTmostrar = new JButton("Mostrar");
		gbc.gridy = 1;
		gbc.insets = new Insets(15, 15, 0, 15);
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(BTmostrar, gbc);

		BTsalir = new JButton("Salir");
		gbc.gridy = 2;
		gbc.insets = new Insets(15, 15, 15, 15);
		gbc.anchor = GridBagConstraints.SOUTHWEST;
		panel.add(BTsalir, gbc);

		BTagregar.addActionListener(this);
		BTmostrar.addActionListener(this);
		BTsalir.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton = (JButton) e.getSource();
		if (boton.equals(BTagregar))
			TA1.append("Texto\n");
		if (boton.equals(BTmostrar))
			System.out.println(TA1.getText());
		if (boton.equals(BTsalir))
			dispose();
	}
}