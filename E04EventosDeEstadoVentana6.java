package eventos;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class E04EventosDeEstadoVentana6 extends JFrame implements WindowStateListener {

	public E04EventosDeEstadoVentana6(JFrame f_ppal) {
		setTitle("Eventos IV - eventos de ventana. Cambios de estado");
		setBackground(SystemColor.window);
		setSize(400, 400);
		setLocationRelativeTo(f_ppal);

		// mandamos a la clase misma como oyente
		addWindowStateListener(this);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	/*
	 * En este caso se implementó la interfaz ya que contiene un solo método. De
	 * todas formas podría haberse usado la clase adaptadora WindowAdapter Ya que la
	 * misma implementa también WindowStateListener
	 */

	public void windowStateChanged(WindowEvent e) {
		System.out.print(e.getNewState() + ") La ventana ha cambiado de estado: ");

		if (e.getNewState() == JFrame.MAXIMIZED_BOTH)
			System.out.println("HA SIDO MAXIMIZADA");
		else if (e.getNewState() == JFrame.NORMAL)
			System.out.println("HA VUELTO AL ESTADO NORMAL");
		else if (e.getNewState() == JFrame.ICONIFIED)
			System.out.println("HA SIDO MINIMIZADA");

	}

}