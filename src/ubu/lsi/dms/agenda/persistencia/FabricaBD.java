/**
 * 
 */
package ubu.lsi.dms.agenda.persistencia;

/**
 * Fabrica para crea la fachada BD
 * 
 * @author <A HREF="mailto:jld0016@alu.ubu.es">Jorge Laguna</A>
 * @author <A HREF="mailto:rmp0046@alu.ubu.es">Roberto Miranda</A>
 * @author <A HREF="mailto:aam0093@alu.ubu.es">Asier Alonso</A>
 * @author <A HREF="mailto:dlr0008@alu.ubu.es">Daniel Lozano</A> 
 * @version 1.0
 * 
 */
public class FabricaBD implements FabricaPersistencia {
	/**
	 * Servidor donde está funcionado el SGBD.
	 */
	private static final String servidor = "localhost";

	/**
	 * Puerto de conexión.
	 */
	private static final String puerto = "";

	/**
	 * Usuario de la base de datos.
	 */
	private static final String usuario = "SA";

	/**
	 * Contraseña.
	 */
	private static final String contraseña = "";

	/**
	 * Sistema gestor de base de datos.
	 */
	private static final String SGBD = "hsqldb:hsql";

	/**
	 * Base de datos sobre la que trabajamos.
	 */
	private static final String baseDeDatos = "Agenda";

	/* (non-Javadoc)
	 * @see ubu.lsi.dms.agenda.persistencia.FabricaPersistencia#crearFachadaPersistente()
	 */
	@Override
	public FachadaPersistente createFachadaPersistente() {
		return FachadaBD.getInstance();
	}	
	
	public static String getServidor() {
		return servidor;
	}
	
	public static String getPuerto() {
		return puerto;
	}

	public static String getUsuario() {
		return usuario;
	}

	public static String getContraseña() {
		return contraseña;
	}

	public static String getSgbd() {
		return SGBD;
	}

	public static String getBasededatos() {
		return baseDeDatos;
	}

}
