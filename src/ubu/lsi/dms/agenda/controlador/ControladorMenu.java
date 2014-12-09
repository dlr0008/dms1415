package ubu.lsi.dms.agenda.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import ubu.lsi.dms.agenda.gui.JFramePrincipal;
import ubu.lsi.dms.agenda.gui.JMenuAgenda;
import ubu.lsi.dms.agenda.gui.JPanelConsulta;
import ubu.lsi.dms.agenda.gui.JPanelContacto;
import ubu.lsi.dms.agenda.gui.JPanelLlamada;
import ubu.lsi.dms.agenda.gui.JPanelTipo;
import ubu.lsi.dms.agenda.modelo.ModelTemporal;

/**
 * Patron Medidador
 * 
 * 
 * @author Roberto
 *
 */
public class ControladorMenu {

	private JFramePrincipal frame;
	private JMenuAgenda menu;
	private ModelTemporal modelo;

	public ControladorMenu(JFramePrincipal frame, ModelTemporal modelo) {

		this.frame = frame;
		this.modelo = modelo;

		menu = frame.getMenu();
		frame.setPanel(new JPanelConsulta());
		new ControladorConsultas(frame, modelo);
		menu.setListenerNuevoContacto(menuNuevoContacto());
		menu.setListenerNuevaLLamada(menuNuevaLlamada());
		menu.setListenerNuevoTipo(menuNuevoTipo());
		menu.setListenerNuevaConsulta(menuConsulta());
	}

	public ActionListener menuNuevoContacto() {

		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(new JPanelContacto());
				new ControladorNuevoContacto(frame, modelo);

			}
		};

	}

	public ActionListener menuNuevaLlamada() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(new JPanelLlamada());

			}
		};

	}

	public ActionListener menuNuevoTipo() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(new JPanelTipo());

			}
		};

	}

	public ActionListener menuConsulta() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(new JPanelConsulta());
				new ControladorConsultas(frame, modelo);

			}
		};

	}

	private void cambiarPanel(JPanel panel) {
		JPanel viejoPanel = frame.getPanel();
		panel.setBounds(viejoPanel.getX(), viejoPanel.getY(),
				viejoPanel.getWidth(), viejoPanel.getHeight());
		frame.remove(viejoPanel);
		frame.setPanel(panel);
		frame.add(panel);
		frame.validate();
		frame.repaint();
	}
}
