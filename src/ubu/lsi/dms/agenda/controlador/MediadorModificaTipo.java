package ubu.lsi.dms.agenda.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ubu.lsi.dms.agenda.gui.JFramePrincipal;
import ubu.lsi.dms.agenda.gui.JPanelTipo;
import ubu.lsi.dms.agenda.modelo.ModelTemporal;
import ubu.lsi.dms.agenda.modelo.TipoContacto;

public class MediadorModificaTipo {

	private JPanelTipo panelModificaTipo;
	private ModelTemporal modelo;
	private TipoContacto tipo  ;
	private Collection<TipoContacto> tipos;
	int fila;

	public MediadorModificaTipo(JFramePrincipal frame, ModelTemporal modelo) {

		this.modelo = modelo;
		panelModificaTipo = new JPanelTipo(frame);
		panelModificaTipo.recargarTabla(frame.tablaTipos());
		panelModificaTipo.añadirListenerGuardar(guardarTipo());
		panelModificaTipo.añadirListenerDescartarContacto(descartarCampos());
		panelModificaTipo.añadirListeterTabla(seleccionarTipo());

	}
	
	private ActionListener guardarTipo() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Tipo Guardado");
				modificarTipo();
				resetCampos();
			}
		};
	}	
	
	private void modificarTipo() {
		int idContacto = fila;
		String tContacto = panelModificaTipo.getTipoContacto();		
		TipoContacto tipoContacto = new TipoContacto(idContacto, tContacto);
		modelo.getTipos().addTipo(tipoContacto);
	}

	private MouseListener seleccionarTipo() {
		return new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				panelModificaTipo.activarCampos();
				tipos = modelo.getTipos().obtenerTodosTipos();
				fila = panelModificaTipo.getFilaSeleccionada();
				int i = 0;
				for (TipoContacto t : tipos) {
					if (fila == i) {
						tipo= t;
						cambiarNombre(tipo.getTipoContacto());						
					}
					i++;
				}				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
		};	
	}	


	private void cambiarNombre(String tipoContacto) {
		panelModificaTipo.setTipoContacto(tipoContacto);
		
	}

	private void resetCampos() {
		panelModificaTipo.setTipoContacto("");
	}

	private ActionListener descartarCampos() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				resetCampos();
			}
		};
	}

	public JPanel getPanelAsociado() {
		return panelModificaTipo;
	}
}
	
