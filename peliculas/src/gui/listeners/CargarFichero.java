package gui.listeners;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JList;

import gui.DatosPrograma;
import peliculas.Critica;
import peliculas.Pelicula;

public class CargarFichero implements ActionListener {
	DatosPrograma datosBackup;
	Frame FrameBackup;
	JList<Pelicula> peliBackup;



	public CargarFichero(DatosPrograma datos,Frame frame,JList<Pelicula> peli) 


	{
		// TODO Auto-generated constructor stub

		 datosBackup=datos;
		 FrameBackup=frame;
		 peliBackup=peli;




	}

	@Override
	public void actionPerformed(ActionEvent e) 


	{
		// TODO Auto-generated method stub

		JFileChooser fileChooser = new JFileChooser(); // seleciona el fichero a cargar de datos del foro.

		int seleccion=fileChooser.showOpenDialog(FrameBackup);	// recoge el fiechero seleccionado	

		switch (seleccion) { //el switch controla el aceptar o cancelar de la pantalla de seleccion de fichero.
		case JFileChooser.APPROVE_OPTION://aceptar			
			datosBackup.leerFichero(fileChooser.getSelectedFile());
			datosBackup.actualizarMuro();
			Vector <Pelicula>nuevosDatos=new Vector <Pelicula>();
			 for (int i = 0; i < datosBackup.getPeliculas().getListaPelicula().size(); i++) 
			 
			 {
			
				 nuevosDatos.addElement(datosBackup.getPeliculas().getListaPelicula().get(i));
				 
				 
				 
			 }
			 peliBackup.setListData(nuevosDatos);
			
			
			
			
		default:

			break;
		}


	}

}
