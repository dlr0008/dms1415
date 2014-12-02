package ubu.lsi.dms.agenda.gui;

import java.awt.Container;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JToolBar;

public class JPanelConsulta extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	private Vector<String> datos = new Vector<String>();

	public JPanelConsulta() {
		String cadena = "Campo ";
		String cadaux;
		for (int i = 1; i < 20; i++) {
			cadaux = cadena + i;
			datos.addElement(cadaux);
		}
		setLayout(null);

		JRadioButton rdbtnContactos = new JRadioButton("Contactos");
		rdbtnContactos.setBounds(16, 19, 109, 23);
		add(rdbtnContactos);

		JRadioButton radioButton = new JRadioButton("Llamadas");
		radioButton.setBounds(16, 45, 109, 23);
		add(radioButton);

		JRadioButton rdbtnTiposDeContacto = new JRadioButton(
				"Tipos de Contacto");
		rdbtnTiposDeContacto.setBounds(16, 71, 127, 23);
		add(rdbtnTiposDeContacto);

		textField = new JTextField();
		textField.setBounds(173, 46, 133, 20);
		add(textField);
		textField.setColumns(10);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(351, 45, 89, 23);
		add(btnConsultar);
		JScrollPane listScroller = new JScrollPane();
		listScroller.setBounds(16, 101, 424, 188);
		add(listScroller);
		
		JList list = new JList();
		listScroller.setViewportView(list);
		
		list.setLayoutOrientation(JList.VERTICAL);

	}
}
