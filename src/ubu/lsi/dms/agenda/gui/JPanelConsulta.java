package ubu.lsi.dms.agenda.gui;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
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
	private JButton btnMostrar = new JButton("Mostrar");
	private JButton btnTodos = new JButton("Mostrar Todos");
	private JTextField campo = new JTextField();
	private JLabel lblIntroduce = new JLabel(
			"Introduce el apellido a consultar");
	private JScrollPane listScroller = null;

	public JPanelConsulta() {

		rdbtnContactos.setBounds(6, 5, 113, 23);
		rdbtnContactos.setSelected(true);

		rdbtnLlamadas.setBounds(6, 31, 113, 23);

		rdbtnTiposDeContacto.setBounds(6, 57, 170, 23);

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
		add(btnMostrar);

		btnTodos.setBounds(517, 31, 126, 23);
		add(btnTodos);

		lblIntroduce.setBounds(179, 9, 211, 14);
		add(lblIntroduce);

		listScroller = new JScrollPane();
		listScroller.setBounds(6, 87, 929, 467);
		add(listScroller);

	}

	public String getApellido() {
		return campo.getText();
	}

	public boolean isCampoEnabled() {
		return campo.isEnabled();
	}

	public void setListScroller(JScrollPane nuevaLista) {
		this.listScroller = nuevaLista;

	}

	public void activar(Boolean encendido) {

		campo.setEnabled(encendido);
		if (encendido)
			campo.setBackground(Color.WHITE);
		else
			campo.setBackground(this.getBackground());
		btnMostrar.setEnabled(encendido);
		lblIntroduce.setEnabled(encendido);
	}

	public void crearListaConsultas(JTable tabla) {
		if (listScroller != null)
			remove(listScroller);
		JScrollPane nuevaLista = new JScrollPane(tabla);

		nuevaLista.setBounds(6, 87, 929, 467);

		if (tabla.getRowCount() == 0)
			JOptionPane.showMessageDialog(null, "Lista Vacia");

		nuevaLista
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		nuevaLista
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		setListScroller(nuevaLista);
		add(nuevaLista);
		validate();
		repaint();
	}

	public int getSelectedRadio() {
		if (rdbtnContactos.isSelected())
			return 1;
		if (rdbtnLlamadas.isSelected())
			return 2;
		if (rdbtnTiposDeContacto.isSelected())
			return 3;
		return 0;
	}

	public void añadirListernerMostrar(ActionListener listener) {
		btnMostrar.addActionListener(listener);

	}

	public void añadirListenerActivar(ItemListener listener) {
		rdbtnContactos.addItemListener(listener);
		rdbtnLlamadas.addItemListener(listener);

	}

	public void añadirListenerDesactivar(ItemListener listener) {
		rdbtnTiposDeContacto.addItemListener(listener);

	}

	public void añadirListenerMostrarTodos(ActionListener listener) {
		btnTodos.addActionListener(listener);

	}
	
	public JTable crearTabla(AbstractTableModel datos, String[] cabecera) {
		DefaultTableColumnModel columnModel = new DefaultTableColumnModel();
		int i = 0;
		TableColumn columna = null;
		for (String cadena : cabecera) {
			columna = new TableColumn(i++);
			columna.setHeaderValue(cadena);
			columna.setMinWidth(100);
			columnModel.addColumn(columna);
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