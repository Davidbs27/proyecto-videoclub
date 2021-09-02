package peliculas;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombreUSuario;
	private int jugadas;
	private int ganadas;
	private int empatadas;
	private int perdidas;
	private double  porcentaje_victorias;
	private int ptos;
	private ArrayList<Partida> partidas_completadas;
	/*constructor*/

	public Item() 
	{
		nombreUSuario="";
		jugadas=0;
		ganadas=0;
		empatadas=0;
		perdidas=0;
		porcentaje_victorias=0;
		ptos=0;;
		partidas_completadas=new ArrayList<>();
	
	}
	
	
	
	@Override
	public String toString() {
		
		
		
		// TODO Auto-generated method stub
		return "Nombre usuario: "+nombreUSuario+" Partidas jugadas : "+jugadas+" Partidas ganadas : "+ganadas+ " Partidas empatadas : "
				+empatadas+" Partidas perdidas : "+perdidas+" Porcentaje victorias : "+porcentaje_victorias+" Puntos totales :  "+ptos;
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
				
				
				nombreUSuario=(String) input.readObject();
				jugadas=(int) input.readObject();
				ganadas=(int) input.readObject();
				perdidas=(int) input.readObject();
				porcentaje_victorias=(double) input.readObject();
				ptos=(int) input.readObject();
				partidas_completadas=(ArrayList <Partida>) input.readObject();
			
			}catch (EOFException eof) 
			
			{
				
				//fin del fichero
				
			}
			
		
		
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public void detallePartidas(String nombre)
	{
		
		
		
		
		
		
	}





	public String getNombreUSuario() {
		return nombreUSuario;
	}





	public void setNombreUSuario(String nombreUSuario) {
		this.nombreUSuario = nombreUSuario;
	}





	public int getJugadas() {
		return jugadas;
	}





	public void setJugadas(int jugadas) {
		this.jugadas = jugadas;
	}





	public int getGanadas() {
		return ganadas;
	}





	public void setGanadas(int ganadas) {
		this.ganadas = ganadas;
	}





	public int getPerdidas() {
		return perdidas;
	}





	public void setPerdidas(int perdidas) {
		this.perdidas = perdidas;
	}





	public double getPorcentaje_victorias() {
		return porcentaje_victorias;
	}





	public void setPorcentaje_victorias(double porcentaje_victorias) {
		this.porcentaje_victorias = porcentaje_victorias;
	}





	public int getPtos() {
		return ptos;
	}





	public void setPtos(int ptos) {
		this.ptos = ptos;
	}





	public ArrayList<Partida> getPartidas_completadas() {
		return partidas_completadas;
	}





	public void setPartidas_completadas(ArrayList<Partida> partidas_completadas) {
		this.partidas_completadas = partidas_completadas;
	}
	
	
	public int getEmpatadas() {
		return empatadas;
	}
	
	
	public void setEmpatadas(int empatadas) {
		this.empatadas = empatadas;
	}

	
	
}
