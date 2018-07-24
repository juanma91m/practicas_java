package graficos;

import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

@SuppressWarnings("serial")
public class PruebaImageIO extends JDialog {

	public PruebaImageIO(JFrame f_ppal) {
		super(f_ppal, ModalityType.APPLICATION_MODAL);

		setTitle("Uso librería de dibujo Java2D");

		setSize(400, 400);
		setLocationRelativeTo(f_ppal);

		Lamina miLamina = new Lamina();
		add(miLamina);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	class Lamina extends JPanel {

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g); // lo que tenía + lo que sigue a continuación
			setBackground(Color.YELLOW);// para poner el color por defecto del sistema
										// SystemColor.window

			Image imagen = null;
			try {
				imagen = ImageIO.read(new File("src/graficos/icono.png"));

			} catch (IOException e) {
				System.out.println(e);
			}

			g.drawImage(imagen, 0, 0, 20, 20, null); // dibujar imagen en la lamina
			for (int posX = 0; posX < 400 / 20; posX++) {
				for (int posY = 0; posY < 360 / 20; posY++) {
					if (posX + posY > 0) {
						g.copyArea(0, 0, 20, 20, posX * 20, posY * 20); // copiar area de la lamina
					}
				}
			}
		}
	}
}