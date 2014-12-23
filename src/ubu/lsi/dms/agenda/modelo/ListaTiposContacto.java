package ubu.lsi.dms.agenda.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;

/**
 * @author <A HREF="mailto:jld0016@alu.ubu.es">Jorge Laguna</A>
 * @author <A HREF="mailto:rmp0046@alu.ubu.es">Roberto Miranda</A>
 * @author <A HREF="mailto:aam0093@alu.ubu.es">Asier Alonso</A>
 * @author <A HREF="mailto:dlr0008@alu.ubu.es">Daniel Lozano</A>
 * @version 1.0
 * 
 *          Clase que implementa el Patron Observador, es el sujeto Concreto,
 *          contiene la lista de tipos de contacto
 */
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
