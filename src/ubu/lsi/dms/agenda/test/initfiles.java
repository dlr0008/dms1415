package ubu.lsi.dms.agenda.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

import ubu.lsi.dms.agenda.modelo.*;
import ubu.lsi.dms.agenda.persistencia.FabricaBin;
import ubu.lsi.dms.agenda.persistencia.FachadaBin;
import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;

public class initfiles {

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		String fileContactos = "." + File.separator + "res" + File.separator
				+ "contactos.dat";
		String filellamadas = "." + File.separator + "res" + File.separator
				+ "contactos.dat";
		Collection<Contacto> contactos = new ArrayList<Contacto>();
		iniContactos(contactos);
		FabricaBin fabricabinaria = new FabricaBin();
		FachadaPersistente fachadabinaria = fabricabinaria
				.createFachadaPersistente();
		for (Contacto c : contactos) {
			System.out.println(c.toString());
			fachadabinaria.insertContacto(c);
		}
		System.out.println("FINALIZADA INSERCIÓN");
		
		testContactos(contactos,fachadabinaria);

	}

	private static void iniContactos(Collection<Contacto> contactos) {
		TipoContacto tipoContacto = new TipoContacto(1, "Tipo001");
		for (int i = 1; i <= 9; i++)
			contactos.add(new Contacto(i, "Nombre00" + i, "Apellidos00" + i,
					"Estimado00" + i, " Direccion00" + i, "Ciudad00" + i,
					"Prov00" + i, "CodPostal000" + i, "Region000" + i,
					"Pais000" + i, "NombreCompania000" + i, "Cargo000" + i,
					"TelefonoTrabajo00" + i, "ExtensionTrabajo00" + i,
					"TelefonoMovil00" + i, "NumFax00" + i,
					" NomCorreoElectronico00" + i + "@ubu.es", "Notas00" + i,
					tipoContacto));

	}

	private static void testContactos(Collection<Contacto> contactos,
			FachadaPersistente fachadabinaria) {

		int i = 1;

		for (Contacto c : contactos) {

			assert c.equals(fachadabinaria.getContacto("Apellido00" + i));
			i++;
		}

	}
}
