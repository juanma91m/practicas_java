package admin;

public class Administrador {

	public static void main(String[] args) {
		new FormularioPrincipal();
	}

	public static boolean esEntero(String texto) {
		try {
			Integer.parseInt(texto);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/*public static JFrame posicionarJFrame(JFrame form, int hoffset, int voffset) {
	Toolkit pantalla = Toolkit.getDefaultToolkit();
	int altoPantalla = pantalla.getScreenSize().height;
	int anchoPantalla = pantalla.getScreenSize().width;
	int altoVentana = form.getSize().height;
	int anchoVentana = form.getSize().width;
	form.setLocation((anchoPantalla - anchoVentana) / 2 + hoffset, (altoPantalla - altoVentana) / 2 + voffset);

	return form;
}

public static JDialog posicionarJDialog(JDialog form, int hoffset, int voffset) {
	Toolkit pantalla = Toolkit.getDefaultToolkit();
	int altoPantalla = pantalla.getScreenSize().height;
	int anchoPantalla = pantalla.getScreenSize().width;
	int altoVentana = form.getSize().height;
	int anchoVentana = form.getSize().width;
	form.setLocation((anchoPantalla - anchoVentana) / 2 + hoffset, (altoPantalla - altoVentana) / 2 + voffset);

	return form;
}*/
}
