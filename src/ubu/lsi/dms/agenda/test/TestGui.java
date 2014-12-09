package ubu.lsi.dms.agenda.test;


import javax.swing.SwingUtilities;

import ubu.lsi.dms.agenda.controlador.ControladorMenu;
import ubu.lsi.dms.agenda.gui.JFramePrincipal;
import ubu.lsi.dms.agenda.modelo.ModelTemporal;

public class TestGui {
	private static JFramePrincipal frame = null;
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		ModelTemporal modelo = new ModelTemporal();
		modelo.iniContactos();
		modelo.iniLlamadas();
		modelo.iniTipos();

		frame = new JFramePrincipal();
		new ControladorMenu(frame, modelo);
		startApplication();

	}

	public static void startApplication() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				frame.setVisible(true);
			}
		});
	}
}
