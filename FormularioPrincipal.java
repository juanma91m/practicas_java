package admin;

import javax.swing.*;
import eventos.*;
import graficos.*;
import layouts.*;
import practicas.E01ProcesadorTexto;
import practicas.E02ProcesadorTexto2;
import swing_componentes.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class FormularioPrincipal extends JFrame implements ActionListener {

	private JButton
			btImageIO, btGraphics2D,

			btEventosBG, btEventosBG2, btEventosVentana, btEventosEstadoVentana, btEventosTeclado, btEventosMouse,
			btEventosFoco, btEventosFocoVentana, btMultiplesFuentes,

			btFlowlayout, btBorderlayout, btMultiplesLayouts, btGridlayout_calculadora,

			btTF, btEventosTF, btJPasswordField, btTA, btCheckRadio, btJComboBox, btJSlider, btJSpinner, btJMenu,

			btProcesadorTexto, btProcesadorTexto2;
	
	
	private JPanel panelGraficos, panelEventos, panelLayout, panelSwing, panelPractica;

	public FormularioPrincipal() {
		setTitle("App organizadora de prácticas de píldoras informáticas");

		cargarPaneles();
		cargarComponentesPGraficos();
		cargarComponentesPEventos();
		cargarComponentesPLayout();
		cargarComponentesPSwing();
		cargarComponentesPPractica();
		pack();
		setExtendedState(JFrame.MAXIMIZED_HORIZ);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void cargarPaneles() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridheight = 1;// alto
		gbc.gridwidth = 1;// ancho
		gbc.weightx = 1.0; // que se estiren horizontalmente
		gbc.weighty = 1.0;// que se estiren verticalmente
		gbc.fill = GridBagConstraints.BOTH;

		panelGraficos = new JPanel();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.NORTH;
		add(panelGraficos, gbc);
		panelGraficos.setBackground(Color.RED);

		panelLayout = new JPanel();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.NORTH;
		add(panelLayout, gbc);
		panelLayout.setBackground(Color.BLUE);

		panelEventos = new JPanel();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.gridwidth = 2;// ancho
		add(panelEventos, gbc);
		panelEventos.setBackground(Color.YELLOW);

		panelSwing = new JPanel();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.gridwidth = 2;// ancho
		add(panelSwing, gbc);
		panelSwing.setBackground(Color.GREEN);
		
		panelPractica = new JPanel();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.gridwidth = 2;// ancho
		add(panelPractica, gbc);
		panelPractica.setBackground(Color.ORANGE);

	}

	private void cargarComponentesPGraficos() {
		panelGraficos.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridheight = 1;// alto
		gbc.gridwidth = 1;// ancho
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(15, 15, 15, 15);
		gbc.anchor = GridBagConstraints.NORTHWEST;

		// fila 0
		JLabel graphics = new JLabel("(01) Formas y figuras - librería Graphics2D");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.weightx = 0.1;
		gbc.weighty = 0.0;
		panelGraficos.add(graphics, gbc);
		gbc.gridwidth = 1;

		// fila 1
		btImageIO = new JButton("Clase ImageIO");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 0.1;
		panelGraficos.add(btImageIO, gbc);

		btGraphics2D = new JButton("Clase Graphics2D");
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		panelGraficos.add(btGraphics2D, gbc);

		btImageIO.addActionListener(this);
		btGraphics2D.addActionListener(this);
	}

	private void cargarComponentesPLayout() {
		panelLayout.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridheight = 1;// alto
		gbc.gridwidth = 1;// ancho
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(15, 15, 15, 0);
		gbc.anchor = GridBagConstraints.NORTHWEST;

		// fila 0
		JLabel graphics = new JLabel("(03) Librería Swing - layouts");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		panelLayout.add(graphics, gbc);
		gbc.gridwidth = 1;

		// fila 1
		btFlowlayout = new JButton("FlowLayout");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 0.1;
		panelLayout.add(btFlowlayout, gbc);

		btBorderlayout = new JButton("BorderLayout");
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 0.1;
		panelLayout.add(btBorderlayout, gbc);

		btMultiplesLayouts = new JButton("Múltiples Layouts");
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 0.1;
		panelLayout.add(btMultiplesLayouts, gbc);

		btGridlayout_calculadora = new JButton("GridLayout Calculadora");
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		panelLayout.add(btGridlayout_calculadora, gbc);

		btFlowlayout.addActionListener(this);
		btBorderlayout.addActionListener(this);
		btMultiplesLayouts.addActionListener(this);
		btGridlayout_calculadora.addActionListener(this);
	}

	private void cargarComponentesPEventos() {
		panelEventos.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridheight = 1;// alto
		gbc.gridwidth = 1;// ancho
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(15, 15, 15, 0);
		gbc.anchor = GridBagConstraints.NORTHWEST;

		// fila 2
		JLabel eventos = new JLabel("(02) eventos");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		panelEventos.add(eventos, gbc);

		JLabel eventosVentana = new JLabel("Eventos de ventana y de cambio de estado");
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.gridwidth = 2;
		panelEventos.add(eventosVentana, gbc);
		gbc.gridwidth = 1;

		JLabel eventosTeclado = new JLabel("Eventos de teclado y mouse");
		gbc.gridx = 4;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.gridwidth = 2;
		panelEventos.add(eventosTeclado, gbc);
		gbc.gridwidth = 1;

		JLabel eventosFoco = new JLabel("Eventos de foco y foco-ventana");
		gbc.gridx = 6;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.gridwidth = 2;
		panelEventos.add(eventosFoco, gbc);
		gbc.gridwidth = 1;

		JLabel eventosMultiplesFuentes = new JLabel("Eventos de múltiples fuentes");
		gbc.gridx = 8;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		panelEventos.add(eventosMultiplesFuentes, gbc);

		// fila 3
		btEventosBG = new JButton("JButton");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 0.1;
		panelEventos.add(btEventosBG, gbc);

		btEventosBG2 = new JButton("idem c/clase oyente");
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 0.1;
		panelEventos.add(btEventosBG2, gbc);

		btEventosVentana = new JButton("Ventana");
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 0.1;
		panelEventos.add(btEventosVentana, gbc);

		btEventosEstadoVentana = new JButton("Cambio estado ventana");
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 0.1;
		panelEventos.add(btEventosEstadoVentana, gbc);

		btEventosTeclado = new JButton("De teclado");
		gbc.gridx = 4;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 0.1;
		panelEventos.add(btEventosTeclado, gbc);

		btEventosMouse = new JButton("De mouse");
		gbc.gridx = 5;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 0.1;
		panelEventos.add(btEventosMouse, gbc);

		btEventosFoco = new JButton("De foco");
		gbc.gridx = 6;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 0.1;
		panelEventos.add(btEventosFoco, gbc);

		btEventosFocoVentana = new JButton("De foco-ventana");
		gbc.gridx = 7;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 0.1;
		panelEventos.add(btEventosFocoVentana, gbc);

		btMultiplesFuentes = new JButton("Múltiples fuentes");
		gbc.gridx = 8;
		gbc.gridy = 1;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		panelEventos.add(btMultiplesFuentes, gbc);

		btEventosBG.addActionListener(this);
		btEventosBG2.addActionListener(this);
		btEventosVentana.addActionListener(this);
		btEventosEstadoVentana.addActionListener(this);
		btEventosTeclado.addActionListener(this);
		btEventosMouse.addActionListener(this);
		btEventosFoco.addActionListener(this);
		btEventosFocoVentana.addActionListener(this);
		btMultiplesFuentes.addActionListener(this);

	}

	private void cargarComponentesPSwing() {
		panelSwing.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridheight = 1;// alto
		gbc.gridwidth = 1;// ancho
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(15, 15, 15, 0);
		gbc.anchor = GridBagConstraints.NORTHWEST;

		// fila 0
		JLabel swing = new JLabel("(04) Componentes Swing");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		panelSwing.add(swing, gbc);
		gbc.gridwidth = 1;

		// fila 1
		btTF = new JButton("JTextField");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 0.1;
		panelSwing.add(btTF, gbc);

		btEventosTF = new JButton("eventos JTextField");
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 0.1;
		panelSwing.add(btEventosTF, gbc);

		btJPasswordField = new JButton("JPasswordField");
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 0.1;
		panelSwing.add(btJPasswordField, gbc);

		btTA = new JButton("JTextArea");
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 0.1;
		panelSwing.add(btTA, gbc);

		btCheckRadio = new JButton("JCheckBox y JRadioButton");
		gbc.gridx = 4;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 0.1;
		panelSwing.add(btCheckRadio, gbc);

		btJComboBox = new JButton("JComboBox");
		gbc.gridx = 5;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 0.1;
		panelSwing.add(btJComboBox, gbc);

		btJSlider = new JButton("JSlider");
		gbc.gridx = 6;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 0.1;
		panelSwing.add(btJSlider, gbc);

		btJSpinner = new JButton("JSpinner");
		gbc.gridx = 7;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 0.1;
		panelSwing.add(btJSpinner, gbc);

		btJMenu = new JButton("JMenu");
		gbc.gridx = 8;
		gbc.gridy = 1;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		panelSwing.add(btJMenu, gbc);

		btTF.addActionListener(this);
		btEventosTF.addActionListener(this);
		btJPasswordField.addActionListener(this);
		btTA.addActionListener(this);
		btCheckRadio.addActionListener(this);
		btJComboBox.addActionListener(this);
		btJSlider.addActionListener(this);
		btJSpinner.addActionListener(this);
		btJMenu.addActionListener(this);
	}

	private void cargarComponentesPPractica () {
		panelPractica.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridheight = 1;// alto
		gbc.gridwidth = 1;// ancho
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(15, 15, 15, 0);
		gbc.anchor = GridBagConstraints.NORTHWEST;
		
		// fila 0
		JLabel practica = new JLabel("(05) Practicas");
		gbc.gridx = 0;
		gbc.gridy = 0;

		panelPractica.add(practica, gbc);
		
		btProcesadorTexto = new JButton("Procesador de texto");
		gbc.gridx = 0;
		gbc.gridy = 1;
		panelPractica.add(btProcesadorTexto, gbc);
		
		btProcesadorTexto2 = new JButton("Procesador de texto 2");
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		panelPractica.add(btProcesadorTexto2, gbc);
		
		btProcesadorTexto.addActionListener(this);
		btProcesadorTexto2.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton = (JButton) e.getSource();
		if (boton.equals(btImageIO))
			new PruebaImageIO(this);
		else if (boton.equals(btGraphics2D))
			new PruebaJava2D(this);
		else if (boton.equals(btEventosBG))
			new E01Eventos1y2CambiarBackground(this);
		else if (boton.equals(btEventosBG2))
			new E02Eventos3CambiarBackgroundMejorado(this);
		else if (boton.equals(btEventosVentana))
			new E03EventosDeVentana4(this);
		else if (boton.equals(btEventosEstadoVentana))
			new E04EventosDeEstadoVentana6(this);
		else if (boton.equals(btEventosTeclado))
			new E05EventosDeTeclado7(this);
		else if (boton.equals(btEventosMouse))
			new E06EventosDeRaton8y9(this);
		else if (boton.equals(btEventosFoco))
			new E07EventosDeFoco10(this);
		else if (boton.equals(btEventosFocoVentana)) {
			E08EventosDeFocoVentana11 formulario = new E08EventosDeFocoVentana11();
			formulario.iniciar();
		} else if (boton.equals(btMultiplesFuentes))
			new E09MultiplesFuentes121314y15(this);
		else if (boton.equals(btFlowlayout))
			new Layout1_FlowLayout(this);
		else if (boton.equals(btBorderlayout))
			new Layout2_BorderLayout(this);
		else if (boton.equals(btMultiplesLayouts))
			new Layout3_MultiplesLayout(this);
		else if (boton.equals(btGridlayout_calculadora))
			new Layout4_GridLayout_Calculadora(this);
		else if (boton.equals(btTF))
			new E01CuadrosDeTexto0102(this);
		else if (boton.equals(btEventosTF))
			new E02CuadrosDeTexto03_eventosDeTexto(this);
		else if (boton.equals(btJPasswordField))
			new E03EventosDeTexto04_JPasswordField_GridbagLayout(this);
		else if (boton.equals(btTA))
			new E04AreasDeTexto05(this);
		else if (boton.equals(btCheckRadio))
			new E05JCheckBox01_JRadioButton02(this);
		else if (boton.equals(btJComboBox))
			new E06JComboBox(this);
		else if (boton.equals(btJSlider))
			new E07JSlider(this);
		else if (boton.equals(btJSpinner))
			new E08JSpinner(this);
		else if (boton.equals(btJMenu))
			new E09JMenu(this);
		else if (boton.equals(btProcesadorTexto))
			new E01ProcesadorTexto(this);
		else if (boton.equals(btProcesadorTexto2))
			new E02ProcesadorTexto2(this);	
	}

}
