package ubu.lsi.dms.agenda.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JPanelLlamada extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public JPanelLlamada() {
		setLayout(null);
		
		JLabel lblFechaDeLlamada = new JLabel("Fecha de llamada");
		lblFechaDeLlamada.setBounds(10, 56, 127, 14);
		add(lblFechaDeLlamada);
		
		JLabel lblAsunto = new JLabel("Asunto");
		lblAsunto.setBounds(10, 92, 86, 14);
		add(lblAsunto);
		
		JLabel lblNotas = new JLabel("Notas");
		lblNotas.setBounds(10, 130, 86, 14);
		add(lblNotas);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 148, 430, 106);
		add(textPane);
		
		textField = new JTextField();
		textField.setBounds(157, 18, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(157, 89, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnDescartar = new JButton("Descartar");
		btnDescartar.setBounds(733, 536, 102, 23);
		add(btnDescartar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(845, 536, 89, 23);
		add(btnGuardar);
		
		JLabel lblContacto = new JLabel("Contacto");
		lblContacto.setBounds(10, 21, 86, 14);
		add(lblContacto);
		
		textField_2 = new JTextField();
		textField_2.setBounds(157, 53, 86, 20);
		add(textField_2);
		textField_2.setColumns(10);

	}

}
