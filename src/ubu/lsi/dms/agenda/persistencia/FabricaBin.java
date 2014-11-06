/**
 * 
 */
package ubu.lsi.dms.agenda.persistencia;

/**
 * @author alumno
 *
 */
public class FabricaBin implements FabricaPersistencia {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ubu.lsi.dms.agenda.persistencia.FabricaPersistencia#crearFachadaPersistente
	 * ()
	 */
	@Override
	public FachadaPersistente createFachadaPersistente() {
		return FachadaBin.getInstance();		
	}
}
