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
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sun.javafx.accessible.utils.ControlTypeIds;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.modelo.TipoContacto;

/**
 * @author Roberto Miranda PÃ©rez.
 *
 */
public class FachadaBin implements FachadaPersistente {

	private static String fileContactos = "." + File.separator + "res"
			+ File.separator + "contactos.dat";
	private static String fileLlamadas = "." + File.separator + "res"
			+ File.separator + "llamadas.dat";
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
		// in = new ObjectInputStream(new FileInputStream(fileContactos));
		ArrayList<Contacto> contactos = new ArrayList<Contacto>();
		ArrayList<Contacto> contactosFiltrado = new ArrayList<Contacto>();
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(fileContactos));

			contactos = (ArrayList<Contacto>) in.readObject();

			for (Contacto c : contactos) {
				if (c.getApellidos().equals(apellido))
					contactosFiltrado.add(c);
			}

		} catch (IOException | ClassNotFoundException E) {
			E.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			return contactosFiltrado;

		}
	}

	@Override
	public Collection<Llamada> getLlamadas(Contacto contacto) {

		List<Llamada> llamadasFiltrado = new ArrayList<Llamada>();
		List<Llamada> llamadas = new ArrayList<Llamada>();
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(fileLlamadas));
			llamadas = (ArrayList<Llamada>) in.readObject();
			System.out.println(llamadas.size());
			for (Llamada l : llamadas) {
				System.out.println(l.toString());
				if (l.getContacto().equals(contacto))
					llamadasFiltrado.add(l);

			}
		} finally {
			if (llamadasFiltrado == null)
				System.err.println("No existen llamadas del contacto "
						+ contacto.getNombre());
			return llamadasFiltrado;
		}
	}

	@Override
	public Collection<TipoContacto> getTipoContacto() {
		return null;
	}

	@Override
	public void insertContacto(Contacto contacto) {
		ObjectOutputStream out = null;
		ArrayList<Contacto> contactos = null;
		try {

			if (!new File(fileContactos).exists()) {
				System.out.println("No existe");
				out = new ObjectOutputStream(new FileOutputStream(
						fileContactos, true));
				contactos = new ArrayList<Contacto>();
				contactos.add(contacto);
				out.writeObject(contactos);
				out.close();
			} else {
				contactos = leerContactos();
				new File(fileContactos).delete();
				out = new ObjectOutputStream(new FileOutputStream(
						fileContactos, true));
				contactos.add(contacto);
				out.writeObject(contactos);
				out.close();
			}

		} catch (IOException E) {
			E.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private ArrayList<Contacto> leerContactos() {

		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					fileContactos));
			ArrayList<Contacto> contactos = (ArrayList<Contacto>) in
					.readObject();

			in.close();

			return contactos;

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void insertLlamada(Llamada llamada) {
		ObjectOutputStream out = null;
		ArrayList<Llamada> llamadas = null;
		try {

			if (!new File(fileLlamadas).exists()) {
				out = new ObjectOutputStream(new FileOutputStream(fileLlamadas,
						true));
				llamadas = new ArrayList<Llamada>();
				llamadas.add(llamada);
				out.writeObject(llamadas);
				out.close();
			} else {
				llamadas = leerLlamadas();
				new File(fileLlamadas).delete();
				out = new ObjectOutputStream(new FileOutputStream(
						fileLlamadas, true));
				llamadas.add(llamada);
				out.writeObject(llamadas);
				out.close();
			}

		} catch (IOException E) {
			E.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private ArrayList<Llamada> leerLlamadas() {

		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					fileLlamadas));
			ArrayList<Llamada> llamadas = (ArrayList<Llamada>) in.readObject();

			in.close();

			return llamadas;

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insertTipoContacto(String TipoContacto) {

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
					fileLlamadas.toString()));
			llamadas = (Collection<Llamada>) in.readObject();
			in.close();

			for (Llamada l : llamadas) {
				if (l.getIdLlamada() == llamada.getIdLlamada()) {
					llamadas.remove(l);
					llamadas.add(llamada);
				}

				ObjectOutputStream out = new ObjectOutputStream(
						new FileOutputStream(fileLlamadas.toString()));
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
