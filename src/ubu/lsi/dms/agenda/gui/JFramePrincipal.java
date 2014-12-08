package ubu.lsi.dms.agenda.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import ubu.lsi.dms.agenda.test.TestGui;

import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;

public class JFramePrincipal extends JFrame {

	private static final long serialVersionUID = 4560575572881828200L;
	private JPanel contentPane;

	JPanel panel = null;

	private ArrayList<JPanel> paneles = new ArrayList<JPanel>();
	private JMenuAgenda menuAgenda;

	public JMenuAgenda getMenu() {
		return menuAgenda;
	}

	public void setMenu(JMenuAgenda menu) {
		this.menuAgenda = menu;
	}

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
		menuAgenda = new JMenuAgenda();
		menuAgenda.setBounds(0, 0, 950, 25);
		contentPane.add(menuAgenda);
		panel = new JPanelConsulta();
		panel.setBounds(0, 25, 950, 925);
		contentPane.add(panel);
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel nuevoPanel) {
		panel = nuevoPanel;
	}

	public ArrayList<JPanel> getPaneles() {
		return paneles;
	}
}
