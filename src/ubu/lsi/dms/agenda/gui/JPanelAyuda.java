package ubu.lsi.dms.agenda.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class JPanelAyuda extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFramePrincipal frame;

	/**
	 * Create the panel.
	 */
	public JPanelAyuda() {
		setLayout(null);
		
		JLabel lblAyudaDeAgenda = new JLabel("Ayuda de Agenda");
		lblAyudaDeAgenda.setBounds(10, 11, 141, 14);
		add(lblAyudaDeAgenda);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 36, 924, 523);
		add(textPane);
		textPane.setEditable(false);
		textPane.setText("Acerca de:\n"
				+ "Aplicación de Agenda destinada a la aplicación de patrones de diseño, "
				+ "en la asignatura de Diseño y Mantenimiento de Equipos Informáticos.\n\n"
				+ "Creado por:\n"
				+ "\tRoberto Miranda\n"
				+ "\tAsier Alonso\n"
				+ "\tJorge Laguna\n"
				+ "\tDaniel Lozano\n\n"
				+ "Funcionalidad:\n"
				+ "Con esta agenda se pretende poder añadir, modificar o consultar un conjunto "
				+ "de contactos, llamadas o tipos de contacto, según la necesidad del usuario.\n"
				+ "A la hora de la programación, no se utiliza en un contexto de persistencia, sino "
				+ "con colecciones, para centrarnos en los patrones.\n\n"
				+ "Si tiene alguna duda, contacte con nosotros:\n"
				+ "\t-jld0016@alu.ubu.es - Jorge Laguna\n"
				+ "\t-rmp0046@alu.ubu.es - Roberto Miranda\n"
				+ "\t-aam0093@alu.ubu.es - Asier Alonso\n"
				+ "\t-dlr0008@alu.ubu.es - Daniel Lozano\n");
	}

	public void setFrame(JFramePrincipal frame) {
		this.frame=frame;
		
	}
}
