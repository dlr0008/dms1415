package ubu.lsi.dms.agenda.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;

public class ListaTiposContacto extends Observable {

	Collection<TipoContacto> listaTipos = new ArrayList<TipoContacto>();

	public ListaTiposContacto() {

		for (int i = 1; i <= 30; i++)
			addTipo(new TipoContacto(i, "Tipo00" + i));
	}

	/**
	 * Añade un tipo de contacto a la lista, y notifica a los observadores
	 * 
	 * @param tipo
	 */
	public void addTipo(TipoContacto tipo) {
		listaTipos.add(tipo);
		setChanged();
		notifyObservers(tipo);
	}

	/**
	 * Devuelve la lista completa de Tipos de Contacto
	 * 
	 * @return listaTipoContactos
	 */
	public Collection<TipoContacto> obtenerTodosTipos() {
		return listaTipos;
	}

	public int size() {
		return listaTipos.size();
	}

}
