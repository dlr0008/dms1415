package ubu.lsi.dms.agenda.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

import ubu.lsi.dms.agenda.gui.JFramePrincipal;
import ubu.lsi.dms.agenda.gui.JPanelConsulta;
import ubu.lsi.dms.agenda.gui.TablaContactos;
import ubu.lsi.dms.agenda.gui.TablaLlamadas;
import ubu.lsi.dms.agenda.gui.TablaTipos;
import ubu.lsi.dms.agenda.modelo.ModelTemporal;

/**
 * 
 * 
 * @author Roberto Miranda Pérez
 *
 */
public class ControladorConsultas {

	private JPanelConsulta panelConsulta;
	ModelTemporal modelo;
	JFramePrincipal frame;
	int i = 0;

	public ControladorConsultas(JFramePrincipal frame, ModelTemporal modelo) {
		this.modelo = modelo;
		this.frame = frame;
		panelConsulta = (JPanelConsulta) frame.getPanel();
		panelConsulta.añadirListernerMostrar(mostrar());
		panelConsulta.añadirListenerActivar(activarElementos());
		panelConsulta.añadirListenerDesactivar(desActivarElementos());
		panelConsulta.añadirListenerMostrarTodos(mostrarTodos());

		TablaContactos contactosEnTabla = new TablaContactos(
				modelo.getContactos());

		panelConsulta.crearListaConsultas(crearTabla(contactosEnTabla,
				contactosEnTabla.getCabecera()));

	}

	public ActionListener mostrar() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AbstractTableModel modeloTabla = null;
				String[] cabecera = null;
				if (panelConsulta.getCampo().equals("")
						&& panelConsulta.isCampoEnabled()) {
					JOptionPane.showMessageDialog(null,
							"Introduce un criterio de Busqueda");
				} else {
					int boton = panelConsulta.getSelected();
					switch (boton) {
					case 1:
						modeloTabla = new TablaContactos(
								modelo.filtrarContactos(panelConsulta
										.getCampo()));
						cabecera = ((TablaContactos) modeloTabla).getCabecera();
						break;
					case 2:
						modeloTabla = new TablaLlamadas(
								modelo.filtrarLLamadas(panelConsulta.getCampo()));
						cabecera = ((TablaLlamadas) modeloTabla).getCabecera();
						break;
					case 3:
						modeloTabla = new TablaTipos(modelo.getTipos());
						cabecera = ((TablaTipos) modeloTabla).getCabecera();
						break;
					default:
						break;
					}

					panelConsulta.crearListaConsultas(crearTabla(modeloTabla,
							cabecera));
				}
			}
		};
	}

	public ActionListener mostrarTodos() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AbstractTableModel modeloTabla = null;
				String[] cabecera = null;
				int boton = panelConsulta.getSelected();
				switch (boton) {
				case 1:
					modeloTabla = new TablaContactos(modelo.getContactos());
					cabecera = ((TablaContactos) modeloTabla).getCabecera();
					break;
				case 2:
					modeloTabla = new TablaLlamadas(modelo.getLlamadas());
					cabecera = ((TablaLlamadas) modeloTabla).getCabecera();
					break;
				case 3:
					modeloTabla = new TablaTipos(modelo.getTipos());
					cabecera = ((TablaTipos) modeloTabla).getCabecera();
					break;
				default:
					break;
				}

				panelConsulta.crearListaConsultas(crearTabla(modeloTabla,
						cabecera));

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

	private JTable crearTabla(AbstractTableModel datos, String[] cabecera) {
		DefaultTableColumnModel columnModel = new DefaultTableColumnModel();
		int i = 0;
		TableColumn columna = null;
		for (String cadena : cabecera) {
			columna = new TableColumn(i);
			columna.setHeaderValue(cadena);
			columna.setMinWidth(100);
			columnModel.addColumn(columna);
			i++;
		}
		JTable table = new JTable(datos, columnModel);
		if (cabecera.length >= 6)
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		else
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setRowHeight(20);
		return table;
	}
}
