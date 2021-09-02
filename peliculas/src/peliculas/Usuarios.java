package peliculas;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class Usuarios implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Usuario> listaUsuarios;
	
	
	
	public Usuarios() {
		
		super();
		listaUsuarios=new ArrayList<>();
		
		
		
	}
	
	
	
	
	
public void escribirFichero (ObjectOutputStream output) throws IOException 
	
	{
		
		if (output!=null)
		{
			
			
			output.writeObject(this);
			
		}
		
		
	}
	
	
	
	public void leerFichero (ObjectInputStream input) throws IOException,ClassNotFoundException
	
	
	{
		
		if (input!=null)
		{
			
			try {
				
			
				listaUsuarios=(ArrayList <Usuario>) input.readObject();
				
				
				
				
				
			
			}catch (EOFException eof) 
			
			{
				
				//fin del fichero
				
			}
			
		
		
		}
		
		
		
		
		
	}
	
	
	
	
	public Usuario autenticar(Usuario usuarioEntrante) throws Exception
	{
		if (listaUsuarios.contains(usuarioEntrante)) {
			
			Usuario u= listaUsuarios.get(listaUsuarios.indexOf(usuarioEntrante));
			if(!u.getcontrasena().equals(usuarioEntrante.getcontrasena())) 
			
			{
				
					throw new Exception("Usuario no existe o error de autentificacion");
			}
			else {
				return u;
			}
			
			
		}
			
		
		else {
			throw new  Exception("Usuario no existe o error de autentificacion");
		}
		
	}	
	
	public void registrar(Usuario usuario ) throws Exception
	{
		if(!listaUsuarios.contains(usuario)) {
			
			listaUsuarios.add(usuario);
		}
		else {
			throw new Exception("Usuario ya existe");
	
		}
		
	}





	/**
	 * @return the listaUsuarios
	 */
	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}





	/**
	 * @param listaUsuarios the listaUsuarios to set
	 */
	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
		
		
		
		
}
	
	

