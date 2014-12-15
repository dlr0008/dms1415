package ubu.lsi.dms.agenda.modelo;

public class ModelTemporal {

	private ListaContactos contactos;
	private ListaLlamadas llamadas;
	private ListaTiposContacto tipos;

	public ModelTemporal() {

		contactos = new ListaContactos();
		llamadas = new ListaLlamadas();
		tipos = new ListaTiposContacto();

	}

	public ListaContactos getContactos() {
		return contactos;
	}

	public ListaLlamadas getLlamadas() {
		return llamadas;
	}

	public ListaTiposContacto getTipos() {
		return tipos;
	}
}
