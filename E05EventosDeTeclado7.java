package eventos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class E05EventosDeTeclado7 extends JDialog implements KeyListener {

	public E05EventosDeTeclado7(JFrame f_ppal) {
		super(f_ppal, ModalityType.APPLICATION_MODAL);
		setTitle("Eventos IV - eventos de teclado");
		setBackground(SystemColor.window);
		setSize(400, 400);
		setLocationRelativeTo(f_ppal);

		addKeyListener(this);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void keyPressed(KeyEvent e) {
		// tecla pulsada
	}

	public void keyReleased(KeyEvent e) {
		// tecla soltada
	}

	public void keyTyped(KeyEvent e) {
		// tecla pulsada y soltada
		System.out.println("\nCódigo de caracter: " + e.getKeyCode());
		System.out.println("Caracter pulsado: " + e.getKeyChar());
	}
}