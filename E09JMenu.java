package swing_componentes;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class E09JMenu extends JDialog {

	JPanel panel;
	
	JMenuBar menuBar;
	JMenu mArchivo,mEdicion,mAyuda,mOpciones;
	JMenuItem archivoGuardar,archivoGuardarComo,edicionCortar,edicionCopiar,edicionPegar,ayudaAsistencia,ayudaAcerca;
	JMenuItem opcion1,opcion2;
	public E09JMenu(JFrame f_ppal) {
		super(f_ppal, ModalityType.APPLICATION_MODAL);
		setTitle("Video 100	- JMenu.");
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
		menuBar = new JMenuBar();

		mArchivo = new JMenu("Archivo");
		archivoGuardar = new JMenuItem("Guardar");
		archivoGuardarComo = new JMenuItem("Guardar como...");
		mArchivo.add(archivoGuardar);
		mArchivo.add(archivoGuardarComo);
		menuBar.add(mArchivo);
		
		mEdicion = new JMenu("Edición");
		edicionCopiar = new JMenuItem("Copiar");
		edicionCortar = new JMenuItem("Cortar");
		edicionPegar = new JMenuItem("Pegar");
		mEdicion.add(edicionCopiar);
		mEdicion.add(edicionCortar);
		mEdicion.add(edicionPegar);
		//Agrega separador
		mEdicion.addSeparator();  
		//Es un submenu de Edicion pero al tener elementos dentro no puede ser JMenuItem, debe ser JMenu
		mOpciones = new JMenu("Opciones");
		opcion1 = new JMenuItem("Opcion 1");
		opcion2 = new JMenuItem("Opcion 2");
		mOpciones.add(opcion1);
		mOpciones.add(opcion2);
		mEdicion.add(mOpciones);
		menuBar.add(mEdicion);
		
		mAyuda = new JMenu("Ayuda");
		ayudaAsistencia = new JMenuItem("Asistencia");
		ayudaAcerca = new JMenuItem("Acerca de la app");
		mAyuda.add(ayudaAsistencia);
		mAyuda.add(ayudaAcerca);
		menuBar.add(mAyuda);
		
		menuBar.setAlignmentX(LEFT_ALIGNMENT);
		panel.add(menuBar);
	}
}
