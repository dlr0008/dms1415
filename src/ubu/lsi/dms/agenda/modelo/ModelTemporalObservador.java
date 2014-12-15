package ubu.lsi.dms.agenda.modelo;

public class ModelTemporalObservador {

	ListaContactos contactos;
	ListaLlamadas llamadas;
	ListaTiposContacto tipos;
	
	public ModelTemporalObservador(){
		
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
