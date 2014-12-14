package ubu.lsi.dms.agenda.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import ubu.lsi.dms.agenda.gui.JFramePrincipal;
import ubu.lsi.dms.agenda.gui.JPanelLlamada;
import ubu.lsi.dms.agenda.gui.TablaContactos;
import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.modelo.ModelTemporal;

public class MediadorNuevaLLamada {

	private JPanelLlamada panelModificaLlamada;
	private ModelTemporal modelo;
	private Collection<Contacto> contactos;
	private Contacto contactoLlamada;

	/**
	 * @wbp.parser.entryPoint
	 */
	public MediadorNuevaLLamada(JFramePrincipal frame, ModelTemporal modelo) {

		this.modelo = modelo;
		panelModificaLlamada = (JPanelLlamada) frame.getPanel();
		panelModificaLlamada.setFrame(frame);
		TablaContactos tabla = new TablaContactos(modelo.getContactos());
		panelModificaLlamada.crearListaConsultas(panelModificaLlamada
				.crearTabla(tabla, tabla.getCabecera()));
		contactos = this.modelo.getContactos();
		panelModificaLlamada.añadirListenerGuardar(guardarLlamada());
		panelModificaLlamada.añadirListenerDescartarContacto(descartarCampos());
		panelModificaLlamada.añadirListeterTabla(elementoSelecionado());

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

		Llamada llamada = new Llamada(3, contactoLlamada,
				panelModificaLlamada.getFecha(),
				panelModificaLlamada.getAsunto(),
				panelModificaLlamada.getNotas());
		System.out.println(llamada.toString());
		modelo.addLlamada(llamada);

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
}
