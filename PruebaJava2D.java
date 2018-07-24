package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

@SuppressWarnings("serial")
public class PruebaJava2D extends JDialog {

	public PruebaJava2D(JFrame f_ppal) {
		super(f_ppal, ModalityType.APPLICATION_MODAL);
		setTitle("Uso librería de dibujo Java2D");

		setSize(400, 400);

		setLocationRelativeTo(f_ppal);

		Lamina miLamina = new Lamina();
		miLamina.setBackground(SystemColor.window);// para poner el color por defecto del sistema // SystemColor.window
		add(miLamina);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	class Lamina extends JPanel {

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g); // lo que tenía + lo que sigue a continuación

			// crear objeto de tipo graphics2d casteando al parámetro
			Graphics2D g2D = (Graphics2D) g;

			// creamos rectangulo 2d
			Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150);
			g2D.setPaint(new Color(255, 0, 0));
			g2D.fill(rectangulo); // dibuja relleno
			g2D.setPaint(Color.BLACK);
			g2D.setStroke(new BasicStroke(5));// ancho del contorno o borde

			g2D.draw(rectangulo); // dibuja borde

			Ellipse2D elipse = new Ellipse2D.Double();
			elipse.setFrame(rectangulo);
			// Color(ROJO,VERDE,AZUL,TRANSPARENCIA) 0-255 SISTEMA RGB
			g2D.setPaint(new Color(87, 189, 148));
			g2D.fill(elipse);
			g2D.setPaint(Color.BLACK);
			g2D.setStroke(new BasicStroke(2));
			g2D.draw(elipse);

			/*
			 * Para dibujar formas sin relleno
			 * 
			 * //creamos elipse a partir del rectangulo Ellipse2D elipse = new
			 * Ellipse2D.Double(); elipse.setFrame(rectangulo); g2D.draw(rectangulo);
			 * g2D.draw(elipse);
			 * 
			 * //creamos lineas g2D.draw(new Line2D.Double(100, 100, 300, 250));
			 * g2D.draw(new Line2D.Double(300, 100, 100, 250));
			 * 
			 * //dibujar circulo centrado double centroX = rectangulo.getCenterX(); double
			 * centroY = rectangulo.getCenterY(); double radio = 125; Ellipse2D circulo =
			 * new Ellipse2D.Double(); circulo.setFrameFromCenter(centroX, centroY, centroX
			 * + radio, centroY + radio); g2D.draw(circulo);
			 *
			 */
		}
	}
}
