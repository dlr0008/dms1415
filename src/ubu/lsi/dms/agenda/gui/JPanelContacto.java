package ubu.lsi.dms.agenda.gui;

import java.awt.Choice;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import ubu.lsi.dms.agenda.modelo.TipoContacto;
import ubu.lsi.dms.agenda.test.TestGui;

public class JPanelContacto extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JFramePrincipal frame = null;

	/**
	 * Create the panel.
	 */
	public JPanelContacto(JFramePrincipal jFramePrincipal) {
		frame = jFramePrincipal;
		setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 11, 75, 14);
		add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(95, 8, 114, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(10, 44, 75, 14);
		add(lblApellidos);
		
		textField_1 = new JTextField();
		textField_1.setBounds(95, 41, 114, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(10, 79, 75, 14);
		add(lblDireccion);
		
		textField_2 = new JTextField();
		textField_2.setBounds(95, 76, 114, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(95, 107, 114, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(95, 138, 114, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setBounds(10, 110, 75, 14);
		add(lblCiudad);
		
		JLabel lblMovil = new JLabel("Movil");
		lblMovil.setBounds(10, 141, 75, 14);
		add(lblMovil);
		
		JLabel lblTipoDeContacto = new JLabel("Tipo de contacto");
		lblTipoDeContacto.setBounds(247, 11, 133, 14);
		add(lblTipoDeContacto);
		
		final Choice menu = new Choice();
		menu.setBounds(397, 5, 133, 20);
		add(menu);
		for (int i = 1; i <= TestGui.tipos.size(); i++){
			menu.add(((TipoContacto) TestGui.tipos.toArray()[i-1]).getTipoContacto());
		}
		JLabel lblNotas = new JLabel("Notas");
		lblNotas.setBounds(247, 44, 75, 14);
		add(lblNotas);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(250, 69, 501, 89);
		add(textPane);

		
		final JButton btnOtrosCampos = new JButton("Otros Campos");
		btnOtrosCampos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JPanel viejoPanel = frame.getPanel();
				JPanel panel=new JPanelOtrosCampos(frame);
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
}
