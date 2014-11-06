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
		String fileContactos = "." + File.separator + "res"
				+ File.separator + "contactos.dat";
		String filellamadas = "." + File.separator + "res" + File.separator
				+ "contactos.dat";
		Collection<Contacto> contactos = new ArrayList<Contacto>();
		iniContactos(contactos);
		FabricaBin fabricabinaria = new FabricaBin();
		FachadaPersistente fachadabinaria = fabricabinaria.createFachadaPersistente();
		
		contactos = fachadabinaria.getContacto("hola");
		for (Contacto c : contactos) {
			Logger.getLogger("global").info(c.toString());
		}
	}

	private static void iniContactos(Collection<Contacto> contactos) {
		Contacto contacto = null;
		for (int i = 1; i < 10; i++) {
			contacto = new Contacto("nombre " + i, " apellido " + i,
					" telefono " + i);
			Llamada llamada = null;
			for (int j = 1; j < 5; j++) {
				llamada = new Llamada("Asunto " + i + j);
				contacto.addLlamada(llamada);
			}
			contactos.add(contacto);
		}
	}

}
