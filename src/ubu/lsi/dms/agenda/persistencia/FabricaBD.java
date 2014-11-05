/**
 * 
 */
package ubu.lsi.dms.agenda.persistencia;

/**
 * @author alumno
 *
 */
public class FabricaBD implements FabricaPersistencia {

	/* (non-Javadoc)
	 * @see ubu.lsi.dms.agenda.persistencia.FabricaPersistencia#crearFachadaPersistente()
	 */
	@Override
	public FachadaPersistente createFachadaPersistente() {
		return null;
	}
	
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
