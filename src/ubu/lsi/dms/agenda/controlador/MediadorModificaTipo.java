package ubu.lsi.dms.agenda.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;

import javax.swing.JOptionPane;

import ubu.lsi.dms.agenda.gui.JFramePrincipal;
import ubu.lsi.dms.agenda.gui.JPanelTipo;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.modelo.ModelTemporal;
import ubu.lsi.dms.agenda.modelo.TipoContacto;

public class MediadorModificaTipo {

	private JPanelTipo panelModificaTipo;
	private ModelTemporal modelo;
	private TipoContacto tipo  ;
	private Collection<TipoContacto> tipos;

	public MediadorModificaTipo(JFramePrincipal frame, ModelTemporal modelo) {

		this.modelo = modelo;
		panelModificaTipo = (JPanelTipo) frame.getPanel();
		
		panelModificaTipo.añadirListenerGuardar(guardarTipo());
		panelModificaTipo.añadirListenerDescartarContacto(descartarCampos());
		panelModificaTipo.añadirListeterTabla(seleccionarTipo());

	}

	private MouseListener seleccionarTipo() {
		return new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				panelModificaTipo.activarCampos();
				int fila = panelModificaTipo.getFilaSeleccionada();
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

	private void cambiarNombre(String tipoContacto) {
		panelModificaTipo.setName(tipoContacto);
		
	}

	private ActionListener guardarTipo() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Tipo Guardado");
				resetCampos();
			}
		};
	}

	private boolean comprobarTipos() {
		return false;

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
}
	
