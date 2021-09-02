package gui;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JTextField;

import peliculas.Pregunta;

public class  PantallaPreguntasj1 extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2131188204117438063L;
	private JTextField pregunta1;
	private JTextField pregunta2;
	private JTextField pregunta3;
	private JTextField pregunta4;
	private JTextField pregunta5;
	private JTextField pregunta6;
	
	
	

	private JButton botonAceptar;
	private boolean aceptar;

	/**
	 * Constructor que pone titulo al dialogo, construye la ventana y la hace
	 * modal.
	 * 
	 * @param padre
	 *            Frame que hace de padre de esta dialogo.
	 * @param ayuda6 
	 * @param ayuda5 
	 * @param ayuda4 
	 * @param ayuda3 
	 * @param ayuda2 
	 * @param ayuda1 
	 * @param pregunta 
	 */
	public PantallaPreguntasj1(Frame padre,Pregunta p0, String pregunta, String ayuda1,int numeroPelicula,int numeroPista,int jugador) {

		// padre y modal
 		super(padre, true);
		
		
 		
 		p0.setnumeroPregunta(numeroPelicula);
 		p0.setnumero_pistas(numeroPista);

		setTitle("Pelicula "+numeroPelicula +" ¿"+pregunta+"? -> Pista Numero "+numeroPista+":"+ayuda1+" "+p0.ofrecerNuevaPista(jugador));
		pregunta1= new JTextField(20);
		/*pregunta1.setToolTipText("Pelicula1 ¿Titulo? -> Pista: Año distribcion="+p0.ofrecerNuevaPista(1));*/
		
		/*p1.setnumeroPregunta(2);
 		p1.setnumero_pistas(1);
		
		pregunta2 = new JTextField(20);
		pregunta2.setToolTipText("pelicula 2: ¿Año?-> Pista: Titulo="+p1.ofrecerNuevaPista(1));
		
		p2.setnumeroPregunta(3);
 		p2.setnumero_pistas(1);
 		
		pregunta3 = new JTextField(20);
		pregunta3.setToolTipText("pelicula 3: ¿Genero?-> Pista: Titulo="+p2.ofrecerNuevaPista(1));
		
		p3.setnumeroPregunta(4);
 		p3.setnumero_pistas(1);
 		
		pregunta4= new JTextField(20);
		pregunta4.setToolTipText("pelicula 4: ¿Director? Pista: Titulo="+p3.ofrecerNuevaPista(1));
		
		p4.setnumeroPregunta(5);
 		p4.setnumero_pistas(1);
		pregunta5 = new JTextField(20);
		pregunta5.setToolTipText("pelicula 5: ¿Actor? Pista: Titulo="+p4.ofrecerNuevaPista(1));
		
		p5.setnumeroPregunta(6);
 		p5.setnumero_pistas(1);
 		
		pregunta6 = new JTextField(20);
		pregunta6.setToolTipText("pelicula 6  ¿Director? Pista: Titulo="+p5.ofrecerNuevaPista(1));*/
		
		
		
		botonAceptar=new JButton("Aceptar");
		botonAceptar.addActionListener(e -> {
			setVisible(false);
			setAceptar(true);
		});
		
		getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.PAGE_AXIS));
		
		
		
		
		
		getContentPane().add(pregunta1);
		/*getContentPane().add(pregunta2);
		getContentPane().add(pregunta3);
		getContentPane().add(pregunta4);
		getContentPane().add(pregunta5);
		getContentPane().add(pregunta6);*/
		
	
		getContentPane().add(botonAceptar,BorderLayout.SOUTH);
		this.setBounds(100, 100, 450, 300);
		aceptar=false;
		
	}

	/**
	 * Deveulve el texto en el jtextfield
	 * 
	 * @return el texto
	 */
	public String getPregunta1() {
		return pregunta1.getText();
	}
	
	public String getPregunta2() {
		return pregunta2.getText();
	}
	
	public String getPregunta3() {
		return pregunta3.getText();
	}
	
	public String getPregunta4() {
		return pregunta4.getText();
	}
	
	public String getPregunta5() {
		return pregunta5.getText();
	}
	
	public String getPregunta6() {
		return pregunta6.getText();
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



