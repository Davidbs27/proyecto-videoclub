package gui;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class  PantallaRegistroUsuario extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2131188204117438063L;
	private JTextField nombre;
	private JPasswordField contraseña;
	private JButton botonAceptar;
	private boolean aceptar;

	/**
	 * Constructor que pone titulo al dialogo, construye la ventana y la hace
	 * modal.
	 * 
	 * @param padre
	 *            Frame que hace de padre de esta dialogo.
	 */
	public PantallaRegistroUsuario(Frame padre) {

		// padre y modal
		super(padre, true);
		setTitle("Introduce los datos del usuario");
		nombre = new JTextField(20);
		nombre.setToolTipText("Nombre de usuario");
		contraseña = new JPasswordField(20);
		contraseña.setToolTipText("Contraseña");
		botonAceptar=new JButton("Aceptar");
		botonAceptar.addActionListener(e -> {
			setVisible(false);
			setAceptar(true);
		});
		getContentPane().add(nombre,BorderLayout.NORTH);
		getContentPane().add(contraseña,BorderLayout.CENTER);
		getContentPane().add(botonAceptar,BorderLayout.SOUTH);
		this.setBounds(100, 100, 450, 300);
		aceptar=false;
		
	}

	/**
	 * Deveulve el texto en el jtextfield
	 * 
	 * @return el texto
	 */
	public String getNombreUsuario() {
		return nombre.getText();
	}
	
	public char[] getContraseña() {
		return contraseña.getPassword();
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



