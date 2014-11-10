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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
		List<Contacto> contactosFiltrado = new ArrayList<Contacto>();
		List<Contacto> contactos = new ArrayList<Contacto>();
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(fileContactos));
			contactos = (ArrayList<Contacto>) in.readObject();
			for (Contacto c : contactos) {
				System.out.println(c.toString());
				if (c.getApellidos().equals(apellido))
					contactosFiltrado.add(c);

			}

		} catch (IOException | ClassNotFoundException E) {
			E.printStackTrace();
		} finally {
			try {
				in.close();
				return contactosFiltrado;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return contactosFiltrado;
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
		try {
			out = new ObjectOutputStream(new FileOutputStream(fileContactos,
					true));
			out.writeObject(contacto);

		} catch (IOException E) {
			System.err.println("No se pudo insertar el contacto");

		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void insertLlamada(Llamada llamada) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(fileLlamadas,
					true));
			out.writeObject(llamada);

		} catch (IOException E) {
			System.err.println("No se pudo insertar el contacto");

		} finally {
			try {
				out.close();
			} catch (IOException e) {
	
				e.printStackTrace();
			}
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
