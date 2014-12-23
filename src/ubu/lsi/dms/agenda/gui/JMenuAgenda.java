package ubu.lsi.dms.agenda.gui;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @author <A HREF="mailto:jld0016@alu.ubu.es">Jorge Laguna</A>
 * @author <A HREF="mailto:rmp0046@alu.ubu.es">Roberto Miranda</A>
 * @author <A HREF="mailto:aam0093@alu.ubu.es">Asier Alonso</A>
 * @author <A HREF="mailto:dlr0008@alu.ubu.es">Daniel Lozano</A>
 * @version 1.0
 * 
 *          JPanel que contiene el panel que maneja el menu de la aplicacion
 * 
 */

public class JMenuAgenda extends JPanel {

	private static final long serialVersionUID = 1L;

	private JMenuBar menuBar;
	private JMenu mnInsertar;
	private JMenuItem mntmNuevoContacto;
	private JMenuItem mntnNuevoLlamada;
	private JMenuItem mntmNuevoTipocontacto;
	private JMenu mnModificar;
	private JMenuItem mntmContacto;
	private JMenuItem mntmLlamada;
	private JMenuItem mntmTipoDeContacto;
	private JMenu mnConsultar;
	private JMenuItem mntmNuevaConsulta;
	private JMenu mnAyuda;
	private JMenuItem mntmAyuda;

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

	public void setListenerNuevoContacto(ActionListener menuNuevoContacto) {
		mntmNuevoContacto.addActionListener(menuNuevoContacto);

	}

	public void setListenerNuevaLLamada(ActionListener menuNuevaLlamada) {
		mntnNuevoLlamada.addActionListener(menuNuevaLlamada);

	}

	public void setListenerNuevoTipo(ActionListener menuNuevoTipo) {
		mntmNuevoTipocontacto.addActionListener(menuNuevoTipo);

	}

	public void setListenerModificaContacto(ActionListener menuModificaContacto) {
		mntmContacto.addActionListener(menuModificaContacto);

	}

	public void setListenerModificaLlamada(ActionListener menuModificaLlamada) {
		mntmLlamada.addActionListener(menuModificaLlamada);

	}

	public void setListenerModificaTipo(ActionListener menuModificaTipo) {
		mntmTipoDeContacto.addActionListener(menuModificaTipo);

	}

	public void setListenerNuevaConsulta(ActionListener menuConsulta) {
		mntmNuevaConsulta.addActionListener(menuConsulta);

	}

	public void setListenerAyuda(ActionListener menuAyuda) {
		mntmAyuda.addActionListener(menuAyuda);

	}

}
