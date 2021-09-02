package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import gui.DatosPrograma;
import gui.PantallaRegistroPelicula;
import peliculas.Pelicula;

public class PeliculaNueva implements ActionListener {
	
	
	DatosPrograma datosBackup;
	JList<Pelicula> peliculasBackup;
	private JFrame padre;
	

	public PeliculaNueva(DatosPrograma datos, JList<Pelicula> peliculas,  JFrame frame) {
		// TODO Auto-generated constructor stub
		
		datosBackup=datos;
		peliculasBackup=peliculas;
		padre=frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		PantallaRegistroPelicula pantalla=new PantallaRegistroPelicula(padre);
		pantalla.setVisible(true);
		String titulo;
		String año;
		String director;
		String genero;
		String actor;
		String actriz;
		
			titulo=pantalla.getitulo();
			año=pantalla.getaño();
			director=pantalla.getdirector();
			genero=pantalla.getgenero();
			actor=pantalla.getactor();
			actriz=pantalla.getactriz();
			
			if(titulo.isEmpty() ||año.isEmpty() || director.isEmpty() || genero.isEmpty() || actor.isEmpty() || actriz.isEmpty()) {
				JOptionPane.showMessageDialog(pantalla, "Debe rellenar todos los datos", "Error al Crear la pelicula", JOptionPane.ERROR_MESSAGE);
				pantalla.setVisible(true);				
			}
			else {
				Pelicula pelicula=new Pelicula();
				try {
				
					 pelicula.setTitulo(titulo);
					 pelicula.setAño(Integer.valueOf(año));
					 pelicula.setDirector(director);
					 pelicula.setGenero(genero);
					 pelicula.setActor(actor);
					 pelicula.setActriz(actriz);
					 
					 datosBackup.nuevaPelicula(pelicula);
					 Vector <Pelicula>nuevosDatos=new Vector <Pelicula>();
					 for (int i = 0; i < datosBackup.getPeliculas().getListaPelicula().size(); i++) 
					 
					 {
					
						 nuevosDatos.addElement(datosBackup.getPeliculas().getListaPelicula().get(i));
						 
						 
						 
					 }
					 peliculasBackup.setListData(nuevosDatos);
					
					
				}catch (Exception ex) {

					JOptionPane.showMessageDialog(pantalla, ex.getMessage(), "Error al crear pelicula", JOptionPane.ERROR_MESSAGE);
					pantalla.setVisible(true);
				}
			}
		
		
		
		
			datosBackup.actualizarMuro();

	}

}
