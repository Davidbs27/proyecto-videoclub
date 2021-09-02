package peliculas;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Pregunta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id; /*numero de pregunta*/
	private Pelicula pelicula; /*pelicula a preguntar*/
	private int puntos_jugador1;
	private int puntos_jugador2;
	private int numero_pistas=1;
	private int puntuacion_maxj1=50;
	private int puntuacion_maxj2=50;
	                                        
	
	
	/*costructor*/
	/*metodos*/
	
	public Pregunta (int numero_pregunta) 
	
	{
		id=numero_pregunta;
		pelicula=null;
		puntos_jugador1=0;
		puntos_jugador2=0;
		numero_pistas=1;
		puntuacion_maxj1=50;
		puntuacion_maxj2=50;
		
		
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
				
				id=(int) input.readObject();
				pelicula=(Pelicula) input.readObject();
				puntos_jugador1=(int) input.readObject();
				puntos_jugador1=(int) input.readObject();
				numero_pistas=(int) input.readObject();
				puntuacion_maxj1=(int) input.readObject();	
				puntuacion_maxj2=(int) input.readObject();	
				
				
			
			}catch (EOFException eof) 
			
			{
				
				//fin del fichero
				
			}
			
		
		
		}
		
		
		
		
		
	}
	
	
	
	
	public void seleccionarPelicula(Peliculas films )
	
	{
		ArrayList<Pelicula> lista_seleccion;
		int tamañoLista;
		int numero;
		/*Pelicula seleccionada;
		
		/*sacamos la lista y el tamaño de esta*/
		lista_seleccion=films.getListaPelicula();
		
		tamañoLista=lista_seleccion.size();
		
		/*ahora con el tamaño hacemos un random*/
		numero = (int) (Math.random() * tamañoLista) /* + 1*/;
		
		
		/*cogemos el numero obtenido y obtenermos la pelicula del  array list*/
		                                                 
		/*seleccionada=lista_seleccion.get(numero);
		 peliculaSeleccionada=(lista_seleccion.get(numero));
		 numero_pregunta=numero_p;*/
		 
		setpeliculaSeleccionada(lista_seleccion.get(numero));
		setnumeroPregunta(numero);
		
		
		                                                                                                                                                                                                                                                            
		
	}
	
	
	public String ofrecerNuevaPista(int numero_jugador)
	{
		
		int numero_pista;
		int numero_pregunta;
		Pelicula numero_pelicula;
		int año_pelicula;
 		String campo_pelicula=null;
	
		
		
		
		/*extraemos el numero de pista en el que estamos */
		numero_pista=getnumero_pistas();
		/*extraemos el numero de pregunta en la que estamos*/
		numero_pregunta=getnumeroPregunta();
		
		/* si es 1 le quitamos 10 al jugador 1 y si es 2 10 al jugador 2*/
		
		if ((numero_jugador==1) && (numero_pista>1)) 
		
		{
			
			puntuacion_maxj1=puntuacion_maxj1-10;
			
			
		}
		else if((numero_jugador==2) &&(numero_pista>1))
		{
			puntuacion_maxj2=puntuacion_maxj2-10;
		}
		
		
		
		
		
		/*pregunta 1*/
		if ((numero_pregunta==1) && (numero_pista==1)) 
		{
			
			/*extraemos el año de distribucion*/
			
			numero_pelicula=getpeliculaSeleccionada();
			año_pelicula=numero_pelicula.getAño();
			campo_pelicula=""+año_pelicula;
			/*falta la gui*/
			
			
		
		}
		
		else if ((numero_pregunta==1) && (numero_pista==2))
		{
			
			/*extraemos el genero */
			
			numero_pelicula=getpeliculaSeleccionada();
			campo_pelicula=numero_pelicula.getGenero();
			
			/*falta la gui*/
			
			
			
		}
		
		
		
		else if ((numero_pregunta==1) && (numero_pista==3))
		{
			
			/*extraemos el director*/
			
			numero_pelicula=getpeliculaSeleccionada();
			campo_pelicula=numero_pelicula.getDirector();
			
			/*falta la gui*/
			
		}
		
		else if ((numero_pregunta==1) && (numero_pista==4))
		{
			
			/*extraemos el actor*/
			

			numero_pelicula=getpeliculaSeleccionada();
			campo_pelicula=numero_pelicula.getActor();
			
			/*falta la gui*/
			
		}
		
		else if ((numero_pregunta==1) && (numero_pista==5))
		{
			
			/*extraemos la actriz*/
			
			numero_pelicula=getpeliculaSeleccionada();
			campo_pelicula=numero_pelicula.getActriz();
			
			/*falta la gui*/
			
		}
		
		/*pregunta 2*/
		
		if ((numero_pregunta==2) && (numero_pista==1)) 
		{
			
			/*extraemos el titulo*/
			

			numero_pelicula=getpeliculaSeleccionada();
			campo_pelicula=numero_pelicula.getTitulo();
			
			/*falta la gui*/
			
			
		
		}
		else if ((numero_pregunta==2) && (numero_pista==2))
		{
			
			/*extraemos el genero*/
			numero_pelicula=getpeliculaSeleccionada();
			campo_pelicula=numero_pelicula.getGenero();
			
			/*falta la gui*/
			
		}
		
		else if ((numero_pregunta==2) && (numero_pista==3))
		{
			
			/*extraemos el director*/

			numero_pelicula=getpeliculaSeleccionada();
			campo_pelicula=numero_pelicula.getDirector();
			
			/*falta la gui*/
			
		}
		
		else if ((numero_pregunta==2) && (numero_pista==4))
		{
			
			/*extraemos la actor*/


			numero_pelicula=getpeliculaSeleccionada();
			campo_pelicula=numero_pelicula.getActor();
			
			/*falta la gui*/
		}
		
		
		else if ((numero_pregunta==2) && (numero_pista==5))
		{
			
			/*extraemos la actriz*/

			numero_pelicula=getpeliculaSeleccionada();
			campo_pelicula=numero_pelicula.getActriz();
			
			/*falta la gui*/
			
		}
		
/*pregunta 3*/
		
		if ((numero_pregunta==3) && (numero_pista==1)) 
		{
			
			/*extraemos el titulo*/

			numero_pelicula=getpeliculaSeleccionada();
			campo_pelicula=numero_pelicula.getTitulo();
			
			
			
		
		}
		else if ((numero_pregunta==3) && (numero_pista==2))
		{
			
			/*extraemos elaño*/
			numero_pelicula=getpeliculaSeleccionada();
			año_pelicula=numero_pelicula.getAño();
			campo_pelicula=""+año_pelicula;
			/*falta la gui*/
			
			
		}
		
		else if ((numero_pregunta==3) && (numero_pista==3))
		{
			
			/*extraemos el director*/

			numero_pelicula=getpeliculaSeleccionada();
			campo_pelicula=numero_pelicula.getDirector();
			
			/*falta la gui*/
			
		}
		
		else if ((numero_pregunta==3) && (numero_pista==4))
		{
			
			/*extraemos el actor*/


			numero_pelicula=getpeliculaSeleccionada();
			campo_pelicula=numero_pelicula.getActor();
			
			/*falta la gui*/
			
		}
		
		
		else if ((numero_pregunta==3) && (numero_pista==5))
		{
			
			/*extraemos la actriz*/

			numero_pelicula=getpeliculaSeleccionada();
			campo_pelicula=numero_pelicula.getActriz();
			
			/*falta la gui*/
			
		}
		
		
		
/*pregunta 4*/
		
		if ((numero_pregunta==4) && (numero_pista==1)) 
		{
			
			/*extraemos el titulo*/

			numero_pelicula=getpeliculaSeleccionada();
			campo_pelicula=numero_pelicula.getTitulo();
			
			/*falta la gui*/
			
		
		}
		else if ((numero_pregunta==4) && (numero_pista==2))
		{
			
			/*extraemos el año*/
			numero_pelicula=getpeliculaSeleccionada();
			año_pelicula=numero_pelicula.getAño();
			campo_pelicula=""+año_pelicula;
			/*falta la gui*/
			
			
		}
		
		else if ((numero_pregunta==4) && (numero_pista==3))
		{
			
			/*extraemos el genero*/
			numero_pelicula=getpeliculaSeleccionada();
			campo_pelicula=numero_pelicula.getGenero();
			
			/*falta la gui*/
		}
		
		else if ((numero_pregunta==4) && (numero_pista==4))
		{
			
			/*extraemos la actor*/


			numero_pelicula=getpeliculaSeleccionada();
			campo_pelicula=numero_pelicula.getActor();
			
			/*falta la gui*/
		}
		
		
		else if ((numero_pregunta==4) && (numero_pista==5))
		{
			
			/*extraemos la actriz*/

			numero_pelicula=getpeliculaSeleccionada();
			campo_pelicula=numero_pelicula.getActriz();
			
			/*falta la gui*/
			
		}
		
/*pregunta 5*/
		
		if ((numero_pregunta==5) && (numero_pista==1)) 
		{
			
			/*extraemos el titulo*/

			numero_pelicula=getpeliculaSeleccionada();
			campo_pelicula=numero_pelicula.getTitulo();
			
			/*falta la gui*/
			
			
		
		}
		else if ((numero_pregunta==5) && (numero_pista==2))
		{
			
			/*extraemos el año*/
			numero_pelicula=getpeliculaSeleccionada();
			año_pelicula=numero_pelicula.getAño();
			campo_pelicula=""+año_pelicula;
			/*falta la gui*/
			
			
		}
		
		else if ((numero_pregunta==5) && (numero_pista==3))
		{
			
			/*extraemos el genero*/
			numero_pelicula=getpeliculaSeleccionada();
			campo_pelicula=numero_pelicula.getGenero();
			
			/*falta la gui*/
		}
		
		else if ((numero_pregunta==5) && (numero_pista==4))
		{
			
			/*extraemos el director*/
			

			numero_pelicula=getpeliculaSeleccionada();
			campo_pelicula=numero_pelicula.getDirector();
			
			/*falta la gui*/
		}
		
		
		else if ((numero_pregunta==5) && (numero_pista==5))
		{
			
			/*extraemos la actriz*/

			numero_pelicula=getpeliculaSeleccionada();
			campo_pelicula=numero_pelicula.getActriz();
			
			/*falta la gui*/
			
		}
		
/*pregunta 6*/
		
		if ((numero_pregunta==6) && (numero_pista==1)) 
		{
			
			/*extraemos el titulo*/

			numero_pelicula=getpeliculaSeleccionada();
			campo_pelicula=numero_pelicula.getTitulo();
			
			/*falta la gui*/
			
		
		}
		else if ((numero_pregunta==6) && (numero_pista==2))
		{
			
			/*extraemos el año*/
			numero_pelicula=getpeliculaSeleccionada();
			año_pelicula=numero_pelicula.getAño();
			campo_pelicula=""+año_pelicula;
			/*falta la gui*/
			
			
		}
		
		else if ((numero_pregunta==6) && (numero_pista==3))
		{
			
			/*extraemos el genero*/
			numero_pelicula=getpeliculaSeleccionada();
			campo_pelicula=numero_pelicula.getGenero();
			
			/*falta la gui*/
		}
		
		else if ((numero_pregunta==6) && (numero_pista==4))
		{
			
			/*extraemos el director*/

			numero_pelicula=getpeliculaSeleccionada();
			campo_pelicula=numero_pelicula.getDirector();
			
			/*falta la gui*/
			
		}
		
		
		else if ((numero_pregunta==6) && (numero_pista==5))
		{
			
			/*extraemos el actor */


			numero_pelicula=getpeliculaSeleccionada();
			campo_pelicula=numero_pelicula.getActor();
			
			/*falta la gui*/
			
		}
		
		return campo_pelicula;
		
	}
	
	
	
	public boolean respuestaCorrecta(String respuestav1,boolean jugador1) 
	
	{
	      boolean respuesta=false;
	      
	       if ((id==1) && (respuestav1.equalsIgnoreCase(pelicula.getTitulo())))
	    	   
	    		   
	       {
	    	   
	    	   respuesta=true;
	    	   
	       }
	      
	      
	      else if ((id==2) && (respuestav1.equalsIgnoreCase(""+pelicula.getAño())))
	    	  
	      {
	    	  
	    	respuesta=true;
	    	  
	    	  
	      }
	       
	       
	      else if ((id==3) && (respuestav1.equalsIgnoreCase(pelicula.getGenero())))
	    	   
    		   
	       {
	    	   
	    	   respuesta=true;
	    	   
	       }
	       
	       
	       
	      else if ((id==4) && (respuestav1.equalsIgnoreCase(pelicula.getDirector())))
	    	   
    		   
	       {
	    	   
	    	   respuesta=true;
	    	   
	       }
	       
	       
	      else if ((id==5) && (respuestav1.equalsIgnoreCase(pelicula.getActor())))
	    	   
    		   
	       {
	    	   
	    	   respuesta=true;
	    	   
	       }
	       
	      
	      else if ((id==6) && (respuestav1.equalsIgnoreCase(pelicula.getActriz())))
	    	   
    		   
	       {
	    	   
	    	   respuesta=true;
	    	   
	       }
	       
	       if (jugador1)
	       {
	    	   
	    	   this.puntos_jugador1=this.puntuacion_maxj1;
	    	   
	    	   
	       }
	       else
	    	   
	       {
	    	   this.puntos_jugador2=this.puntuacion_maxj2;
	       }
	       return respuesta;
	      
	      
	}
	
	
	
	
	public int getnumeroPregunta()
	{
		
		return this.id;
		
	}
	
	public void setnumeroPregunta(int insertNumero) 
	{
		
		this.id=insertNumero;
		
	}
	
	
	public Pelicula getpeliculaSeleccionada()
	{
		
		return this.pelicula;
		
	}
	
	public void setpeliculaSeleccionada(Pelicula insertPelicula) 
	{
		
		this.pelicula=insertPelicula;
		
	}
	
	public int getnumero_pistas()
	{
		
		return this.numero_pistas;
		
	}
	
	public void setnumero_pistas(int insertnumero_pista) 
	{
		
		this.numero_pistas=insertnumero_pista;
		
	}


	public int getPuntos_jugador1() {
		return puntos_jugador1;
	}


	public void setPuntos_jugador1(int puntos_jugador1) {
		this.puntos_jugador1 = puntos_jugador1;
	}


	public int getPuntos_jugador2() {
		return puntos_jugador2;
	}


	public void setPuntos_jugador2(int puntos_jugador2) {
		this.puntos_jugador2 = puntos_jugador2;
	}
	
	
	
}
