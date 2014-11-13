package ubu.lsi.dms.agenda.test;

import java.util.ArrayList;
import java.util.Collection;

import ubu.lsi.dms.agenda.modelo.*;
import ubu.lsi.dms.agenda.persistencia.FabricaBD;
import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;

/**
 * Clase de test para comprobar que todas las operacion en BD se realizana
 * correctamente
 * 
 * @author <A HREF="mailto:jld0016@alu.ubu.es">Jorge Laguna</A>
 * @author <A HREF="mailto:rmp0046@alu.ubu.es">Roberto Miranda</A>
 * @author <A HREF="mailto:aam0093@alu.ubu.es">Asier Alonso</A>
 * @author <A HREF="mailto:dlr0008@alu.ubu.es">Daniel Lozano</A>
 * @version 1.0
 */
public class TestDB {

	/**
	 * Metodo para inicializar los contactos
	 * 
	 * @param contactos
	 */
	private static void iniContactos(Collection<Contacto> contactos) {
		TipoContacto tipoContacto = new TipoContacto(1, "Tipo001");
		for (int i = 1; i <= 9; i++)
			contactos.add(new Contacto(i, "Nombre00" + i, "Apellidos00" + i,
					"Estimado00" + i, "Direccion00" + i, "Ciudad00" + i,
					"Prov00" + i, "CodPostal000" + i, "Region000" + i,
					"Pais000" + i, "NombreCompania000" + i, "Cargo000" + i,
					"TelefonoTrabajo00" + i, "ExtensionTrabajo00" + i,
					"TelefonoMovil00" + i, "NumFax00" + i,
					" NomCorreoElectronico00" + i + "@ubu.es", "Notas00" + i,
					tipoContacto));
	}

	/**
	 * Metodo para inicializar las llamadas
	 * 
	 * @param llamadas
	 * @param fachadaBD
	 */
	private static void iniLlamadas(Collection<Llamada> llamadas,
			FachadaPersistente fachadaBD) {
		// int i = 1;
		TipoContacto tipoContacto = new TipoContacto(1, "Tipo001");

		for (int i = 1; i <= 5; i++) {
			llamadas.add(new Llamada(i, new Contacto(1, "Nombre00" + 1,
					"Apellidos00" + 1, "Estimado00" + 1, "Direccion00" + 1,
					"Ciudad00" + 1, "Prov00" + 1, "CodPostal000" + i,
					"Region000" + i, "Pais000" + 1, "NombreCompania000" + 1,
					"Cargo000" + 1, "TelefonoTrabajo00" + 1,
					"ExtensionTrabajo00" + 1, "TelefonoMovil00" + 1,
					"NumFax00" + 1, " NomCorreoElectronico00" + 1 + "@ubu.es",
					"Notas00" + 1, tipoContacto),
					"2014-10-18 0" + i + ":00:00", "AsuntoLlamada00" + i,
					"NotaLlamada00" + i));
		}
	}

	/**
	 * Metodo para inicializar e insertar los tipos de contactos
	 * 
	 * @param fachadaBD
	 */
	private static void iniTipos(FachadaPersistente fachadaBD) {
		for (int i = 1; i <= 9; i++)
			fachadaBD.insertTipoContacto("Tipo00" + i);
	}

	/**
	 * Main del test
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Collection<Contacto> contactos = new ArrayList<Contacto>();
		Collection<Llamada> llamadas = new ArrayList<Llamada>();
		FabricaBD fabricaBD = new FabricaBD();
		FachadaPersistente fachadaBD = fabricaBD.createFachadaPersistente();
		// Iniciamos los tipos de datos
		iniContactos(contactos);
		iniLlamadas(llamadas, fachadaBD);
		iniTipos(fachadaBD);
		// Introducimos contactos y llamadas en BD
		for (Contacto c : contactos) {
			// System.out.println(c.toString());
			fachadaBD.insertContacto(c);
		}
		for (Llamada l : llamadas) {
			// System.out.println(l.toString());
			fachadaBD.insertLlamada(l);
		}
		// Mostramos la evoluxion en pantalla
		System.out.println("FINALIZADA INSERCIÓN");
		System.out.println("TEST CONTACTOS");
		testContactos(contactos, fachadaBD);
		System.out.println("TEST LLAMADAS");
		testLlamadas(contactos, fachadaBD);
		System.out.println("TEST TIPOS");
		testTipos(fachadaBD);
		System.out.println("OK");
	}

	/**
	 * Metodo para probar el funcionamiento de los contactos(get, insert,
	 * update)
	 * 
	 * @param contactos
	 * @param fachadaBD
	 */
	private static void testContactos(Collection<Contacto> contactos,
			FachadaPersistente fachadaBD) {
		Collection<Contacto> todos = new ArrayList<Contacto>();
		for (int i = 1; i <= 9; i++) {
			todos = fachadaBD.getContacto("Apellidos00" + i);
			assert (todos.size() == 1);
			for (Contacto c : todos) {
				assert ("Nombre00" + i).equals(c.getNombre());
				assert ("Apellidos00" + i).equals(c.getApellidos());
				assert ("Estimado00" + i).equals(c.getEstimado());
				assert ("Direccion00" + i).equals(c.getDireccion());
				assert ("Ciudad00" + i).equals(c.getCiudad());
				assert ("Prov00" + i).equals(c.getProv());
				assert ("CodPostal000" + i).equals(c.getCodPostal());
				assert ("Region000" + i).equals(c.getRegion());
				assert ("TelefonoTrabajo00" + i).equals(c.getTelefonoTrabajo());
				assert ("ExtensionTrabajo00" + i).equals(c
						.getExtensionTrabajo());
				assert ("TelefonoMovil00" + i).equals(c.getTelefonoMovil());
				assert ("TelefonoTrabajo00" + i).equals(c.getTelefonoTrabajo());
				assert (" NomCorreoElectronico00" + i + "@ubu.es").equals(c
						.getNomCorreoElectronico());
				assert ("Notas00" + i).equals(c.getNotas());
			}
		}
		Collection<Contacto> actualizar = new ArrayList<Contacto>();
		actualizar = fachadaBD.getContacto("Apellidos002");
		for (Contacto c : actualizar) {
			c.setApellidos("NuevoApellido");
			fachadaBD.updateContacto(c);
		}
		assert fachadaBD.getContacto("NuevoApellido").size() == 1;
		assert fachadaBD.getContacto("Apellidos002").size() == 0;

	}

	/**
	 * Metodo para probar el funcionamiento de las llamadas(get, insert, update)
	 * 
	 * @param contactos
	 * @param fachadaBD
	 */
	private static void testLlamadas(Collection<Contacto> contactos,
			FachadaPersistente fachadaBD) {
		Collection<Contacto> contacto = new ArrayList<Contacto>();
		Collection<Llamada> todos = new ArrayList<Llamada>();
		int i = 1;
		contacto = fachadaBD.getContacto("Apellidos001");
		for (Contacto c : contacto) {
			todos = fachadaBD.getLlamadas(c);
			assert todos.size() == 5;
			for (Llamada l : todos) {
				assert ("Nombre001".equals(l.getContacto().getNombre()));
				assert ("2014-10-18 0" + i + ":00:00.000000").equals(l
						.getFechaLlamada());
				assert ("AsuntoLlamada00" + i).equals(l.getAsunto());
				i++;
			}
		}
		Collection<Llamada> actualizar = new ArrayList<Llamada>();
		for (Contacto c : contacto) {
			actualizar = fachadaBD.getLlamadas(c);
			for (Llamada l : actualizar) {
				if (l.getIdLlamada() == 3) {
					l.setAsunto("NuevoAsunto");
					l.setNotas("NuevasNotas");
					fachadaBD.updateLlamada(l);
				}
			}
		}
		for (Contacto c : contacto) {
			actualizar = fachadaBD.getLlamadas(c);
			assert actualizar.size() == 5;
			for (Llamada l : actualizar) {
				if (l.getIdLlamada() == 3) {
					assert l.getAsunto().equals("NuevoAsunto");
					assert l.getNotas().equals("NuevasNotas");
					l.setAsunto("Asunto003");
					l.setNotas("Notas003");
					fachadaBD.updateLlamada(l);
				}
			}
		}
	}

	/**
	 * Metodo para probar el funcionamiento de los tipos(get, insert, update)
	 * 
	 * @param fachadaBD
	 */
	private static void testTipos(FachadaPersistente fachadaBD) {
		ArrayList<TipoContacto> tipos = (ArrayList<TipoContacto>) fachadaBD
				.getTipoContacto();

		int i = 1;
		assert tipos.size() == 9;
		for (TipoContacto t : tipos) {
			assert t.getIdTipoContacto() == i;
			assert t.getTipoContacto().equals("Tipo00" + i);
			i++;
		}
		for (TipoContacto t : tipos) {
			if (t.getIdTipoContacto() == 1)
				t.setTipoContacto("NuevoTipo");
			fachadaBD.updateTipoContacto(t);
		}
		tipos = (ArrayList<TipoContacto>) fachadaBD.getTipoContacto();
		assert tipos.size() == 9;
		i = 1;
		for (TipoContacto t : tipos) {
			assert t.getIdTipoContacto() == i;
			i++;
		}
	}
}