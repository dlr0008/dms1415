package ubu.lsi.dms.agenda.gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JPanelOtrosCampos extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JFramePrincipal frame = null;

	/**
	 * Create the panel.
	 */
	public JPanelOtrosCampos(JFramePrincipal jFramePrincipal) {
		frame = jFramePrincipal;
		setLayout(null);
		
		JButton btnGuardar = new JButton("Guardar");		
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel viejoPanel = frame.getPanel();
				JPanel panel=new JPanelNuevoContacto(frame);
				panel.setBounds(viejoPanel.getX(), viejoPanel.getY(),
						viejoPanel.getWidth(), viejoPanel.getHeight());
				frame.remove(viejoPanel);
				frame.setPanel(panel);
				frame.add(panel);
				frame.validate();
				frame.repaint();
			}
		});
		btnGuardar.setBounds(845, 536, 89, 23);
		add(btnGuardar);
		
		JButton btnDescartar = new JButton("Descartar");
		btnDescartar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel viejoPanel = frame.getPanel();
				JPanel panel=new JPanelNuevoContacto(frame);
				panel.setBounds(viejoPanel.getX(), viejoPanel.getY(),
						viejoPanel.getWidth(), viejoPanel.getHeight());
				frame.remove(viejoPanel);
				frame.setPanel(panel);
				frame.add(panel);
				frame.validate();
				frame.repaint();
			}
		});
		btnDescartar.setBounds(738, 536, 97, 23);
		add(btnDescartar);
		
		JLabel lblNewLabel = new JLabel("Estimado");
		lblNewLabel.setBounds(10, 11, 74, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Provincia");
		lblNewLabel_1.setBounds(10, 46, 74, 14);
		add(lblNewLabel_1);
		
		JLabel label = new JLabel("Cod. Postal");
		label.setBounds(10, 83, 74, 14);
		add(label);
		
		JLabel lblNewLabel_2 = new JLabel("Region");
		lblNewLabel_2.setBounds(10, 121, 74, 14);
		add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(105, 8, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(105, 43, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(105, 80, 86, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(105, 118, 86, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Pais");
		lblNewLabel_3.setBounds(10, 163, 46, 14);
		add(lblNewLabel_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(105, 160, 86, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre Compañia");
		lblNewLabel_4.setBounds(282, 11, 105, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Cargo");
		lblNewLabel_5.setBounds(282, 46, 74, 14);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Tfn. Trabajo");
		lblNewLabel_6.setBounds(282, 83, 97, 14);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Extension Trabajo");
		lblNewLabel_7.setBounds(282, 121, 97, 14);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Num. Fax");
		lblNewLabel_8.setBounds(282, 163, 74, 14);
		add(lblNewLabel_8);
		
		textField_5 = new JTextField();
		textField_5.setBounds(397, 8, 86, 20);
		add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(397, 43, 86, 20);
		add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(397, 80, 86, 20);
		add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(397, 118, 86, 20);
		add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(397, 160, 86, 20);
		add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Correo Electronico");
		lblNewLabel_9.setBounds(566, 11, 105, 14);
		add(lblNewLabel_9);

		textField_10 = new JTextField();
		textField_10.setBounds(681, 8, 177, 20);
		add(textField_10);
		textField_10.setColumns(10);
	}
}
