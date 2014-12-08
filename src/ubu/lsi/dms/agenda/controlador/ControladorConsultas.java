package ubu.lsi.dms.agenda.controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

import ubu.lsi.dms.agenda.gui.JFramePrincipal;
import ubu.lsi.dms.agenda.gui.JPanelConsulta;
import ubu.lsi.dms.agenda.modelo.ModelTemporal;
import ubu.lsi.dms.agenda.modelo.TablaContactos;
import ubu.lsi.dms.agenda.modelo.TablaLlamadas;
import ubu.lsi.dms.agenda.modelo.TablaTipos;

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
		this.frame=frame;
		panelConsulta = (JPanelConsulta) frame.getPanel();
		panelConsulta.getBtnMostrar().addActionListener(mostrar());
		panelConsulta.getRdbtnContactos().addItemListener(activarElementos());
		panelConsulta.getRdbtnLlamadas().addItemListener(activarElementos());
		panelConsulta.getRdbtnTiposDeContacto().addItemListener(
				desActivarElementos());
		panelConsulta.getBtnTodos().addActionListener(mostrarTodos());

		TablaContactos contactosEnTabla = new TablaContactos(
				modelo.getContactos());

		crearListaConsultas(crearTabla(contactosEnTabla,
				contactosEnTabla.getCabecera()));

	}

	public ActionListener mostrar() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AbstractTableModel modeloTabla = null;
				String[] cabecera = null;
				if (panelConsulta.getCampo().getText().equals("")
						&& panelConsulta.getCampo().isEnabled()) {
					JOptionPane.showMessageDialog(null,
							"Introduce un criterio de Busqueda");
				} else {
					if (panelConsulta.getRdbtnLlamadas().isSelected()) {
						modeloTabla = new TablaLlamadas(
								modelo.filtrarLLamadas(panelConsulta.getCampo()
										.getText()));
						cabecera = ((TablaLlamadas) modeloTabla).getCabecera();
					}
					if (panelConsulta.getRdbtnContactos().isSelected()) {
						modeloTabla = new TablaContactos(
								modelo.filtrarContactos(panelConsulta
										.getCampo().getText()));
						cabecera = ((TablaContactos) modeloTabla).getCabecera();
					}

					crearListaConsultas(crearTabla(modeloTabla, cabecera));
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
				if (panelConsulta.getRdbtnLlamadas().isSelected()) {
					modeloTabla = new TablaLlamadas(modelo.getLlamadas());
					cabecera = ((TablaLlamadas) modeloTabla).getCabecera();
				}
				if (panelConsulta.getRdbtnContactos().isSelected()) {
					modeloTabla = new TablaContactos(modelo.getContactos());
					cabecera = ((TablaContactos) modeloTabla).getCabecera();
				}
				if (panelConsulta.getRdbtnTiposDeContacto().isSelected()) {
					modeloTabla = new TablaTipos(modelo.getTipos());
					cabecera = ((TablaTipos) modeloTabla).getCabecera();
				}

				crearListaConsultas(crearTabla(modeloTabla, cabecera));

			}
		};
	}

	public ItemListener activarElementos() {

		return new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					panelConsulta.getCampo().setEnabled(true);
					panelConsulta.getCampo().setBackground(Color.WHITE);
					panelConsulta.getBtnMostrar().setEnabled(true);
					panelConsulta.getLblIntroduce().setEnabled(true);
				}

			}
		};
	}

	public ItemListener desActivarElementos() {

		return new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					panelConsulta.getCampo().setEnabled(false);
					panelConsulta.getCampo().setBackground(
							panelConsulta.getBackground());
					panelConsulta.getBtnMostrar().setEnabled(false);
					panelConsulta.getLblIntroduce().setEnabled(false);
				}

			}
		};
	}

	private void crearListaConsultas(JTable tabla) {
		System.out.println(panelConsulta);
		if (panelConsulta.getListScroller() != null)
			panelConsulta.remove(panelConsulta.getListScroller());
		JScrollPane nuevaLista = new JScrollPane(tabla);

		nuevaLista.setBounds(6, 87, 929, 467);

		if (tabla.getRowCount() == 0)
			JOptionPane.showMessageDialog(null, "Lista Vacia");

		nuevaLista
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		nuevaLista
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		panelConsulta.setListScroller(nuevaLista);
		panelConsulta.add(nuevaLista);
		panelConsulta.validate();
		panelConsulta.repaint();
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
