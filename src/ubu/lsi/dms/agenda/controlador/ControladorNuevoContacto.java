package ubu.lsi.dms.agenda.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JOptionPane;

import ubu.lsi.dms.agenda.gui.JFramePrincipal;
import ubu.lsi.dms.agenda.gui.JPanelContacto;
import ubu.lsi.dms.agenda.modelo.ModelTemporal;
import ubu.lsi.dms.agenda.modelo.TipoContacto;

public class ControladorNuevoContacto {

	private JFramePrincipal frame;
	private JPanelContacto panelNuevoContacto;
	private ModelTemporal modelo;

	public ControladorNuevoContacto(JFramePrincipal frame, ModelTemporal modelo) {

		this.frame = frame;
		this.modelo = modelo;
		panelNuevoContacto = (JPanelContacto) frame.getPanel();

		Collection<TipoContacto> tipos = this.modelo.getTipos();
		for (TipoContacto t : tipos)
			panelNuevoContacto.añadirElementoListaMenu(t.getTipoContacto());
		panelNuevoContacto.añadirListenerGuardar(guardarContacto());
		panelNuevoContacto.añadirListenerDescartar(descartarCampos());

	}

	private ActionListener guardarContacto() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Contacto Guardado");
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
		// panelNuevoContacto.getMenu().select(0);
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
