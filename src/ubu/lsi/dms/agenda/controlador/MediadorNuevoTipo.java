package ubu.lsi.dms.agenda.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ubu.lsi.dms.agenda.gui.JFramePrincipal;
import ubu.lsi.dms.agenda.gui.JPanelTipo;
import ubu.lsi.dms.agenda.modelo.ModelTemporal;
import ubu.lsi.dms.agenda.modelo.TipoContacto;

public class MediadorNuevoTipo {

	private JPanelTipo panelNuevoTipo;
	private ModelTemporal modelo;

	public MediadorNuevoTipo(JFramePrincipal frame,
			ModelTemporal modelo) {

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
	public JPanel getPanelAsociado(){
		return panelNuevoTipo;
	}

}
