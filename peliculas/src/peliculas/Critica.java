package peliculas;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Critica implements Compartible, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*atributos*/
	
	private String pelicula;
	private double puntuacion;
	private String texto;
	/*constructor*/
		/*metodos*/
		


	
	
	

	@Override
	public String toString() {
		
		
		
		// TODO Auto-generated method stub
		return Double.toString(puntuacion);
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
				
				
				pelicula=(String)  input.readObject();
				puntuacion=(double)  input.readObject();
				texto=(String)  input.readObject();
				
				
				
			
			}catch (EOFException eof) 
			
			{
				
				//fin del fichero
				
			}
		
		
		
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public String getPelicula()
	{
		
		return this.pelicula;
		
	}
	
	public void setPelicula(String insertPelicula) 
	{
		
		this.pelicula=insertPelicula;
		
	}
	
	public double getPuntuacion()
	{
		
		return this.puntuacion;
		
	}
	
	public void setPuntuacion(double insertPuntuacion) 
	{
		
		this.puntuacion=insertPuntuacion;
		
	}
	

	public String getTexto()
	{
		
		return this.texto;
		
	}
	
	public void setTexto(String insertTexto) 
	{
		
		this.texto=insertTexto;
		
	}

	@Override
	public void compartir(Usuario u) 
	
	{
		// TODO Auto-generated method stub
		
		u.compartirCritica(this);
		
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
	
			
		
		
}
