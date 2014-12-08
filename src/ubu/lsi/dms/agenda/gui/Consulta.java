package ubu.lsi.dms.agenda.gui;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

public class Consulta extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Consulta() {
		setLayout(null);
		
		JRadioButton rdbtnContactos = new JRadioButton("Contactos");
		rdbtnContactos.setBounds(16, 19, 109, 23);
		add(rdbtnContactos);
		
		JRadioButton radioButton = new JRadioButton("Llamadas");
		radioButton.setBounds(16, 45, 109, 23);
		add(radioButton);
		
		JRadioButton rdbtnTiposDeContacto = new JRadioButton("Tipos de Contacto");
		rdbtnTiposDeContacto.setBounds(16, 71, 109, 23);
		add(rdbtnTiposDeContacto);
		
		textField = new JTextField();
		textField.setBounds(173, 46, 133, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(351, 45, 89, 23);
		add(btnConsultar);
		
		@SuppressWarnings("rawtypes")
		JList list = new JList();
		list.setBounds(16, 101, 397, 157);
		add(list);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(423, 101, 20, 188);
		add(scrollBar);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setOrientation(JScrollBar.HORIZONTAL);
		scrollBar_1.setBounds(16, 269, 397, 20);
		add(scrollBar_1);

	}
}
