package ubu.lsi.dms.agenda.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class JPanelNuevoContacto extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public JPanelNuevoContacto() {
		setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 11, 46, 14);
		add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(66, 8, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(10, 44, 46, 14);
		add(lblApellidos);
		
		textField_1 = new JTextField();
		textField_1.setBounds(66, 41, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(10, 79, 46, 14);
		add(lblDireccion);
		
		textField_2 = new JTextField();
		textField_2.setBounds(66, 76, 86, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(66, 107, 86, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(66, 138, 86, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setBounds(10, 110, 46, 14);
		add(lblCiudad);
		
		JLabel lblMovil = new JLabel("Movil");
		lblMovil.setBounds(10, 141, 46, 14);
		add(lblMovil);
		
		JLabel lblTipoDeContacto = new JLabel("Tipo de contacto");
		lblTipoDeContacto.setBounds(213, 11, 80, 14);
		add(lblTipoDeContacto);
		
		JLabel lblNotas = new JLabel("Notas");
		lblNotas.setBounds(213, 44, 46, 14);
		add(lblNotas);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(213, 69, 227, 89);
		add(textPane);
		
		JButton btnOtrosCampos = new JButton("Otros Campos");
		btnOtrosCampos.setBounds(39, 205, 101, 23);
		add(btnOtrosCampos);
		
		JButton btnDescartar = new JButton("Descartar");
		btnDescartar.setBounds(183, 205, 89, 23);
		add(btnDescartar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(321, 205, 89, 23);
		add(btnGuardar);

	}
}
