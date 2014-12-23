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
 *          contiene la ista de llamadas
 */
public class ListaLlamadas extends Observable {

	Collection<Llamada> listaLlamadas = new ArrayList<Llamada>();

	public ListaLlamadas() {
		for (int i = 1; i <= 100; i++) {
			listaLlamadas.add(new Llamada(i, new Contacto(i, "Nombre00" + i,
					"Apellidos00" + new Random().nextInt(10), "Estimado00" + i,
					"Direccion00" + i, "Ciudad00" + i, "Prov00" + i,
					"CodPostal000" + i, "Region000" + i, "Pais000" + i,
					"NombreCompania000" + i, "Cargo000" + i,
					"TelefonoTrabajo00" + 1, "ExtensionTrabajo00" + 1,
					"TelefonoMovil00" + i, "NumFax00" + 1,
					" NomCorreoElectronico00" + i + "@ubu.es", "Notas00" + i,
					new TipoContacto(1, "Tipo 1")), "2014-10-18 0" + i
					+ ":00:00", "AsuntoLlamada00" + i, "NotaLlamada00" + i));
		}

	}

	/**
	 * Añade una llamada a la lista, y notifica a los observadores
	 * 
	 * @param llamada
	 */
	public void addLLamada(Llamada llamada) {
		Llamada eliminar = null;
		for (Llamada l : listaLlamadas) {
			if (llamada.getIdLlamada() == l.getIdLlamada())
				eliminar = l;
		}
		if (eliminar != null) {
			listaLlamadas.remove(eliminar);
		}
		listaLlamadas.add(llamada);
		setChanged();
		notifyObservers(llamada);

	}

	/**
	 * Devuelve la lista completa de llamadas
	 * 
	 * @return listaLlamadas
	 */
	public Collection<Llamada> obtenerTodasLLamadas() {
		return listaLlamadas;
	}

	/**
	 * Devuelve la lista filtrada por apellido de las llamadas
	 * 
	 * @param apellido
	 * @return listaFiltrada
	 */
	public Collection<Llamada> ObtenerLLamadasFiltradas(String apellido) {
		Collection<Llamada> listaLlamadasFiltradas = new ArrayList<Llamada>();
		for (Llamada l : listaLlamadas) {
			if (l.getContacto().getApellidos().equals(apellido))
				listaLlamadasFiltradas.add(l);
		}
		return listaLlamadasFiltradas;
	}

}
