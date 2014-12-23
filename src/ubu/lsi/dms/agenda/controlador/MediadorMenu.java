package ubu.lsi.dms.agenda.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import ubu.lsi.dms.agenda.gui.JFramePrincipal;
import ubu.lsi.dms.agenda.gui.JMenuAgenda;
import ubu.lsi.dms.agenda.gui.JPanelContacto;
import ubu.lsi.dms.agenda.gui.JPanelLlamada;
import ubu.lsi.dms.agenda.gui.JPanelTipo;
import ubu.lsi.dms.agenda.modelo.ModelTemporal;

/**
 * @author <A HREF="mailto:jld0016@alu.ubu.es">Jorge Laguna</A>
 * @author <A HREF="mailto:rmp0046@alu.ubu.es">Roberto Miranda</A>
 * @author <A HREF="mailto:aam0093@alu.ubu.es">Asier Alonso</A>
 * @author <A HREF="mailto:dlr0008@alu.ubu.es">Daniel Lozano</A>
 * @version 1.0
 * 
 *          Clase que implementa el Patron mediador, se encarga del manejo de
 *          los distintos Jpanel Implementa tambien el Patron Comando, asignado
 *          los distintos listener a los objetos del panel del menu
 * 
 */
public class MediadorMenu {

	private JFramePrincipal frame;
	private JMenuAgenda menu;

	private JPanel panelNuevaLlamada, panelConsultas, panelNuevoContacto,
			panelNuevoTipo, panelModificaLlamada, panelModificaTipo,
			panelModificaContacto, panelAyuda;

	public MediadorMenu(JFramePrincipal frame, ModelTemporal modelo) {

		this.frame = frame;
		// crear todos los paneles y Mediadores
		menu = frame.getMenuAgenda();
		panelConsultas = new MediadorConsultas(frame, modelo)
				.getPanelAsociado();
		frame.setPanel(panelConsultas);
		panelNuevaLlamada = new MediadorNuevaLLamada(frame, modelo)
				.getPanelAsociado();
		panelNuevaLlamada.setVisible(false);
		panelNuevoContacto = new MediadorNuevoContacto(frame, modelo)
				.getPanelAsociado();
		panelNuevoContacto.setVisible(false);
		panelNuevoTipo = new MediadorNuevoTipo(frame, modelo)
				.getPanelAsociado();
		panelNuevoTipo.setVisible(false);

		panelModificaLlamada = new MediadorModificaLlamada(frame, modelo)
				.getPanelAsociado();
		panelModificaLlamada.setVisible(false);

		panelModificaTipo = new MediadorModificaTipo(frame, modelo)
				.getPanelAsociado();
		panelModificaTipo.setVisible(false);

		panelModificaContacto = new MediadorModificaContacto(frame, modelo)
				.getPanelAsociado();
		panelModificaContacto.setVisible(false);

		panelAyuda = new MediadorAyuda(frame, modelo).getPanelAsociado();
		panelAyuda.setVisible(false);

		menu.setListenerNuevoContacto(menuNuevoContacto());
		menu.setListenerNuevaLLamada(menuNuevaLlamada());
		menu.setListenerNuevoTipo(menuNuevoTipo());
		menu.setListenerModificaContacto(menuModificaContacto());
		menu.setListenerModificaLlamada(menuModificaLlamada());
		menu.setListenerModificaTipo(menuModificaTipo());
		menu.setListenerNuevaConsulta(menuConsulta());
		menu.setListenerModificaContacto(menuModificaContacto());
		menu.setListenerAyuda(menuAyuda());
	}

	public ActionListener menuNuevoContacto() {

		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(panelNuevoContacto);
			}
		};

	}

	public ActionListener menuNuevaLlamada() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				((JPanelLlamada) panelNuevaLlamada).recargarTabla(frame
						.tablaContactos());
				cambiarPanel(panelNuevaLlamada);
			}
		};

	}

	public ActionListener menuNuevoTipo() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(panelNuevoTipo);
			}
		};
	}

	public ActionListener menuModificaContacto() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				((JPanelContacto) panelModificaContacto).recargarTabla(frame
						.tablaContactos());
				cambiarPanel(panelModificaContacto);
			}
		};
	}

	public ActionListener menuModificaLlamada() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				((JPanelLlamada) panelModificaLlamada).recargarTabla(frame
						.tablaLLamadas());
				cambiarPanel(panelModificaLlamada);
			}
		};
	}

	public ActionListener menuModificaTipo() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				((JPanelTipo) panelModificaTipo).recargarTabla(frame
						.tablaTipos());
				cambiarPanel(panelModificaTipo);
			}
		};
	}

	public ActionListener menuConsulta() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(panelConsultas);

			}
		};

	}

	public ActionListener menuAyuda() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(panelAyuda);
			}
		};

	}

	/**
	 * Permite cambiar entre los distitos paneles
	 * 
	 * @param panel
	 */
	private void cambiarPanel(JPanel panel) {
		JPanel viejoPanel = frame.getPanel();
		panel.setBounds(viejoPanel.getX(), viejoPanel.getY(),
				viejoPanel.getWidth(), viejoPanel.getHeight());
		viejoPanel.setVisible(false);
		panel.setVisible(true);
		panel.repaint();
		frame.setPanel(panel);
		frame.validate();
		frame.repaint();
	}
}
