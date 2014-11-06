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
	int IdTipoContacto=0; //Esto tiene que ser TipoContacto
	String notas=null;

	@Override
	public Collection<Contacto> getContacto(String apellido) {
		Collection<Contacto> contactos = new ArrayList<Contacto>();
		Connection conn = null;
		PreparedStatement contacts = null;
		PreparedStatement tipo = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		try {
			contacts = conn.prepareStatement("select * from contactos");
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
	
	@Override
	public Collection<Llamada> getLlamadas(Contacto contacto) {
		Collection<Llamada> llamadas = new ArrayList<Llamada>();
		Connection conn = null;
		PreparedStatement calls = null;
		ResultSet rs = null;
		try {
			calls = conn.prepareStatement("select * from llamadas");
			rs = calls.executeQuery();
			while (rs.next()) {
				int IdLlamada=rs.getInt("IdLlamada");
				int IdContacto=rs.getInt("IdContacto");
				String FechaLlamada=rs.getString("FechaLlamada");
				String Asunto=rs.getString("Asunto");
				String Notas=rs.getString("Notas");
			}
		}catch(SQLException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		}
		return llamadas;
	}

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

	@Override
	public void insertContacto(Contacto contacto) {
		Connection conn = null;
		PreparedStatement ins=null;
		PreparedStatement st_insert_Contacto = null;
		try{			
			st_insert_Contacto = conn.prepareStatement(
					"INSERT INTO Contactos VALUES (seq_facturas.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			st_insert_Contacto.setString(1,contacto.nombre);
			st_insert_Contacto.setString(2,contacto.apellidos);
			st_insert_Contacto.setString(3,contacto.estimado);
			st_insert_Contacto.setString(4,contacto.direccion);
			st_insert_Contacto.setString(5,contacto.ciudad);
			st_insert_Contacto.setString(6,contacto.prov);
			st_insert_Contacto.setString(7,contacto.codPostal);
			st_insert_Contacto.setString(8,contacto.region);
			st_insert_Contacto.setString(9,contacto.pais);
			st_insert_Contacto.setString(10,contacto.nombreCompania);
			st_insert_Contacto.setString(11,contacto.cargo);
			st_insert_Contacto.setString(12,contacto.telefonoTrabajo);
			st_insert_Contacto.setString(13,contacto.extensionTrabajo);
			st_insert_Contacto.setString(14,contacto.telefonoMovil);
			st_insert_Contacto.setString(15,contacto.numFax);
			st_insert_Contacto.setString(16,contacto.nomCorreoElectronico);
			st_insert_Contacto.setInt(17,contacto.tipoContacto);
			st_insert_Contacto.setString(18,contacto.notas);	
		}catch(SQLException e){
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		}
		
	}

	@Override
	public void insertLlamada(Llamada llamada) {
		Connection conn = null;
		PreparedStatement ins=null;
		PreparedStatement st_insert_Llamada = null;
		try{		
			
			st_insert_Llamada = conn.prepareStatement(
					"INSERT INTO LLamadas VALUES (seq_facturas.nextval,?,?,?,?)");
			st_insert_Llamada.setInt(1,llamada.contacto); //el idContacto es de tipo Contacto
			st_insert_Llamada.setString(2,llamada.fechaLlamada);
			st_insert_Llamada.setString(3,llamada.asunto);
			st_insert_Llamada.setString(4,llamada.notas);
			
		}catch(SQLException e){
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		}
		
	}
		

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
