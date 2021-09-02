package peliculas;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class Pelicula implements Compartible,Serializable{


	private static final long serialVersionUID = 1L;
	private String titulo,director,genero,actor,actriz;
	private	int año;
	private ArrayList<Critica> lista_criticas;





	/**
	 * @param titulo
	 * @param director
	 * @param genero
	 * @param actor
	 * @param actriz
	 * @param año
	 * @param lista_criticas
	 */
	public Pelicula() {
		super();
		this.titulo = "";
		this.director = "";
		this.genero = "";
		this.actor = "";
		this.actriz = "";
		this.año = 0;
		this.lista_criticas = new ArrayList<>();
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

				titulo=(String) input.readObject();
				director=(String) input.readObject();
				genero=(String) input.readObject();
				actor=(String) input.readObject();
				actriz=(String) input.readObject();
				año=(int) input.readObject();	




			}catch (EOFException eof) 

			{

				//fin del fichero

			}



		}





	}





	



	@Override
	public String toString() {
		
		
		
		// TODO Auto-generated method stub
		return titulo;
	}



	@Override	

	public int hashCode() {

		final int prime=31;
		int result=1;
		result=prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		result=prime * result + ((director == null) ? 0 : director.hashCode());
		result=prime * result + ((genero== null) ? 0 : genero.hashCode());
		result=prime * result + ((actor == null) ? 0 : actor.hashCode());
		result=prime * result + ((actriz == null) ? 0 : actriz.hashCode());
		result=año;


		return result;
	}


	public boolean  equals (Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Pelicula))
			return false;
		Pelicula other = (Pelicula) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;	
		}else if (!titulo.equals(other.titulo))
			return false;
		if (director == null) {
			if (other.director != null)
				return false;
		}else if (!director.equals(other.director))
			return false;

		if (genero == null) {
			if (other.genero != null)
				return false;	
		}else if (!genero.equals(other.genero))
			return false;
		if (actor == null) {
			if (other.actor != null)
				return false;
		}else if (!actor.equals(other.actor))
			return false;

		if (actriz == null) {
			if (other.actriz != null)
				return false;	
		}else if (!actriz.equals(other.actriz))
			return false;
		if (año == 0) 
			if (other.año != 0)
				return false;
		/*}else if (!año.equals(other.año))
			return false;*/
		return true;
	}	

	public String getTitulo()
	{

		return this.titulo;

	}

	public void setTitulo(String insertTitulo) 
	{

		this.titulo=insertTitulo;

	}

	public String getDirector()
	{

		return this.director;

	}

	public void setDirector(String insertDirector) 
	{

		this.director=insertDirector;

	}


	public String getGenero()
	{

		return this.genero;

	}

	public void setGenero(String insertGenero) 
	{

		this.genero=insertGenero;

	}


	public String getActor()
	{

		return this.actor;

	}

	public void setActor(String insertActor) 
	{

		this.actor=insertActor;

	}


	public String getActriz()
	{

		return this.actriz;

	}

	public void setActriz(String insertActriz) 
	{

		this.actriz=insertActriz;

	}


	public int getAño()
	{

		return this.año;

	}

	public void setAño(int insertAño) 
	{

		this.año=insertAño;

	}


	@Override
	public void compartir(Usuario u) 
	{
		// TODO Auto-generated method stub

		u.compartirPelicula(this);

	}


	@Override
	public void compartir(Usuario[] users) 
	{
		// TODO Auto-generated method stub
		for (int i = 0; i < users.length; i++) 
		{
			this.compartir(users[i]);
		}


	}



	/**
	 * @return the lista_criticas
	 */
	public ArrayList<Critica> getLista_criticas() {
		return lista_criticas;
	}



	/**
	 * @param lista_criticas the lista_criticas to set
	 */
	public void setLista_criticas(ArrayList<Critica> lista_criticas) {
		this.lista_criticas = lista_criticas;
	}



	public void añadirCritica(Critica c) {
		this.lista_criticas.add(c);
	}




}


