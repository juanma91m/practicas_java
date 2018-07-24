package eventos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class E09MultiplesFuentes121314y15 extends JDialog {

	JButton botonAmarillo, botonAzul, botonRojo;
	JPanel panel;

	public E09MultiplesFuentes121314y15(JFrame f_ppal) {
		super(f_ppal, ModalityType.APPLICATION_MODAL);
		setTitle("Eventos XII y XIII - eventos multiples fuentes");
		setBackground(SystemColor.window);
		setSize(400, 400);
		setLocationRelativeTo(f_ppal);

		panel = new JPanel();
		cargarComponentes();
		add(panel);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void cargarComponentes() {
		/*
		 * Comentamos la forma habitual de hacer botones botonAmarillo = new
		 * JButton("Amarillo"); botonAzul = new JButton("Azul"); botonRojo = new
		 * JButton("Rojo");
		 * 
		 * add(botonAmarillo); add(botonAzul); add(botonRojo);
		 */

		/*
		 * Ajustamos el tamaño del icono al tamaño de boton que queremos en caso de no
		 * querer hacerlo todo en una linea sola se podria hacer así:
		 * 
		 * ImageIcon icono = new ImageIcon("src/graficos/amarillo.png"); ImageIcon
		 * iconoEscalado = new ImageIcon(icono.getImage().getScaledInstance(32, -1,
		 * Image.SCALE_DEFAULT));
		 * 
		 * si alto lo ponemos en -1 quiere decir que mantengamos la proporcion. o lo
		 * mismo con el ancho
		 */
		int ancho = 24;
		int alto = -1;
		ImageIcon iconoAmarillo = new ImageIcon(new ImageIcon("src/graficos/amarillo.png").getImage()
				.getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		ImageIcon iconoAzul = new ImageIcon(
				new ImageIcon("src/graficos/azul.png").getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		ImageIcon iconoRojo = new ImageIcon(
				new ImageIcon("src/graficos/rojo.png").getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));

		// Instanciamos un objeto de la clase oyente para cada botón
		AccionColor accionAmarillo = new AccionColor("Amarillo", iconoAmarillo, Color.YELLOW);
		AccionColor accionAzul = new AccionColor("Azul", iconoAzul, Color.BLUE);
		AccionColor accionRojo = new AccionColor("Rojo", iconoRojo, Color.RED);

		panel.add(botonAmarillo = new JButton(accionAmarillo));
		panel.add(botonAzul = new JButton(accionAzul));
		panel.add(botonRojo = new JButton(accionRojo));

		// 1-crear mapa de entrada
		InputMap mapaEntrada = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);

		// 2-crear combinacion de teclas
		KeyStroke teclaAmarillo = KeyStroke.getKeyStroke("ctrl Y");
		KeyStroke teclaAzul = KeyStroke.getKeyStroke("ctrl B");
		KeyStroke teclaRojo = KeyStroke.getKeyStroke("ctrl R");

		// 3-asignar combinacion de tecla a objeto
		mapaEntrada.put(teclaAmarillo, "fondoAmarillo");
		mapaEntrada.put(teclaAzul, "fondoAzul");
		mapaEntrada.put(teclaRojo, "fondoRojo");

		// 4-asignar objeto a accion
		ActionMap mapaAccion = panel.getActionMap();
		mapaAccion.put("fondoAmarillo", accionAmarillo);
		mapaAccion.put("fondoAzul", accionAzul);
		mapaAccion.put("fondoRojo", accionRojo);

		/*
		 * //establecer tamaño de botones botonAmarillo.setBounds(43, 5, 119,34);
		 * botonAzul.setBounds(167, 5, 92,34); botonRojo.setBounds(264, 5, 93,34);
		 */
	}

	class AccionColor extends AbstractAction {

		public AccionColor(String nombre, Icon icono, Color colorBoton) {
			// la informacion del objeto se guarda en formato clave:valor mediante
			// metodo putValue(clave,valor). las clave son constantes de clase, ver api
			putValue(Action.NAME, nombre);
			putValue(Action.LARGE_ICON_KEY, icono);
			putValue(Action.SHORT_DESCRIPTION, "Poner la lámina de color " + nombre.toLowerCase());
			putValue("ColorFondo", colorBoton);
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			Color c = (Color) getValue("ColorFondo");
			panel.setBackground(c);
			System.out.println("Nombre: " + getValue(Action.NAME));
			
			// obtener dimensiones y posicion del boton,
			// se encierra en un try catch dado que si el evento se genera por la combinación de
			// teclas el casting da un error porque el objeto fuente no es el botón
			try {
				JButton a = (JButton) e.getSource();
				System.out.println(a.getX() + " " + a.getY() + " " + a.getWidth() + " " + a.getHeight());
			} catch (Exception ex) {

			}
		}
	}
}