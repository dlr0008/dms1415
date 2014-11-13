/**
 * 
 */
package ubu.lsi.dms.agenda.persistencia;

/**
 * Interfaz de FachadaPersistente
 * 
 * @author <A HREF="mailto:jld0016@alu.ubu.es">Jorge Laguna</A>
 * @author <A HREF="mailto:rmp0046@alu.ubu.es">Roberto Miranda</A>
 * @author <A HREF="mailto:aam0093@alu.ubu.es">Asier Alonso</A>
 * @author <A HREF="mailto:dlr0008@alu.ubu.es">Daniel Lozano</A>
 * @version 1.0
 */
public class FabricaBin implements FabricaPersistencia {

	/**
	 * Aplicacion del patron Singleton
	 * 
	 * @see * ubu.lsi.dms.agenda.persistencia.FabricaPersistencia#
	 *      crearFachadaPersistente* ()
	 */
	@Override
	public FachadaPersistente createFachadaPersistente() {
		return FachadaBin.getInstance();
	}
}
