package ubu.lsi.dms.agenda.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;

import javax.swing.JOptionPane;

import ubu.lsi.dms.agenda.gui.JFramePrincipal;
import ubu.lsi.dms.agenda.gui.JPanelLlamada;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.modelo.ModelTemporal;

/**
 * @author <A HREF="mailto:jld0016@alu.ubu.es">Jorge Laguna</A>
 * @author <A HREF="mailto:rmp0046@alu.ubu.es">Roberto Miranda</A>
 * @author <A HREF="mailto:aam0093@alu.ubu.es">Asier Alonso</A>
 * @author <A HREF="mailto:dlr0008@alu.ubu.es">Daniel Lozano</A>
 * @version 1.0
 * 
 *          Clase que implementa el Patron mediador, se encarga del manejo de el
 *          Jpanel de Llamada, modificandolo para el caso de uso de modificar
 *          llamada, tambien el patron comando asignado los listener a los
 *          distintos elementos.
 */
public class MediadorModificaLlamada {

	private JPanelLlamada panelModificarLlamada;
	private ModelTemporal modelo;
	private Llamada llamada;
	private Collection<Llamada> llamadas;

	public MediadorModificaLlamada(JFramePrincipal frame, ModelTemporal modelo) {

		this.modelo = modelo;
		panelModificarLlamada = new JPanelLlamada(frame);
		panelModificarLlamada.recargarTabla(frame.tablaLLamadas());
		panelModificarLlamada.añadirListenerGuardar(guardarLlamada());
		panelModificarLlamada.añadirListeterTabla(seleccionarContacto());
		panelModificarLlamada
				.añadirListenerDescartarContacto(descartarCampos());

	}

	private ActionListener guardarLlamada() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				añadirLlamada();
				JOptionPane.showMessageDialog(null, "Llamada Modificada");

				resetCampos();
			}

			private void añadirLlamada() {
				Llamada llam = new Llamada(llamada.getIdLlamada(),
						llamada.getContacto(),
						panelModificarLlamada.getFecha(),
						panelModificarLlamada.getNotas(),
						panelModificarLlamada.getAsunto());
				modelo.getLlamadas().addLLamada(llam);
			}
		};
	}

	private MouseListener seleccionarContacto() {
		return new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				panelModificarLlamada.activarCampos();
				llamadas = modelo.getLlamadas().obtenerTodasLLamadas();
				int fila = panelModificarLlamada.getFilaSeleccionada();
				int i = 0;
				for (Llamada l : llamadas) {
					if (fila == i) {
						llamada = l;
						cambiarNombre(llamada.getContacto().getNombre() + " "
								+ llamada.getContacto().getApellidos());
						cambiarFecha(llamada.getFechaLlamada());
						cambiarAsunto(llamada.getAsunto());
						cambiarNotas(llamada.getNotas());

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

	private void resetCampos() {
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

	public JPanelLlamada getPanelAsociado() {
		return panelModificarLlamada;
	}
}
