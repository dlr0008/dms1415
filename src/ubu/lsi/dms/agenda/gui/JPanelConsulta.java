package ubu.lsi.dms.agenda.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

import ubu.lsi.dms.agenda.gui.tables.TablaContactos;
import ubu.lsi.dms.agenda.gui.tables.TablaLlamadas;
import ubu.lsi.dms.agenda.gui.tables.TablaTipos;
import ubu.lsi.dms.agenda.test.TestGui;
import javax.swing.JLabel;

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
	private JButton btnMostrar = new JButton("Mostrar");

	private JRadioButton rdbtnTiposDeContacto = new JRadioButton(
			"Tipos de Contacto");
	private JTextField campo = new JTextField();
	private JLabel lblIntroduce = new JLabel("Introduce el apellido a consultar");
	private JScrollPane listScroller = null;
	private TestGui testGui = null;

	public JPanelConsulta(TestGui testGui) {

		this.testGui = testGui;

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

		btnMostrar.setBounds(400, 31, 107, 23);
		btnMostrar.addActionListener(new buttonConsulta());
		add(btnMostrar);

		TablaContactos contactosEnTabla = new TablaContactos(
				testGui.getContactos());

		JTable tabla = crearTabla(contactosEnTabla,
				contactosEnTabla.getCabecera());

		crearListaConsultas(tabla);

		JButton btnNewButton = new JButton("Mostrar Todos");
		btnNewButton.addActionListener(new buttonTodos());
		btnNewButton.setBounds(517, 31, 126, 23);
		add(btnNewButton);
		
		
		lblIntroduce.setBounds(179, 9, 211, 14);
		add(lblIntroduce);

	}

	private class buttonConsulta implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			AbstractTableModel modeloTabla = null;
			String[] cabecera = null;
			if (campo.getText().equals("") && campo.isEnabled()) {
				JOptionPane.showMessageDialog(null,
						"Introduce un criterio de Busqueda");
			} else {
				if (rdbtnLlamadas.isSelected()) {
					modeloTabla = new TablaLlamadas(
							testGui.filtrarLLamadas(campo.getText()));
					cabecera = ((TablaLlamadas) modeloTabla).getCabecera();
				}
				if (rdbtnContactos.isSelected()) {
					modeloTabla = new TablaContactos(
							testGui.filtrarContactos(campo.getText()));
					cabecera = ((TablaContactos) modeloTabla).getCabecera();
				}

				crearListaConsultas(crearTabla(modeloTabla, cabecera));
			}
		}
	}

	private class buttonTodos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			AbstractTableModel modeloTabla = null;
			String[] cabecera = null;
			if (rdbtnLlamadas.isSelected()) {
				modeloTabla = new TablaLlamadas(testGui.getLlamadas());
				cabecera = ((TablaLlamadas) modeloTabla).getCabecera();
			}
			if (rdbtnContactos.isSelected()) {
				modeloTabla = new TablaContactos(testGui.getContactos());
				cabecera = ((TablaContactos) modeloTabla).getCabecera();
			}
			if (rdbtnTiposDeContacto.isSelected()) {
				modeloTabla = new TablaTipos(testGui.getTipos());
				cabecera = ((TablaTipos) modeloTabla).getCabecera();
			}

			crearListaConsultas(crearTabla(modeloTabla, cabecera));

		}

	}

	private class rbttonDisableField implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				campo.setEnabled(false);
				campo.setBackground(JPanelConsulta.this.getBackground());
				btnMostrar.setEnabled(false);
				lblIntroduce.setEnabled(false);
			}

		}
	}

	private class rbttonEnableField implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				campo.setEnabled(true);
				campo.setBackground(Color.WHITE);
				btnMostrar.setEnabled(true);
				lblIntroduce.setEnabled(true);
			}

		}
	}

	private void crearListaConsultas(JTable tabla) {
		if (listScroller != null)
			remove(listScroller);

		listScroller = new JScrollPane(tabla);
		listScroller.setBounds(6, 87, 929, 467);
		if (tabla.getRowCount() == 0)
			JOptionPane.showMessageDialog(null, "Lista Vacia");

		listScroller
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		listScroller
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		add(listScroller);
		validate();
		repaint();
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