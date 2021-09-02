package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;

import gui.DatosPrograma;
import peliculas.Usuario;

public class CompartirConTodosTodo implements ActionListener {
	
	
	DatosPrograma datosbackup;
	JList<Usuario> amigosBackup;

	public CompartirConTodosTodo(DatosPrograma datos, JList<Usuario> amigos) {
		// TODO Auto-generated constructor stub
		
		datosbackup=datos;
		amigosBackup=amigos;
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		
		
		
		
		for (Usuario iterable_element : amigosBackup.getSelectedValuesList() ) 
			
		{
			
			
			

			datosbackup.getUsuarioActual().compartirTodo(iterable_element);
		}
		
		
		datosbackup.actualizarMuro();
	}

}
