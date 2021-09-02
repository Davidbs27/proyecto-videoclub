package peliculas;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Peliculas implements Serializable {

	
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		/*atributos*/
	
		/*constructor*/
		/*metodos*/
	
	private ArrayList<Pelicula> lista_de_peliculas; 
	
	
	
	
	public Peliculas() {
		
		super();
		
		lista_de_peliculas=new ArrayList<>();
	
	
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
				
				
				lista_de_peliculas=(ArrayList <Pelicula>) input.readObject();
				
				
			
			}catch (EOFException eof) 
			
			{
				
				//fin del fichero
				
			}
			
		
		
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	void añadirPelicula(Pelicula p) throws Exception
	{
		
		if(!lista_de_peliculas.contains(p)) {
			
			lista_de_peliculas.add(p);
		}
		else {
			throw new Exception("La pelicula ya ha sido añadida");
	
		}
		
	}
	
	void verinfoPeliculas()
	{
		
		
		/*esto es recorrer el arraylist y sacarlo enla gui*/
		
	}
	
	
	

	public ArrayList<Pelicula> getListaPelicula()
	{
		
		return this.lista_de_peliculas;
		
	}
	
	public void setListaPelicula(ArrayList<Pelicula> insertListaPelicula) 
	{
		
		this.lista_de_peliculas=insertListaPelicula;
		
	}
	
	
	
}
