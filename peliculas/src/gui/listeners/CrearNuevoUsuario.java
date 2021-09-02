/**
 * 
 */
package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import gui.DatosPrograma;
import gui.PantallaRegistroUsuario;
import peliculas.Usuario;


public class CrearNuevoUsuario implements ActionListener {
	
	private DatosPrograma datos;
	private JFrame padre; 

	public CrearNuevoUsuario(JFrame padre,DatosPrograma datos) {
		this.padre=padre;
		this.datos=datos;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		PantallaRegistroUsuario pantalla=new PantallaRegistroUsuario(padre);
		pantalla.setVisible(true);
		boolean nuevo=false;
		String nombreUsuario;
		String contraseña;
		while(!nuevo) {
			nombreUsuario=pantalla.getNombreUsuario();
			contraseña=String.valueOf(pantalla.getContraseña());
			if(nombreUsuario.isEmpty() ||contraseña.isEmpty()) {
				JOptionPane.showMessageDialog(pantalla, "Debe rellenar ambos datos", "Error Crear de usuario", JOptionPane.ERROR_MESSAGE);
				nuevo=false;
				pantalla.setVisible(true);				
			}
			else {
				Usuario usuario=new Usuario(nombreUsuario, contraseña);
				try {
					datos.registrar(usuario);
					nuevo=true;
				}catch (Exception ex) {
					nuevo=false;
					JOptionPane.showMessageDialog(pantalla, ex.getMessage(), "Error Crear de usuario", JOptionPane.ERROR_MESSAGE);
					pantalla.setVisible(true);
				}
			}
		}
	}

}
