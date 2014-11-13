package ubu.lsi.dms.agenda.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.modelo.TipoContacto;
import ubu.lsi.dms.agenda.persistencia.FabricaBin;
import ubu.lsi.dms.agenda.persistencia.FachadaBin;
import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;

public class TestBin {

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

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		Collection<Contacto> contactos = new ArrayList<Contacto>();
		Collection<Llamada> llamadas = new ArrayList<Llamada>();
		Collection<TipoContacto> tipos = new ArrayList<TipoContacto>();

		FabricaBin fabricabinaria = new FabricaBin();
		FachadaPersistente fachadaBinaria = fabricabinaria
				.createFachadaPersistente();
		new File("." + File.separator + "res" + File.separator
				+ "contactos.dat").delete();
		new File("." + File.separator + "res" + File.separator + "llamadas.dat")
				.delete();
		new File("." + File.separator + "res" + File.separator + "tipos.dat")
				.delete();

		iniContactos(contactos);
		iniLlamadas(llamadas, fachadaBinaria);
		iniTipos(fachadaBinaria);
		for (Contacto c : contactos) {
			// System.out.println(c.toString());
			fachadaBinaria.insertContacto(c);
		}
		for (Llamada l : llamadas) {
			// System.out.println(l.toString());
			fachadaBinaria.insertLlamada(l);
		}

		System.out.println("FINALIZADA INSERCIÓN");

		System.out.println("TEST CONTACTOS");
		testContactos(contactos, fachadaBinaria);
		System.out.println("TEST LLAMADAS");
		testLlamadas(contactos, fachadaBinaria);
		System.out.println("TEST TIPOS");
		testTipos(fachadaBinaria);
		System.out.println("OK");
	}

	private static void testTipos(FachadaPersistente fachadaBinaria) {
		ArrayList<TipoContacto> tipos = (ArrayList<TipoContacto>) fachadaBinaria
				.getTipoContacto();

		int i = 1;
		for (TipoContacto t : tipos) {
			assert t.getIdTipoContacto() == i;
			assert t.getTipoContacto().equals("Tipo00" + i);
			i++;
		}

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
				assert ("2014-10-18 0" + i + ":00:00").equals(l
						.getFechaLlamada());
				assert ("AsuntoLlamada00" + i).equals(l.getAsunto());
				i++;

			}
		}
	}

	private static void iniTipos(FachadaPersistente fachadaBinaria) {

		for (int i = 1; i <= 9; i++)
			fachadaBinaria.insertTipoContacto("Tipo00" + i);

	}

}