package ubu.lsi.dms.agenda.gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ubu.lsi.dms.agenda.modelo.TipoContacto;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class JPanelTipo extends JPanel implements Observer {
	/**
	 * 
	 */
	private JFramePrincipal frame;
	private static final long serialVersionUID = 1L;
	private static JTextField tipo;
	JButton btnDescartar;
	JButton btnGuardar;

	/**
	 * Create the panel.
	 */
	public JPanelTipo(JFramePrincipal frame) {
		setLayout(null);
		this.frame = frame;
		btnDescartar = new JButton("Descartar");
		btnDescartar.setBounds(734, 536, 101, 23);
		add(btnDescartar);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(845, 536, 89, 23);
		add(btnGuardar);

		JLabel lblTipoDeContacto = new JLabel("Tipo de Contacto");
		lblTipoDeContacto.setBounds(10, 11, 101, 14);
		add(lblTipoDeContacto);

		tipo = new JTextField();
		tipo.setBounds(135, 8, 86, 20);
		add(tipo);
		tipo.setColumns(10);
	}

	public static String getTextField() {
		return tipo.getText();
	}

	public void añadirListenerGuardar(ActionListener listener) {
		btnGuardar.addActionListener(listener);

	}

	public void añadirListenerDescartarContacto(ActionListener listener) {
		btnDescartar.addActionListener(listener);

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		frame.añadirTipoContacto((TipoContacto) arg1);

	}

	public void setTipoContacto(String string) {
		tipo.setText(string);

	}

}
