package ubu.lsi.dms.agenda.gui;

import java.awt.event.ActionListener;

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
	JLabel lblFechaDeLlamada;
	JLabel lblAsunto;
	JLabel lblNotas;
	JButton btnDescartar;
	JButton btnGuardar;
	JLabel lblContacto;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextPane textPane;
	
	private JFramePrincipal frame = null;

	/**
	 * Create the panel.
	 */
	public JPanelLlamada() {
		setLayout(null);
		
		lblFechaDeLlamada = new JLabel("Fecha de llamada");
		lblFechaDeLlamada.setBounds(10, 56, 127, 14);
		add(lblFechaDeLlamada);
		
		lblAsunto = new JLabel("Asunto");
		lblAsunto.setBounds(10, 92, 86, 14);
		add(lblAsunto);
		
		lblNotas = new JLabel("Notas");
		lblNotas.setBounds(10, 130, 86, 14);
		add(lblNotas);
		
		textPane = new JTextPane();
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
		
		btnDescartar = new JButton("Descartar");
		btnDescartar.setBounds(733, 536, 102, 23);
		add(btnDescartar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(845, 536, 89, 23);
		add(btnGuardar);
		
		lblContacto = new JLabel("Contacto");
		lblContacto.setBounds(10, 21, 86, 14);
		add(lblContacto);
		
		textField_2 = new JTextField();
		textField_2.setBounds(157, 53, 86, 20);
		add(textField_2);
		textField_2.setColumns(10);

	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(String string) {
		this.textField.setText(string);
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(String string) {
		this.textField_1.setText(string);
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(String string) {
		this.textField_2.setText(string);
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
		this.frame=frame;		
	}

	
	public void añadirListenerGuardar(ActionListener listener) {
		btnGuardar.addActionListener(listener);

	}

	public void añadirListenerDescartarContacto(ActionListener listener) {
		btnDescartar.addActionListener(listener);

	}
}
