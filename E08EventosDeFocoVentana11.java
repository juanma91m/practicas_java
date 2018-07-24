package eventos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class E08EventosDeFocoVentana11 extends JFrame implements WindowFocusListener{

	E08EventosDeFocoVentana11 form1;
	E08EventosDeFocoVentana11 form2;
	
	public void iniciar() {

		form1 = new E08EventosDeFocoVentana11();
		form1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		form1.setBackground(SystemColor.window);
		form1.setBounds(0,100, 500,200);
		form1.setVisible(true);
		form1.addWindowFocusListener(this);
		
		form2 = new E08EventosDeFocoVentana11();
		form2.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		form2.setBackground(SystemColor.window);
		form2.setBounds(800,100, 200,200);
		form2.setVisible(true);
		form2.addWindowFocusListener(this);
	}
	
	@Override
	public void windowGainedFocus(WindowEvent e) {
		if ( e.getSource() == form1 )
			form1.setTitle("Eventos XI - eventos de FocoVentana. Tengo el foco!!");
		else
			form2.setTitle("Eventos XI - eventos de FocoVentana. Tengo el foco!!");
	}

	@Override
	public void windowLostFocus(WindowEvent e) {
		if ( e.getSource() == form1 )
			form1.setTitle("");
		else
			form2.setTitle("");
	}

}