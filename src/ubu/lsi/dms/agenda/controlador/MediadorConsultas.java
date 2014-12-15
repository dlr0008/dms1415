package ubu.lsi.dms.agenda.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ubu.lsi.dms.agenda.gui.JFramePrincipal;
import ubu.lsi.dms.agenda.gui.JPanelConsultas;
import ubu.lsi.dms.agenda.modelo.ModelTemporal;

/**
 * 
 * 
 * @author Roberto Miranda Pérez
 *
 */
public class MediadorConsultas {

	private JPanelConsultas panelConsulta;
	ModelTemporal modelo;
	JFramePrincipal frame;
	int i = 0;

	public MediadorConsultas(JFramePrincipal frame,
			ModelTemporal modelo) {

		this.modelo = modelo;
		this.frame = frame;
		panelConsulta = new JPanelConsultas();
		panelConsulta.añadirListernerMostrar(mostrar());
		panelConsulta.añadirListenerActivar(activarElementos());
		panelConsulta.añadirListenerDesactivar(desActivarElementos());
		panelConsulta.añadirListenerMostrarTodos(mostrarTodos());
		modelo.getContactos().addObserver(panelConsulta);
		modelo.getLlamadas().addObserver(panelConsulta);
		modelo.getTipos().addObserver(panelConsulta);
		frame.tablaContactos();
		frame.tablaLLamadas();
		frame.tablaTipos();

	}

	public ActionListener mostrar() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (panelConsulta.getApellido().equals("")
						&& panelConsulta.isCampoEnabled()) {
					JOptionPane.showMessageDialog(null,
							"Introduce un criterio de Busqueda");
				} else {
					int i = panelConsulta.getSelectedRadio();

					switch (i) {
					case 1:
						frame.filtrarContactos(panelConsulta.getApellido());
						panelConsulta.crearListaConsultas(frame
								.tablaContactos());
						break;
					case 2:
						frame.filtrarLLamadas(panelConsulta.getApellido());
						panelConsulta
								.crearListaConsultas(frame.tablaLLamadas());
						break;
					case 3:
						panelConsulta.crearListaConsultas(frame.tablaTipos());
						break;
					}

				}
			}
		};
	}

	public ActionListener mostrarTodos() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i = panelConsulta.getSelectedRadio();

				switch (i) {
				case 1:
					frame.filtrarContactos(null);
					panelConsulta.crearListaConsultas(frame.tablaContactos());
					break;
				case 2:
					frame.filtrarLLamadas(null);
					panelConsulta.crearListaConsultas(frame.tablaLLamadas());
					break;
				case 3:
					panelConsulta.crearListaConsultas(frame.tablaTipos());
					break;
				}

			}
		};
	}

	public ItemListener activarElementos() {

		return new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					panelConsulta.activar(true);
				}

			}
		};
	}

	public ItemListener desActivarElementos() {

		return new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					panelConsulta.activar(false);
				}

			}
		};
	}

	public JPanel getPanelAsociado() {
		return panelConsulta;
	}
}
