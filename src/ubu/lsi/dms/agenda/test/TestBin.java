package ubu.lsi.dms.agenda.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.modelo.TipoContacto;
import ubu.lsi.dms.agenda.persistencia.FabricaBin;
import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;

/**
 * Clase Que realiza una serie de pruebas sobre los metodos de la Fachada
 * Binaria y los distintos archivos
 * 
 * @author <A HREF="mailto:jld0016@alu.ubu.es">Jorge Laguna</A>
 * @author <A HREF="mailto:rmp0046@alu.ubu.es">Roberto Miranda</A>
 * @author <A HREF="mailto:aam0093@alu.ubu.es">Asier Alonso</A>
 * @author <A HREF="mailto:dlr0008@alu.ubu.es">Daniel Lozano</A>
 * @version 1.0
 */

public class TestBin {
	/**
	 * Inicializa una coleción con los contactos que se emplean para las
	 * pruebas.
	 * 
	 * @param contactos
	 *            lista donde se guardan los contactos
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
	 * Inicializa una coleción con las llamadas que se emplean para las pruebas.
	 * 
	 * @param contactos
	 *            lista donde se guardan las llamadas
	 */
	private static void iniLlamadas(Collection<Llamada> llamadas,
			FachadaPersistente fachadaBinaria) {
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
	 * Inicilizaliza los tipos de contacto y los guarda en su fichero.
	 * 
	 * @param fachadaBinaria
	 *            Fachada que controla las operaciones sobre los ficheros
	 */
	private static void iniTipos(FachadaPersistente fachadaBinaria) {

		for (int i = 1; i <= 9; i++)
			fachadaBinaria.insertTipoContacto("Tipo00" + i);

	}

	/**
	 * Metodo que borra los ficheros para poder realiar las pruebas desde 0
	 * 
	 */
	private static void limpiarFicheros() {
		File contactos = new File("." + File.separator + "res" + File.separator
				+ "contactos.dat");
		if (contactos.exists())
			contactos.delete();

		File llamadas = new File("." + File.separator + "res" + File.separator
				+ "llamadas.dat");
		if (llamadas.exists()) {
			llamadas.delete();
		}
		File tipos = new File("." + File.separator + "res" + File.separator
				+ "tipos.dat");
		if (tipos.exists()) {
			tipos.delete();
		}

	}

	/**
	 * 
	 * Metodo main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Collection<Contacto> contactos = new ArrayList<Contacto>();
		Collection<Llamada> llamadas = new ArrayList<Llamada>();
		FabricaBin fabricabinaria = new FabricaBin();
		FachadaPersistente fachadaBinaria = fabricabinaria
				.createFachadaPersistente();

		limpiarFicheros();
		iniContactos(contactos);
		iniLlamadas(llamadas, fachadaBinaria);
		iniTipos(fachadaBinaria);

		for (Contacto c : contactos) {
			fachadaBinaria.insertContacto(c);
		}
		for (Llamada l : llamadas) {
			fachadaBinaria.insertLlamada(l);
		}

		System.out.println("FINALIZADA INSERCIÓN");

		testContactos(contactos, fachadaBinaria);
		testLlamadas(contactos, fachadaBinaria);
		testTipos(fachadaBinaria);

		System.out.println("OK");
	}

	/**
	 * Pruebas sobre el fichero de contactos que obtiene todos los contactos y
	 * realiza updates comprobando que los datos quedan guardados correctamente
	 * 
	 * @param contactos
	 *            colección de contactos
	 * @param fachadabinaria
	 *            fachada que controla las operaciones sobre los ficheros.
	 */
	private static void testContactos(Collection<Contacto> contactos,
			FachadaPersistente fachadabinaria) {
		System.out.println("TEST CONTACTOS");
		Collection<Contacto> todos = new ArrayList<Contacto>();
		for (int i = 1; i <= 9; i++) {
			todos = fachadabinaria.getContacto("Apellidos00" + i);
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
		actualizar = fachadabinaria.getContacto("Apellidos002");
		for (Contacto c : actualizar) {
			c.setApellidos("NuevoApellido");
			fachadabinaria.updateContacto(c);
		}

		assert fachadabinaria.getContacto("NuevoApellido").size() == 1;
		assert fachadabinaria.getContacto("Apellidos002").size() == 0;
	}

	/**
	 * Pruebas sobre el fichero de llamadas que obtiene todas las llamadas y
	 * realiza updates comprobando que los datos quedan guardados correctamente
	 * 
	 * @param contactos
	 *            Colección de contactos para obtener las llamadas
	 * @param fachadabinaria
	 *            fachada que controla las operaciones sobre los ficheros.
	 */
	private static void testLlamadas(Collection<Contacto> contactos,
			FachadaPersistente fachadabinaria) {
		System.out.println("TEST LLAMADAS");
		Collection<Contacto> contacto = new ArrayList<Contacto>();
		Collection<Llamada> todos = new ArrayList<Llamada>();
		int i = 1;
		contacto = fachadabinaria.getContacto("Apellidos001");
		for (Contacto c : contacto) {
			todos = fachadabinaria.getLlamadas(c);
			assert todos.size() == 5;
			for (Llamada l : todos) {
				assert ("Nombre001".equals(l.getContacto().getNombre()));
				assert ("2014-10-18 0" + i + ":00:00").equals(l
						.getFechaLlamada());
				assert ("AsuntoLlamada00" + i).equals(l.getAsunto());
				i++;

			}
		}
		i = 1;
		Collection<Llamada> actualizar = new ArrayList<Llamada>();
		for (Contacto c : contacto) {
			actualizar = fachadabinaria.getLlamadas(c);
			for (Llamada l : actualizar) {
				assert i == l.getIdLlamada();
				if (l.getIdLlamada() == 3) {
					l.setAsunto("NuevoAsunto");
					l.setNotas("NuevasNotas");
					fachadabinaria.updateLlamada(l);
				}
				i++;
			}
		}
		for (Contacto c : contacto) {
			actualizar = fachadabinaria.getLlamadas(c);
			assert actualizar.size() == 5;
			for (Llamada l : actualizar) {
				if (l.getIdLlamada() == 3) {
					assert l.getAsunto().equals("NuevoAsunto");
					assert l.getNotas().equals("NuevasNotas");
					l.setAsunto("Asunto003");
					l.setNotas("Notas003");
					fachadabinaria.updateLlamada(l);
				}

			}
		}
	}

	/**
	 * Pruebas sobre el fichero de tipos de contacto que obtiene todos los tipos
	 * de contacto y realiz updates comprobando que los datos quedan guardados
	 * correctamente
	 * 
	 * @param fachadabinaria
	 *            fachada que controla las operaciones sobre los ficheros.
	 */
	private static void testTipos(FachadaPersistente fachadaBinaria) {
		System.out.println("TEST TIPOS");
		ArrayList<TipoContacto> tipos = (ArrayList<TipoContacto>) fachadaBinaria
				.getTipoContacto();

		int i = 1;
		assert tipos.size() == 9;
		for (TipoContacto t : tipos) {
			assert t.getIdTipoContacto() == i;
			assert t.getTipoContacto().equals("Tipo00" + i);
			i++;
		}
		for (TipoContacto t : tipos) {
			if (t.getIdTipoContacto() == 4)
				t.setTipoContacto("NuevoTipo");
			fachadaBinaria.updateTipoContacto(t);
		}
		tipos = (ArrayList<TipoContacto>) fachadaBinaria.getTipoContacto();
		assert tipos.size() == 9;
		i = 1;
		for (TipoContacto t : tipos) {
			assert t.getIdTipoContacto() == i;
			if (i == 4)
				assert t.getTipoContacto().equals("NuevoTipo");
			i++;
		}

	}

}
