package ubu.lsi.dms.agenda.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TablaLlamadas extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	public List<Llamada> listaLlamadas;
	private String[] cabecera = new String[] { "ID", "Contacto",
			"Fecha", "Asunto", "Notas" };

	public TablaLlamadas(Collection<Llamada> llamadas) {
		listaLlamadas = Collections
				.synchronizedList((ArrayList<Llamada>) llamadas);
	}

	public void add(Llamada llamada) {
		listaLlamadas.add(llamada);
		fireTableRowsInserted(listaLlamadas.size() - 1,
				listaLlamadas.size() - 1);
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
			return l.getContacto().getNombre()+ " "+l.getContacto().getApellidos();
		case 2:
			return l.getFechaLlamada();
		case 3:
			return l.getAsunto();
		case 4:
			return l.getNotas();

		}
		return "";
	}
	public String[] getCabecera(){
		return cabecera;
	}
}
