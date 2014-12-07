package ubu.lsi.dms.agenda.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

import ubu.lsi.dms.agenda.gui.tables.TablaContactos;
import ubu.lsi.dms.agenda.gui.tables.TablaLlamadas;
import ubu.lsi.dms.agenda.gui.tables.TablaTipos;
import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.modelo.TipoContacto;

public class JPanelConsulta extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	private ButtonGroup botones = new ButtonGroup();
	private JRadioButton rdbtnContactos = new JRadioButton("Contactos");
	private JRadioButton rdbtnLlamadas = new JRadioButton("Llamadas");
	private JRadioButton rdbtnTiposDeContacto = new JRadioButton(
			"Tipos de Contacto");
	private JTextField campo = new JTextField();
	private JScrollPane listScroller = null;

	private Collection<Contacto> contactos = new ArrayList<Contacto>();
	private Collection<Llamada> llamadas = new ArrayList<Llamada>();
	private Collection<TipoContacto> tipos = new ArrayList<TipoContacto>();
	private JTable tabla = null;

	private String[] cabeceraContacto = new String[] { "Id", "Nombre",
			"Apellidos", "Estimado", "Direccion", "Ciudad", "Prov",
			"CodPostal", "Region", "Páis", "NombreCompañia", "Cargo",
			"telefonoTrabajo", "ExtensionTrabajo", "TelefonoMovil", "NumFax",
			"NomCorreoElectronico", "Notas" };
	private String[] cabeceraLlamada = new String[] { "ID", "Contacto",
			"Fecha", "Asunto", "Notas" };
	private String[] cabeceraTipos = new String[] { "ID", "Nombre" };

	public JPanelConsulta() {
		iniContactos(contactos);
		iniLlamadas(llamadas);
		iniTipos(tipos);

		rdbtnContactos.setBounds(6, 5, 113, 23);
		rdbtnContactos.addItemListener(new rbttonEnableField());
		rdbtnContactos.setSelected(true);

		rdbtnLlamadas.setBounds(6, 31, 113, 23);
		rdbtnLlamadas.addItemListener(new rbttonEnableField());

		rdbtnTiposDeContacto.setBounds(6, 57, 170, 23);
		rdbtnTiposDeContacto.addItemListener(new rbttonDisableField());

		botones.add(rdbtnContactos);
		botones.add(rdbtnLlamadas);
		botones.add(rdbtnTiposDeContacto);
		setLayout(null);

		add(rdbtnContactos);
		add(rdbtnLlamadas);
		add(rdbtnTiposDeContacto);

		campo.setBounds(174, 32, 216, 20);
		campo.setEnabled(true);
		add(campo);
		campo.setColumns(10);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(400, 31, 107, 23);
		btnConsultar.addActionListener(new ButtonEnable());
		add(btnConsultar);

		TablaContactos contactosEnTabla = new TablaContactos(contactos);

		JTable tabla = crearTabla(contactosEnTabla, cabeceraContacto);

		crearListaConsultas(tabla);

	}

	private void iniTipos(Collection<TipoContacto> tipos) {
		for (int i = 1; i <= 30; i++)
			tipos.add(new TipoContacto(i, "Tipo00" + i));

	}

	private class rbttonDisableField implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				campo.setEnabled(false);
				campo.setBackground(JPanelConsulta.this.getBackground());
			}

		}
	}

	private class rbttonEnableField implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				campo.setEnabled(true);
				campo.setBackground(Color.WHITE);
			}

		}
	}

	private class ButtonEnable implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (rdbtnLlamadas.isSelected()) {
				TablaLlamadas llamadasEnTabla = new TablaLlamadas(llamadas);
				tabla = crearTabla(llamadasEnTabla, cabeceraLlamada);
			}
			if (rdbtnContactos.isSelected()) {
				TablaContactos contactosEnTabla = new TablaContactos(contactos);
				tabla = crearTabla(contactosEnTabla, cabeceraContacto);
			}
			if (rdbtnTiposDeContacto.isSelected()) {
				TablaTipos tiposEnTabla = new TablaTipos(tipos);
				tabla = crearTabla(tiposEnTabla, cabeceraTipos);
			}
			crearListaConsultas(tabla);

		}
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

	private void iniContactos(Collection<Contacto> contactos) {
		TipoContacto tipoContacto = new TipoContacto(1, "Tipo001");
		for (int i = 1; i <= 40; i++)
			contactos.add(new Contacto(i, "Nombre00" + i, "Apellidos00" + i,
					"Estimado00" + i, "Direccion00" + i, "Ciudad00" + i,
					"Prov00" + i, "CodPostal000" + i, "Region000" + i,
					"Pais000" + i, "NombreCompania000" + i, "Cargo000" + i,
					"TelefonoTrabajo00" + i, "ExtensionTrabajo00" + i,
					"TelefonoMovil00" + i, "NumFax00" + i,
					" NomCorreoElectronico00" + i + "@ubu.es", "Notas00" + i,
					tipoContacto));

	}

	private void iniLlamadas(Collection<Llamada> llamadas) {
		TipoContacto tipoContacto = new TipoContacto(1, "Tipo001");

		for (int i = 1; i <= 5; i++) {
			llamadas.add(new Llamada(i, new Contacto(1, "Nombre00" + 1,
					"Apellidos00" + 1, "Estimado00" + 1, "Direccion00" + 1,
					"Ciudad00" + 1, "Prov00" + 1, "CodPostal000" + i,
					"Region000" + i, "Pais000" + 1, "NombreCompania000" + 1,
					"Cargo000" + 1, "TelefonoTrabajo00" + 1,
					"ExtensionTrabajo00" + 1, "TelefonoMovil00" + 1,
					"NumFax00" + 1, " NomCorreoElectronico00" + 1 + "@ubu.es",
					"Notas00" + 1, tipoContacto),
					"2014-10-18 0" + i + ":00:00", "AsuntoLlamada00" + i,
					"NotaLlamada00" + i));
		}
	}

	private void crearListaConsultas(JTable tabla) {
		if (listScroller != null)
			remove(listScroller);

		listScroller = new JScrollPane(tabla);
		listScroller.setBounds(6, 87, 929, 467);
		listScroller
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		listScroller
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		add(listScroller);
		validate();
		repaint();
	}
}