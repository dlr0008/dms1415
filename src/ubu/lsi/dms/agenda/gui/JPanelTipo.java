package ubu.lsi.dms.agenda.gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPanelTipo extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextField textField;
	JButton btnDescartar;
	JButton btnGuardar;
	
	/**
	 * Create the panel.
	 */
	public JPanelTipo() {
		setLayout(null);
		
		btnDescartar = new JButton("Descartar");
		btnDescartar.setBounds(734, 536, 101, 23);
		add(btnDescartar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(845, 536, 89, 23);
		add(btnGuardar);
		
		JLabel lblTipoDeContacto = new JLabel("Tipo de Contacto");
		lblTipoDeContacto.setBounds(10, 11, 101, 14);
		add(lblTipoDeContacto);
		
		textField = new JTextField();
		textField.setBounds(135, 8, 86, 20);
		add(textField);
		textField.setColumns(10);
	}
	
	public static String getTextField() {
		return textField.getText();
	}

	public void setTextField(String string) {
		this.textField.setText(string);
	}

	public void añadirListenerGuardar(ActionListener listener) {
		btnGuardar.addActionListener(listener);

	}

	public void añadirListenerDescartarContacto(ActionListener listener) {
		btnDescartar.addActionListener(listener);

	}

	public void setFrame(JFramePrincipal frame) {
		// TODO Auto-generated method stub
		
	}
}
