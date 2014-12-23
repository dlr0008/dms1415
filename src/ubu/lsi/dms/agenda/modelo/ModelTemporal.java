package ubu.lsi.dms.agenda.modelo;

/**
 * @author <A HREF="mailto:jld0016@alu.ubu.es">Jorge Laguna</A>
 * @author <A HREF="mailto:rmp0046@alu.ubu.es">Roberto Miranda</A>
 * @author <A HREF="mailto:aam0093@alu.ubu.es">Asier Alonso</A>
 * @author <A HREF="mailto:dlr0008@alu.ubu.es">Daniel Lozano</A>
 * @version 1.0
 * 
 *          Clase que implementa el Patron mediador, se encarga del manejo de el
 *          Jpanel de Contactos, modificandolo para el caso de uso de modificar
 *          contactos, tambien el patron comando asignado los listener a los
 *          distintos elementos.
 */
public class ModelTemporal {

	private ListaContactos contactos;
	private ListaLlamadas llamadas;
	private ListaTiposContacto tipos;

	public ModelTemporal() {

		contactos = new ListaContactos();
		llamadas = new ListaLlamadas();
		tipos = new ListaTiposContacto();

	}

	public ListaContactos getContactos() {
		return contactos;
	}

	public ListaLlamadas getLlamadas() {
		return llamadas;
	}

	public ListaTiposContacto getTipos() {
		return tipos;
	}
}
