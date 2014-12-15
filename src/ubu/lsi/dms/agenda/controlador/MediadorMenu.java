package ubu.lsi.dms.agenda.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import ubu.lsi.dms.agenda.gui.JFramePrincipal;
import ubu.lsi.dms.agenda.gui.JMenuAgenda;
import ubu.lsi.dms.agenda.gui.JPanelLlamada;
import ubu.lsi.dms.agenda.modelo.ModelTemporal;

/**
 * Patron Medidador
 * 
 * 
 * @author Roberto
 *
 */
public class MediadorMenu {

	private JFramePrincipal frame;
	private JMenuAgenda menu;

	private JPanel panelNuevaLlamada, panelConsultas, panelNuevoContacto, panelNuevoTipo, panelModificaLlamada, panelModificaTipo, panelAyuda;

	public MediadorMenu(JFramePrincipal frame,
			ModelTemporal modelo) {

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
		panelNuevoTipo = new MediadorNuevoTipo(frame, modelo).getPanelAsociado();
		panelNuevoTipo.setVisible(false);
		
		panelModificaLlamada = new MediadorModificaLlamada(frame, modelo).getPanelAsociado();
		panelModificaLlamada.setVisible(false);
		
		panelModificaTipo = new MediadorModificaTipo(frame, modelo).getPanelAsociado();
		panelModificaTipo.setVisible(false);
		
		panelAyuda = new MediadorAyuda(frame, modelo).getPanelAsociado();
		panelAyuda.setVisible(false);
		
		menu.setListenerNuevoContacto(menuNuevoContacto());
		menu.setListenerNuevaLLamada(menuNuevaLlamada());
		menu.setListenerNuevoTipo(menuNuevoTipo());
		menu.setListenerModificaContacto(menuModificaContacto());
		menu.setListenerModificaLlamada(menuModificaLlamada());
		menu.setListenerModificaTipo(menuModificaTipo());
		menu.setListenerNuevaConsulta(menuConsulta());
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
				((JPanelLlamada) panelNuevaLlamada)
						.recargarTabla(frame.tablaContactos());
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
			}
		};
	}

	public ActionListener menuModificaLlamada() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelModificaLlamada.recargarTabla(frame.tablaLLamadas());
				cambiarPanel(panelModificaLlamada);
			}
		};
	}

	public ActionListener menuModificaTipo() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelModificaTipo.recargarTabla(frame.tablaTipos());
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
