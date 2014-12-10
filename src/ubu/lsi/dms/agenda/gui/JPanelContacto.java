package ubu.lsi.dms.agenda.gui;

import java.awt.Choice;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import ubu.lsi.dms.agenda.modelo.Contacto;

import com.sun.corba.se.spi.orbutil.fsm.Action;

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
	private JTextPane notas;
	private JButton btnGuardar;
	private JButton btnDescartar;
	private JButton btnOtrosCampos;
	private JPanelOtrosCampos otrosCampos ;	

	public JPanelContacto() {
		setLayout(null);

		otrosCampos=new JPanelOtrosCampos(this);
		otrosCampos.setBounds(this.getX(), this.getY(),
				this.getWidth(), this.getHeight());
		
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

		notas = new JTextPane();
		notas.setBounds(250, 69, 501, 89);
		add(notas);

		btnOtrosCampos = new JButton("Otros Campos");
		btnOtrosCampos.setBounds(39, 205, 133, 23);
		add(btnOtrosCampos);

		btnDescartar = new JButton("Descartar");
		btnDescartar.setBounds(734, 536, 101, 23);
		add(btnDescartar);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(845, 536, 89, 23);
		add(btnGuardar);

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JFramePrincipal getFrame() {
		return frame;
	}

	public String getNombre() {
		return nombre.getText();
	}

	public String getApellidos() {
		return apellidos.getText();
	}

	public String getDireccion() {
		return Direccion.toString();
	}

	public String getCiudad() {
		return Ciudad.getText();
	}

	public String getMovil() {
		return Movil.getText();
	}

	public void setNotas(String texto) {
		notas.setText(texto);

	}

	public void setNombre(String texto) {
		nombre.setText(texto);
	}

	public void setApellidos(String texto) {
		apellidos.setText(texto);
	}

	public void setDireccion(String texto) {
		Direccion.setText(texto);
	}

	public void setCiudad(String texto) {
		Ciudad.setText(texto);
	}

	public void setMovil(String texto) {
		Movil.setText(texto);
	}

	public String getNotas() {
		return notas.getText();
	}

	public String getTipoCotacto() {
		return menu.getSelectedItem();
	}

	public void añadirElementoListaMenu(String item) {
		menu.add(item);

	}

	public void añadirListenerGuardar(ActionListener listener) {
		btnGuardar.addActionListener(listener);

	}

	public void añadirListenerDescartarContacto(ActionListener listener) {
		btnDescartar.addActionListener(listener);

	}
	
	public void añadirListenerOtrosCampos(ActionListener listener) {
		btnOtrosCampos.addActionListener(listener);

	}
	
	public void añadirListenerDescartarOtrosCampos(ActionListener listener){
		otrosCampos.getBtnDescartar().addActionListener(listener);
	}
	
	public void añadirListenerGuardarOtrosCampos(ActionListener listener){
		otrosCampos.getBtnGuardar().addActionListener(listener);
	}
	
	public void setFrame(JFramePrincipal frame){
		this.frame=frame;
	}

	public void abrirOtrosCampos() {
		otrosCampos.setVisible(true);
		this.setVisible(false);
		frame.setPanel(otrosCampos);
		frame.validate();
		frame.repaint();
	}
	
	public void cerrarOtrosCampos(){
		otrosCampos.setVisible(false);
		setVisible(true);
		frame.setPanel(this);
		frame.validate();
		frame.repaint();
	}
	
	public void resetMenu(){
		menu.select(0);
	}
	
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
		private JButton btnDescartar;
		private JButton btnGuardar;
		
		/**
		 * Create the panel.
		 */		
		public JPanelOtrosCampos(final JPanelContacto contacto) {
			setLayout(null);
			setVisible(false);
			
			btnGuardar = new JButton("Guardar");
			btnGuardar.setBounds(845, 536, 89, 23);
			add(btnGuardar);
			
			btnDescartar = new JButton("Descartar");
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
		
		public JButton getBtnGuardar() {
			return btnGuardar;
		}

		public JButton getBtnDescartar() {
			return btnDescartar;
		}
	}
}
