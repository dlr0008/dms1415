package ubu.lsi.dms.agenda.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import ubu.lsi.dms.agenda.modelo.TipoContacto;

public class TablaTipos extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	public List<TipoContacto> listaTipos;
	private String[] cabecera = new String[] { "ID", "Nombre" };

	public TablaTipos(Collection<TipoContacto> tipos) {
		listaTipos = new ArrayList<TipoContacto>();
	}

	public void add(TipoContacto contacto) {
		listaTipos.add(contacto);
	
	}

	@Override
	public int getColumnCount() {
		return 2;
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