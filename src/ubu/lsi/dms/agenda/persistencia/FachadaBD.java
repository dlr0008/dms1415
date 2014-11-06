/**
 * 
 */
package ubu.lsi.dms.agenda.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

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
	
	private static Logger l = null;
	
	int idContacto=0;
	String nombre=null;
	String apellidos=null;
	String estimado=null;
	String direccion=null;
	String ciudad=null;
	String prov=null;
	String codPostal=null;
	String region=null;
	String pais=null;;
	String nombreCompania=null;
	String cargo=null;
	String telefonoTrabajo=null;
	String extensionTrabajo=null;
	String telefonoMovil=null;
	String numFax=null;
	String nomCorreoElectronico=null;
	int IdTipoContacto=0;
	String notas=null;
	
	
	/*
	 * Descripcion - Devuelve todos los contactos a partir del parametro introducido.
	 * @param apellido - Campo a partir del cual vamos a filtar los contactos.
	 * @return contactos - Collection de todos los contactos con el mismo apellido.
	 * @see ubu.lsi.dms.agenda.persistencia.FachadaPersistente#getContacto(java.lang.String)
	 */
	@Override
	public Collection<Contacto> getContacto(String apellido) {
		Collection<Contacto> contactos = new ArrayList<Contacto>();
		Connection conn = null;
		PreparedStatement contacts = null;
		PreparedStatement tipo = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		try {
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
		Connection conn = null;
		PreparedStatement calls = null;
		ResultSet rs = null;
		try {
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
	 * (non-Javadoc)
	 * @see ubu.lsi.dms.agenda.persistencia.FachadaPersistente#getTipoContacto()
	 */
	@Override
	public Collection<TipoContacto> getTipoContacto() {
		Collection<TipoContacto> tipoContacto = new ArrayList<TipoContacto>();
		Connection conn = null;
		PreparedStatement type = null;
		ResultSet rs = null;
		try {
			type = conn.prepareStatement("select * from tipoContacto");		
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
	 * (non-Javadoc)
	 * @see ubu.lsi.dms.agenda.persistencia.FachadaPersistente#insertContacto(ubu.lsi.dms.agenda.modelo.Contacto)
	 */
	@Override
	public void insertContacto(Contacto contacto) {
		Connection conn = null;
		PreparedStatement ins=null;
		PreparedStatement st_insert_Contacto = null;
		try{			
			st_insert_Contacto = conn.prepareStatement(
					"INSERT INTO Contactos VALUES (seq_facturas.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			st_insert_Contacto.setString(1,contacto.getNombre());
			st_insert_Contacto.setString(2,contacto.getApellidos());
			st_insert_Contacto.setString(3,contacto.getEstimado());
			st_insert_Contacto.setString(4,contacto.getDireccion());
			st_insert_Contacto.setString(5,contacto.getCiudad());
			st_insert_Contacto.setString(6,contacto.getProv());
			st_insert_Contacto.setString(7,contacto.getCodPostal());
			st_insert_Contacto.setString(8,contacto.getRegion());
			st_insert_Contacto.setString(9,contacto.getPais());
			st_insert_Contacto.setString(10,contacto.getNombreCompania());
			st_insert_Contacto.setString(11,contacto.getCargo());
			st_insert_Contacto.setString(12,contacto.getTelefonoTrabajo());
			st_insert_Contacto.setString(13,contacto.getExtensionTrabajo());
			st_insert_Contacto.setString(14,contacto.getTelefonoMovil());
			st_insert_Contacto.setString(15,contacto.getNumFax());
			st_insert_Contacto.setString(16,contacto.getNomCorreoElectronico());
			st_insert_Contacto.setInt(17,contacto.getTipoContacto().getIdTipoContacto());
			st_insert_Contacto.setString(18,contacto.getNotas());	
		}catch(SQLException e){
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		}
		
	}
	/*
	 * (non-Javadoc)
	 * @see ubu.lsi.dms.agenda.persistencia.FachadaPersistente#insertLlamada(ubu.lsi.dms.agenda.modelo.Llamada)
	 */
	@Override
	public void insertLlamada(Llamada llamada) {
		Connection conn = null;
		PreparedStatement ins=null;
		PreparedStatement st_insert_Llamada = null;
		try{		
			
			st_insert_Llamada = conn.prepareStatement(
					"INSERT INTO LLamadas VALUES (seq_facturas.nextval,?,?,?,?)");
			st_insert_Llamada.setInt(1,llamada.getContacto().getTipoContacto().getIdTipoContacto()); 
			st_insert_Llamada.setString(2,llamada.getFechaLlamada());
			st_insert_Llamada.setString(3,llamada.getAsunto());
			st_insert_Llamada.setString(4,llamada.getNotas());
			
		}catch(SQLException e){
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		}
		
	}
		
	/*
	 * 
	 * @see ubu.lsi.dms.agenda.persistencia.FachadaPersistente#insertTipoContacto(java.lang.String)
	 */
	@Override
	public void insertTipoContacto(String TipoContacto) {
		Connection conn = null;
		PreparedStatement ins=null;
		PreparedStatement st_insert_Tiposdecontacto = null;
		try{		
			
			st_insert_Tiposdecontacto = conn.prepareStatement(
					"INSERT INTO Tiposdecontacto VALUES (seq_facturas.nextval,?)");
			st_insert_Tiposdecontacto.setString(1,TipoContacto);

			
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
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see ubu.lsi.dms.agenda.persistencia.FachadaPersistente#updateLlamada(ubu.lsi.dms.agenda.modelo.Llamada)
	 */
	@Override
	public void updateLlamada(Llamada llamada) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see ubu.lsi.dms.agenda.persistencia.FachadaPersistente#updateTipoContacto(ubu.lsi.dms.agenda.modelo.TipoContacto)
	 */
	@Override
	public void updateTipoContacto(TipoContacto tipoContacto) {
		// TODO Auto-generated method stub
		
	}


}
