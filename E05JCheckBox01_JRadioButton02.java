package swing_componentes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class E05JCheckBox01_JRadioButton02 extends JDialog implements ActionListener {

	private JTextField TF1;
	private JCheckBox check1, check2;
	private JRadioButton option1, option2, option3, option4, option5, option6;
	private JPanel panel;

	public E05JCheckBox01_JRadioButton02(JFrame f_ppal) {
		super(f_ppal, ModalityType.APPLICATION_MODAL);
		setTitle("Video 92, 93 y 94 - JCheckBox y JRadioButton");

		panel = new JPanel();
		cargarComponentes();
		add(panel);

		pack();
		setSize(getSize().width, getSize().height + 200);

		setLocationRelativeTo(f_ppal);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void cargarComponentes() {

		panel.setLayout(new BorderLayout());
		JPanel norte = new JPanel();
		JPanel sur = new JPanel();
		norte.setLayout(new FlowLayout());

		TF1 = new JTextField("Aquí va el texto...", 40);
		// aumentar ancho JTextField
		Dimension dim = new Dimension(TF1.getWidth(), 30);
		TF1.setPreferredSize(dim);
		Font fuente = new Font("Arial", Font.PLAIN, 10);
		TF1.setFont(fuente);
		TF1.setForeground(Color.RED);
		norte.add(TF1);
		panel.add(norte, BorderLayout.NORTH);

		JPanel oeste = new JPanel();
		ButtonGroup grupo1 = new ButtonGroup();
		option1 = new JRadioButton("Rojo", true);
		option2 = new JRadioButton("Azul", false);
		option3 = new JRadioButton("Verde", false);
		grupo1.add(option1);
		grupo1.add(option2);
		grupo1.add(option3);
		oeste.add(option1);
		oeste.add(option2);
		oeste.add(option3);
		panel.add(oeste, BorderLayout.WEST);

		JPanel este = new JPanel();
		ButtonGroup grupo2 = new ButtonGroup();
		option4 = new JRadioButton("10", true);
		option5 = new JRadioButton("15", false);
		option6 = new JRadioButton("20", false);
		grupo2.add(option4);
		grupo2.add(option5);
		grupo2.add(option6);

		este.add(option4);
		este.add(option5);
		este.add(option6);
		panel.add(este, BorderLayout.EAST);

		sur.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0));
		check1 = new JCheckBox("Negrita");
		check2 = new JCheckBox("Cursiva");
		sur.add(check1);
		sur.add(check2);
		panel.add(sur, BorderLayout.SOUTH);

		check1.addActionListener(this);
		check2.addActionListener(this);
		option1.addActionListener(this);
		option2.addActionListener(this);
		option3.addActionListener(this);
		option4.addActionListener(this);
		option5.addActionListener(this);
		option6.addActionListener(this);
		/*
		 * Listar fuentes instaladas en el sistema
		 * 
		 * GraphicsEnvironment environment =
		 * GraphicsEnvironment.getLocalGraphicsEnvironment(); String[] listaFuentes =
		 * environment.getAvailableFontFamilyNames();
		 * 
		 * for (int i = 0; i < listaFuentes.length ; i++)
		 * System.out.println(listaFuentes[i]);
		 */
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int estilo = 0;
		int tamano = 0;
		estilo += (check1.isSelected() ? Font.BOLD : 0);
		estilo += (check2.isSelected() ? Font.ITALIC : 0);
		if (option4.isSelected())
			tamano = Integer.parseInt(option4.getText());
		if (option5.isSelected())
			tamano = Integer.parseInt(option5.getText());
		if (option6.isSelected())
			tamano = Integer.parseInt(option6.getText());
		System.out.println(tamano);

		TF1.setFont(new Font(TF1.getFont().getFamily(), estilo, tamano));
		if (option1.isSelected())
			TF1.setForeground(Color.RED);
		if (option2.isSelected())
			TF1.setForeground(Color.BLUE);
		if (option3.isSelected())
			TF1.setForeground(Color.GREEN);
	}
}
