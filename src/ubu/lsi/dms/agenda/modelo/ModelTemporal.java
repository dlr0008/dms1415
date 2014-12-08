package ubu.lsi.dms.agenda.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class ModelTemporal {
	private static Collection<Contacto> contactos = new ArrayList<Contacto>();

	private static Collection<Llamada> llamadas = new ArrayList<Llamada>();

	public static Collection<TipoContacto> tipos = new ArrayList<TipoContacto>();

	public static void iniContactos() {
		TipoContacto tipoContacto = new TipoContacto(1, "Tipo001");
		for (int i = 1; i <= 40; i++)
			contactos.add(new Contacto(i, "Nombre00" + i, "Apellidos00"
					+ new Random().nextInt(10), "Estimado00" + i, "Direccion00"
					+ i, "Ciudad00" + i, "Prov00" + i, "CodPostal000" + i,
					"Region000" + i, "Pais000" + i, "NombreCompania000" + i,
					"Cargo000" + i, "TelefonoTrabajo00" + i,
					"ExtensionTrabajo00" + i, "TelefonoMovil00" + i, "NumFax00"
							+ i, " NomCorreoElectronico00" + i + "@ubu.es",
					"Notas00" + i, tipoContacto));

	}

	public static void iniLlamadas() {
		TipoContacto tipoContacto = new TipoContacto(1, "Tipo001");

		for (int i = 1; i <= 100; i++) {
			llamadas.add(new Llamada(i, new Contacto(i, "Nombre00" + i,
					"Apellidos00" + new Random().nextInt(10), "Estimado00" + i,
					"Direccion00" + i, "Ciudad00" + i, "Prov00" + i,
					"CodPostal000" + i, "Region000" + i, "Pais000" + i,
					"NombreCompania000" + i, "Cargo000" + i,
					"TelefonoTrabajo00" + 1, "ExtensionTrabajo00" + 1,
					"TelefonoMovil00" + i, "NumFax00" + 1,
					" NomCorreoElectronico00" + i + "@ubu.es", "Notas00" + i,
					tipoContacto), "2014-10-18 0" + i + ":00:00",
					"AsuntoLlamada00" + i, "NotaLlamada00" + i));
		}
	}

	public static void iniTipos() {
		for (int i = 1; i <= 30; i++)
			tipos.add(new TipoContacto(i, "Tipo00" + i));
	}

	public void addContacto(Contacto contacto) {

		contactos.add(contacto);
	}

	public void addLlamada(Llamada llamada) {

		llamadas.add(llamada);
	}

	public void addTiposContacto(TipoContacto tipo) {

		tipos.add(tipo);
	}

	public Collection<Contacto> filtrarContactos(String Apellido) {
		Collection<Contacto> contactosFiltrados = new ArrayList<Contacto>();
		for (Contacto c : contactos) {
			if (c.getApellidos().equals(Apellido))
				contactosFiltrados.add(c);
		}
		return contactosFiltrados;

	}

	public Collection<Llamada> filtrarLLamadas(String Apellido) {
		Collection<Llamada> llamadasFiltradas = new ArrayList<Llamada>();
		for (Llamada l : llamadas) {
			System.out.println(l.toString());
			if (l.getContacto().getApellidos().equals(Apellido))
				llamadasFiltradas.add(l);
		}

		return llamadasFiltradas;

	}

	public Collection<Contacto> getContactos() {

		return contactos;

	}

	public Collection<Llamada> getLlamadas() {

		return llamadas;

	}

	public Collection<TipoContacto> getTipos() {

		return tipos;

	}
}
