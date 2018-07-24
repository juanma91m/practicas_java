package layouts;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Layout4_GridLayout_Calculadora extends JDialog {

	public Layout4_GridLayout_Calculadora(JFrame f_ppal) {
		super(f_ppal, ModalityType.APPLICATION_MODAL);
		setTitle("Layout - GridLayout Calculadora");
		setBackground(SystemColor.window);
		setSize(300, 300);
		setLocationRelativeTo(f_ppal);

		Calculadora miLamina = new Calculadora(new BorderLayout());
		add(miLamina);
		// pack(); //da tamaño por defecto segun lo que contiene al contenedor

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	class Calculadora extends JPanel {

		private JPanel botonera;
		private JButton pantalla;
		private float operando1, operando2, resultado;
		private char operador;
		private boolean inicio;

		public Calculadora(BorderLayout disposicion) {
			setLayout(disposicion);
			inicio = true;
			operando1 = 0;
			operando2 = 0;
			resultado = 0;
			pantalla = new JButton("0");
			pantalla.setEnabled(false);
			add(pantalla, BorderLayout.NORTH);

			// creamos la lamina botonera (podríamos crear otra clase pero así se ve una
			// forma
			// distinta}

			botonera = new JPanel();
			botonera.setLayout(new GridLayout(4, 5, 5, 5));

			InsertaNumero insertar = new InsertaNumero();
			Operador operar = new Operador();

			crearBoton("7", insertar);
			crearBoton("8", insertar);
			crearBoton("9", insertar);
			crearBoton("÷", operar);

			crearBoton("4", insertar);
			crearBoton("5", insertar);
			crearBoton("6", insertar);
			crearBoton("x", operar);

			crearBoton("1", insertar);
			crearBoton("2", insertar);
			crearBoton("3", insertar);
			crearBoton("-", operar);

			crearBoton("0", insertar);
			crearBoton(",", insertar);
			crearBoton("=", operar);
			crearBoton("+", operar);

			add(botonera, BorderLayout.CENTER);
		}

		private void crearBoton(String nombre, ActionListener oyente) {
			JButton boton = new JButton(nombre);
			boton.addActionListener(oyente);
			botonera.add(boton);
		}

		private class InsertaNumero implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				String entrada = e.getActionCommand();
				if (inicio) {
					if (entrada.equals(",")) {
						pantalla.setText("0.");
					} else
						pantalla.setText(entrada);
				} else {
					if (entrada.equals(",")) {
						if (!pantalla.getText().contains(".")) {
							pantalla.setText(pantalla.getText() + ".");
						} else
							System.out.println("Un número solo puede tener 1 coma decimal.");
					} else
						pantalla.setText(pantalla.getText() + entrada);
				}
				inicio = false;
			}
		}

		private class Operador implements ActionListener {

			public float calcular(float op1, float op2, char operador) {

				if (operador == '+')
					return op1 + op2;

				if (operador == '-')
					return op1 - op2;

				if (operador == 'x')
					return op1 * op2;

				if (operador == '÷')
					return op1 / op2;

				return op1;
			}

			@Override
			public void actionPerformed(ActionEvent e) {

				if (resultado == 0)
					resultado = Float.parseFloat(pantalla.getText());
				else {
					operando1 = resultado;
					operando2 = Float.parseFloat(pantalla.getText());
					resultado = calcular(operando1, operando2, operador);

				}

				if (Float.toString(resultado).contains(".0"))
					pantalla.setText(Float.toString(resultado).substring(0, Float.toString(resultado).length() - 2));
				else
					pantalla.setText(Float.toString(resultado));

				System.out.println(resultado);

				if (e.getActionCommand().charAt(0) == '=') {
					if (Float.toString(resultado).contains(".0"))
						pantalla.setText(
								Float.toString(resultado).substring(0, Float.toString(resultado).length() - 2));
					else
						pantalla.setText(Float.toString(resultado));
				}
				operador = e.getActionCommand().charAt(0);
				inicio = true;
			}
		}
	}
}