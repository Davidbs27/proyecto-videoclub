package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JList;

import gui.DatosPrograma;
import peliculas.Partida;
import peliculas.Usuario;

public class PartidaNueva implements ActionListener {
	
	
	DatosPrograma datosBackup;
	JList<Partida> partidasJ1Backup;
	
	

	public PartidaNueva(DatosPrograma datos, JList<Partida> partidasJ1) {
		// TODO Auto-generated constructor stub
		
		
		datosBackup=datos;
		partidasJ1Backup=partidasJ1;
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		ArrayList<Usuario> oponente;
		int candidatosOponente,numero,numeroPartida;
		Partida partidaActual;
		Boolean salida=false;
		/*Vector <Partida>nuevosDatos=new Vector <Partida>()*/;
		Vector<Partida>nuevosDatos=new Vector <Partida>();
		
		do {
			
		
			/*Vamos a elegir un adversario */
			oponente=datosBackup.getUsuarios().getListaUsuarios();
			candidatosOponente=oponente.size();
			numero=(int)(Math.random()*candidatosOponente);
		
			/*Si el nombre del numero extraido es igual a mi nombre no puedo luchar conmigo mismo*/
			if (oponente.get(numero).getusuarioNombre()==datosBackup.getUsuarioActual().getusuarioNombre()) 
			{
			
				/* repetimos */
				salida=false;
			
			
			}
			else
			{
				datosBackup.getUsuarioActual().iniciarPartida(oponente.get(numero));
				salida=true;
			}
		
		}while (salida==false);
			
			
			
		
		
		for (Partida partida : datosBackup.getUsuarioActual().getpartidas_pendientesj1())
			
		{
		
			nuevosDatos.add(partida);
			
		}
		
		partidasJ1Backup.setListData(nuevosDatos); /*pinta los datos nuevos en la pantalla */
		
		/*Vamos a calcular las preguntas */
		
		numeroPartida=datosBackup.getUsuarioActual().getpartidas_pendientesj1().size();
		numeroPartida=numeroPartida-1;
		System.out.println(numeroPartida);
		partidaActual=datosBackup.getUsuarioActual().getpartidas_pendientesj1().get(numeroPartida);
		
		partidaActual.readyPlayerOne(datosBackup,partidaActual);
		
		
		
		

	}

}
