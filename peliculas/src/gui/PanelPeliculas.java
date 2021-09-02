package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import peliculas.Pelicula;

public class PanelPeliculas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel titulo,director,genero,actor,actriz,año;

	/**
	 * 
	 */
	public PanelPeliculas() {
		super();		
		setLayout(new GridBagLayout());
		GridBagConstraints restriccionesPanelUsuario = new GridBagConstraints();
		restriccionesPanelUsuario.gridx=0;
		restriccionesPanelUsuario.gridy=0;	
		restriccionesPanelUsuario.weightx=1;//1/4
		restriccionesPanelUsuario.weighty=0.15;		//50% de la pantalla.
		titulo=new JLabel("Titulo:");
		this.add(titulo,restriccionesPanelUsuario);
		director=new JLabel("Director:");
		restriccionesPanelUsuario.gridy=1;
		this.add(director,restriccionesPanelUsuario);		
		genero=new JLabel("Genero:");
		restriccionesPanelUsuario.gridy=2;
		this.add(genero,restriccionesPanelUsuario);
		actor=new JLabel("Actor:");
		restriccionesPanelUsuario.gridy=3;
		this.add(actor,restriccionesPanelUsuario);
		actriz=new JLabel("Actriz:");
		restriccionesPanelUsuario.gridy=4;
		this.add(actriz,restriccionesPanelUsuario);
		año=new JLabel("Año:");
		restriccionesPanelUsuario.gridy=5;
		this.add(año,restriccionesPanelUsuario);
	}
	
	public void mostrarPelicula(Pelicula pelicula) {
		titulo.setText("Titulo:"+pelicula.getTitulo());
		director.setText("Director:"+pelicula.getDirector());
		genero.setText("Genero:"+pelicula.getGenero());
		actor.setText("Actor:"+pelicula.getActor());
		actriz.setText("Actriz:"+pelicula.getActriz());
		año.setText("Año:"+pelicula.getAño());
	}
	

}
