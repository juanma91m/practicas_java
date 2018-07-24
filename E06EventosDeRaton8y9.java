package eventos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class E06EventosDeRaton8y9 extends JDialog implements MouseListener, MouseWheelListener, MouseMotionListener {

	public E06EventosDeRaton8y9(JFrame f_ppal) {
		super(f_ppal, ModalityType.APPLICATION_MODAL);
		setTitle("Eventos IV - eventos de Mouse");
		setBackground(SystemColor.window);
		setSize(400, 400);
		setLocationRelativeTo(f_ppal);

		addMouseListener(this); // evento de click
		addMouseWheelListener(this); // evento de rueda
		addMouseMotionListener(this); // movimiento de raton

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	// MouseListener
	@Override
	public void mouseClicked(MouseEvent e) {
		// posicion dentro de la pantalla
		// String posicion =
		// e.getLocationOnScreen().toString().substring(15,e.getLocationOnScreen().toString().length()
		// - 1);

		// posicion dentro del formulario
		String posicion = "x=" + e.getX() + ",y=" + e.getY();

		if (e.getButton() == 1)
			System.out.println(
					"Has hecho " + e.getClickCount() + " clicks izquierdos seguidos en la posición " + posicion);
		else if (e.getButton() == 2)
			System.out.println(
					"Has hecho " + e.getClickCount() + " clicks centrales seguidos en la posición " + posicion);
		else if (e.getButton() == 3)
			System.out
					.println("Has hecho " + e.getClickCount() + " clicks derechos seguidos en la posición " + posicion);
	}

	// MouseListener
	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("Entraste al formulario");
	}

	// MouseListener
	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("Saliste del formulario");
	}

	// MouseListener
	@Override
	public void mousePressed(MouseEvent e) {
	}

	// MouseListener
	@Override
	public void mouseReleased(MouseEvent e) {
	}

	// MouseWheelListener
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// posicion dentro de la pantalla
		// String posicion =
		// e.getLocationOnScreen().toString().substring(15,e.getLocationOnScreen().toString().length()
		// - 1);
		String posicion = "x=" + e.getX() + ",y=" + e.getY();

		if (e.getWheelRotation() == -1)
			System.out.println("Has movido la rueda del mouse hacia arriba en la posición " + posicion);
		else if (e.getWheelRotation() == 1)
			System.out.println("Has movido la rueda del mouse hacia abajo en la posición " + posicion);
	}

	// MouseMotionListener
	@Override
	public void mouseDragged(MouseEvent e) {
		String posicion = "x=" + e.getX() + ",y=" + e.getY();
		System.out.println("Estas arrastrando el raton por la posición " + posicion);

	}

	// MouseMotionListener
	@Override
	public void mouseMoved(MouseEvent e) {
	}

	/*
	 * Este método devuelve en cada movimiento de mouse la posicion exacta del
	 * cursor. Comentado por las multiples salidas que genera public void
	 * mouseMoved(MouseEvent e) { String posicion = "x="+e.getX()+",y="+e.getY();
	 * System.out.println("el puntero está en "+posicion); }
	 */
}