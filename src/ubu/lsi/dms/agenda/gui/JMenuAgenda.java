package ubu.lsi.dms.agenda.gui;

import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class JMenuAgenda extends JPanel {
	public JMenuAgenda() {
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 256, 50);
		add(menuBar);
		
		javax.swing.JMenu mnInsertar = new javax.swing.JMenu("Insertar");
		menuBar.add(mnInsertar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Nuevo Contacto");
		mnInsertar.add(mntmNewMenuItem);
		
		JMenuItem menuItem = new JMenuItem("Nueva Llamada");
		mnInsertar.add(menuItem);
		
		JMenuItem mntmNuevoTipocontacto = new JMenuItem("Nuevo Tipo de Contacto");
		mnInsertar.add(mntmNuevoTipocontacto);
		
		javax.swing.JMenu mnModificar = new javax.swing.JMenu("Modificar");
		menuBar.add(mnModificar);
		
		JMenuItem mntmContacto = new JMenuItem("Contacto");
		mnModificar.add(mntmContacto);
		
		JMenuItem mntmLlamada = new JMenuItem("Llamada");
		mnModificar.add(mntmLlamada);
		
		JMenuItem mntmTipoDeContacto = new JMenuItem("Tipo de Contacto");
		mnModificar.add(mntmTipoDeContacto);
		
		javax.swing.JMenu mnConsultar = new javax.swing.JMenu("Consultar");
		menuBar.add(mnConsultar);
		
		javax.swing.JMenu mnAyuda = new javax.swing.JMenu("Ayuda");
		menuBar.add(mnAyuda);
	}
}


