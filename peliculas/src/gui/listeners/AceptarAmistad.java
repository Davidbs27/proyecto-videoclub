package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JList;

import gui.DatosPrograma;
import peliculas.Usuario;

public class AceptarAmistad implements ActionListener {
	
	private JList <Usuario >listaBackup;
	private DatosPrograma datosBackup;
	private JList <Usuario >listaAmigosBackup;
	

	public AceptarAmistad(DatosPrograma datos, JList<Usuario> lista, JList<Usuario> lista_Amigos) {
		// TODO Auto-generated constructor st
		
		datosBackup=datos; /* datos mios */
		listaBackup=lista; /*datos del del usuario externo*/
		listaAmigosBackup=lista_Amigos; /* lista  mis amigos  */
		
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
		
		datosBackup.getUsuarioActual().aceptarInvitacion(listaBackup.getSelectedValue());
		Vector <Usuario>nuevosDatos=new Vector <Usuario>();
		Vector <Usuario>nuevosDatos2=new Vector <Usuario>();
		
		/*for que se recorre de mi lista actual las solicitudes pendientes */
		
		/*quitamos la peticion de amistad */
		
		for (Usuario usuario2 : datosBackup.getUsuarioActual().getSolicitudes_amigos_pendientes()) 
		
		{
		
			nuevosDatos.add(usuario2);
			
		}
		
		listaBackup.setListData(nuevosDatos); /*pinta los datos nuevos en la pantalla */
		
		for (Usuario usuario : datosBackup.getUsuarioActual().getLista_mis_amigos())
			
		{
		
			nuevosDatos2.add(usuario);
			
		}
		
		listaAmigosBackup.setListData(nuevosDatos2); /*pinta los datos nuevos en la pantalla */
		
		
	}

}
