package peliculas;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import gui.DatosPrograma;

public class Partida implements Compartible,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int identificador;
	private Usuario ganador;
	private String resultado_Final;
	private int ptos_jugador1;
	private int ptos_jugador2;
	private ArrayList<Pregunta> lista_mis_preguntas;
	private boolean esParcial;	
	private Usuario creador;	
	private Usuario nombrej2;
	private boolean finJ1;
	private boolean finJ2;
	
	
	/*constructor*/
		/*metodos*/
	
		
		
		
		public Partida(Usuario creador,Usuario oponente) {
			
			/*constructor iniziador de variables paritda*/
			
			setIdentificador(0);
			/*setGanador(ganador);*/
			setResultado_Final(null);
			setPtos_jugador1(0);
			setPtos_jugador2(0);
			esParcial=true;
			this.creador=creador; 
			nombrej2=oponente;
			
			lista_mis_preguntas=new ArrayList<Pregunta>();

			finJ1=false;
			finJ2=false;
		}
		
		
		
		public void readyPlayerOne(DatosPrograma datosBackup, Partida partidaActual)
		{
			/*Obtenemos las preguntas para el jugador 1*/
			Pregunta pregunta0;
			Pregunta pregunta1;
			Pregunta pregunta2;
			Pregunta pregunta3;
			Pregunta pregunta4;
			Pregunta pregunta5;
			
			
			pregunta0=new Pregunta(0);
			pregunta1=new Pregunta(1);
			pregunta2=new Pregunta(2);
			pregunta3=new Pregunta(3);
			pregunta4=new Pregunta(4);
			pregunta5=new Pregunta(5);
			
			
			/*pregunta0=lista_mis_preguntas.get(0);
			pregunta1=lista_mis_preguntas.get(1);
			pregunta2=lista_mis_preguntas.get(2);
			pregunta3=lista_mis_preguntas.get(3);
			pregunta4=lista_mis_preguntas.get(4);
			pregunta5=lista_mis_preguntas.get(5);*/
			
			
	
				
				pregunta0.seleccionarPelicula(datosBackup.getPeliculas());
				pregunta1.seleccionarPelicula(datosBackup.getPeliculas());
				pregunta2.seleccionarPelicula(datosBackup.getPeliculas());
				pregunta3.seleccionarPelicula(datosBackup.getPeliculas());
				pregunta4.seleccionarPelicula(datosBackup.getPeliculas());
				pregunta5.seleccionarPelicula(datosBackup.getPeliculas());
				
				
				lista_mis_preguntas.add(0, pregunta0);
				lista_mis_preguntas.add(1, pregunta0);
				lista_mis_preguntas.add(2, pregunta1);
				lista_mis_preguntas.add(3, pregunta2);
				lista_mis_preguntas.add(4, pregunta3);
				lista_mis_preguntas.add(5, pregunta4);
				
							
			
		
		}
		
		public void readyPlayertwo()
		{
			
			
		}
		
		
		
		
		
		
		
		
		
		
		@Override
		public String toString() {
			
			
			
			// TODO Auto-generated method stub
			/*return (creador.getusuarioNombre());*/
			return (nombrej2.getusuarioNombre());
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
					
					identificador=(int) input.readObject();
					ganador=(Usuario) input.readObject();
					resultado_Final=(String) input.readObject();
					ptos_jugador1=(int) input.readObject();
					ptos_jugador2=(int) input.readObject();
					lista_mis_preguntas=(ArrayList <Pregunta>) input.readObject();
					esParcial=(boolean) input.readObject();	
					creador=(Usuario) input.readObject();	
					nombrej2=(Usuario) input.readObject();
					
					
				
				}catch (EOFException eof) 
				
				{
					
					//fin del fichero
					
				}
				
			
			
			}
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		public void finalizar_Partida(boolean jugador1)
		
		{
			if(jugador1) {
				finJ1=true;
			}
			else {
				finJ2=true;
			}

			if(finJ1 && finJ2) {
				for (int i = 0; i < lista_mis_preguntas.size(); i++) 

				{

					ptos_jugador1=lista_mis_preguntas.get(i).getPuntos_jugador1()+ptos_jugador1;
					ptos_jugador2=lista_mis_preguntas.get(i).getPuntos_jugador2()+ptos_jugador2;



				}

				if (ptos_jugador1>ptos_jugador2)
				{

					ganador=creador;

					resultado_Final="win1";



				}
				else if(ptos_jugador1==ptos_jugador2) 
				{
					ganador=null;
					resultado_Final="empate";
				}
				else
				{
					ganador=nombrej2;
					resultado_Final="win2";
				}

				setEsParcial(false);
				this.creador.completarPartida(this);
				this.nombrej2.completarPartida(this);
				
			}
			
			
		}
		
		
		
		
		
		
		
		public int getIdentificador()
		{
			
			return this.identificador;
			
		}
		
		public void setIdentificador(int insertIdentificador) 
		{
			
			this.identificador=insertIdentificador;
			
		}
		
		public Usuario getGanador()
		{
			
			return this.ganador;
			
		}
		
		public void setGanador(Usuario insertGanador) 
		{
			
			this.ganador=insertGanador;
			
		}
		

		public String getResultado_Final()
		{
			
			return this.resultado_Final;
			
		}
		
		public void setResultado_Final(String insertResultado_Final) 
		{
			
			this.resultado_Final=insertResultado_Final;
			
		}
		
		
		public int getPtos_jugador1()
		{
			
			return this.ptos_jugador1;
			
		}
		
		public void setPtos_jugador1(int insertPtos_jugador1) 
		{
			
			this.ptos_jugador1=insertPtos_jugador1;
			
		}
		
		
		public int getPtos_jugador2()
		{
			
			return this.ptos_jugador2;
			
		}
		
		public void setPtos_jugador2(int insertPtos_jugador2) 
		{
			
			this.ptos_jugador2=insertPtos_jugador2;
			
		}
		
		public Pregunta preguntaQueToca(int indice)
		{
			Pregunta question;
			
			question=lista_mis_preguntas.get(indice);
			
			
			return question;
			
		}


		@Override
		public void compartir(Usuario u) {

			
			
			u.compartirPartida(this);
			
			
			
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


		public boolean isEsParcial() {
			return esParcial;
		}


		public void setEsParcial(boolean esParcial) {
			this.esParcial = esParcial;
		}


		public Usuario getCreador() {
			return creador;
		}


		public void setCreador(Usuario creador) {
			this.creador = creador;
		}


	



		public Usuario getNombrej2() {
			return nombrej2;
		}


		public void setNombrej2(Usuario nombrej2) {
			this.nombrej2 = nombrej2;
		}



		

}
