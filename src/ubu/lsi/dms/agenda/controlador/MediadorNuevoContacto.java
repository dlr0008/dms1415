package ubu.lsi.dms.agenda.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JOptionPane;

import ubu.lsi.dms.agenda.gui.JFramePrincipal;
import ubu.lsi.dms.agenda.gui.JPanelContacto;
import ubu.lsi.dms.agenda.gui.JPanelContacto.JPanelOtrosCampos;
import ubu.lsi.dms.agenda.modelo.Contacto;
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
				creaNuevoContacto();
				resetCampos();
			}
		};
	}
	
	
	private void creaNuevoContacto(){
		
		int idContacto=modelo.getContactos().size()+1;
		String nombre=JPanelContacto.getNombre();
		String apellidos=JPanelContacto.getApellidos();
		String direccion=JPanelContacto.getDireccion();
		String ciudad=JPanelContacto.getCiudad();
		String telefonoMovil=JPanelContacto.getMovil();
		String notas=JPanelContacto.getNotas();
		String tContacto=JPanelContacto.getTipoContacto();
		String estimado=JPanelOtrosCampos.getEstimado();
		String prov=JPanelOtrosCampos.getProv();
		String codPostal=JPanelOtrosCampos.getCodPostal();
		String region=JPanelOtrosCampos.getRegion();
		String pais=JPanelOtrosCampos.getPais();
		String nombreCompania=JPanelOtrosCampos.getNombreCompania();
		String cargo=JPanelOtrosCampos.getCargo();
		String telefonoTrabajo=JPanelOtrosCampos.getTelefonoTrabajo();
		String extensionTrabajo=JPanelOtrosCampos.getExtensionTrabajo();
		String numFax=JPanelOtrosCampos.getFax();
		String nomCorreoElectronico=JPanelOtrosCampos.getNomCorreoElectronico();
		TipoContacto tipoContacto=buscaTipoContacto(tContacto);
		
		Contacto contacto=new Contacto(idContacto, nombre, apellidos,
				estimado, direccion, ciudad, prov,
				codPostal, region, pais,
				nombreCompania, cargo, telefonoTrabajo,
				extensionTrabajo, telefonoMovil, numFax,
				nomCorreoElectronico, notas, tipoContacto);
		modelo.addContacto(contacto);
	}
	

	private TipoContacto buscaTipoContacto(String tContacto) {
		Collection<TipoContacto> tipos = this.modelo.getTipos();
		for (TipoContacto t : tipos){
			if (t.toString()==tContacto){
				return t;
			}
		}
		return null;
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
