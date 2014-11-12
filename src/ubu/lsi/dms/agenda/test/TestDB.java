package ubu.lsi.dms.agenda.test;

import java.util.ArrayList;
import ubu.lsi.dms.agenda.modelo.*;
import ubu.lsi.dms.agenda.persistencia.FachadaBD;
import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;

public class TestDB {

	private static FachadaPersistente fachada = FachadaBD.getInstance();
	
	static ArrayList<Contacto> contactos = new ArrayList<Contacto>();
	static ArrayList<Llamada> llamadas = new ArrayList<Llamada>();
	static ArrayList<TipoContacto> tiposContacto = new ArrayList<TipoContacto>();

	
	private static void rellena(){
		for (int i=1;i<=9;i++){
			TipoContacto tipo = new TipoContacto(i, "TipoDeContacto00"+ i);
			tiposContacto.add(tipo);
			
			Contacto contacto = new Contacto(i, "Nombre00" + i, "Apellidos0" + i, "Estimado00" + i, "Direccion00"
					+ i, "Ciudad00"	+ i, "Prov00" + i, "CodProv00" + i, "Region00"	+ i, "Pais00" + i, "NombreCompania00" 
					+ i, "Cargo00"	+ i, "TelefonoTrabajo00" + i, "ExtensionTrabajo00"	+ i, "TelefonoMovil00" + i, "NumFax00" 
					+ i,"NomCorreoElectronico00" + i, "Notas00" + i, tipo);
			contactos.add(contacto);
			
			Llamada llamada = new Llamada(i, contacto, "2014-11-12 03:00:00.000000",
					"Asunto00" + i, "Notas00" + i);
			llamadas.add(llamada);		
		}
	}

	/**
	 * Test para los contactos
	 */
	private static void testContactos() {
		
	}



	/**
	 * Test para las llamdas
	 */
	private static void testLLamadas() {

	}

	
	/**
	 * Test para los tipos de contacto
	 */
	private static void testTiposDeContacto() {

	}
	
	/**
	 * Main del test
	 * @param args
	 */
	public static void main(String[] args) {
		rellena();
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