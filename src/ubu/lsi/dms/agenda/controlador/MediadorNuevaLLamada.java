package ubu.lsi.dms.agenda.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;
import java.util.Observable;

import javax.swing.JOptionPane;

import ubu.lsi.dms.agenda.gui.JFramePrincipal;
import ubu.lsi.dms.agenda.gui.JPanelLlamada;
import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.modelo.ModelTemporal;

public class MediadorNuevaLLamada extends Observable {

	private JPanelLlamada panelModificaLlamada;
	private Collection<Contacto> contactos;
	private Contacto contactoLlamada;
	private ModelTemporal modelo;

	public MediadorNuevaLLamada(JFramePrincipal frame,
			ModelTemporal modelo) {

		this.modelo = modelo;
		panelModificaLlamada = new JPanelLlamada(frame);
		panelModificaLlamada.recargarTabla(frame.tablaContactos());
		panelModificaLlamada.setTable(frame.tablaContactos());
		panelModificaLlamada.añadirListenerGuardar(guardarLlamada());
		panelModificaLlamada.añadirListenerDescartarContacto(descartarCampos());
		panelModificaLlamada.añadirListeterTabla(elementoSelecionado());
		modelo.getLlamadas().addObserver(panelModificaLlamada);

	}

	private ActionListener guardarLlamada() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Llamada Guardada");
				añadirLlamada();
				resetCampos();
			}
		};
	}

	private MouseListener elementoSelecionado() {
		return new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				panelModificaLlamada.activarCampos();
				contactos = modelo.getContactos().obtenerTodosContactos();
				int fila = panelModificaLlamada.getFilaSeleccionada();
				int i = 0;
				for (Contacto c : contactos) {
					if (fila == i) {
						contactoLlamada = c;
						cambiarNombre(c.getNombre() + " " + c.getApellidos());
					}
					i++;
				}

			}

		};
	}

	private void añadirLlamada() {
		Llamada llamada = new Llamada(modelo.getLlamadas()
				.obtenerTodasLLamadas().size() + 1, contactoLlamada,
				panelModificaLlamada.getFecha(),
				panelModificaLlamada.getAsunto(),
				panelModificaLlamada.getNotas());
		modelo.getLlamadas().addLLamada(llamada);

	}

	private void cambiarNombre(String nombre) {
		panelModificaLlamada.setNombre(nombre);

	}

	private void resetCampos() {

		panelModificaLlamada.setNombre("");
		panelModificaLlamada.setfecha("");
		panelModificaLlamada.setasunto("");
		panelModificaLlamada.setTextPane("");
	}

	private ActionListener descartarCampos() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				resetCampos();

			}
		};
	}

	public JPanelLlamada getPanelAsociado() {
		return panelModificaLlamada;
	}
}
