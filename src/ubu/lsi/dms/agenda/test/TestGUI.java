package ubu.lsi.dms.agenda.test;

import javax.swing.SwingUtilities;

import ubu.lsi.dms.agenda.controlador.MediadorMenu;
import ubu.lsi.dms.agenda.gui.JFramePrincipal;
import ubu.lsi.dms.agenda.modelo.ModelTemporal;

public class TestGUI {
	private static JFramePrincipal frame = null;

	public static void main(String[] args) {

		frame = new JFramePrincipal();
		ModelTemporal modelo = new ModelTemporal();
		frame.setTablaContactos(modelo.getContactos().obtenerTodosContactos());
		frame.setTablaLLamadas(modelo.getLlamadas().obtenerTodasLLamadas());
		frame.setTablaTipos(modelo.getTipos().obtenerTodosTipos());
		new MediadorMenu(frame, modelo);

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
