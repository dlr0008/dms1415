package ubu.lsi.dms.agenda.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Random;

/**
 * @author <A HREF="mailto:jld0016@alu.ubu.es">Jorge Laguna</A>
 * @author <A HREF="mailto:rmp0046@alu.ubu.es">Roberto Miranda</A>
 * @author <A HREF="mailto:aam0093@alu.ubu.es">Asier Alonso</A>
 * @author <A HREF="mailto:dlr0008@alu.ubu.es">Daniel Lozano</A>
 * @version 1.0
 * 
 *          Clase que implementa el Patron Observador, es el sujeto Concreto,
 *          contiene la ista de Contactos
 */
public class ListaContactos extends Observable {
	Collection<Contacto> listaContactos = new ArrayList<Contacto>();

	public ListaContactos() {
		for (int i = 1; i <= 100; i++) {
			listaContactos.add(new Contacto(i, "Nombre00" + i, "Apellidos00"
					+ new Random().nextInt(10), "Estimado00" + i, "Direccion00"
					+ i, "Ciudad00" + i, "Prov00" + i, "CodPostal000" + i,
					"Region000" + i, "Pais000" + i, "NombreCompania000" + i,
					"Cargo000" + i, "TelefonoTrabajo00" + i,
					"ExtensionTrabajo00" + i, "TelefonoMovil00" + i, "NumFax00"
							+ i, " NomCorreoElectronico00" + i + "@ubu.es",
					"Notas00" + i, new TipoContacto(1, "Tipo 1")));
		}

	}

	/**
	 * Añade uncontacto a la lista, y notifica a los observadores
	 * 
	 * @param llamada
	 */
	public void addContacto(Contacto contacto) {
		listaContactos.add(contacto);
		setChanged();
		notifyObservers(contacto);
	}

	/**
	 * Añade un contacto a la lista, y notifica a los observadores
	 * 
	 * @param llamada
	 */
	public void removeContacto(Contacto contacto) {
		listaContactos.remove(contacto);
		setChanged();
		notifyObservers(contacto);
	}

	/**
	 * Devuelve la lista completa de contactos
	 * 
	 * @return listaContactos
	 */
	public Collection<Contacto> obtenerTodosContactos() {
		return listaContactos;
	}

	/**
	 * Devuelve la lista filtrada por apellido de los contactos
	 * 
	 * @param apellido
	 * @return listaFiltrada
	 */
	public Collection<Contacto> ObtenerContactosFiltradas(String apellido) {
		Collection<Contacto> listaContactosFiltradas = new ArrayList<Contacto>();
		for (Contacto c : listaContactos) {
			if (c.getApellidos().equals(apellido))
				listaContactosFiltradas.add(c);
		}
		return listaContactosFiltradas;
	}

	public int size() {
		return listaContactos.size();
	}

}
