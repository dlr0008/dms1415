/**
 * 
 */
package ubu.lsi.dms.agenda.persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;

import sun.security.jca.GetInstance;
import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.modelo.TipoContacto;

/**
 * @author Roberto Miranda Pérez.
 *
 */
public class FachadaBin implements FachadaPersistente {

	private String fileContactos = "." + File.separator + "res"
			+ File.separator + "contactos.dat";
	private String filellamadas = "." + File.separator + "res" + File.separator
			+ "llamadas.dat";
	private String fileTipoContacto = "." + File.separator + "res"
			+ File.separator + "tipos.dat";
	private static final FachadaPersistente fachadaBin = new FachadaBin();

	public FachadaBin() {
	}

	public static FachadaPersistente getInstance() {

		return fachadaBin;

	}

	@Override
	public Collection<Contacto> getContacto(String apellido) {
		Collection<Contacto> contactosFiltrado = null;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					fileContactos.toString()));
			Collection<Contacto> contactos = (Collection<Contacto>) in
					.readObject();

			in.close();
			for (Contacto c : contactos) {
				if (c.getApellidos() == apellido)
					contactosFiltrado.add(c);
			}
		} catch (IOException | ClassNotFoundException E) {
			System.err.print("No se pudo obtener el contacto");
		} finally {

			return contactosFiltrado;
		}
	}

	@Override
	public Collection<Llamada> getLlamadas(Contacto contacto) {
		Collection<Llamada> llamadasFiltrado = null;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					filellamadas.toString()));
			Collection<Llamada> llamadas = (Collection<Llamada>) in
					.readObject();

			in.close();
			for (Llamada l : llamadas) {
				if (l.getContacto() == contacto)
					llamadasFiltrado.add(l);
			}
		} catch (IOException | ClassNotFoundException E) {
			System.err.print("No se pudo obtener las llamadas");
		} finally {

			return llamadasFiltrado;
		}
	}

	@Override
	public Collection<TipoContacto> getTipoContacto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertContacto(Contacto contacto) {

		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(fileContactos.toString()));
			out.writeObject(contacto);
			out.close();
		} catch (IOException E) {
			System.err.println("No se pudo insetar el contacto");

		}

	}

	@Override
	public void insertLlamada(Llamada llamada) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(filellamadas.toString()));
			out.writeObject(llamada);
			out.close();
		} catch (Exception E) {
			System.err.println("No se pudo insetar el contacto");

		}

	}

	@Override
	public void insertTipoContacto(String TipoContacto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateContacto(Contacto contacto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateLlamada(Llamada llamada) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTipoContacto(TipoContacto tipoContacto) {
		// TODO Auto-generated method stub

	}

}
