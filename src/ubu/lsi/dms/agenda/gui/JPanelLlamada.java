package ubu.lsi.dms.agenda.gui;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

public class JPanelLlamada extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lblFechaDeLlamada;
	JLabel lblAsunto;
	JLabel lblNotas;
	JButton btnDescartar;
	JButton btnGuardar;
	JLabel lblContacto;
	private JTextField nombre;
	private JTextField fecha;
	private JTextField asunto;
	private JTextPane textPane;
	private JScrollPane scrollPane;

	private JFramePrincipal frame = null;

	/**
	 * Create the panel.
	 */
	public JPanelLlamada() {
		setLayout(null);

		lblFechaDeLlamada = new JLabel("Fecha de llamada");
		lblFechaDeLlamada.setBounds(10, 66, 127, 14);
		add(lblFechaDeLlamada);

		lblAsunto = new JLabel("Asunto");
		lblAsunto.setBounds(10, 112, 86, 14);
		add(lblAsunto);

		lblNotas = new JLabel("Notas");
		lblNotas.setBounds(10, 160, 86, 14);
		add(lblNotas);

		textPane = new JTextPane();
		textPane.setBounds(10, 200, 430, 118);
		add(textPane);

		nombre = new JTextField();
		nombre.setBounds(157, 18, 155, 20);
		add(nombre);
		nombre.setColumns(10);

		asunto = new JTextField();
		asunto.setBounds(157, 109, 155, 20);
		add(asunto);
		asunto.setColumns(10);

		btnDescartar = new JButton("Descartar");
		btnDescartar.setBounds(733, 536, 102, 23);
		add(btnDescartar);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(845, 536, 89, 23);
		add(btnGuardar);

		lblContacto = new JLabel("Contacto");
		lblContacto.setBounds(10, 21, 86, 14);
		add(lblContacto);

		fecha = new JTextField();
		fecha.setBounds(157, 63, 155, 20);
		add(fecha);
		fecha.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(462, 18, 394, 300);
		add(scrollPane);

	}

	public JTextField getTextField() {
		return nombre;
	}

	public void setTextField(String string) {
		this.nombre.setText(string);
	}

	public JTextField getfecha() {
		return fecha;
	}

	public void setfecha(String string) {
		this.fecha.setText(string);
	}

	public JTextField getasunto() {
		return asunto;
	}

	public void setasunto(String string) {
		this.asunto.setText(string);
	}

	public JTextPane getTextPane() {
		return textPane;
	}

	public void setTextPane(String string) {
		this.textPane.setText(string);
	}

	public JFramePrincipal getFrame() {
		return frame;
	}

	public void setFrame(JFramePrincipal frame) {
		this.frame = frame;
	}

	public void añadirListenerGuardar(ActionListener listener) {
		btnGuardar.addActionListener(listener);

	}

	public void añadirListenerDescartarContacto(ActionListener listener) {
		btnDescartar.addActionListener(listener);

	}

	public void crearListaConsultas(JTable tabla) {
		if (scrollPane != null)
			remove(scrollPane);
		JScrollPane nuevaLista = new JScrollPane(tabla);

		nuevaLista.setBounds(462, 18, 394, 300);

		if (tabla.getRowCount() == 0)
			JOptionPane.showMessageDialog(null, "Lista Vacia");

		nuevaLista
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		nuevaLista
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane = nuevaLista;
		add(nuevaLista);
		validate();
		repaint();
	}

	public JTable crearTabla(AbstractTableModel datos, String[] cabecera) {
		DefaultTableColumnModel columnModel = new DefaultTableColumnModel();
		int i = 0;
		
		TableColumn columna = null;
		for (String cadena : cabecera) {
			if (i < 3 || i==14 || i==12) {
				columna = new TableColumn(i);
				columna.setHeaderValue(cadena);
				columna.setMinWidth(40);
				columna.setMaxWidth(100);
				columna.setWidth(80);
				columnModel.addColumn(columna);
			}
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
