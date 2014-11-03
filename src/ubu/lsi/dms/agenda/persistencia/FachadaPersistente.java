package ubu.lsi.dms.agenda.persistencia;

import java.util.Collection;
import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.modelo.TipoContacto;

/**
 * Interfaz de FachadaPersistente
 * 
 * @author <A HREF="mailto:jld0016@alu.ubu.es">Jorge Laguna</A>
 * @author <A HREF="mailto:rmp0046@alu.ubu.es">Roberto Miranda</A>
 * @author <A HREF="mailto:aam0093@alu.ubu.es">Asier Alonso</A>
 * @author <A HREF="mailto:dlr0008@alu.ubu.es">Daniel Lozano</A> 
 * @version 1.0
 * 
 */
public interface FachadaPersistente {

	public Contacto getContacto(String apellido);

	public Collection<Llamada> getLlamadas(Contacto contacto);

	public TipoContacto getTipoContacto();

	public void updateContacto(Contacto contacto);

	public void updateLlamada(Llamada llamada);

	public void updateTipoContacto();
	
	public void insertContacto(Contacto contacto);
	
	public void insertLlamada(Llamada llamada);
	
	public void insertTipoContacto(int idTipoContacto, String TipoContacto);

}
