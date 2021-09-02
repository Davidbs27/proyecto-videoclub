package gui;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JTextField;

public class  PantallaRegistroCritica extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2131188204117438063L;
	private JTextField pelicula;
	private JTextField puntuacion;
	private JTextField texto;

	private JButton botonAceptar;
	private boolean aceptar;

	/**
	 * Constructor que pone titulo al dialogo, construye la ventana y la hace
	 * modal.
	 * 
	 * @param padre
	 *            Frame que hace de padre de esta dialogo.
	 */
	public PantallaRegistroCritica(Frame padre) {

		// padre y modal
		super(padre, true);
		setTitle("Introduce los datos de la critica");
		pelicula= new JTextField(20);
		pelicula.setToolTipText("Titulo de la pelicula");
		puntuacion = new JTextField(20);
		puntuacion.setToolTipText("Puntuacion de la pelicula");
		texto = new JTextField(20);
		texto.setToolTipText("Texto critica  de la pelicula");
		
		botonAceptar=new JButton("Aceptar");
		botonAceptar.addActionListener(e -> {
			setVisible(false);
			setAceptar(true);
		});
		
		getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.PAGE_AXIS));
		
		
		
		
		
		getContentPane().add(pelicula);
		getContentPane().add(puntuacion);
		getContentPane().add(texto);
		
	
		getContentPane().add(botonAceptar,BorderLayout.SOUTH);
		this.setBounds(100, 100, 450, 300);
		aceptar=false;
		
	}

	/**
	 * Deveulve el texto en el jtextfield
	 * 
	 * @return el texto
	 */
	public String getPelicula() {
		return pelicula.getText();
	}
	
	public String getpuntuacion() {
		return puntuacion.getText();
	}
	
	public String getTexto() {
		return texto.getText();
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



