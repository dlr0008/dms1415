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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	private static FachadaPersistente fachadaBin = null;

	public FachadaBin() {

	}

	public static FachadaPersistente getInstance() {
		if (fachadaBin == null) {
			fachadaBin = new FachadaBin();

		}
		return fachadaBin;

	}

	protected void esperar() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
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
			in.close();
			for (Contacto c : contactos) {
				if (c.getApellidos().equals(apellido))
					contactosFiltrado.add(c);
			}

		} catch (IOException | ClassNotFoundException E) {
			E.printStackTrace();

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
			in.close();
			for (Llamada l : llamadas) {
				if (l.getContacto().getNombre().equals(contacto.getNombre()))
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
		List<TipoContacto> tipos = null;
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(fileTipoContacto));
			tipos = (ArrayList<TipoContacto>) in.readObject();
			in.close();

		} finally {
			if (tipos == null)
				System.err.println("No existen tipos de Contacto");
			return tipos;
		}
	}

	@Override
	public void insertContacto(Contacto contacto) {
		ObjectOutputStream out = null;
		ArrayList<Contacto> contactos = null;
		try {

			if (!new File(fileContactos).exists()) {
				out = new ObjectOutputStream(new FileOutputStream(
						fileContactos, true));
				contactos = new ArrayList<Contacto>();
				contactos.add(contacto);
				out.writeObject(contactos);
				out.close();
			} else {
				contactos = leerContactos();
				new File(fileContactos).delete();
				esperar();
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
				esperar();
				out = new ObjectOutputStream(new FileOutputStream(fileLlamadas,
						true));
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

	@Override
	public void insertTipoContacto(String tipoContacto) {
		ObjectOutputStream out = null;
		Collection<TipoContacto> tipos = null;
		try {

			if (!new File(fileTipoContacto).exists()) {
				out = new ObjectOutputStream(new FileOutputStream(
						fileTipoContacto, true));
				tipos = new ArrayList<TipoContacto>();
				tipos.add(new TipoContacto(1, tipoContacto));
				out.writeObject(tipos);
				out.close();
			} else {
				tipos = getTipoContacto();
				new File(fileTipoContacto).delete();
				esperar();
				out = new ObjectOutputStream(new FileOutputStream(
						fileTipoContacto, true));
				tipos.add(new TipoContacto(tipos.size() + 1, tipoContacto));
				out.writeObject(tipos);
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
	public void updateContacto(Contacto contacto) {
		Collection<Contacto> contactosViejos = leerContactos();
		Collection<Contacto> contactosNuevos = new ArrayList<Contacto>();

		int contador = 1;
		for (Contacto c : contactosViejos) {
			if (contador != contacto.getIdContacto()) {
				contactosNuevos.add(c);
			} else {
				contactosNuevos.add(contacto);
			}
			contador++;
		}
		new File(fileContactos).delete();
		esperar();
		for (Contacto c : contactosNuevos)
			insertContacto(c);
	}

	@Override
	public void updateLlamada(Llamada llamada) {
		Collection<Llamada> llamadasViejas = leerLlamadas();
		Collection<Llamada> llamadasNuevas = new ArrayList<Llamada>();

		int contador = 1;
		for (Llamada l : llamadasViejas) {
			if (contador != llamada.getIdLlamada()) {
				llamadasNuevas.add(l);
			} else {
				llamadasNuevas.add(llamada);
			}
			contador++;
		}
		new File(fileLlamadas).delete();
		esperar();
		for (Llamada l : llamadasNuevas)
			insertLlamada(l);
	}

	@Override
	public void updateTipoContacto(TipoContacto tipoContacto) {
		Collection<TipoContacto> tiposViejos = getTipoContacto();
		Collection<TipoContacto> tiposNuevos = new ArrayList<TipoContacto>();
		int contador = 1;
		for (TipoContacto t : tiposViejos) {
			if (contador != tipoContacto.getIdTipoContacto()) {
				tiposNuevos.add(t);
			} else {
				tiposNuevos.add(tipoContacto);
			}
			contador++;
		}
		new File(fileTipoContacto).delete();
		esperar();
		for (TipoContacto t : tiposNuevos)
			insertTipoContacto(t.getTipoContacto());
	}
}
