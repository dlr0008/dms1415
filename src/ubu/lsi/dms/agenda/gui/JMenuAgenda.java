package ubu.lsi.dms.agenda.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ubu.lsi.dms.agenda.test.TestGui;

public class JMenuAgenda extends JPanel {

	private JFramePrincipal frame = null;
	private static final long serialVersionUID = 1L;
	private JPanelConsulta panelConsultas = null;
	private JPanelTipo panelTipos = null;

	public JMenuAgenda(JFramePrincipal jFramePrincipal, TestGui testGui) {
		setLayout(null);
		frame = jFramePrincipal;
		panelConsultas = new JPanelConsulta(testGui);
		panelTipos = new JPanelTipo();
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 950, 25);
		add(menuBar);

		javax.swing.JMenu mnInsertar = new javax.swing.JMenu("Insertar");
		menuBar.add(mnInsertar);

		JMenuItem mntmNewMenuItem = new JMenuItem("Nuevo Contacto");
		mntmNewMenuItem.addActionListener(new menuChange(
				new JPanelContacto(frame)));
		mnInsertar.add(mntmNewMenuItem);

		JMenuItem menuItem = new JMenuItem("Nueva Llamada");
		menuItem.addActionListener(new menuChange(
				new JPanelLlamada()));
		mnInsertar.add(menuItem);

		JMenuItem mntmNuevoTipocontacto = new JMenuItem(
				"Nuevo Tipo de Contacto");
		mntmNuevoTipocontacto.addActionListener(new menuChange(panelTipos));
		mnInsertar.add(mntmNuevoTipocontacto);

		javax.swing.JMenu mnModificar = new javax.swing.JMenu("Modificar");
		menuBar.add(mnModificar);

		JMenuItem mntmContacto = new JMenuItem("Contacto");
		mntmContacto.addActionListener(new menuChange(
				new JPanelContacto(frame)));
		mnModificar.add(mntmContacto);

		JMenuItem mntmLlamada = new JMenuItem("Llamada");
		mntmLlamada.addActionListener(new menuChange(
				new JPanelLlamada()));
		mnModificar.add(mntmLlamada);

		JMenuItem mntmTipoDeContacto = new JMenuItem("Tipo de Contacto");
		mntmTipoDeContacto.addActionListener(new menuChange(panelTipos));
		mnModificar.add(mntmTipoDeContacto);

		javax.swing.JMenu mnConsultar = new javax.swing.JMenu("Consultar");
		menuBar.add(mnConsultar);

		JMenuItem mntmNuevaConsulta = new JMenuItem("Nueva Consulta");
		mntmNuevaConsulta.addActionListener(new menuChange(panelConsultas));
		mnConsultar.add(mntmNuevaConsulta);

		javax.swing.JMenu mnAyuda = new javax.swing.JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAyuda = new JMenuItem("Manual");
		mntmAyuda.addActionListener(new menuChange(new JPanelAyuda()));
		mnAyuda.add(mntmAyuda);
		
		
	}

	class menuChange implements ActionListener {
		JPanel panel = null;

		public menuChange(JPanel panel) {
			this.panel = panel;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			JPanel viejoPanel = frame.getPanel();
			panel.setBounds(viejoPanel.getX(), viejoPanel.getY(),
					viejoPanel.getWidth(), viejoPanel.getHeight());
			frame.remove(viejoPanel);
			frame.setPanel(panel);
			frame.add(panel);
			frame.validate();
			frame.repaint();
		}
	}
}
