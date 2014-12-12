package ubu.lsi.dms.agenda.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import ubu.lsi.dms.agenda.gui.JFramePrincipal;
import ubu.lsi.dms.agenda.gui.JMenuAgenda;
import ubu.lsi.dms.agenda.gui.JPanelAyuda;
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
public class MediadorMenu {

	private JFramePrincipal frame;
	private JMenuAgenda menu;
	private ModelTemporal modelo;

	public MediadorMenu(JFramePrincipal frame, ModelTemporal modelo) {

		this.frame = frame;
		this.modelo = modelo;

		menu = frame.getMenu();
		frame.setPanel(new JPanelConsulta());
		new MediadorConsultas(frame, modelo);
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
				cambiarPanel(new JPanelContacto());
				new MediadorNuevoContacto(frame, modelo);

			}
		};

	}

	public ActionListener menuNuevaLlamada() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(new JPanelLlamada());
				new MediadorNuevaLLamada(frame, modelo);
			}
		};

	}

	public ActionListener menuNuevoTipo() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(new JPanelTipo());
				new MediadorNuevoTipo(frame, modelo);
			}
		};
	}
	
	public ActionListener menuModificaContacto() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(new JPanelContacto());
				new MediadorModificaContacto(frame, modelo);
			}
		};
	}
	
	public ActionListener menuModificaLlamada() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(new JPanelLlamada());
				new MediadorModificaLlamada(frame, modelo);
			}
		};
	}
	
	public ActionListener menuModificaTipo() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(new JPanelTipo());
				new MediadorModificaTipo(frame, modelo);
			}
		};
	}

	public ActionListener menuConsulta() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(new JPanelConsulta());
				new MediadorConsultas(frame, modelo);

			}
		};

	}
	
	public ActionListener menuAyuda() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(new JPanelAyuda());
				new MediadorAyuda(frame, modelo);

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
