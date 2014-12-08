package ubu.lsi.dms.agenda.gui;

import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class JMenuAgenda extends JPanel {

	private static final long serialVersionUID = 1L;

	private JMenuBar menuBar;
	private JMenu mnInsertar;
	private JMenuItem mntmNuevoContacto;
	private JMenuItem mntnNuevoContacto;
	private JMenuItem mntmNuevoTipocontacto;
	private JMenu mnModificar;
	private JMenuItem mntmContacto;
	private JMenuItem mntmLlamada;
	private JMenuItem mntmTipoDeContacto;
	private JMenu mnConsultar;
	private JMenuItem mntmNuevaConsulta;
	private JMenu mnAyuda;
	private JMenuItem mntmAyuda;
	private JMenuItem mntnNuevoLlamada;

	public JMenuAgenda() {
		setLayout(null);
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 950, 25);
		add(menuBar);

		mnInsertar = new JMenu("Insertar");
		menuBar.add(mnInsertar);

		mntmNuevoContacto = new JMenuItem("Nuevo Contacto");
		mnInsertar.add(mntmNuevoContacto);

		mntnNuevoLlamada = new JMenuItem("Nueva Llamada");
		mnInsertar.add(mntnNuevoLlamada);

		mntmNuevoTipocontacto = new JMenuItem("Nuevo Tipo de Contacto");
		mnInsertar.add(mntmNuevoTipocontacto);

		mnModificar = new JMenu("Modificar");
		menuBar.add(mnModificar);

		mntmContacto = new JMenuItem("Contacto");
		mnModificar.add(mntmContacto);

		mntmLlamada = new JMenuItem("Llamada");
		mnModificar.add(mntmLlamada);

		mntmTipoDeContacto = new JMenuItem("Tipo de Contacto");
		mnModificar.add(mntmTipoDeContacto);

		mnConsultar = new JMenu("Consultar");
		menuBar.add(mnConsultar);

		mntmNuevaConsulta = new JMenuItem("Nueva Consulta");
		mnConsultar.add(mntmNuevaConsulta);

		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);

		mntmAyuda = new JMenuItem("Manual");
		mnAyuda.add(mntmAyuda);

	}

	public JMenuItem getMntnNuevoLlamada() {
		return mntnNuevoLlamada;
	}


	public JMenuBar getMenuBar() {
		return menuBar;
	}

	public JMenu getMnInsertar() {
		return mnInsertar;
	}

	public JMenuItem getMntmNuevoContacto() {
		return mntmNuevoContacto;
	}

	public JMenuItem getMntnNuevoContacto() {
		return mntnNuevoContacto;
	}

	public JMenuItem getMntmNuevoTipocontacto() {
		return mntmNuevoTipocontacto;
	}

	public JMenu getMnModificar() {
		return mnModificar;
	}

	public JMenuItem getMntmContacto() {
		return mntmContacto;
	}

	public JMenuItem getMntmLlamada() {
		return mntmLlamada;
	}

	public JMenuItem getMntmTipoDeContacto() {
		return mntmTipoDeContacto;
	}

	public JMenu getMnConsultar() {
		return mnConsultar;
	}

	public JMenuItem getMntmNuevaConsulta() {
		return mntmNuevaConsulta;
	}

	public JMenu getMnAyuda() {
		return mnAyuda;
	}

	public JMenuItem getMntmAyuda() {
		return mntmAyuda;
	}

}
