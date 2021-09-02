package gui;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JTextField;

public class  PantallaRegistroPelicula extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2131188204117438063L;
	private JTextField titulo;
	private JTextField año;
	private JTextField director;
	private JTextField genero;
	private JTextField actor;
	private JTextField actriz;
	private JButton botonAceptar;
	private boolean aceptar;

	/**
	 * Constructor que pone titulo al dialogo, construye la ventana y la hace
	 * modal.
	 * 
	 * @param padre
	 *            Frame que hace de padre de esta dialogo.
	 */
	public PantallaRegistroPelicula(Frame padre) {

		// padre y modal
		super(padre, true);
		setTitle("Introduce los datos de la pelicula");
		titulo = new JTextField(20);
		titulo.setToolTipText("Titulo de la pelicula");
		año = new JTextField(20);
		año.setToolTipText("Año de la pelicula");
		director = new JTextField(20);
		director.setToolTipText("Director de la pelicula");
		genero = new JTextField(20);
		genero.setToolTipText("Genero de la pelicula");
		actor = new JTextField(20);
		actor.setToolTipText("Actor de la pelicula");
		actriz = new JTextField(20);
		actriz.setToolTipText("Actriz de la pelicula");
		
		botonAceptar=new JButton("Aceptar");
		botonAceptar.addActionListener(e -> {
			setVisible(false);
			setAceptar(true);
		});
		
		getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.PAGE_AXIS));
		
		
		
		
		
		getContentPane().add(titulo);
		getContentPane().add(año);
		getContentPane().add(director);
		getContentPane().add(genero);
		getContentPane().add(actor);
		getContentPane().add(actriz);
		
	
		getContentPane().add(botonAceptar,BorderLayout.SOUTH);
		this.setBounds(100, 100, 450, 300);
		aceptar=false;
		
	}

	/**
	 * Deveulve el texto en el jtextfield
	 * 
	 * @return el texto
	 */
	public String getitulo() {
		return titulo.getText();
	}
	
	public String getaño() {
		return año.getText();
	}
	
	public String getdirector() {
		return director.getText();
	}
	
	public String getgenero() {
		return genero.getText();
	}
	
	public String getactor() {
		return actor.getText();
	}
	
	public String getactriz() {
		return actriz.getText();
	}

	/**
	 * @return the aceptar
	 */
	public boolean isAceptar() {
		return aceptar;
	}

	/**
	 * @param aceptar the aceptar to set
	 */
	public void setAceptar(boolean aceptar) {
		this.aceptar = aceptar;
	}
	
	
}



