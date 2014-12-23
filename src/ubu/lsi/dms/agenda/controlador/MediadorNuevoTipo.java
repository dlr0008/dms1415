package ubu.lsi.dms.agenda.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ubu.lsi.dms.agenda.gui.JFramePrincipal;
import ubu.lsi.dms.agenda.gui.JPanelTipo;
import ubu.lsi.dms.agenda.modelo.ModelTemporal;
import ubu.lsi.dms.agenda.modelo.TipoContacto;

/**
 * @author <A HREF="mailto:jld0016@alu.ubu.es">Jorge Laguna</A>
 * @author <A HREF="mailto:rmp0046@alu.ubu.es">Roberto Miranda</A>
 * @author <A HREF="mailto:aam0093@alu.ubu.es">Asier Alonso</A>
 * @author <A HREF="mailto:dlr0008@alu.ubu.es">Daniel Lozano</A>
 * @version 1.0
 * 
 *          Clase que implementa el Patron mediador, se encarga del manejo de el
 *          Jpanel de tipos de contacto, modificandolo para el caso de uso de
 *          modificar tipos de contacto, tambien el patron comando asignado los
 *          listener a los distintos elementos.
 */
public class MediadorNuevoTipo {

	private JPanelTipo panelNuevoTipo;
	private ModelTemporal modelo;

	public MediadorNuevoTipo(JFramePrincipal frame, ModelTemporal modelo) {

		this.modelo = modelo;
		panelNuevoTipo = new JPanelTipo(frame);
		panelNuevoTipo.añadirListenerGuardar(guardarTipo());
		panelNuevoTipo.añadirListenerDescartarContacto(descartarCampos());
		modelo.getTipos().addObserver(panelNuevoTipo);

	}

	private ActionListener guardarTipo() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Tipo Guardado");
				creaNuevoTipo();
				resetCampos();
			}
		};
	}

	private void creaNuevoTipo() {
		int idContacto = modelo.getTipos().size() + 1;
		String tContacto = panelNuevoTipo.getTipoContacto();
		TipoContacto tipoContacto = new TipoContacto(idContacto, tContacto);
		modelo.getTipos().addTipo(tipoContacto);
	}

	private void resetCampos() {
		panelNuevoTipo.setTipoContacto("");
	}

	private ActionListener descartarCampos() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				resetCampos();
			}
		};
	}

	public JPanel getPanelAsociado() {
		return panelNuevoTipo;
	}

}
