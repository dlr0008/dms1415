package ubu.lsi.dms.agenda.gui;

import java.awt.Choice;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;


public class JPanelContacto extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JFramePrincipal frame = null;

	/**
	 * Create the panel.
	 */

	private JLabel lblNombre;
	private JTextField nombre;
	private JLabel lblApellidos;
	private JTextField apellidos;
	private JLabel lblDireccion;
	private JTextField Direccion;
	private JLabel lblCiudad;
	private JTextField Ciudad;
	private JLabel lblMovil;
	private JTextField Movil;
	private JLabel lblTipoDeContacto;
	private Choice menu;
	private JLabel lblNotas;
	private JTextPane textPane;

	public JPanelContacto() {
		setLayout(null);

		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 11, 75, 14);
		add(lblNombre);

		nombre = new JTextField();
		nombre.setBounds(95, 8, 114, 20);
		add(nombre);
		nombre.setColumns(10);

		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(10, 44, 75, 14);
		add(lblApellidos);

		apellidos = new JTextField();
		apellidos.setBounds(95, 41, 114, 20);
		add(apellidos);
		apellidos.setColumns(10);

		lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(10, 79, 75, 14);
		add(lblDireccion);

		Direccion = new JTextField();
		Direccion.setBounds(95, 76, 114, 20);
		add(Direccion);
		Direccion.setColumns(10);

		lblCiudad = new JLabel("Ciudad");
		lblCiudad.setBounds(10, 110, 75, 14);
		add(lblCiudad);

		Ciudad = new JTextField();
		Ciudad.setBounds(95, 107, 114, 20);
		add(Ciudad);
		Ciudad.setColumns(10);

		lblMovil = new JLabel("Movil");
		lblMovil.setBounds(10, 141, 75, 14);
		add(lblMovil);

		Movil = new JTextField();
		Movil.setBounds(95, 138, 114, 20);
		add(Movil);
		Movil.setColumns(10);

		lblTipoDeContacto = new JLabel("Tipo de contacto");
		lblTipoDeContacto.setBounds(247, 11, 133, 14);
		add(lblTipoDeContacto);

		menu = new Choice();
		menu.setBounds(397, 5, 133, 20);
		add(menu);
		
		lblNotas = new JLabel("Notas");
		lblNotas.setBounds(247, 44, 75, 14);
		add(lblNotas);

		textPane = new JTextPane();
		textPane.setBounds(250, 69, 501, 89);
		add(textPane);

		final JButton btnOtrosCampos = new JButton("Otros Campos");
		btnOtrosCampos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JPanel viejoPanel = frame.getPanel();
				JPanel panel = new JPanelOtrosCampos(frame);
				panel.setBounds(viejoPanel.getX(), viejoPanel.getY(),
						viejoPanel.getWidth(), viejoPanel.getHeight());
				frame.remove(viejoPanel);
				frame.setPanel(panel);
				frame.getContentPane().add(panel);
				frame.validate();
				frame.repaint();
			}
		});
		btnOtrosCampos.setBounds(39, 205, 133, 23);
		add(btnOtrosCampos);

		JButton btnDescartar = new JButton("Descartar");
		btnDescartar.setBounds(734, 536, 101, 23);
		add(btnDescartar);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(845, 536, 89, 23);
		add(btnGuardar);

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JFramePrincipal getFrame() {
		return frame;
	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public JTextField getNombre() {
		return nombre;
	}

	public JLabel getLblApellidos() {
		return lblApellidos;
	}

	public JTextField getApellidos() {
		return apellidos;
	}

	public JLabel getLblDireccion() {
		return lblDireccion;
	}

	public JTextField getDireccion() {
		return Direccion;
	}

	public JLabel getLblCiudad() {
		return lblCiudad;
	}

	public JTextField getCiudad() {
		return Ciudad;
	}

	public JLabel getLblMovil() {
		return lblMovil;
	}

	public JTextField getMovil() {
		return Movil;
	}

	public JLabel getLblTipoDeContacto() {
		return lblTipoDeContacto;
	}

	public Choice getMenu() {
		return menu;
	}

	public JLabel getLblNotas() {
		return lblNotas;
	}

	public JTextPane getTextPane() {
		return textPane;
	}
}
