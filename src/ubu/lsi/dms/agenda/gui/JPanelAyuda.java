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

	}

	public void setFrame(JFramePrincipal frame) {
		this.frame=frame;
		
	}
}
