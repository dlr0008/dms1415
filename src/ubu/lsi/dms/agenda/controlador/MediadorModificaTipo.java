package ubu.lsi.dms.agenda.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ubu.lsi.dms.agenda.gui.JFramePrincipal;
import ubu.lsi.dms.agenda.gui.JPanelTipo;
import ubu.lsi.dms.agenda.modelo.ModelTemporal;

public class MediadorModificaTipo {

	private JPanelTipo panelModificaTipo;
	private ModelTemporal modelo;

	public MediadorModificaTipo(JFramePrincipal frame, ModelTemporal modelo) {

		this.modelo = modelo;
		panelModificaTipo = (JPanelTipo) frame.getPanel();
		panelModificaTipo.setFrame(frame);

		panelModificaTipo.añadirListenerGuardar(guardarTipo());
		panelModificaTipo.añadirListenerDescartarContacto(descartarCampos());

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
		panelModificaTipo.setTextField("");
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
