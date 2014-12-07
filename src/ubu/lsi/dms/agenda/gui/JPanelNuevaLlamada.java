package ubu.lsi.dms.agenda.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JPanelNuevaLlamada extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public JPanelNuevaLlamada() {
		setLayout(null);
		
		JLabel lblFechaDeLlamada = new JLabel("Fecha de llamada");
		lblFechaDeLlamada.setBounds(10, 56, 98, 14);
		add(lblFechaDeLlamada);
		
		JLabel lblAsunto = new JLabel("Asunto");
		lblAsunto.setBounds(10, 92, 46, 14);
		add(lblAsunto);
		
		JLabel lblNotas = new JLabel("Notas");
		lblNotas.setBounds(10, 130, 46, 14);
		add(lblNotas);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 148, 430, 73);
		add(textPane);
		
		textField = new JTextField();
		textField.setBounds(118, 18, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(118, 89, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnDescartar = new JButton("Descartar");
		btnDescartar.setBounds(177, 232, 89, 23);
		add(btnDescartar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(326, 232, 89, 23);
		add(btnGuardar);
		
		JLabel lblContacto = new JLabel("Contacto");
		lblContacto.setBounds(10, 21, 46, 14);
		add(lblContacto);
		
		textField_2 = new JTextField();
		textField_2.setBounds(118, 53, 86, 20);
		add(textField_2);
		textField_2.setColumns(10);

	}

}
