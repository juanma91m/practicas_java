package swing_componentes;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

@SuppressWarnings("serial")
public class E07JSlider extends JDialog implements ChangeListener {

	JPanel panel;
	JSlider slider1, slider2;
	JLabel lbTamano1, lbTamano2;

	public E07JSlider(JFrame f_ppal) {
		super(f_ppal, ModalityType.APPLICATION_MODAL);
		setTitle("Video 96 y 97 - JSlider");
		setBackground(SystemColor.window);

		panel = new JPanel();
		cargarComponentes();
		add(panel);
		setSize(500, 500);
		setLocationRelativeTo(f_ppal);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void cargarComponentes() {
		panel.setLayout(new BorderLayout());
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		panel.add(panel2, BorderLayout.CENTER);
		panel.add(panel3, BorderLayout.SOUTH);

		slider1 = new JSlider(0, 50, 25);
		slider1.setPreferredSize(new Dimension(400, 100));
		slider1.setPaintTicks(true);
		slider1.setPaintLabels(true);
		slider1.setMajorTickSpacing(10);
		slider1.setMinorTickSpacing(1);
		slider1.setSnapToTicks(true);
		panel2.add(slider1);

		lbTamano1 = new JLabel("Acá va un texto");
		panel2.add(lbTamano1);

		slider2 = new JSlider(JSlider.VERTICAL, 0, 20, 10);
		slider2.setPreferredSize(new Dimension(100, 200));
		slider2.setPaintTicks(true);
		slider2.setPaintLabels(true);
		slider2.setMajorTickSpacing(5);
		slider2.setMinorTickSpacing(1);
		panel3.add(slider2);

		lbTamano2 = new JLabel("Acá va otro texto");
		panel3.add(lbTamano2);

		slider1.addChangeListener(this);
		slider2.addChangeListener(this);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider slider = (JSlider) e.getSource();
		if (slider.equals(slider1)) {
			String fuente = lbTamano1.getFont().getFamily();
			Font f = new Font(fuente, Font.PLAIN, slider.getValue());
			lbTamano1.setFont(f);
		} else if (slider.equals(slider2)) {
			String fuente = lbTamano2.getFont().getFamily();
			Font f = new Font(fuente, Font.PLAIN, slider.getValue());
			lbTamano2.setFont(f);
		}
	}
}
