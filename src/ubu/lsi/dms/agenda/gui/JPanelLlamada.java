package ubu.lsi.dms.agenda.gui;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class JPanelLlamada extends JPanel implements Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblFechaDeLlamada;
	private JLabel lblAsunto;
	private JLabel lblNotas;
	private JButton btnDescartar;
	private JButton btnGuardar;
	private JLabel lblContacto;
	private JTextField nombre;
	private JTextField fecha;
	private JTextField asunto;
	private JTextPane notas;
	private JScrollPane scrollPane;
	private JTable table;
	private JFramePrincipal frame;

	/**
	 * Create the panel.
	 */
	public JPanelLlamada(JFramePrincipal frame) {
		setLayout(null);
		this.frame = frame;
		lblFechaDeLlamada = new JLabel("Fecha de llamada");
		lblFechaDeLlamada.setBounds(10, 66, 127, 14);
		add(lblFechaDeLlamada);

		lblAsunto = new JLabel("Asunto");
		lblAsunto.setBounds(10, 112, 86, 14);
		add(lblAsunto);

		lblNotas = new JLabel("Notas");
		lblNotas.setBounds(10, 160, 86, 14);
		add(lblNotas);

		notas = new JTextPane();
		notas.setBounds(10, 200, 430, 118);
		add(notas);

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

		fecha.setEnabled(false);
		fecha.setBackground(this.getBackground());
		asunto.setEnabled(false);
		asunto.setBackground(this.getBackground());
		notas.setEnabled(false);
		notas.setBackground(this.getBackground());
		btnGuardar.setEnabled(false);

	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public void setNombre(String nombre) {

		this.nombre.setText(nombre);

	}

	public void setfecha(String string) {
		this.fecha.setText(string);
	}

	public void setasunto(String string) {
		this.asunto.setText(string);
	}

	public void setTextPane(String string) {
		this.notas.setText(string);
	}

	public void añadirListenerGuardar(ActionListener listener) {
		btnGuardar.addActionListener(listener);

	}

	public void añadirListenerDescartarContacto(ActionListener listener) {
		btnDescartar.addActionListener(listener);

	}

	public void recargarTabla(JTable tabla) {
		table = tabla;
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

	public void añadirListeterTabla(MouseListener listener) {
		table.addMouseListener(listener);

	}

	public int getFilaSeleccionada() {
		return table.getSelectedRow();

	}

	public String getFecha() {
		return fecha.getText();
	}

	public String getNotas() {
		return notas.getText();
	}

	public String getAsunto() {
		return asunto.getText();
	}

	public void activarCampos() {
		fecha.setEnabled(true);
		fecha.setBackground(Color.WHITE);
		asunto.setEnabled(true);
		asunto.setBackground(Color.WHITE);
		notas.setEnabled(true);
		notas.setBackground(Color.WHITE);
		btnGuardar.setEnabled(true);

	}

	@Override
	public void update(Observable o, Object arg) {

		frame.añadirLamada(arg);
	}

	@Override
	public void setVisible(boolean aFlag) {
		frame.filtrarContactos(null);
		super.setVisible(aFlag);
	}

}
