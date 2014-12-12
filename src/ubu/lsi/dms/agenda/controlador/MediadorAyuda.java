package ubu.lsi.dms.agenda.controlador;

import ubu.lsi.dms.agenda.gui.JFramePrincipal;
import ubu.lsi.dms.agenda.gui.JPanelAyuda;
import ubu.lsi.dms.agenda.gui.JPanelTipo;
import ubu.lsi.dms.agenda.modelo.ModelTemporal;



public class MediadorAyuda {
	
	private JPanelAyuda panelAyuda;
	
	public MediadorAyuda(JFramePrincipal frame, ModelTemporal modelo) {
		panelAyuda = (JPanelAyuda) frame.getPanel();
		panelAyuda.setFrame(frame);
	}
}
