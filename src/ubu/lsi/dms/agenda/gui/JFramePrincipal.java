package ubu.lsi.dms.agenda.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import ubu.lsi.dms.agenda.test.TestGui;

import java.awt.Toolkit;
import java.io.File;

public class JFramePrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4560575572881828200L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	JPanel panel = null;

	/**
	 * Create the frame.
	 * 
	 * @param testGui
	 */
	public JFramePrincipal(TestGui testGui) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"." + File.separator + "images" + File.separator + "ubu.jpg"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 954, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JMenuAgenda menuAgenda = new JMenuAgenda(this,testGui);
		menuAgenda.setBounds(0, 0, 950, 25);
		contentPane.add(menuAgenda);
		panel = new JPanelConsulta(testGui);
		panel.setBounds(0, 25, 950, 925);
		contentPane.add(panel);

	}

	public void startApplication() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				setVisible(true);
			}
		});
	}

	public JPanel getPanel(){		
		return panel;
	}
	public void setPanel(JPanel nuevoPanel){
		panel= nuevoPanel;
	}
}
