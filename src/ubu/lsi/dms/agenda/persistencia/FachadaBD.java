/**
 * 
 */
package ubu.lsi.dms.agenda.persistencia;

import java.util.Collection;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.modelo.TipoContacto;

/**
 * @author alumno
 *
 */
public class FachadaBD implements FachadaPersistente {

	@Override
	public Collection<Contacto> getContacto(String apellido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Llamada> getLlamadas(Contacto contacto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<TipoContacto> getTipoContacto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertContacto(Contacto contacto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertLlamada(Llamada llamada) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertTipoContacto(String TipoContacto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateContacto(Contacto contacto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateLlamada(Llamada llamada) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTipoContacto(TipoContacto tipoContacto) {
		// TODO Auto-generated method stub
		
	}


}
