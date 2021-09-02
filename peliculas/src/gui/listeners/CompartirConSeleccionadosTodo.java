package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;

import gui.DatosPrograma;
import peliculas.Usuario;

public class CompartirConSeleccionadosTodo implements ActionListener {
	
	DatosPrograma datosBackup;
	JList<Usuario> amigosBackup;
	
	

	public CompartirConSeleccionadosTodo(DatosPrograma datos, JList<Usuario> amigos) 
	
	{
		// TODO Auto-generated constructor stub
		
	datosBackup=datos;	
	amigosBackup=amigos;	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	
	{
		// TODO Auto-generated method stub
		
		
		
				
			for (Usuario iterable_element : amigosBackup.getSelectedValuesList() ) 
			
			{
				
				
				

				datosBackup.getUsuarioActual().compartirTodo( iterable_element);
			}
			
		
		
	
		
			datosBackup.actualizarMuro();
	}

}
