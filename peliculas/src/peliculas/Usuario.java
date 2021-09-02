package peliculas;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*atributos*/
		private String nombreUSuario;
		private String contrasena;
		private StringBuilder muro;
		private int partidas_ganadas;
		private int partidas_perdidas;
		private int partidas_empatadas;
		private ArrayList<Partida> partidas_completas;
		/*Partida partidas_pendientes[];*/
		private ArrayList<Partida>partidas_pendientesj1 ;
		private ArrayList<Partida>partidas_pendientesj2 ;
		 /*Usuario solicitudes_amigos_pendientes[];*/
		private ArrayList<Usuario> solicitudes_amigos_pendientes;
		private ArrayList<Usuario> lista_mis_amigos;
		private ArrayList<Pelicula> lista_mis_peliculas;
		private ArrayList<Critica> lista_mis_criticas;
		
		
		/*constructor*/
		
	public Usuario (String nombre,String clave) {
		
		this.contrasena=clave;
		this.nombreUSuario=nombre;
		this.partidas_ganadas=0;
		this.partidas_perdidas=0;
		this.partidas_empatadas=0;
		this.partidas_completas=null;
		this.partidas_pendientesj1=null;
		this.partidas_pendientesj2=null;
		this.solicitudes_amigos_pendientes=null;
		partidas_completas=new ArrayList<>();
		/*Partida partidas_pendientes[];*/
		partidas_pendientesj1=new ArrayList<>() ;
		partidas_pendientesj2=new ArrayList<>() ;
		solicitudes_amigos_pendientes=new ArrayList<>();
		lista_mis_amigos=new ArrayList<>();
		lista_mis_peliculas=new ArrayList<>();
		lista_mis_criticas=new ArrayList<>();
		this.muro=new StringBuilder();
		
	}

		
		/*metodos*/
	
	
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
				
				nombreUSuario=(String) input.readObject();
				contrasena=(String) input.readObject();
				muro=(StringBuilder) input.readObject();
				partidas_ganadas=(int) input.readObject();
				partidas_perdidas=(int) input.readObject();
				partidas_empatadas=(int) input.readObject();
				partidas_completas=(ArrayList <Partida>) input.readObject();
				partidas_pendientesj1=(ArrayList <Partida>) input.readObject();
				partidas_pendientesj2=(ArrayList <Partida>) input.readObject();
				solicitudes_amigos_pendientes=(ArrayList <Usuario>) input.readObject();
				lista_mis_amigos=(ArrayList <Usuario>) input.readObject();
				lista_mis_peliculas=(ArrayList <Pelicula>) input.readObject();
			
				
				
				
				
			
			}catch (EOFException eof) 
			
			{
				
				//fin del fichero
				
			}
			
		
		
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	public void invitarAmigo(Usuario u) throws Exception
	{
		if(!solicitudes_amigos_pendientes.contains(u)) {
			
			solicitudes_amigos_pendientes.add(u);
		}
		else {
			throw new Exception("Usuario ya esta en la lista de invitaciones pendientes");
	
		}
		
	}
	
	public void aceptarInvitacion(Usuario u)
	{
		
		lista_mis_amigos.add(u);
		this.solicitudes_amigos_pendientes.remove(u);
		u.aceptarInvitacionInt(this);
		
		
	}
	
	public void aceptarInvitacionInt(Usuario u)
	{
		
		lista_mis_amigos.add(u);
		solicitudes_amigos_pendientes.remove(u);
		
		
	}
	
	
	public void rechazarInvitacion(Usuario u)
	{
		 solicitudes_amigos_pendientes.remove(u);
		
		
	}
	
	public void compartirPelicula(Pelicula p)
	{
		 /*titulo,director,genero,actor,actriz*/
		/*lista_mis_amigos.forEach(muro+"Titulo:" + p.getTitulo()+"Director:"+p.getDirector()+"Actor:"+p.getActor()+"Actriz:"+p.getActriz()+"Año:"+p.getAño());*/
		
	        
	    	muro.append("Titulo:");
	    	muro.append(p.getTitulo());
	    	muro.append("Director:");
	    	muro.append(p.getDirector());
	    	muro.append("Actor:");
	    	muro.append(p.getActor());
	    	muro.append("Actriz:");
	    	muro.append(p.getActriz());
	    	muro.append("Año:");
	    	muro.append(p.getAño());
	    	muro.append("Compartido por: ");
	    	muro.append(this.getusuarioNombre());
	    	
	     
		
		
	}
	
	public void compatirPelicula(Pelicula p,Usuario u)
	{
		
		
		
		 u.muro.append("Titulo:");
		 u.muro.append(p.getTitulo());
		 u.muro.append("Director:");
		 u.muro.append(p.getDirector());
		 u.muro.append("Actor:");
		 u.muro.append(p.getActor());
		 u.muro.append("Actriz:");
		 u.muro.append(p.getActriz());
		 u.muro.append("Año:");
		 u.muro.append(p.getAño());
		 u.muro.append("Compartido por: ");
		 u.muro.append(this.getusuarioNombre());
		 
	    	
		
	}
	
	public void compartirCritica(Critica c)
	{
		
	        
	    	muro.append("Pelicula:");
	    	muro.append(c.getPelicula());
	    	muro.append("Puntuacion:");
	    	muro.append(c.getPuntuacion());
	    	muro.append("Critica:");
	    	muro.append(c.getTexto());
	    	muro.append("Compartido por: ");
			muro.append(this.getusuarioNombre());
	      
		
		
	}
	
	public void compartirCritica(Critica c,Usuario u)
	{
		
		u.muro.append("Pelicula:");
		u.muro.append(c.getPelicula());
		u.muro.append("Puntuacion:");
		u.muro.append(c.getPuntuacion());
		u.muro.append("Critica:");
		u.muro.append(c.getTexto());
		u.muro.append("Compartido por: ");
		u.muro.append(this.getusuarioNombre());
		
	}
	
	public void compartirPartida(Partida p)
	{
		
		this.muro.append("Partida:" );
		this.muro.append(p.getIdentificador());
		this.muro.append("Puntuacion j1: ");
		this.muro.append(p.getPtos_jugador1());
		this.muro.append("Puntuacion j2: ");
		this.muro.append(p.getPtos_jugador2());
		this.muro.append("Resultado Final: ");
		this.muro.append(p.getResultado_Final());
		this.muro.append("Ganador: ");
		this.muro.append(p.getGanador());
		this.muro.append("Compartido por: ");
		this.muro.append(this.getusuarioNombre());
	
	}
	
	public void compartirPartida(Partida p,Usuario u)
	{
		
		u.compartirPartida(p);
		
	}
	
	public void compartirTodo()
	{
		
		for (int i = 0; i < lista_mis_amigos.size(); i++) 
		{
			
			for (int j = 0; j < lista_mis_criticas.size(); j++) 
			{
				lista_mis_amigos.get(i).compartirCritica(lista_mis_criticas.get(j));
			}
			
			for (int j = 0; j < lista_mis_peliculas.size(); j++) 
			{
				
				lista_mis_amigos.get(i).compartirPelicula(lista_mis_peliculas.get(j));
			}
			
			for (int j = 0; j < partidas_completas.size(); j++) 
			{
				
				lista_mis_amigos.get(i).compartirPartida(partidas_completas.get(j));
			}
		}
		
		
	}
	public void compartirTodo(Usuario u)
	{
		
		for (int j = 0; j < lista_mis_criticas.size(); j++) 
		{
			u.compartirCritica(lista_mis_criticas.get(j));
		}
		
		for (int j = 0; j < lista_mis_peliculas.size(); j++) 
		{
			
			u.compartirPelicula(lista_mis_peliculas.get(j));
		}
		
		for (int j = 0; j < partidas_completas.size(); j++) 
		{
			
			u.compartirPartida(partidas_completas.get(j));
		}
		
		
	}
	public void añadirPelicula(Pelicula p) throws Exception
	{
		
		/*para añadir una pelicula cada usuario necesitara su propia lista*/
		
		if(!lista_mis_peliculas.contains(p)) {
			
			lista_mis_peliculas.add(p);
		}
		else {
			throw new Exception("Ya has añadido esta pelicula,no puedes añadirla otra vez");
	
		}
		this.compartirPelicula(p);
		
		
		
	}
	
	public void añadirCritica(Critica c,Pelicula p)
	{
		
		
		
		c.setPelicula(p.getTitulo());
		/* falta añadir la puntuacion y el texto por la gui*/
		p.añadirCritica(c);
		
		lista_mis_criticas.add(c);
		this.compartirCritica(c);
		
	}
	
	public void iniciarPartida(Usuario u)
	{
		Partida p;
		
		p=new Partida(this,u);
		this.partidas_pendientesj1.add(p);
		u.partidas_pendientesj2.add(p);
		
		
	}
	
	public void completarPartida(Partida p)
	{
		
		this.partidas_completas.add(p);
		
		this.partidas_pendientesj2.remove(p);
		this.partidas_pendientesj1.remove(p);
		
		if (p.getGanador()==this)
		{
			this.partidas_ganadas++;
		}
		
		else
		{
			if (p.getResultado_Final().equalsIgnoreCase("empate"))
			{
				this.partidas_empatadas++;
				
			}
			else
			{
				
				this.partidas_perdidas++;
			}
			
		}
		this.compartirPartida(p);
		
	}
	
	public void setMuro(StringBuilder s)
	{
		
		this.muro=s;
	}
	
	public static void setUsuarioNombre(Usuario u,String x) {
		
		u.nombreUSuario=x;
	}

	public static void setContrasena(Usuario u,String cla) {
		
		u.contrasena=cla;
	}

	
public  String getusuarioNombre() {
	
		return nombreUSuario;
	}

	public String getcontrasena() {
		return contrasena;
	}
	
	
	
	
	
	
@Override	
	
	public int hashCode() {
		
		final int prime=31;
		int result=1;		
		result=prime * result + ((nombreUSuario == null) ? 0 : nombreUSuario.hashCode());
		return result;
	}
	

	public boolean  equals (Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Usuario))
			return false;
		Usuario other = (Usuario) obj;
		if (nombreUSuario == null) {
			if (other.nombreUSuario != null)
				return false;
		}else if (!nombreUSuario.equals(other.nombreUSuario))
			return false;
		return true;
	}
	
	public ArrayList<Partida> getpartidas_pendientesj1()
	{
		
		return this.partidas_pendientesj1;
		
	}
	
	public void setpartidas_pendientesj1(ArrayList <Partida> insertpartidas_pendientesj1) 
	{
		
		this.partidas_pendientesj1=insertpartidas_pendientesj1;
		
	}
	
	
	public ArrayList <Partida> getpartidas_pendientesj2()
	{
		
		return this.partidas_pendientesj2;
		
	}
	
	public void setpartidas_pendientesj2(ArrayList <Partida>insertpartidas_pendientesj2) 
	{
		
		this.partidas_pendientesj2=insertpartidas_pendientesj2;
		
	}


	public ArrayList<Partida> getPartidas_completas() {
		return partidas_completas;
	}


	public void setPartidas_completas(ArrayList<Partida> partidas_completas) {
		this.partidas_completas = partidas_completas;
	}


	public int getPartidas_ganadas() {
		return partidas_ganadas;
	}


	public void setPartidas_ganadas(int partidas_ganadas) {
		this.partidas_ganadas = partidas_ganadas;
	}


	public int getPartidas_perdidas() {
		return partidas_perdidas;
	}


	public void setPartidas_perdidas(int partidas_perdidas) {
		this.partidas_perdidas = partidas_perdidas;
	}


	public int getPartidas_empatadas() {
		return partidas_empatadas;
	}


	public void setPartidas_empatadas(int partidas_empatadas) {
		this.partidas_empatadas = partidas_empatadas;
	}


	/**
	 * @return the solicitudes_amigos_pendientes
	 */
	public  ArrayList<Usuario> getSolicitudes_amigos_pendientes() {
		return solicitudes_amigos_pendientes;
	}


	/**
	 * @param solicitudes_amigos_pendientes the solicitudes_amigos_pendientes to set
	 */
	public  void setSolicitudes_amigos_pendientes(ArrayList<Usuario> solicitudes_amigos_pendientes) {
		this.solicitudes_amigos_pendientes = solicitudes_amigos_pendientes;
	}


	/**
	 * @return the lista_mis_amigos
	 */
	public  ArrayList<Usuario> getLista_mis_amigos() {
		return lista_mis_amigos;
	}


	/**
	 * @param lista_mis_amigos the lista_mis_amigos to set
	 */
	public  void setLista_mis_amigos(ArrayList<Usuario> lista_mis_amigos) {
		this.lista_mis_amigos = lista_mis_amigos;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.nombreUSuario;
	}


	/**
	 * @return the muro
	 */
	public StringBuilder getMuro() {
		return muro;
	}
	
	
	
	
}
