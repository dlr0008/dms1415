package ubu.lsi.dms.agenda.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.modelo.TipoContacto;
import ubu.lsi.dms.agenda.persistencia.FabricaBin;
import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;

public class initfiles {

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

	private static void iniLlamadas(Collection<Llamada> llamadas,
			Collection<Contacto> contactos) {
		int i = 1;
		for (Contacto c : contactos) {
			llamadas.add(new Llamada(i, c, "2014-10-18 0" + i + ":00:00",
					"AsuntoLlamada00" + i, "NotaLlamada00" + i));
			i++;
		}
	}

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		Collection<Contacto> contactos = new ArrayList<Contacto>();
		Collection<Llamada> llamadas = new ArrayList<Llamada>();
		iniContactos(contactos);
		iniLlamadas(llamadas, contactos);
		FabricaBin fabricabinaria = new FabricaBin();
		FachadaPersistente fachadabinaria = fabricabinaria
				.createFachadaPersistente();
		for (Contacto c : contactos) {
			// System.out.println(c.toString());
			fachadabinaria.insertContacto(c);
		}
		for (Llamada l : llamadas) {
			// System.out.println(l.toString());
			fachadabinaria.insertLlamada(l);
		}
		System.out.println("FINALIZADA INSERCIÓN");

		testContactos(contactos, fachadabinaria);
		// testLlamadas(contactos, fachadabinaria);

		System.out.println("OK");

	}

	private static void testContactos(Collection<Contacto> contactos,
			FachadaPersistente fachadabinaria) {
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

	}

	private static void testLlamadas(Collection<Contacto> contactos,
			FachadaPersistente fachadabinaria) {
		Collection<Llamada> llamadasTest = null;
		Collection<Contacto> contacto = new ArrayList<Contacto>();
		Collection<Llamada> todos = new ArrayList<Llamada>();
		int i = 1;
		contacto = fachadabinaria.getContacto("Apellidos001");
		for (Contacto c : contacto) {
			todos = fachadabinaria.getLlamadas(c);
			for (Llamada l : todos) {
				// assert i.equals(l.getIdLlamada();
				assert ("Nombre001".equals(l.getContacto().getNombre()));
				assert ("2014-10-18 0" + i + ":00:00").equals(l
						.getFechaLlamada());
				assert ("2014-10-18 0" + i + ":00:00").equals(l
						.getFechaLlamada());
				assert ("AsuntoLlamada00" + i).equals(l.getAsunto());
				i++;

			}
		}
	}
}
