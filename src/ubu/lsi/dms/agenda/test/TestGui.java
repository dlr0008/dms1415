package ubu.lsi.dms.agenda.test;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.SwingUtilities;

import ubu.lsi.dms.agenda.controlador.ControladorConsultas;
import ubu.lsi.dms.agenda.controlador.ControladorMenu;
import ubu.lsi.dms.agenda.gui.JFramePrincipal;
import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.modelo.ModelTemporal;
import ubu.lsi.dms.agenda.modelo.TipoContacto;

public class TestGui {
	private static Collection<Contacto> contactos = new ArrayList<Contacto>();

	private static Collection<Llamada> llamadas = new ArrayList<Llamada>();
	public static Collection<TipoContacto> tipos = new ArrayList<TipoContacto>();
	private static JFramePrincipal frame = null;

	public static void main(String[] args) {
		ModelTemporal modelo = new ModelTemporal();
		modelo.iniContactos();
		modelo.iniLlamadas();
		modelo.iniTipos();
		TestGui testGui = new TestGui();

		frame = new JFramePrincipal(testGui);
		new ControladorConsultas(frame, modelo);
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
