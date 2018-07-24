package eventos;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class E03EventosDeVentana4 extends JFrame implements WindowListener {

	public E03EventosDeVentana4(JFrame f_ppal) {
		//se usó un JFrame porque el JDialog no tiene botón de maximizar y minimizar
		setTitle("Eventos IV - eventos de ventana.");
		setBackground(SystemColor.window);
		setSize(400, 400);
		setLocationRelativeTo(f_ppal);

		addWindowListener(this);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void windowOpened(WindowEvent e) {
		System.out.println("Ventana abierta - método windowOpened");
	}

	public void windowClosing(WindowEvent e) {
		System.out.println("Cerrando ventana - método windowClosing");
	}

	public void windowClosed(WindowEvent e) {
		System.out.println("Ventana cerrada - método windowClosed");
	}

	// Cuando pasamos la ventana de normal a minimizada
	public void windowIconified(WindowEvent e) {
		System.out.println("Ventana minimizada  - método windowsIconified");
	}

	// Cuando pasamos la ventana de minimizada a normal
	public void windowDeiconified(WindowEvent e) {
		System.out.println("Ventana desminimizada - método windowsDeIconified");
	}

	public void windowActivated(WindowEvent e) {
		System.out.println("Ventana activada - método windowActivated");
	}

	public void windowDeactivated(WindowEvent e) {
		System.out.println("Ventana desactivada - método windowDeactivated");
	}

}