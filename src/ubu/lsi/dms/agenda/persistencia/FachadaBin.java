/**
 * 
 */
package ubu.lsi.dms.agenda.persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

	private static String fileContactos = "." + File.separator + "res"
			+ File.separator + "contactos.dat";
	private String filellamadas = "." + File.separator + "res" + File.separator
			+ "llamadas.dat";
	private String fileTipoContacto = "." + File.separator + "res"
			+ File.separator + "tipos.dat";
	private static final FachadaPersistente fachadaBin = new FachadaBin();

	private static ObjectOutputStream out = null;
	private static ObjectInputStream in = null;

	public FachadaBin() {
	}

	public static FachadaPersistente getInstance() {
		try {
			out = new ObjectOutputStream(new FileOutputStream(
					fileContactos.toString(), true));
			in = new ObjectInputStream(new FileInputStream(
					fileContactos.toString()));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fachadaBin;

	}

	@Override
	public Collection<Contacto> getContacto(String apellido) {
		Collection<Contacto> contactosFiltrado = null;

		try {
			while (true) {

				Contacto c = (Contacto) in.readObject();
				if (c.getApellidos().equals(apellido)) {
					contactosFiltrado.add(c);
				}

			}

		} catch (IOException | ClassNotFoundException E) {
			in.close();
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
			out.writeObject(contacto);
		} catch (IOException E) {
			System.err.println("No se pudo insertar el contacto");

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
			System.err.println("No se pudo insertar la llamada");

		}

	}

	@Override
	public void insertTipoContacto(String TipoContacto) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(fileTipoContacto.toString(), true));
			out.writeObject(TipoContacto);
			out.close();
		} catch (Exception E) {
			System.err.println("No se pudo insertar el tipo de Contacto");

		}

	}

	@Override
	public void updateContacto(Contacto contacto) {
		Collection<Contacto> contactos;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					fileContactos.toString()));
			contactos = (Collection<Contacto>) in.readObject();
			in.close();

			for (Contacto c : contactos) {
				if (c.getIdContacto() == contacto.getIdContacto()) {
					contactos.remove(c);
					contactos.add(contacto);
				}

				ObjectOutputStream out = new ObjectOutputStream(
						new FileOutputStream(fileContactos.toString()));
				out.writeObject(contactos);
				out.close();
			}

		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateLlamada(Llamada llamada) {
		Collection<Llamada> llamadas;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					filellamadas.toString()));
			llamadas = (Collection<Llamada>) in.readObject();
			in.close();

			for (Llamada l : llamadas) {
				if (l.getIdLlamada() == llamada.getIdLlamada()) {
					llamadas.remove(l);
					llamadas.add(llamada);
				}

				ObjectOutputStream out = new ObjectOutputStream(
						new FileOutputStream(filellamadas.toString()));
				out.writeObject(llamadas);
				out.close();
			}

		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateTipoContacto(TipoContacto tipoContacto) {
		Collection<TipoContacto> tipos;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					fileTipoContacto.toString()));
			tipos = (Collection<TipoContacto>) in.readObject();
			in.close();

			for (TipoContacto t : tipos) {
				if (t.getIdTipoContacto() == tipoContacto.getIdTipoContacto()) {
					tipos.remove(t);
					tipos.add(tipoContacto);
				}

				ObjectOutputStream out = new ObjectOutputStream(
						new FileOutputStream(fileTipoContacto.toString()));
				out.writeObject(tipos);
				out.close();
			}

		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
