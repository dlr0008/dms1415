package ubu.lsi.dms.agenda.gui;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.TipoContacto;

/**
 * @author <A HREF="mailto:jld0016@alu.ubu.es">Jorge Laguna</A>
 * @author <A HREF="mailto:rmp0046@alu.ubu.es">Roberto Miranda</A>
 * @author <A HREF="mailto:aam0093@alu.ubu.es">Asier Alonso</A>
 * @author <A HREF="mailto:dlr0008@alu.ubu.es">Daniel Lozano</A>
 * @version 1.0
 * 
 *          JPanel que contiene el panel para poder insertar y modificar
 *          contactos , Es observador Concreto, ya que cuando se actualiza la
 *          lista de contactos se debe actualizar la tabla, tambien cuando se
 *          actualizan los tipos de contacto, se recarga la lista de selecion de
 *          estos
 * 
 */
public class JPanelContacto extends JPanel implements Observer {

	private static final long serialVersionUID = 9166276019426152339L;

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
	public JPanelOtrosCampos otrosCampos;
	private JTable table;
	private JScrollPane scrollPane;

	public JPanelContacto(JFramePrincipal frame) {
		setLayout(null);
		this.frame = frame;
		otrosCampos = new JPanelOtrosCampos();
		otrosCampos.setBounds(this.getX(), this.getY(), this.getWidth(),
				this.getHeight());

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

	public long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNombre() {
		return nombre.getText();
	}

	public String getApellidos() {
		return apellidos.getText();
	}

	public String getDireccion() {
		return Direccion.getText();
	}

	public String getCiudad() {
		return Ciudad.getText();
	}

	public String getMovil() {
		return Movil.getText();
	}

	public String getNotas() {
		return notas.getText();
	}

	public String getTipoContacto() {
		return menu.getSelectedItem();
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

	public void setNotas(String texto) {
		notas.setText(texto);

	}

	public String setTipoDeContacto() {
		return notas.getText();
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

	public void añadirListenerDescartarOtrosCampos(ActionListener listener) {
		otrosCampos.getBtnDescartar().addActionListener(listener);
	}

	public void añadirListenerGuardarOtrosCampos(ActionListener listener) {
		otrosCampos.getBtnGuardar().addActionListener(listener);
	}

	/**
	 * Coloca en el SrollPanel una tabla pasada por parametro
	 * 
	 * @param tabla
	 */
	public void recargarTabla(JTable tabla) {
		table = tabla;
		if (scrollPane != null)
			remove(scrollPane);
		JScrollPane nuevaLista = new JScrollPane(tabla);
		nuevaLista.setBounds(18, 250, 915, 200);

		if (tabla.getRowCount() == 0)
			JOptionPane.showMessageDialog(null, "Lista Vacia");

		nuevaLista
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		nuevaLista
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane = nuevaLista;
		add(nuevaLista);
		validate();
		repaint();
	}

	public void añadirListenerTabla(MouseListener listener) {
		table.addMouseListener(listener);

	}

	public int getFilaSeleccionada() {
		return table.getSelectedRow();

	}

	/**
	 * Abre el panel de otros Campos
	 * 
	 */
	public void abrirOtrosCampos() {
		otrosCampos.setVisible(true);
		this.setVisible(false);
		frame.setPanel(otrosCampos);
		frame.validate();
		frame.repaint();
	}

	/**
	 * Cierra el Panel de Otros Campos
	 * 
	 */
	public void cerrarOtrosCampos() {
		otrosCampos.setVisible(false);
		setVisible(true);
		frame.setPanel(this);
		frame.validate();
		frame.repaint();
	}

	public void resetMenu() {
		menu.select(0);
	}

	public JPanelOtrosCampos otrosCampos() {
		return otrosCampos;
	}

	public boolean compruebaVacios() {
		if ((nombre.getText().equals("")) || apellidos.getText().equals("")
				|| Direccion.getText().equals("")
				|| Ciudad.getText().equals("") || Movil.getText().equals("")
				|| notas.getText().equals("")) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Activa los campos para editar
	 * 
	 */
	public void activarCampos() {
		nombre.setEnabled(true);
		nombre.setBackground(Color.WHITE);
		Direccion.setEnabled(true);
		Direccion.setBackground(Color.WHITE);
		Ciudad.setEnabled(true);
		Ciudad.setBackground(Color.WHITE);
		Movil.setEnabled(true);
		Movil.setBackground(Color.WHITE);
		notas.setEnabled(true);
		notas.setBackground(Color.WHITE);
		btnGuardar.setEnabled(true);

	}

	/**
	 * @author <A HREF="mailto:jld0016@alu.ubu.es">Jorge Laguna</A>
	 * @author <A HREF="mailto:rmp0046@alu.ubu.es">Roberto Miranda</A>
	 * @author <A HREF="mailto:aam0093@alu.ubu.es">Asier Alonso</A>
	 * @author <A HREF="mailto:dlr0008@alu.ubu.es">Daniel Lozano</A>
	 * @version 1.0
	 * 
	 *          JPanel que contiene el panel auziliar que se utiliza para los
	 *          otros campos
	 * 
	 * 
	 */
	public class JPanelOtrosCampos extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = -5872441684715554417L;
		private JTextField estimado;
		private JTextField prov;
		private JTextField codPostal;
		private JTextField region;
		private JTextField pais;
		private JTextField nombreCompania;
		private JTextField cargo;
		private JTextField telefonoTrabajo;
		private JTextField extensionTrabajo;
		private JTextField fax;
		private JTextField nomCorreoElectronico;
		private JButton btnDescartar;
		private JButton btnGuardar;

		/**
		 * Create the panel.
		 */
		public JPanelOtrosCampos() {
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

			estimado = new JTextField();
			estimado.setBounds(105, 8, 86, 20);
			add(estimado);
			estimado.setColumns(10);

			prov = new JTextField();
			prov.setBounds(105, 43, 86, 20);
			add(prov);
			prov.setColumns(10);

			codPostal = new JTextField();
			codPostal.setBounds(105, 80, 86, 20);
			add(codPostal);
			codPostal.setColumns(10);

			region = new JTextField();
			region.setBounds(105, 118, 86, 20);
			add(region);
			region.setColumns(10);

			JLabel lblNewLabel_3 = new JLabel("Pais");
			lblNewLabel_3.setBounds(10, 163, 46, 14);
			add(lblNewLabel_3);

			pais = new JTextField();
			pais.setBounds(105, 160, 86, 20);
			add(pais);
			pais.setColumns(10);

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

			nombreCompania = new JTextField();
			nombreCompania.setBounds(397, 8, 86, 20);
			add(nombreCompania);
			nombreCompania.setColumns(10);

			cargo = new JTextField();
			cargo.setBounds(397, 43, 86, 20);
			add(cargo);
			cargo.setColumns(10);

			telefonoTrabajo = new JTextField();
			telefonoTrabajo.setBounds(397, 80, 86, 20);
			add(telefonoTrabajo);
			telefonoTrabajo.setColumns(10);

			extensionTrabajo = new JTextField();
			extensionTrabajo.setBounds(397, 118, 86, 20);
			add(extensionTrabajo);
			extensionTrabajo.setColumns(10);

			fax = new JTextField();
			fax.setBounds(397, 160, 86, 20);
			add(fax);
			fax.setColumns(10);

			JLabel lblNewLabel_9 = new JLabel("Correo Electronico");
			lblNewLabel_9.setBounds(566, 11, 105, 14);
			add(lblNewLabel_9);

			nomCorreoElectronico = new JTextField();
			nomCorreoElectronico.setBounds(681, 8, 177, 20);
			add(nomCorreoElectronico);
			nomCorreoElectronico.setColumns(10);
		}

		public String getEstimado() {
			return estimado.getText();
		}

		public void setEstimado(String texto) {
			estimado.setText(texto);
		}

		public String getProv() {
			return prov.getText();
		}

		public void setProv(String texto) {
			prov.setText(texto);
		}

		public String getCodPostal() {
			return codPostal.getText();
		}

		public void setCodPostal(String texto) {
			codPostal.setText(texto);
		}

		public String getRegion() {
			return region.getText();
		}

		public void setRegion(String texto) {
			region.setText(texto);
		}

		public String getPais() {
			return pais.getText();
		}

		public void setPais(String texto) {
			pais.setText(texto);
		}

		public String getNombreCompania() {
			return nombreCompania.getText();
		}

		public void setNombreCompania(String texto) {
			nombreCompania.setText(texto);
		}

		public String getCargo() {
			return cargo.getText();
		}

		public void setCargo(String texto) {
			cargo.setText(texto);
		}

		public String getTelefonoTrabajo() {
			return telefonoTrabajo.getText();
		}

		public void setTelefonoTrabajo(String texto) {
			telefonoTrabajo.setText(texto);
		}

		public String getExtensionTrabajo() {
			return extensionTrabajo.getText();
		}

		public void setExtensionTrabajo(String texto) {

			extensionTrabajo.setText(texto);
		}

		public JButton getBtnGuardar() {
			return btnGuardar;
		}

		public JButton getBtnDescartar() {
			return btnDescartar;
		}

		public String getFax() {
			return fax.getText();
		}

		public void setFax(String texto) {
			fax.setText(texto);
		}

		public String getNomCorreoElectronico() {
			return nomCorreoElectronico.getText();
		}

		public void setNomCorreoElectronico(String texto) {
			nomCorreoElectronico.setText(texto);
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 instanceof Contacto)
			frame.añadirContacto(arg1);

		if (arg1 instanceof TipoContacto)
			añadirElementoListaMenu(((TipoContacto) arg1).getTipoContacto());
	}
}
