package ubu.lsi.dms.agenda.gui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import ubu.lsi.dms.agenda.modelo.TipoContacto;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

/**
 * @author <A HREF="mailto:jld0016@alu.ubu.es">Jorge Laguna</A>
 * @author <A HREF="mailto:rmp0046@alu.ubu.es">Roberto Miranda</A>
 * @author <A HREF="mailto:aam0093@alu.ubu.es">Asier Alonso</A>
 * @author <A HREF="mailto:dlr0008@alu.ubu.es">Daniel Lozano</A>
 * @version 1.0
 * 
 *          JPanel que contiene el panel para poder insertar y modificar Tipos
 *          de Contacto, Es observador Concreto, ya que cuando se actualiza la
 *          lista de Tipos, se debe actualizar la tabla
 * 
 */
public class JPanelTipo extends JPanel implements Observer {

	private JFramePrincipal frame;
	private static final long serialVersionUID = 1L;
	private JTextField tipo;
	private JScrollPane scrollPane;
	private JTable table;
	JButton btnDescartar;
	JButton btnGuardar;

	/**
	 * Create the panel.
	 */
	public JPanelTipo(JFramePrincipal frame) {
		setLayout(null);
		this.frame = frame;
		btnDescartar = new JButton("Descartar");
		btnDescartar.setBounds(734, 536, 101, 23);
		add(btnDescartar);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(845, 536, 89, 23);
		add(btnGuardar);

		JLabel lblTipoDeContacto = new JLabel("Tipo de Contacto");
		lblTipoDeContacto.setBounds(10, 11, 101, 14);
		add(lblTipoDeContacto);

		tipo = new JTextField();
		tipo.setBounds(135, 8, 86, 20);
		add(tipo);
	}

	/**
	 * Coloca en el SrollPanel una tabla pasada por parametro
	 * 
	 * @param tabla
	 */
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

	public void añadirListenerGuardar(ActionListener listener) {
		btnGuardar.addActionListener(listener);

	}

	public void añadirListenerDescartarContacto(ActionListener listener) {
		btnDescartar.addActionListener(listener);

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		frame.añadirTipoContacto((TipoContacto) arg1);

	}

	public void setTipoContacto(String string) {
		tipo.setText(string);
	}

	public String getTipoContacto() {
		return tipo.getText();
	}

	public void añadirListeterTabla(MouseListener listener) {
		table.addMouseListener(listener);
	}

	public void activarCampos() {
		tipo.setEnabled(true);
	}

	public int getFilaSeleccionada() {
		return table.getSelectedRow();
	}
}
