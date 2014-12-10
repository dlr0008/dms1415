package ubu.lsi.dms.agenda.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ubu.lsi.dms.agenda.gui.JFramePrincipal;
import ubu.lsi.dms.agenda.gui.JPanelTipo;
import ubu.lsi.dms.agenda.modelo.ModelTemporal;

public class MediadorNuevoTipo {

	private JPanelTipo panelNuevoTipo;
	private ModelTemporal modelo;

	public MediadorNuevoTipo(JFramePrincipal frame, ModelTemporal modelo) {

		this.modelo = modelo;
		panelNuevoTipo = (JPanelTipo) frame.getPanel();
		panelNuevoTipo.setFrame(frame);

		panelNuevoTipo.añadirListenerGuardar(guardarTipo());
		panelNuevoTipo.añadirListenerDescartarContacto(descartarCampos());

	}

	private ActionListener guardarTipo() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Tipo Guardado");
				//Añadir aqui la funcion para guardar los campos del contacto y otros
				resetCampos();
			}
		};
	}

	private boolean comprobarTipos() {
		return false;

	}

	private void resetCampos() {

		panelNuevoTipo.setTextField("");
	}

	private ActionListener descartarCampos() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				resetCampos();

			}
		};
	}
	

	


}
