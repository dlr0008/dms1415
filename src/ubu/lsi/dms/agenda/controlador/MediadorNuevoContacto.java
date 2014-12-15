package ubu.lsi.dms.agenda.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ubu.lsi.dms.agenda.gui.JFramePrincipal;
import ubu.lsi.dms.agenda.gui.JPanelContacto;
import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.ModelTemporal;
import ubu.lsi.dms.agenda.modelo.TipoContacto;

public class MediadorNuevoContacto {

	private JPanelContacto panelNuevoContacto;
	private ModelTemporal modelo;

	public MediadorNuevoContacto(JFramePrincipal frame,
			ModelTemporal modelo) {
		this.modelo = modelo;
		panelNuevoContacto = new JPanelContacto(frame);
		for (TipoContacto t : modelo.getTipos().obtenerTodosTipos()) {
			panelNuevoContacto.añadirElementoListaMenu(t.getTipoContacto());
		}
		modelo.getContactos().addObserver(panelNuevoContacto);
		modelo.getTipos().addObserver(panelNuevoContacto);
		panelNuevoContacto.añadirListenerGuardar(guardarContacto());
		panelNuevoContacto.añadirListenerDescartarContacto(descartarCampos());
		panelNuevoContacto.añadirListenerOtrosCampos(otrosCampos());
		panelNuevoContacto
				.añadirListenerDescartarOtrosCampos(DescartarPanelOtrosCampos());
		panelNuevoContacto.añadirListenerGuardarOtrosCampos(guardarContacto());

	}

	private ActionListener guardarContacto() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelNuevoContacto.cerrarOtrosCampos();
				if (!panelNuevoContacto.compruebaVacios()) {
					JOptionPane.showMessageDialog(null,
							"Rellene todos los campos");
				} else {
					creaNuevoContacto();
					resetCampos();
					JOptionPane.showMessageDialog(null, "Contacto Guardado");
				}
			}
		};
	}

	private void creaNuevoContacto() {

		int idContacto = modelo.getContactos().size() + 1;
		String nombre = panelNuevoContacto.getNombre();
		String apellidos = panelNuevoContacto.getApellidos();
		String direccion = panelNuevoContacto.getDireccion();
		String ciudad = panelNuevoContacto.getCiudad();
		String telefonoMovil = panelNuevoContacto.getMovil();
		String notas = panelNuevoContacto.getNotas();
		String estimado = panelNuevoContacto.otrosCampos.getEstimado();
		String prov = panelNuevoContacto.otrosCampos.getProv();
		String codPostal = panelNuevoContacto.otrosCampos.getCodPostal();
		String region = panelNuevoContacto.otrosCampos.getRegion();
		String pais = panelNuevoContacto.otrosCampos.getPais();
		String nombreCompania = panelNuevoContacto.otrosCampos
				.getNombreCompania();
		String cargo = panelNuevoContacto.otrosCampos.getCargo();
		String telefonoTrabajo = panelNuevoContacto.otrosCampos
				.getTelefonoTrabajo();
		String extensionTrabajo = panelNuevoContacto.otrosCampos
				.getExtensionTrabajo();
		String numFax = panelNuevoContacto.otrosCampos.getFax();
		String nomCorreoElectronico = panelNuevoContacto.otrosCampos
				.getNomCorreoElectronico();
		String tContacto = panelNuevoContacto.getTipoContacto();
		TipoContacto tipoContacto = buscaTipoContacto(tContacto);

		Contacto contacto = new Contacto(idContacto, nombre, apellidos,
				estimado, direccion, ciudad, prov, codPostal, region, pais,
				nombreCompania, cargo, telefonoTrabajo, extensionTrabajo,
				telefonoMovil, numFax, nomCorreoElectronico, notas,
				tipoContacto);
		modelo.getContactos().addContacto(contacto);
	}

	private TipoContacto buscaTipoContacto(String tContacto) {
		Collection<TipoContacto> tipos = modelo.getTipos().obtenerTodosTipos();
		for (TipoContacto t : tipos) {
			if (t.getTipoContacto() == tContacto) {
				return t;
			}
		}
		return null;
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

	private ActionListener DescartarPanelOtrosCampos() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelNuevoContacto.cerrarOtrosCampos();

			}
		};
	}

	public JPanel getPanelAsociado() {
		return panelNuevoContacto;
	}
}
