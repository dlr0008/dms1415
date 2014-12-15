package ubu.lsi.dms.agenda.gui;

import javax.swing.DefaultRowSorter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;

import ubu.lsi.dms.agenda.modelo.*;

import java.awt.Toolkit;
import java.io.File;
import java.util.Collection;

/**
 * 
 * Clase que implemnta la ventana principal de la aplicacion. Contiene las
 * diferentes tablas que emplea la aplicacion.
 * 
 * 
 * @author Roberto
 *
 */
public class JFramePrincipal extends JFrame {

	private static final long serialVersionUID = 4560575572881828200L;
	private JPanel contentPane;

	JPanel panel = null;
	
	private JMenuAgenda menuAgenda;
	private JTable tablaLlamadas;
	private JTable tablaContactos;
	private JTable tablaTipos;
	private TablaLlamadas tablaAbstractaLlamadas;
	private TablaContactos tablaAbstractaContactos;
	private TablaTipos tablaAbstractaTipos;
	private TableRowSorter<TableModel> sorter;

	public JFramePrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"." + File.separator + "images" + File.separator + "ubu.jpg"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 954, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		menuAgenda = new JMenuAgenda();
		menuAgenda.setBounds(0, 0, 950, 25);
		contentPane.add(menuAgenda);
		

	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel nuevoPanel) {
		panel = nuevoPanel;
		panel.setBounds(0, 25, 950, 925);
		contentPane.add(panel);
	}

	/**
	 * Devuelve una Tabla que emplean los diferentes paneles.
	 * 
	 * @param datos
	 *            Lista con los datos
	 * @param cabecera
	 *            cabecera de la tabla
	 * @return tabla
	 */
	public JTable crearTabla(AbstractTableModel datos, String[] cabecera) {
		DefaultTableColumnModel columnModel = new DefaultTableColumnModel();
		int i = 0;
		sorter = new TableRowSorter<TableModel>(datos);
		TableColumn columna = null;
		for (String cadena : cabecera) {
			columna = new TableColumn(i++);
			columna.setHeaderValue(cadena);
			columna.setMinWidth(60);
			columnModel.addColumn(columna);

		}
		JTable table = new JTable(datos, columnModel);
		if (cabecera.length >= 6)
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		else
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setRowHeight(20);
		table.setRowSorter(sorter);
		return table;
	}

	/**
	 * Devuelve la tabla de llamadas
	 * 
	 * @return
	 */
	public JTable tablaLLamadas() {
		return tablaLlamadas;
	}

	/**
	 * Devuelve la tabla de Contactos
	 * 
	 * 
	 * @return
	 */
	public JTable tablaContactos() {
		return tablaContactos;
	}

	/**
	 * Devuelve la tabla de tipos de contacto
	 * 
	 * @return
	 */
	public JTable tablaTipos() {
		return tablaTipos;
	}

	/**
	 * Crea la tabla de llamadas
	 * 
	 * @param llamadas
	 */
	public void setTablaLLamadas(Collection<Llamada> llamadas) {
		TablaLlamadas datos = new TablaLlamadas();
		tablaAbstractaLlamadas = datos;
		for (Llamada l : llamadas) {
			datos.add(l);
		}
		tablaLlamadas = crearTabla(datos, datos.getCabecera());
	}

	public TablaLlamadas getTablaAbstractaLlamadas() {
		return tablaAbstractaLlamadas;
	}

	/**
	 * Crea la tabla de contactos
	 * 
	 * @param contacto
	 */
	public void setTablaContactos(Collection<Contacto> contacto) {
		TablaContactos datos = new TablaContactos();
		tablaAbstractaContactos = datos;
		for (Contacto c : contacto)
			datos.add(c);
		tablaContactos = crearTabla(datos, datos.getCabecera());
	}

	/**
	 * Crea la tabla de tipos de contactos
	 * 
	 * @param tipos
	 */
	public void setTablaTipos(Collection<TipoContacto> tipos) {
		TablaTipos datos = new TablaTipos(tipos);
		tablaAbstractaTipos = datos;
		for (TipoContacto t : tipos)
			datos.add(t);
		tablaTipos = crearTabla(datos, datos.getCabecera());
	}

	public JMenuAgenda getMenuAgenda() {
		return menuAgenda;
	}

	public void añadirLamada(Object arg) {
		tablaAbstractaLlamadas.add((Llamada) arg);

	}

	public void añadirContacto(Object arg) {
		tablaAbstractaContactos.add((Contacto) arg);
	}

	public void añadirTipoContacto(Object arg) {
		tablaAbstractaTipos.add((TipoContacto) arg);
	}
	
	@SuppressWarnings("unchecked")
	public void filtrarLLamadas(String apellido){
		if (apellido!=null)
		((DefaultRowSorter<TableModel, Integer>) tablaLlamadas.getRowSorter()).setRowFilter(RowFilter.regexFilter(apellido));
		else
			((DefaultRowSorter<TableModel, Integer>) tablaLlamadas.getRowSorter()).setRowFilter(null);
	}
	@SuppressWarnings("unchecked")
	public void filtrarContactos(String apellido){
		if (apellido!=null)
		((DefaultRowSorter<TableModel, Integer>) tablaContactos.getRowSorter()).setRowFilter(RowFilter.regexFilter(apellido));
		else
			((DefaultRowSorter<TableModel, Integer>) tablaContactos.getRowSorter()).setRowFilter(null);
	}

}
