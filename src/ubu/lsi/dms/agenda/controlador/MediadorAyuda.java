package ubu.lsi.dms.agenda.controlador;

import javax.swing.JPanel;

import ubu.lsi.dms.agenda.gui.JFramePrincipal;
import ubu.lsi.dms.agenda.gui.JPanelAyuda;
import ubu.lsi.dms.agenda.modelo.ModelTemporal;

public class MediadorAyuda {

	private JPanelAyuda panelAyuda;

	public MediadorAyuda(JFramePrincipal frame,	ModelTemporal modelo) {
		panelAyuda = new JPanelAyuda();
	}

	public JPanel getPanelAsociado() {
		return panelAyuda;
	}	
}
