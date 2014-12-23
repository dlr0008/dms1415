package ubu.lsi.dms.agenda.modelo;

/**
 * @author <A HREF="mailto:jld0016@alu.ubu.es">Jorge Laguna</A>
 * @author <A HREF="mailto:rmp0046@alu.ubu.es">Roberto Miranda</A>
 * @author <A HREF="mailto:aam0093@alu.ubu.es">Asier Alonso</A>
 * @author <A HREF="mailto:dlr0008@alu.ubu.es">Daniel Lozano</A>
 * @version 1.0
 * 
 *          Se encarga de manejar las distintas listas
 * 
 */
public class ModelTemporalObservador {

	ListaContactos contactos;
	ListaLlamadas llamadas;
	ListaTiposContacto tipos;

	public ModelTemporalObservador() {

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
