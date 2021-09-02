package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;

import gui.DatosPrograma;
import peliculas.Compartible;
import peliculas.Usuario;

public class CompartirConSeleccionados<Elem extends Compartible> implements ActionListener {
	
	
	DatosPrograma datosBackup;
	JList<Elem> elementosAcompartirBackup;
	JList<Usuario> amigosBackup;
	
	

	public CompartirConSeleccionados(DatosPrograma datos, JList<Elem> elementosACompartir, JList<Usuario> amigos) {
		// TODO Auto-generated constructor stub
		
		/*constructor*/
		datosBackup=datos;
		elementosAcompartirBackup=elementosACompartir;
		amigosBackup=amigos;	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		

		
			
			
			for (Elem iterable_element : elementosAcompartirBackup.getSelectedValuesList())
			
			{
					
				for (Usuario iterable_element1 : amigosBackup.getSelectedValuesList() ) 
				
				{
					
					
					

					iterable_element.compartir(iterable_element1);
					
				}
				
			
			}
		
			datosBackup.actualizarMuro();
	}

}
