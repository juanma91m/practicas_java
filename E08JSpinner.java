package swing_componentes;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class E08JSpinner extends JDialog {

	JPanel panel;
	JSpinner spinner1, spinner2, spinner3, spinner4, spinner5, spinner6, spinner7;

	public E08JSpinner(JFrame f_ppal) {
		super(f_ppal, ModalityType.APPLICATION_MODAL);
		setTitle("Video 98 y 99 - JSpinner");
		setBackground(SystemColor.window);

		panel = new JPanel();
		cargarComponentes();
		add(panel);

		setSize(300, 150);

		setLocationRelativeTo(f_ppal);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void cargarComponentes() {
		// para fechas
		spinner1 = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor de = new JSpinner.DateEditor(spinner1, "dd/MM/yyyy");
		spinner1.setEditor(de);
		panel.add(spinner1);

		spinner2 = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor de2 = new JSpinner.DateEditor(spinner2, "hh:mm:ss");
		spinner2.setEditor(de2);
		panel.add(spinner2);

		String[] meses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
				"Octubre", "Noviembre", "Diciembre" };
		spinner3 = new JSpinner(new SpinnerListModel(meses));
		spinner3.setPreferredSize(new Dimension(100, 20));
		panel.add(spinner3);

		String[] fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		spinner4 = new JSpinner(new SpinnerListModel(fuentes));
		spinner4.setPreferredSize(new Dimension(200, 20));
		panel.add(spinner4);
		// recuperar valor del spinner
		System.out.println(spinner4.getValue());

		// SpinnerNumberModel(vInicial,vMin,vMax,paso)
		spinner5 = new JSpinner(new SpinnerNumberModel(0, 0, 3, 1));
		spinner5.setPreferredSize(new Dimension(30, 20));
		panel.add(spinner5);
		System.out.println(spinner5.getValue());

		// invertir comportamiento de botones
		spinner6 = new JSpinner(new SpinnerNumberModel(3, 0, 3, -1));
		spinner6.setPreferredSize(new Dimension(30, 20));
		panel.add(spinner6);

		// clase interna anónima
		spinner7 = new JSpinner(new SpinnerNumberModel(3, 0, 3, 1)) {
			@Override
			public Object getNextValue() {
				return super.getPreviousValue();
			}

			@Override
			public Object getPreviousValue() {
				return super.getNextValue();
			}
		};
		spinner7.setPreferredSize(new Dimension(30, 20));
		panel.add(spinner7);
	}
}
