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
 * Fachada sobre la que se aplica el patron fachada para realizar operaciones
 * sobre distintos ficheros binarios
 * 
 * @author <A HREF="mailto:jld0016@alu.ubu.es">Jorge Laguna</A>
 * @author <A HREF="mailto:rmp0046@alu.ubu.es">Roberto Miranda</A>
 * @author <A HREF="mailto:aam0093@alu.ubu.es">Asier Alonso</A>
 * @author <A HREF="mailto:dlr0008@alu.ubu.es">Daniel Lozano</A>
 * @version 1.0
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

	/**
	 * Aplicado el patron singleton para obtener una única instacia de la
	 * fachada
	 * 
	 * 
	 * @return fachadaBin encargada de el manejo de las operaciones sobre los
	 *         ficheros
	 */
	public static FachadaPersistente getInstance() {
		if (fachadaBin == null)
			fachadaBin = new FachadaBin();

		return fachadaBin;

	}

	/**
	 * Metodo para esperar antes de el borrado y creacion del fichero, ya que
	 * pueden dar error al hacer als 2 operaciones seguidas.
	 * 
	 */
	private void esperar() {
		try {
			Thread.sleep(15);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	/**
	 * Se consulta el fichero buscando los contactos que contengan el apellido
	 * pasado por parametro
	 * 
	 * 
	 * @param apellido
	 *            Apellido para localizar el contacto
	 * @return Collection<Contacto> Contactos que se apelliden igual que el
	 *         apellido pasado por parametro
	 * 
	 */
	@Override
	public Collection<Contacto> getContacto(String apellido) {
		ArrayList<Contacto> contactos = new ArrayList<Contacto>();
		ArrayList<Contacto> contactosFiltrado = null;
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(fileContactos));

			contactos = (ArrayList<Contacto>) in.readObject();
			contactosFiltrado = new ArrayList<Contacto>();
			for (Contacto c : contactos) {
				if (c.getApellidos().equals(apellido))
					contactosFiltrado.add(c);
			}

		} catch (IOException | ClassNotFoundException E) {
			E.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (contactosFiltrado == null)
				System.err.println("No existen contactos con el apellido: "
						+ apellido);
			return contactosFiltrado;
		}
	}

	/**
	 * Se consulta el fichero buscando las llamadas realizadas de ese contacto
	 * 
	 * 
	 * @param contacto
	 *            contactacto del que se desea conocer la llamadas
	 * @return Collection<Llamada> llamadas realizadas por ese contactos
	 * 
	 */
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
		} catch (IOException | ClassNotFoundException E) {
			E.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (llamadasFiltrado == null)
				System.err.println("No existen llamadas del contacto "
						+ contacto.getNombre());
			return llamadasFiltrado;
		}
	}

	/**
	 * Se consulta el fichero buscando todos los tipos de contacto
	 * 
	 * @return Collection<TipoContacto> Todos los tipos de contacto guardados en
	 *         el fichero
	 * 
	 */
	@Override
	public Collection<TipoContacto> getTipoContacto() {
		List<TipoContacto> tipos = null;
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(fileTipoContacto));
			tipos = (ArrayList<TipoContacto>) in.readObject();
			in.close();

		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (tipos == null)
				System.err.println("No existen tipos de Contacto");
			return tipos;
		}
	}

	/**
	 * Inserta un contacto en el fichero de contactos
	 * 
	 * @param contacto
	 *            contacto a insertar en el fichero
	 * 
	 */
	@Override
	public void insertContacto(Contacto contacto) {
		ObjectOutputStream out = null;
		ArrayList<Contacto> contactos = null;
		try {

			if (!new File(fileContactos).exists()) {
				out = new ObjectOutputStream(new FileOutputStream(
						fileContactos, true));
				contactos = new ArrayList<Contacto>();

			} else {
				contactos = leerContactos();
				new File(fileContactos).delete();
				esperar();
				out = new ObjectOutputStream(new FileOutputStream(
						fileContactos, true));
			}
			contactos.add(contacto);
			out.writeObject(contactos);

		} catch (IOException E) {
			E.printStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Inserta una llamada en el fichero de llamadas
	 * 
	 * @param llamada
	 *            llamada a insertar en el fichero
	 * 
	 */
	@Override
	public void insertLlamada(Llamada llamada) {
		ObjectOutputStream out = null;
		ArrayList<Llamada> llamadas = null;
		try {

			if (!new File(fileLlamadas).exists()) {
				out = new ObjectOutputStream(new FileOutputStream(fileLlamadas,
						true));
				llamadas = new ArrayList<Llamada>();
			} else {
				llamadas = leerLlamadas();
				new File(fileLlamadas).delete();
				esperar();
				out = new ObjectOutputStream(new FileOutputStream(fileLlamadas,
						true));
			}
			llamadas.add(llamada);
			out.writeObject(llamadas);

		} catch (IOException E) {
			E.printStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Inserta un tipo de contacto, generando el Id automaticamente.
	 * 
	 * @param tipoContacto
	 *            Cadena que contiene el nombre del tipode contacto a introducir
	 */
	@Override
	public void insertTipoContacto(String tipoContacto) {
		ObjectOutputStream out = null;
		Collection<TipoContacto> tipos = null;
		try {

			if (!new File(fileTipoContacto).exists()) {
				out = new ObjectOutputStream(new FileOutputStream(
						fileTipoContacto, true));
				tipos = new ArrayList<TipoContacto>();
			} else {
				tipos = getTipoContacto();
				new File(fileTipoContacto).delete();
				esperar();
				out = new ObjectOutputStream(new FileOutputStream(
						fileTipoContacto, true));

			}
			tipos.add(new TipoContacto(tipos.size() + 1, tipoContacto));
			out.writeObject(tipos);

		} catch (IOException E) {
			E.printStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Devuelve todos los contactos del fichero
	 * 
	 * @return ArrayList<Contacto> Colecion con todos los contactos del fichero
	 */
	private ArrayList<Contacto> leerContactos() {
		ArrayList<Contacto> contactos = null;
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(fileContactos));
			contactos = (ArrayList<Contacto>) in.readObject();

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (contactos == null)
				System.err.println("No hay contactos en el fichero");
			return contactos;
		}
	}

	/**
	 * Devuelve todas las llamadas
	 * 
	 * @return ArrayList<Llamadas> Colecion con todas las llamadas
	 */
	private ArrayList<Llamada> leerLlamadas() {
		ArrayList<Llamada> llamadas = null;
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(fileLlamadas));
			llamadas = (ArrayList<Llamada>) in.readObject();

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (llamadas == null)
				System.err.println("No hay llamadas en el fichero");
			return llamadas;
		}
	}

	/**
	 * Metodo que actualiza un contacto del fichero, manteniendo su id
	 * 
	 * @param contacto
	 *            contacto actualizado a sobrescribir en el fichero
	 */
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

	/**
	 * Metodo que actualiza una llamada del fichero, manteniendo su id
	 * 
	 * @param llamada
	 *            llamada a sobrescrribir en el fichero
	 */
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

	/**
	 * Metodo que actualiza un tipo de contacto, manteniendo su id
	 * 
	 * @param tipoContato
	 *            tipo de contacto que se actualiza
	 */
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
