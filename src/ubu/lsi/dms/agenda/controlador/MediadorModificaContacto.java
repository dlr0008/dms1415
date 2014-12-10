package ubu.lsi.dms.agenda.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JOptionPane;

import ubu.lsi.dms.agenda.gui.JFramePrincipal;
import ubu.lsi.dms.agenda.gui.JPanelContacto;
import ubu.lsi.dms.agenda.modelo.ModelTemporal;
import ubu.lsi.dms.agenda.modelo.TipoContacto;

public class MediadorModificaContacto {

	private JPanelContacto panelModificaContacto;
	private ModelTemporal modelo;

	public MediadorModificaContacto(JFramePrincipal frame, ModelTemporal modelo) {

		this.modelo = modelo;
		panelModificaContacto = (JPanelContacto) frame.getPanel();
		panelModificaContacto.setFrame(frame);

		Collection<TipoContacto> tipos = this.modelo.getTipos();
		for (TipoContacto t : tipos)
			panelModificaContacto.añadirElementoListaMenu(t.getTipoContacto());
		panelModificaContacto.añadirListenerGuardar(guardarContacto());
		panelModificaContacto.añadirListenerDescartarContacto(descartarCampos());
		panelModificaContacto.añadirListenerOtrosCampos(otrosCampos());
		panelModificaContacto.añadirListenerDescartarOtrosCampos(DescartarPanelOtrosCampos());
		panelModificaContacto.añadirListenerGuardarOtrosCampos(guardarContacto());

	}

	private ActionListener guardarContacto() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelModificaContacto.cerrarOtrosCampos();
				JOptionPane.showMessageDialog(null, "Contacto Modificado");
				//Añadir aqui la funcion para modifica los campos del contacto y otros
				resetCampos();
			}
		};
	}

	private boolean comprobarTipos() {
		return false;

	}

	private void resetCampos() {

		panelModificaContacto.setNombre("");
		panelModificaContacto.setApellidos("");
		panelModificaContacto.setCiudad("");
		panelModificaContacto.setDireccion("");
		panelModificaContacto.setMovil("");
		panelModificaContacto.resetMenu();
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
				panelModificaContacto.abrirOtrosCampos();

			}
		};
	}
	
	private ActionListener DescartarPanelOtrosCampos(){
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelModificaContacto.cerrarOtrosCampos();

			}
		};
	}
}
