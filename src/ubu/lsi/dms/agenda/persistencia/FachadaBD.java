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
				int idContacto=rs.getInt("IdContacto");
				String nombre=rs.getString("Nombre");
				String apellidos=rs.getString("Apellidos");
				String estimado=rs.getString("Estimado");
				String direccion=rs.getString("Direccion");
				String ciudad=rs.getString("Ciudad");
				String prov=rs.getString("Prov");
				String codPostal=rs.getString("CodPostal");
				String region=rs.getString("Region");
				String pais=rs.getString("Pais");
				String nombreCompania=rs.getString("NombreCompania");
				String cargo=rs.getString("Cargo");
				String telefonoTrabajo=rs.getString("TelefonoTrabajo");
				String extensionTrabajo=rs.getString("ExtensionTrabajo");
				String telefonoMovil=rs.getString("TelefonoMovil");
				String numFax=rs.getString("NumFax");
				String nomCorreoElectronico=rs.getString("NomCorreoElectronico");
				int IdTipoContacto=rs.getInt("IdTipoContacto");
				String notas=rs.getString("Notas");
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
