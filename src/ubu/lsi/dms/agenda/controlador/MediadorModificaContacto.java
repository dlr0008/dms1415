package ubu.lsi.dms.agenda.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ubu.lsi.dms.agenda.gui.JFramePrincipal;
import ubu.lsi.dms.agenda.gui.JPanelContacto;
import ubu.lsi.dms.agenda.gui.JPanelLlamada;
import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.modelo.ModelTemporal;
import ubu.lsi.dms.agenda.modelo.TipoContacto;

public class MediadorModificaContacto {

	private JPanelContacto panelModificaContacto;
	private ModelTemporal modelo;
	private Contacto contacto;
	private Collection<Contacto> contactos;

	public MediadorModificaContacto(JFramePrincipal frame, ModelTemporal modelo) {
		
		this.modelo=modelo;
		panelModificaContacto=new JPanelContacto(frame);
		for (TipoContacto t : modelo.getTipos().obtenerTodosTipos()) {
			panelModificaContacto.añadirElementoListaMenu(t.getTipoContacto());
		}
		panelModificaContacto.recargarTabla(frame.tablaContactos());
		panelModificaContacto.añadirListenerGuardar(guardarContacto());
		panelModificaContacto.añadirListenerTabla(seleccionarContacto());
		panelModificaContacto.añadirListenerDescartarContacto(descartarCampos());
		panelModificaContacto.añadirListenerOtrosCampos(otrosCampos());
		panelModificaContacto.añadirListenerDescartarOtrosCampos(DescartarPanelOtrosCampos());
	}
	
	public JPanelContacto getPanelAsociado() {
		return panelModificaContacto;
	}

	private ActionListener guardarContacto() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				panelModificaContacto.cerrarOtrosCampos();
				if (!panelModificaContacto.compruebaVacios()) {
					JOptionPane.showMessageDialog(null,
							"Rellene todos los campos");
				} else {
					modificaContacto();
					resetCampos();
					JOptionPane.showMessageDialog(null, "Contacto Modificado");
				}
				panelModificaContacto.cerrarOtrosCampos();
			}
			
			private void modificaContacto(){
				String tContacto = panelModificaContacto.getTipoContacto();
				TipoContacto tipoContacto = buscaTipoContacto(tContacto);
				Contacto con = new Contacto(contacto.getIdContacto(),
						panelModificaContacto.getNombre(),
						panelModificaContacto.getApellidos(),
						panelModificaContacto.otrosCampos.getEstimado(),
						panelModificaContacto.getDireccion(),
						panelModificaContacto.getCiudad(),
						panelModificaContacto.otrosCampos.getProv(),
						panelModificaContacto.otrosCampos.getCodPostal(),
						panelModificaContacto.otrosCampos.getRegion(),
						panelModificaContacto.otrosCampos.getPais(),
						panelModificaContacto.otrosCampos.getNombreCompania(),
						panelModificaContacto.otrosCampos.getCargo(),
						panelModificaContacto.otrosCampos.getTelefonoTrabajo(),
						panelModificaContacto.otrosCampos.getExtensionTrabajo(),
						panelModificaContacto.getMovil(),
						panelModificaContacto.otrosCampos.getFax(),
						panelModificaContacto.otrosCampos.getNomCorreoElectronico(),
						panelModificaContacto.getNotas(),
						tipoContacto
						);
				modelo.getContactos().addContacto(con);
			}
			

		};
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
	
	private MouseListener seleccionarContacto(){
		return new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				panelModificaContacto.activarCampos();
				contactos = modelo.getContactos().obtenerTodosContactos();
				int fila = panelModificaContacto.getFilaSeleccionada();
				int i = 0;
				for (Contacto c : contactos) {
					if (fila == i) {
						contacto = c;
						cambiarNombre(contacto.getNombre());
						cambiarApellido(contacto.getApellidos());
						cambiarDireccion(contacto.getDireccion());
						cambiarCiudad(contacto.getCiudad());
						cambiarMovil(contacto.getTelefonoMovil());
						cambiarNotas(contacto.getNotas());
						cambiarEstimado(contacto.getEstimado());
						cambiarProv(contacto.getProv());
						cambiarCodPostal(contacto.getCodPostal());
						cambiarRegion(contacto.getRegion());
						cambiarPais(contacto.getPais());
						cambiarNombreCompania(contacto.getNombreCompania());
						cambiarCargo(contacto.getCargo());
						cambiarTelefonoTrabajo(contacto.getTelefonoTrabajo());
						cambiarExtensionTrabajo(contacto.getExtensionTrabajo());
						cambiarFax(contacto.getNumFax());
						cambiarNomCorreoElectronico(contacto.getNomCorreoElectronico());						
					}
					i++;
				}
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		
	
	}
	
	private void cambiarNombre(String string) {
		panelModificaContacto.setNombre(string);

	}
	
	private void cambiarApellido(String string) {
		panelModificaContacto.setApellidos(string);

	}

	private void cambiarDireccion(String string) {
		panelModificaContacto.setDireccion(string);

	}
	
	private void cambiarCiudad(String string) {
		panelModificaContacto.setCiudad(string);

	}
	
	private void cambiarMovil(String string) {
		panelModificaContacto.setMovil(string);

	}
	
//	private void cambiarTipoContacto(String string) {
//
//		panelModificaContacto.setTipoContacto(string);
//
//	}
	
	private void cambiarNotas(String string) {
		panelModificaContacto.setNotas(string);

	}
	
	private void cambiarEstimado(String string) {
		panelModificaContacto.otrosCampos.setEstimado(string);
	}
	
	private void cambiarProv(String string) {
		panelModificaContacto.otrosCampos.setProv(string);

	}
	
	private void cambiarCodPostal(String string) {
		panelModificaContacto.otrosCampos.setCodPostal(string);

	}
	private void cambiarRegion(String string) {
		panelModificaContacto.otrosCampos.setRegion(string);

	}
	
	private void cambiarPais(String string) {
		panelModificaContacto.otrosCampos.setPais(string);

	}
	
	private void cambiarNombreCompania(String string) {
		panelModificaContacto.otrosCampos.setNombreCompania(string);

	}
	
	private void cambiarCargo(String string) {
		panelModificaContacto.otrosCampos.setCargo(string);

	}
	
	private void cambiarTelefonoTrabajo(String string) {
		panelModificaContacto.otrosCampos.setTelefonoTrabajo(string);

	}
	
	private void cambiarExtensionTrabajo(String string) {
		panelModificaContacto.otrosCampos.setExtensionTrabajo(string);

	}
	
	private void cambiarFax(String string) {
		panelModificaContacto.otrosCampos.setFax(string);

	}
	private void cambiarNomCorreoElectronico(String string) {
		panelModificaContacto.otrosCampos.setNomCorreoElectronico(string);

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
