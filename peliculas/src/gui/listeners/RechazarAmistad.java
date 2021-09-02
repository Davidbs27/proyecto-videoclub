package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JList;

import gui.DatosPrograma;
import peliculas.Usuario;

public class RechazarAmistad implements ActionListener {
	
	
	DatosPrograma datosBackup;
	JList listaBackup;
	

	public RechazarAmistad(DatosPrograma datos, JList<Usuario> lista) {
		// TODO Auto-generated constructor stub
		
		
		datosBackup=datos;
		listaBackup=lista;
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
		/*rechazamos amistad de los elementos seleccionados*/
		
		datosBackup.getUsuarioActual().rechazarInvitacion((Usuario) listaBackup.getSelectedValue());
		
		Vector <Usuario>nuevosDatos=new Vector <Usuario>();
		
		

		for (Usuario usuario2 : datosBackup.getUsuarioActual().getSolicitudes_amigos_pendientes()) 
		
		{
		
			nuevosDatos.add(usuario2);
			
		}
		
		
		listaBackup.setListData(nuevosDatos); /*pinta los datos nuevos en la pantalla */
		
		

	}

}
