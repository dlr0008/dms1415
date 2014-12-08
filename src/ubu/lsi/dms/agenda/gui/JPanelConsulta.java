package ubu.lsi.dms.agenda.gui;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;

public class JPanelConsulta extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	private ButtonGroup botones = new ButtonGroup();
	private JRadioButton rdbtnContactos = new JRadioButton("Contactos");
	private JRadioButton rdbtnLlamadas = new JRadioButton("Llamadas");
	private JButton btnMostrar = new JButton("Mostrar");
	private JButton btnTodos = new JButton("Mostrar Todos");
	private JTextField campo = new JTextField();
	private JLabel lblIntroduce = new JLabel(
			"Introduce el apellido a consultar");
	private JScrollPane listScroller = null;

	public JPanelConsulta() {

		rdbtnContactos.setBounds(6, 5, 113, 23);
		rdbtnContactos.setSelected(true);

		rdbtnLlamadas.setBounds(6, 31, 113, 23);

		rdbtnTiposDeContacto.setBounds(6, 57, 170, 23);

		botones.add(rdbtnContactos);
		botones.add(rdbtnLlamadas);
		botones.add(rdbtnTiposDeContacto);
		setLayout(null);

		add(rdbtnContactos);
		add(rdbtnLlamadas);
		add(rdbtnTiposDeContacto);

		campo.setBounds(174, 32, 216, 20);
		campo.setEnabled(true);
		add(campo);
		campo.setColumns(10);

		btnMostrar.setBounds(400, 31, 107, 23);
		add(btnMostrar);

		btnTodos.setBounds(517, 31, 126, 23);
		add(btnTodos);

		lblIntroduce.setBounds(179, 9, 211, 14);
		add(lblIntroduce);
		
		listScroller = new JScrollPane();
		listScroller.setBounds(6, 87, 929, 467);
		add(listScroller);

	}

	private JRadioButton rdbtnTiposDeContacto = new JRadioButton(
			"Tipos de Contacto");

	public ButtonGroup getBotones() {
		return botones;
	}

	public void setBotones(ButtonGroup botones) {
		this.botones = botones;
	}

	public JRadioButton getRdbtnContactos() {
		return rdbtnContactos;
	}


	public JRadioButton getRdbtnLlamadas() {
		return rdbtnLlamadas;
	}


	public JButton getBtnMostrar() {
		return btnMostrar;
	}


	public JButton getBtnTodos() {
		return btnTodos;
	}


	public JRadioButton getRdbtnTiposDeContacto() {
		return rdbtnTiposDeContacto;
	}


	public JTextField getCampo() {
		return campo;
	}


	public JLabel getLblIntroduce() {
		return lblIntroduce;
	}


	public JScrollPane getListScroller() {
		return listScroller;
	}

	public void setListScroller(JScrollPane nuevaLista) {
		this.listScroller=nuevaLista;
		
	}
}