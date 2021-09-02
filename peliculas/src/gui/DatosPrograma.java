/**
 * 
 */
package gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import peliculas.Clasificación;
import peliculas.Critica;
import peliculas.Item;
import peliculas.Pelicula;
import peliculas.Peliculas;
import peliculas.Usuario;
import peliculas.Usuarios;

/**
 * @author Grupo 18
 *
 */
public class DatosPrograma {
	
	private Usuario usuarioActual;
	private Usuarios usuarios;
	private Peliculas peliculas;
	private Clasificación clasificacion;
	private JLabel panelUsuario;
	private JTextArea panelMuro;
	/**
	 * 
	 */
	public DatosPrograma() {
		super();
		usuarioActual=null;
		usuarios=new Usuarios();
		peliculas=new Peliculas();
		clasificacion=new Clasificación();
		
	}
	
	
	/**
	 * @return the usuarioActual
	 */
	public synchronized Usuario getUsuarioActual() {
		return usuarioActual;
	}
	/**
	 * @param usuarioActual the usuarioActual to set
	 */
	public synchronized void setUsuarioActual(Usuario usuarioActual) {
		this.usuarioActual = usuarioActual;
	}
	/**
	 * @return the usuarios
	 */
	public synchronized Usuarios getUsuarios() {
		return usuarios;
	}
	/**
	 * @param usuarios the usuarios to set
	 */
	public synchronized void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}
	/**
	 * @return the peliculas
	 */
	public synchronized Peliculas getPeliculas() {
		return peliculas;
	}
	/**
	 * @param peliculas the peliculas to set
	 */
	public synchronized void setPeliculas(Peliculas peliculas) {
		this.peliculas = peliculas;
	}
	/**
	 * @return the clasificacion
	 */
	public synchronized Clasificación getClasificacion() {
		return clasificacion;
	}
	/**
	 * @param clasificacion the clasificacion to set
	 */
	public synchronized void setClasificacion(Clasificación clasificacion) {
		this.clasificacion = clasificacion;
	}
	
	public synchronized void registrar(Usuario usuario) throws Exception {
		Item item;
		item=new Item();
		
		this.getUsuarios().registrar(usuario);
		if(this.usuarioActual==null) {
			this.usuarioActual=usuario;
			panelUsuario.setText("Usuario Actual: "+usuario.getusuarioNombre());		
		}
		item.setNombreUSuario(usuario.getusuarioNombre());
		this.clasificacion.getLista().add(item);
	}
	
	public synchronized void autenticar(Usuario usuario) throws Exception {
		this.usuarioActual=this.getUsuarios().autenticar(usuario);
		panelUsuario.setText("Usuario Actual: "+usuario.getusuarioNombre());		
		this.usuarioActual.getusuarioNombre();
		this.panelMuro.setText(this.getUsuarioActual().getMuro().toString());
		
	}


	public void setPanelUsuarioActual(JLabel lblUsuarioActual) {
		this.panelUsuario=lblUsuarioActual;
	}


	public void ordenarClasificacion(TiposOrdenacion tipoOrdenacion) {
		switch (tipoOrdenacion) {
		case OPCION1:
			clasificacion.ordenarPorcentaje();
			break;
		case OPCION2:
			clasificacion.ordenarPuntos();
			break;
		case OPCION3:
			clasificacion.ordenarVictorias();
			break;
		}
	}


	public void leerFichero(File selectedFile) {
		try {
			FileInputStream fichero=new FileInputStream(selectedFile);
			ObjectInputStream in=new ObjectInputStream(fichero);
			this.usuarios=(Usuarios)in.readObject();
			this.peliculas=(Peliculas)in.readObject();
			this.clasificacion=(Clasificación)in.readObject();
			in.close();
			
		}catch (SecurityException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Cargar datos", JOptionPane.ERROR_MESSAGE);
			
		}catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Cargar datos", JOptionPane.ERROR_MESSAGE);
			
		}catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Cargar datos", JOptionPane.ERROR_MESSAGE);
			
		}catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Cargar datos", JOptionPane.ERROR_MESSAGE);
			
		}
	}

	
	public void escribirFichero(File selectedFile) {
		try {
			FileOutputStream fichero=new FileOutputStream(selectedFile);
			ObjectOutputStream out=new ObjectOutputStream(fichero);
			
			out.writeObject(this.usuarios);
			out.writeObject(this.peliculas);
			out.writeObject(this.clasificacion);
			
			
			
			/*this.usuarios=(Usuarios)in.readObject();
			this.peliculas=(Peliculas)in.readObject();
			this.clasificacion=(Clasificación)in.readObject();*/
			out.close();
			
		}catch (SecurityException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Cargar datos", JOptionPane.ERROR_MESSAGE);
			
		}catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Cargar datos", JOptionPane.ERROR_MESSAGE);
			
		}catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Cargar datos", JOptionPane.ERROR_MESSAGE);
			
		}
			
		
	}

	
	
	

	public void nuevaPelicula(Pelicula pelicula) throws Exception {
		// TODO Auto-generated method stub
		
		this.getUsuarioActual().añadirPelicula(pelicula);
		this.peliculas.getListaPelicula().add(pelicula);
		this.panelMuro.setText(this.getUsuarioActual().getMuro().toString());
		
	}


	public void nuevaCritica(Critica critica,Pelicula pelicula) {

		this.getUsuarioActual().añadirCritica(critica, pelicula);
		this.panelMuro.setText(this.getUsuarioActual().getMuro().toString());
		
	}

	
	public void actualizarMuro() {
		if (this.getUsuarioActual()!=null) {
			
		
		this.panelMuro.setText(this.getUsuarioActual().getMuro().toString());
		}
	}

	public void setPanelMuro(JTextArea panelMuro) {
		this.panelMuro=panelMuro;
	}

}
