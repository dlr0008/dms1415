package ubu.lsi.dms.agenda.test;

import javax.swing.SwingUtilities;

import ubu.lsi.dms.agenda.controlador.MediadorMenu;
import ubu.lsi.dms.agenda.gui.JFramePrincipal;
import ubu.lsi.dms.agenda.modelo.ModelTemporal;

/**
 * @author <A HREF="mailto:jld0016@alu.ubu.es">Jorge Laguna</A>
 * @author <A HREF="mailto:rmp0046@alu.ubu.es">Roberto Miranda</A>
 * @author <A HREF="mailto:aam0093@alu.ubu.es">Asier Alonso</A>
 * @author <A HREF="mailto:dlr0008@alu.ubu.es">Daniel Lozano</A>
 * @version 1.0
 * 
 *          Clase que lanza la aplicacion
 */
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
