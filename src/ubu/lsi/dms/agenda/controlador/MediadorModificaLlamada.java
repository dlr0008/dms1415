package ubu.lsi.dms.agenda.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JOptionPane;

import ubu.lsi.dms.agenda.gui.JFramePrincipal;
import ubu.lsi.dms.agenda.gui.JPanelLlamada;
import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.ModelTemporal;

public class MediadorModificaLlamada {

	private JPanelLlamada panelNuevaLlamada;
	private ModelTemporal modelo;

	public MediadorModificaLlamada(JFramePrincipal frame, ModelTemporal modelo) {

		this.modelo = modelo;
		panelNuevaLlamada = (JPanelLlamada) frame.getPanel();
		panelNuevaLlamada.setFrame(frame);

		panelNuevaLlamada.añadirListenerGuardar(guardarLlamada());
		panelNuevaLlamada.añadirListenerDescartarContacto(descartarCampos());

	}

	private ActionListener guardarLlamada() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Llamada Guardada");
				//Añadir aqui la funcion para guardar los campos del contacto y otros
				resetCampos();
			}
		};
	}

	private boolean comprobarTipos() {
		return false;

	}

	private void resetCampos() {
		panelNuevaLlamada.setTextField("");
		panelNuevaLlamada.setfecha("");
		panelNuevaLlamada.setasunto("");
		panelNuevaLlamada.setTextPane("");
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
