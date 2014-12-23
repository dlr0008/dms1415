package ubu.lsi.dms.agenda.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import ubu.lsi.dms.agenda.modelo.Llamada;

/**
 * @author <A HREF="mailto:jld0016@alu.ubu.es">Jorge Laguna</A>
 * @author <A HREF="mailto:rmp0046@alu.ubu.es">Roberto Miranda</A>
 * @author <A HREF="mailto:aam0093@alu.ubu.es">Asier Alonso</A>
 * @author <A HREF="mailto:dlr0008@alu.ubu.es">Daniel Lozano</A>
 * @version 1.0
 * 
 *          Tabla Abstacta que permite crear las tablas de LLamdas empleada para
 *          crar los JTable que usa la aplicacion, contiene la lista de llamadas
 */
public class TablaLlamadas extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	public List<Llamada> listaLlamadas = new ArrayList<Llamada>();
	private String[] cabecera = new String[] { "ID", "Contacto", "Fecha",
			"Asunto", "Notas" };

	public void add(Llamada llamada) {
		Llamada eliminar = null;
		for (Llamada l : listaLlamadas) {
			if (llamada.getIdLlamada() == l.getIdLlamada())
				eliminar = l;
		}
		if (eliminar != null) {
			listaLlamadas.remove(eliminar);
		}
		listaLlamadas.add(llamada);
	}

	@Override
	public int getColumnCount() {
		return 18;
	}

	@Override
	public int getRowCount() {
		return listaLlamadas.size();
	}

	@Override
	public Object getValueAt(int fila, int columna) {
		Llamada l = listaLlamadas.get(fila);
		switch (columna) {
		case 0:
			return l.getIdLlamada();
		case 1:
			return l.getContacto().getNombre() + " "
					+ l.getContacto().getApellidos();
		case 2:
			return l.getFechaLlamada();
		case 3:
			return l.getAsunto();
		case 4:
			return l.getNotas();

		}
		return "";
	}

	public String[] getCabecera() {
		return cabecera;
	}

}
