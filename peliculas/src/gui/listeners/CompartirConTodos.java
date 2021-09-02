package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;

import gui.DatosPrograma;
import peliculas.Compartible;
import peliculas.Usuario;

public class CompartirConTodos<Elem extends Compartible> implements ActionListener {
	
	DatosPrograma datosbackup;
	JList<Elem> elementosAcompartirBackup;
	JList<Usuario> amigosBackup;

	public CompartirConTodos(DatosPrograma datos, JList<Elem> elementosAcompartir, JList<Usuario> amigos) {
		// TODO Auto-generated constructor stub
		
		
		datosbackup=datos;
		elementosAcompartirBackup=elementosAcompartir;
		amigosBackup=amigos;
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		

		for (Elem iterable_element : elementosAcompartirBackup.getSelectedValuesList())
		
		{
				
			for (Usuario iterable_element1 : amigosBackup.getSelectedValuesList() ) 
			
			{
				
				
				

				iterable_element.compartir(iterable_element1);
				
			}
			
		
		}
		datosbackup.actualizarMuro();
	}

}
