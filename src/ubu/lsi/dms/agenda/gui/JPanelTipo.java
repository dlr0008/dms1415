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
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public JPanelTipo() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("Descartar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(734, 536, 101, 23);
		add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Guardar");
		btnNewButton_2.setBounds(845, 536, 89, 23);
		add(btnNewButton_2);
		
		JLabel lblTipoDeContacto = new JLabel("Tipo de Contacto");
		lblTipoDeContacto.setBounds(10, 11, 101, 14);
		add(lblTipoDeContacto);
		
		textField = new JTextField();
		textField.setBounds(135, 8, 86, 20);
		add(textField);
		textField.setColumns(10);

	}
}