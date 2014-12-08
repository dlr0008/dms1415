package ubu.lsi.dms.agenda.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TablaTipos extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	public List<TipoContacto> listaTipos;
	private String[] cabecera = new String[] { "ID", "Nombre" };

	public TablaTipos(Collection<TipoContacto> tipos) {
		listaTipos = Collections
				.synchronizedList((ArrayList<TipoContacto>) tipos);
	}

	public void add(TipoContacto contacto) {
		listaTipos.add(contacto);
		fireTableRowsInserted(listaTipos.size() - 1, listaTipos.size() - 1);
	}

	@Override
	public int getColumnCount() {
		return 18;
	}

	@Override
	public int getRowCount() {
		return listaTipos.size();
	}

	@Override
	public Object getValueAt(int fila, int columna) {
		TipoContacto t = listaTipos.get(fila);
		switch (columna) {
		case 0:
			return t.getIdTipoContacto();
		case 1:
			return t.getTipoContacto();

		}
		return "";
	}

	public String[] getCabecera() {
		return cabecera;
	}

}