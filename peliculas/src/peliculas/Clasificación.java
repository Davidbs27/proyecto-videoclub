package peliculas;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Clasificación implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList <Item> lista;
	/*atributos*/
	/*constructor*/
	/*metodos*/
	
	
	
	
	

	
	
	
	
	
	
	
	//EStos metodos no hacen falta, en ninguna de las clases
	public void escribirFichero (ObjectOutputStream output) throws IOException 
	
	{
		
		if (output!=null)
		{
			
			
			output.writeObject(this.lista);
			
		}
		
		
	}
	
	
	
	public void leerFichero (ObjectInputStream input) throws IOException,ClassNotFoundException
	
	
	{
		
		
		
		if (input!=null)
		{
			
			try {
				
				lista=(ArrayList <Item>) input.readObject();
			
			}catch (EOFException eof) 
			
			{
				
				//fin del fichero
				
			}
			
		
		
		}
		
		
		
		
		
	}
	
	
	
	
public boolean escribirFicheroTexto (String fichero) throws IOException 
	
	{
		
		FileWriter fileOut=new FileWriter(fichero);
		BufferedWriter buffer=new BufferedWriter(fileOut);
		PrintWriter salida=new PrintWriter(buffer);
		
		
		for (int i = 0; i < lista.size(); i++) 
		
		{
	
			salida.println(lista.get(i));
			
		}
		
		salida.close();

		return true;
	
	}
	
	
	
	
	
	
	
	
	
	
	
	public Clasificación() 
	{
		lista=new ArrayList <>();
	}
	

	public void actualizar(Partida p)
	{
		for (int i = 0; i < lista.size(); i++) 
		{
			
			if ((p.getGanador()!=null))
					
			{
				/*empate actuazizamos ambos */
				if (lista.get(i).getNombreUSuario().equalsIgnoreCase(p.getGanador().getusuarioNombre()))
				{
					lista.get(i).setGanadas(lista.get(i).getGanadas()+1);
				}
			
				else if (lista.get(i).getNombreUSuario().equalsIgnoreCase(p.getCreador().getusuarioNombre()) ||
					lista.get(i).getNombreUSuario().equalsIgnoreCase(p.getNombrej2().getusuarioNombre()))
				{
					lista.get(i).setPerdidas(lista.get(i).getPerdidas()+1);
				}
			}else
			{
				if (p.getCreador().getusuarioNombre().equalsIgnoreCase(lista.get(i).getNombreUSuario()))
				{
					lista.get(i).setEmpatadas(lista.get(i).getEmpatadas()+1);
				}
				
				if (p.getNombrej2().getusuarioNombre().equalsIgnoreCase(lista.get(i).getNombreUSuario()))
				{
					lista.get(i).setEmpatadas(lista.get(i).getEmpatadas()+1);
				}
				
				
			}
		
				if (p.getCreador().getusuarioNombre().equalsIgnoreCase(lista.get(i).getNombreUSuario()))
				{
					lista.get(i).setJugadas(lista.get(i).getJugadas()+1);
					lista.get(i).setPtos(lista.get(i).getPtos()+p.getPtos_jugador1());
				}
				
				if (p.getNombrej2().getusuarioNombre().equalsIgnoreCase(lista.get(i).getNombreUSuario()))
				{
					lista.get(i).setJugadas(lista.get(i).getJugadas()+1);
					lista.get(i).setPtos(lista.get(i).getPtos()+p.getPtos_jugador2());
				}
				
				if(lista.get(i).getJugadas()==0)
				{
					lista.get(i).setPorcentaje_victorias(0);
				}
				else 
				
				{
					lista.get(i).setPorcentaje_victorias((lista.get(i).getGanadas()/lista.get(i).getJugadas())*100);
				}
				
			
		}
	}
	 
	public void visualizar()
	{
		
	}
	
	public void ordenarVictorias()
	{
		Collections.sort(lista, new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) {
				return Integer.valueOf(o1.getGanadas()).compareTo(Integer.valueOf(o2.getGanadas()));
			}
			
		});
	}
	
	public void ordenarPorcentaje()
	{
		
		Collections.sort(lista, new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) {
				return Double.valueOf(o1.getPorcentaje_victorias()).compareTo(Double.valueOf(o2.getPorcentaje_victorias()));
			}
			
		});
		
	}
	
	public void ordenarPuntos()
	{
		
		Collections.sort(lista, new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) {
				return Integer.valueOf(o1.getPtos()).compareTo(Integer.valueOf(o2.getPtos()));
			}
			
		});
		
		
	}
	
	public void volcarTXT(File f)
	{
	}



	public ArrayList<Item> getLista() {
		return lista;
	}



	public void setLista(ArrayList<Item> lista) {
		this.lista = lista;
	}
	

}
