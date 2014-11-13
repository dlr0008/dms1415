package ubu.lsi.dms.agenda.test;

import java.util.ArrayList;
import java.util.Collection;

import ubu.lsi.dms.agenda.modelo.*;
import ubu.lsi.dms.agenda.persistencia.FachadaBD;
import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;

public class TestDB {

	private static FachadaPersistente fachada = FachadaBD.getInstance();
	
	static ArrayList<Contacto> contactos = new ArrayList<Contacto>();
	static ArrayList<Llamada> llamadas = new ArrayList<Llamada>();
	static ArrayList<TipoContacto> tiposContacto = new ArrayList<TipoContacto>();

	
	private static void iniDatos(){
		for (int i=1;i<=9;i++){
			TipoContacto tipo = new TipoContacto(i, "TipoDeContacto00"+ i);
			tiposContacto.add(tipo);
			
			Contacto contacto = new Contacto(i, "Nombre00" + i, "Apellidos0" + i, "Estimado00" + i, "Direccion00"
					+ i, "Ciudad00"	+ i, "Prov00" + i, "CodProv00" + i, "Region00"	+ i, "Pais00" + i, "NombreCompania00" 
					+ i, "Cargo00"	+ i, "TelefonoTrabajo00" + i, "ExtensionTrabajo00"	+ i, "TelefonoMovil00" + i, "NumFax00" 
					+ i,"NomCorreoElectronico00" + i, "Notas00" + i, tipo);
			contactos.add(contacto);
			
			Llamada llamada = new Llamada(i, contacto, "2014-11-12 03:00:00.000000", "Asunto00" + i, "Notas00" + i);
			llamadas.add(llamada);	
			System.out.println(contactos);
		}
	}

	/**
	 * Test para los contactos
	 */
	private static void testContactos() {
		Collection<Contacto> todos = new ArrayList<Contacto>();
		for (int i = 1; i <= 9; i++) {
			todos = fachada.getContacto("Apellidos00" + i);
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
				assert ("ExtensionTrabajo00" + i).equals(c.getExtensionTrabajo());
				assert ("TelefonoMovil00" + i).equals(c.getTelefonoMovil());
				assert ("TelefonoTrabajo00" + i).equals(c.getTelefonoTrabajo());
				assert ("NomCorreoElectronico00" + i + "@ubu.es").equals(c.getNomCorreoElectronico());
				assert ("Notas00" + i).equals(c.getNotas());
			}
		}
	}



	/**
	 * Test para las llamdas
	 */
	private static void testLLamadas() {
		Collection<Contacto> contacto = new ArrayList<Contacto>();
		Collection<Llamada> todos = new ArrayList<Llamada>();
		int i = 1;
		contacto = fachada.getContacto("Apellidos001");
		for (Contacto c : contacto) {
			todos = fachada.getLlamadas(c);
			for (Llamada l : todos) {
				System.out.println(l);
				assert ("Nombre00" + i).equals(l.getContacto().getNombre());
				assert ("2014-10-18 0" + i + ":00:00").equals(l.getFechaLlamada());
				assert ("2014-10-18 0" + i + ":00:00").equals(l.getFechaLlamada());
				assert ("AsuntoLlamada00" + i).equals(l.getAsunto());
				i++;
			}
		}
	}

	
	/**
	 * Test para los tipos de contacto
	 */
	private static void testTiposDeContacto() {
		Collection<TipoContacto> tipo = new ArrayList<TipoContacto>();
		tipo = fachada.getTipoContacto();
		int i = 1;
		for (TipoContacto t : tipo) {
			System.out.println(t);
			assert ("Tipo00" + i).equals(t.getTipoContacto());
			i++;
		}
	}
	
	
	/**
	 * Main del test
	 * @param args
	 */
	public static void main(String[] args) {
		iniDatos();
		System.out.println("Test Contactos");
		testContactos();		
		System.out.println("OK");
		System.out.println("Test Llamadas");
		testLLamadas();		
		System.out.println("OK");
		System.out.println("Test TipoContacto");
		testTiposDeContacto();
		System.out.println("OK");
		System.out.println("Todo OK");
	}
}