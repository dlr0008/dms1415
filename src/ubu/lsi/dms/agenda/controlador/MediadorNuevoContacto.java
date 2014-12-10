package ubu.lsi.dms.agenda.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JOptionPane;

import ubu.lsi.dms.agenda.gui.JFramePrincipal;
import ubu.lsi.dms.agenda.gui.JPanelContacto;
import ubu.lsi.dms.agenda.modelo.ModelTemporal;
import ubu.lsi.dms.agenda.modelo.TipoContacto;

public class MediadorNuevoContacto {

	private JPanelContacto panelNuevoContacto;
	private ModelTemporal modelo;

	public MediadorNuevoContacto(JFramePrincipal frame, ModelTemporal modelo) {

		this.modelo = modelo;
		panelNuevoContacto = (JPanelContacto) frame.getPanel();
		panelNuevoContacto.setFrame(frame);

		Collection<TipoContacto> tipos = this.modelo.getTipos();
		for (TipoContacto t : tipos)
			panelNuevoContacto.añadirElementoListaMenu(t.getTipoContacto());
		panelNuevoContacto.añadirListenerGuardar(guardarContacto());
		panelNuevoContacto.añadirListenerDescartarContacto(descartarCampos());
		panelNuevoContacto.añadirListenerOtrosCampos(otrosCampos());
		panelNuevoContacto.añadirListenerDescartarOtrosCampos(DescartarPanelOtrosCampos());
		panelNuevoContacto.añadirListenerGuardarOtrosCampos(guardarContacto());

	}

	private ActionListener guardarContacto() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelNuevoContacto.cerrarOtrosCampos();
				JOptionPane.showMessageDialog(null, "Contacto Guardado");
				//Añadir aqui la funcion para guardar los campos del contacto y otros
				resetCampos();
			}
		};
	}

	private boolean comprobarTipos() {
		return false;

	}

	private void resetCampos() {

		panelNuevoContacto.setNombre("");
		panelNuevoContacto.setApellidos("");
		panelNuevoContacto.setCiudad("");
		panelNuevoContacto.setDireccion("");
		panelNuevoContacto.setMovil("");
		panelNuevoContacto.resetMenu();
	}

	private ActionListener descartarCampos() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				resetCampos();

			}
		};
	}
	
	private ActionListener otrosCampos() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelNuevoContacto.abrirOtrosCampos();

			}
		};
	}
	
	private ActionListener DescartarPanelOtrosCampos(){
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelNuevoContacto.cerrarOtrosCampos();

			}
		};
	}
}
