package ubu.lsi.dms.agenda.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.modelo.TipoContacto;

/**
 * @author alumno
 *
 */
public class FachadaBD implements FachadaPersistente {
	
	private static final FachadaPersistente instance = new FachadaBD();
	 
	/*
	 * Constructor Fachada BD. Aplicando Singleton
	 */
	 private FachadaBD(){
	  
	 }
	 
	 public static FachadaPersistente getInstance() {
	  return instance;
	 }
	
	private int idContacto=0;
	private String nombre=null;
	private String apellidos=null;
	private String estimado=null;
	private String direccion=null;
	private String ciudad=null;
	private String prov=null;
	private String codPostal=null;
	private String region=null;
	private String pais=null;;
	private String nombreCompania=null;
	private String cargo=null;
	private String telefonoTrabajo=null;
	private String extensionTrabajo=null;
	private String telefonoMovil=null;
	private String numFax=null;
	private String nomCorreoElectronico=null;
	private int IdTipoContacto=0;
	private String notas=null;
	
	
	/*
	 * Descripcion - Devuelve todos los contactos a partir del parametro introducido.
	 * @param apellido - Campo a partir del cual vamos a filtar los contactos.
	 * @return contactos - Collection de todos los contactos con el mismo apellido.
	 * @see ubu.lsi.dms.agenda.persistencia.FachadaPersistente#getContacto(java.lang.String)
	 */
	@Override
	public Collection<Contacto> getContacto(String apellido) {
		Collection<Contacto> contactos = new ArrayList<Contacto>();
		PreparedStatement contacts = null;
		PreparedStatement tipo = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		String URL="jdbc:hsqldb:hsql://localhost";
		try {			
			Connection conn = DriverManager.getConnection(URL, FabricaBD.getUsuario(), FabricaBD.getContraseña());
			contacts = conn.prepareStatement("SELECT * FROM contactos WHERE Apellidos=?");
			contacts.setString(1,apellido);
			rs = contacts.executeQuery();
			while (rs.next()) {
				idContacto=rs.getInt("IdContacto");
				nombre=rs.getString("Nombre");
				apellidos=rs.getString("Apellidos");
				estimado=rs.getString("Estimado");
				direccion=rs.getString("Direccion");
				ciudad=rs.getString("Ciudad");
				prov=rs.getString("Prov");
				codPostal=rs.getString("CodPostal");
				region=rs.getString("Region");
				pais=rs.getString("Pais");
				nombreCompania=rs.getString("NombreCompania");
				cargo=rs.getString("Cargo");
				telefonoTrabajo=rs.getString("TelefonoTrabajo");
				extensionTrabajo=rs.getString("ExtensionTrabajo");
				telefonoMovil=rs.getString("TelefonoMovil");
				numFax=rs.getString("NumFax");
				nomCorreoElectronico=rs.getString("NomCorreoElectronico");
				IdTipoContacto=rs.getInt("IdTipoContacto");
				notas=rs.getString("Notas");
				
				tipo = conn.prepareStatement("select tipoContacto from tipoContacto where IdTipoContacto=?");
				tipo.setInt(1, IdTipoContacto);
				rs2=tipo.executeQuery();
				String tipoCont=rs2.getString("TipoContacto");
				TipoContacto tipoContacto=new TipoContacto(IdTipoContacto, tipoCont);
				
				Contacto contacto=new Contacto(idContacto, nombre, apellidos, estimado, 
						direccion, ciudad, prov, codPostal, region, pais, nombreCompania,
						cargo, telefonoTrabajo, extensionTrabajo, telefonoMovil, numFax,
						nomCorreoElectronico, notas, tipoContacto);
				contactos.add(contacto);
				
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		} 
		return contactos;
	}
	/*
	 * Descripcion - Devuelve todos las llamadas a partir del parametro introducido.
	 * @param contacto - Contacto con el que vamos a filtrar las llamadas realizadas.
	 * @return llamadas - Todas las llamadas del contacto pasado por parametro
	 * @see ubu.lsi.dms.agenda.persistencia.FachadaPersistente#getLlamadas(ubu.lsi.dms.agenda.modelo.Contacto)
	 */
	@Override
	public Collection<Llamada> getLlamadas(Contacto contacto) {
		Collection<Llamada> llamadas = new ArrayList<Llamada>();
		PreparedStatement calls = null;
		ResultSet rs = null;
		String URL="jdbc:hsqldb:hsql://localhost";
		try {
			Connection conn = DriverManager.getConnection(URL, FabricaBD.getUsuario(), FabricaBD.getContraseña());
			calls = conn.prepareStatement("SELECT * FROM Llamadas WHERE IdContacto=?");
			calls.setInt(1, contacto.getIdContacto());
			rs = calls.executeQuery();
			while (rs.next()) {
				int IdLlamada=rs.getInt("IdLlamada");
				String FechaLlamada=rs.getString("FechaLlamada");
				String Asunto=rs.getString("Asunto");
				String Notas=rs.getString("Notas");
				Llamada llamada = new Llamada(IdLlamada, contacto, FechaLlamada, Asunto, Notas);
				llamadas.add(llamada);
			}
		}catch(SQLException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		}
		return llamadas;
	}

	/*
	 * Descripcion - Devuelve todos los Tipo de Contactos
	 * @return contactos - Collection de todos los tipos de Contacto.
	 * @see ubu.lsi.dms.agenda.persistencia.FachadaPersistente#getContacto(java.lang.String)
	 */
	@Override
	public Collection<TipoContacto> getTipoContacto() {
		Collection<TipoContacto> tipoContacto = new ArrayList<TipoContacto>();
		PreparedStatement type = null;
		ResultSet rs = null;
		String URL="jdbc:hsqldb:hsql://localhost";
		try {			
			Connection conn = DriverManager.getConnection(URL, FabricaBD.getUsuario(), FabricaBD.getContraseña());
			type = conn.prepareStatement("SELECT * FROM tipoContacto");		
			rs=type.executeQuery();
			while (rs.next()) {				
				int IdTipoContacto=rs.getInt("IdTipoContacto");
				String tipoCont=rs.getString("TipoContacto");
				TipoContacto tipo=new TipoContacto(IdTipoContacto, tipoCont);
				tipoContacto.add(tipo);
			}
		}catch(SQLException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		}
		return tipoContacto;
	}
	/*
	 * Descripcion - Inserta el Contacto pasado por parametro al final de la Base de Datos
	 * @param contacto - Contacto a insertar.
	 * @see ubu.lsi.dms.agenda.persistencia.FachadaPersistente#getContacto(java.lang.String)
	 */
	@Override
	public void insertContacto(Contacto contacto) {
		PreparedStatement st_insert_Contacto = null;
		PreparedStatement count_Contacto=null;
		String URL="jdbc:hsqldb:hsql://localhost";
		try{
			Connection conn = DriverManager.getConnection(URL, FabricaBD.getUsuario(), FabricaBD.getContraseña());
			count_Contacto=conn.prepareStatement("SELECT COUNT(*) FROM Contactos");
			st_insert_Contacto = conn.prepareStatement(
					"INSERT INTO Contactos VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			st_insert_Contacto.setInt(1, Integer.parseInt(count_Contacto.toString())+1);
			st_insert_Contacto.setString(2,contacto.getNombre());
			st_insert_Contacto.setString(3,contacto.getApellidos());
			st_insert_Contacto.setString(4,contacto.getEstimado());
			st_insert_Contacto.setString(5,contacto.getDireccion());
			st_insert_Contacto.setString(6,contacto.getCiudad());
			st_insert_Contacto.setString(7,contacto.getProv());
			st_insert_Contacto.setString(8,contacto.getCodPostal());
			st_insert_Contacto.setString(9,contacto.getRegion());
			st_insert_Contacto.setString(10,contacto.getPais());
			st_insert_Contacto.setString(11,contacto.getNombreCompania());
			st_insert_Contacto.setString(12,contacto.getCargo());
			st_insert_Contacto.setString(13,contacto.getTelefonoTrabajo());
			st_insert_Contacto.setString(14,contacto.getExtensionTrabajo());
			st_insert_Contacto.setString(15,contacto.getTelefonoMovil());
			st_insert_Contacto.setString(16,contacto.getNumFax());
			st_insert_Contacto.setString(17,contacto.getNomCorreoElectronico());
			st_insert_Contacto.setInt(18,contacto.getTipoContacto().getIdTipoContacto());
			st_insert_Contacto.setString(19,contacto.getNotas());	
		}catch(SQLException e){
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		}
		
	}
	/*
	 * Descripcion - Inserta la Llamada pasado por parametro al final de la Base de Datos
	 * @param llamada - llamada a insertar.
	 * @see ubu.lsi.dms.agenda.persistencia.FachadaPersistente#getContacto(java.lang.String)
	 */
	@Override
	public void insertLlamada(Llamada llamada) {
		PreparedStatement count_Llamadas=null;
		PreparedStatement st_insert_Llamada = null;
		String URL="jdbc:hsqldb:hsql://localhost";
		try{	
			Connection conn = DriverManager.getConnection(URL, FabricaBD.getUsuario(), FabricaBD.getContraseña());
			count_Llamadas=conn.prepareStatement("SELECT COUNT(*) FROM Llamadas");
			st_insert_Llamada = conn.prepareStatement(
					"INSERT INTO LLamadas VALUES (?,?,?,?,?)");
			st_insert_Llamada.setInt(1,Integer.parseInt(count_Llamadas.toString())+1);
			st_insert_Llamada.setInt(2,llamada.getContacto().getIdContacto()); 
			st_insert_Llamada.setString(3,llamada.getFechaLlamada());
			st_insert_Llamada.setString(4,llamada.getAsunto());
			st_insert_Llamada.setString(5,llamada.getNotas());
			
		}catch(SQLException e){
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		}
		
	}
		
	/*
	 * Descripcion - Inserta el tipo contacto pasado por parametro al final de la Base de Datos
	 * @param TipoContacto - tipoContacto a insertar.
	 * @see ubu.lsi.dms.agenda.persistencia.FachadaPersistente#getContacto(java.lang.String)
	 */
	@Override
	public void insertTipoContacto(String TipoContacto){
		PreparedStatement count_TipoContacto=null;
		PreparedStatement st_insert_Tiposdecontacto = null;
		String URL="jdbc:hsqldb:hsql://localhost";
		try{		
			Connection conn = DriverManager.getConnection(URL, FabricaBD.getUsuario(), FabricaBD.getContraseña());
			count_TipoContacto=conn.prepareStatement("SELECT COUNT(*) FROM Llamadas");
			st_insert_Tiposdecontacto = conn.prepareStatement(
					"INSERT INTO Tiposdecontacto VALUES (?,?)");
			st_insert_Tiposdecontacto.setInt(1,Integer.parseInt(count_TipoContacto.toString())+1);
			st_insert_Tiposdecontacto.setString(2,TipoContacto);

			
		}catch(SQLException e){
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		}
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see ubu.lsi.dms.agenda.persistencia.FachadaPersistente#updateContacto(ubu.lsi.dms.agenda.modelo.Contacto)
	 */
	@Override
	public void updateContacto(Contacto contacto) {
		String URL = "jdbc:hsqldb:hsql://localhost";
		try {
			Connection conn = DriverManager.getConnection(URL, FabricaBD.getUsuario(), FabricaBD.getContraseña());
			PreparedStatement st_update_Contacto = null;
		
			st_update_Contacto=conn.prepareStatement("UPDATE Contactos"
					+ " SET IdContacto=?, Nombre=?, Apellidos=?, Estimado=?, Direccion=?, Ciudad=?, Prov=?, CodPostal=?, Region=?, Pais=?, NombreCompania=?, Cargo=?, TelefonoTrabajo=?, ExtesionTrabajo=?, TelefonoMovil=?, NumFax=?, NomCorreoElectronico=?, IdTipoContacto=?, Notas=?"
					+ " WHERE IdContacto=?");
			
			st_update_Contacto.setInt(1, contacto.getIdContacto());
			st_update_Contacto.setString(2,contacto.getNombre());
			st_update_Contacto.setString(3,contacto.getApellidos());
			st_update_Contacto.setString(4,contacto.getEstimado());
			st_update_Contacto.setString(5,contacto.getDireccion());
			st_update_Contacto.setString(6,contacto.getCiudad());
			st_update_Contacto.setString(7,contacto.getProv());
			st_update_Contacto.setString(8,contacto.getCodPostal());
			st_update_Contacto.setString(9,contacto.getRegion());
			st_update_Contacto.setString(10,contacto.getPais());
			st_update_Contacto.setString(11,contacto.getNombreCompania());
			st_update_Contacto.setString(12,contacto.getCargo());
			st_update_Contacto.setString(13,contacto.getTelefonoTrabajo());
			st_update_Contacto.setString(14,contacto.getExtensionTrabajo());
			st_update_Contacto.setString(15,contacto.getTelefonoMovil());
			st_update_Contacto.setString(16,contacto.getNumFax());
			st_update_Contacto.setString(17,contacto.getNomCorreoElectronico());
			st_update_Contacto.setInt(18,contacto.getTipoContacto().getIdTipoContacto());
			st_update_Contacto.setString(19,contacto.getNotas());
			st_update_Contacto.setInt(20, contacto.getIdContacto());
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see ubu.lsi.dms.agenda.persistencia.FachadaPersistente#updateLlamada(ubu.lsi.dms.agenda.modelo.Llamada)
	 */
	@Override
	public void updateLlamada(Llamada llamada) {
		String URL = "jdbc:hsqldb:hsql://localhost";
		try {
			Connection conn = DriverManager.getConnection(URL, FabricaBD.getUsuario(), FabricaBD.getContraseña());
			PreparedStatement st_update_Llamada = null;
			
			st_update_Llamada=conn.prepareStatement("UPDATE Llamadas"
					+ " SET IdLlamada=?, IdContacto=?, FechaLlamada=?, Asunto=?, Notas=?"
					+ " WHERE IdLlamada=?");
			st_update_Llamada.setInt(1,llamada.getIdLlamada());
			st_update_Llamada.setInt(2,llamada.getContacto().getIdContacto()); 
			st_update_Llamada.setString(3,llamada.getFechaLlamada());
			st_update_Llamada.setString(4,llamada.getAsunto());
			st_update_Llamada.setString(5,llamada.getNotas());
			st_update_Llamada.setInt(6, llamada.getIdLlamada());
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		}
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see ubu.lsi.dms.agenda.persistencia.FachadaPersistente#updateTipoContacto(ubu.lsi.dms.agenda.modelo.TipoContacto)
	 */
	@Override
	public void updateTipoContacto(TipoContacto tipoContacto) {
		String URL = "jdbc:hsqldb:hsql://localhost";
		try {
			Connection conn = DriverManager.getConnection(URL, FabricaBD.getUsuario(), FabricaBD.getContraseña());
			PreparedStatement st_update_tipoContacto = null;
			
			st_update_tipoContacto=conn.prepareStatement("UPDATE Tiposdecontacto"
					+ " SET IdTipoContacto=?, TipoContacto=?"
					+ " WHERE IdTipoContacto=?");
			st_update_tipoContacto.setInt(1,tipoContacto.getIdTipoContacto());
			st_update_tipoContacto.setString(2,tipoContacto.getTipoContacto());
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		}
		
	}


}
