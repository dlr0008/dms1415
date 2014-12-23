package ubu.lsi.dms.agenda.modelo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import ubu.lsi.dms.agenda.modelo.Contacto;

/**
 * @author <A HREF="mailto:jld0016@alu.ubu.es">Jorge Laguna</A>
 * @author <A HREF="mailto:rmp0046@alu.ubu.es">Roberto Miranda</A>
 * @author <A HREF="mailto:aam0093@alu.ubu.es">Asier Alonso</A>
 * @author <A HREF="mailto:dlr0008@alu.ubu.es">Daniel Lozano</A>
 * @version 1.0
 * 
 *          Tabla Abstacta que permite crear las tablas de Contactos empleada
 *          para crar los JTable que usa la aplicacion, contiene la lista de
 *          contactos
 */
public class TablaContactos extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	public List<Contacto> listaContactos;
	private String[] cabecera = new String[] { "Id", "Nombre", "Apellidos",
			"Estimado", "Direccion", "Ciudad", "Prov", "CodPostal", "Region",
			"Páis", "NombreCompañia", "Cargo", "telefonoTrabajo",
			"ExtensionTrabajo", "TelefonoMovil", "NumFax",
			"NomCorreoElectronico", "Notas" };

	public TablaContactos() {
		listaContactos = new ArrayList<Contacto>();
	}

	public void add(Contacto contacto) {
		listaContactos.add(contacto);
	}

	@Override
	public int getColumnCount() {
		return 18;
	}

	@Override
	public int getRowCount() {
		return listaContactos.size();
	}

	@Override
	public Object getValueAt(int fila, int columna) {
		Contacto c = listaContactos.get(fila);
		switch (columna) {
		case 0:
			return c.getIdContacto();
		case 1:
			return c.getNombre();
		case 2:
			return c.getApellidos();
		case 3:
			return c.getEstimado();
		case 4:
			return c.getDireccion();
		case 5:
			return c.getCiudad();
		case 6:
			return c.getProv();
		case 7:
			return c.getCodPostal();
		case 8:
			return c.getRegion();
		case 9:
			return c.getPais();
		case 10:
			return c.getNombreCompania();
		case 11:
			return c.getCargo();
		case 12:
			return c.getTelefonoTrabajo();
		case 13:
			return c.getExtensionTrabajo();
		case 14:
			return c.getTelefonoMovil();
		case 15:
			return c.getNumFax();
		case 16:
			return c.getNomCorreoElectronico();
		case 17:
			return c.getNotas();
		}
		return "";
	}

	public String[] getCabecera() {
		return cabecera;
	}
}
