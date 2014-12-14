package ubu.lsi.dms.agenda.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;

import javax.swing.JOptionPane;

import ubu.lsi.dms.agenda.gui.JFramePrincipal;
import ubu.lsi.dms.agenda.gui.JPanelLlamada;
import ubu.lsi.dms.agenda.gui.TablaLlamadas;
import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.modelo.ModelTemporal;

public class MediadorModificaLlamada {

	private JPanelLlamada panelModificarLlamada;
	private ModelTemporal modelo;
	private Llamada llamada  ;
	private Contacto contactoLlamada;
	private Collection<Llamada> llamadas;
	
	public MediadorModificaLlamada(JFramePrincipal frame, ModelTemporal modelo) {

		this.modelo = modelo;
		panelModificarLlamada = (JPanelLlamada) frame.getPanel();
		panelModificarLlamada.setFrame(frame);
		TablaLlamadas tabla = new TablaLlamadas( modelo.getLlamadas());
		panelModificarLlamada.crearListaConsultas(panelModificarLlamada
				.crearTabla(tabla, tabla.getCabecera()));		
		llamadas = this.modelo.getLlamadas();
	
		panelModificarLlamada.añadirListenerGuardar(guardarLlamada());
		panelModificarLlamada.añadirListeterTabla(seleccionarContacto());
		panelModificarLlamada.añadirListenerDescartarContacto(descartarCampos());
		

	}

	private ActionListener guardarLlamada() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Añadir aqui la funcion para guardar los campos del contacto y otros
								
				añadirLlamada();
				JOptionPane.showMessageDialog(null, "Llamada Modificada");
				
				resetCampos();
			}

			private void añadirLlamada() {
				int id = 2; //valor temporal hasta arreglar tablas
				Llamada llam = new Llamada(llamada.getIdLlamada(),llamada.getContacto(),llamada.getFechaLlamada(),
						llamada.getNotas(), llamada.getAsunto() );
				modelo.addLlamada(llam);		
			}
		};
	}
	
	private MouseListener seleccionarContacto(){
		return new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				panelModificarLlamada.activarCampos();
				int fila = panelModificarLlamada.getFilaSeleccionada();
				int i = 0;
				for (Llamada l : llamadas) {
					if (fila == i) {
						llamada = l;
						cambiarNombre(llamada.getContacto().getNombre() + " " + llamada.getContacto().getApellidos());
						cambiarFecha(llamada.getFechaLlamada());
						cambiarAsunto(llamada.getAsunto());
						cambiarNotas(llamada.getNotas());
						
					
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
		panelModificarLlamada.setNombre(string);
		
	}
	
	private void cambiarAsunto(String asunto) {
		panelModificarLlamada.setasunto(asunto);
		
	}


	private void cambiarFecha(String fechaLlamada) {
		panelModificarLlamada.setfecha(fechaLlamada);
		
	}


	private void cambiarNotas(String notas) {
		panelModificarLlamada.setTextPane(notas);
		
	}
	private boolean comprobarTipos() {
		return false;

	}

	private void resetCampos() {
		//panelNuevaLlamada.setTextPane("");
		panelModificarLlamada.setfecha("");
		panelModificarLlamada.setasunto("");
		panelModificarLlamada.setTextPane("");
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
