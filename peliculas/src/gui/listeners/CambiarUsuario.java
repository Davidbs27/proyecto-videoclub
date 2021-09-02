/**
 * 
 */
package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import gui.DatosPrograma;
import gui.PanelUsuario;
import gui.PantallaRegistroUsuario;
import peliculas.Partida;
import peliculas.Usuario;

public class CambiarUsuario implements ActionListener {
	
	private DatosPrograma datos;
	private JFrame padre; 
	private PanelUsuario panelDatosUsuario;
	private JList<Usuario> amigos;
	private JList<Usuario> solicitudesPendientes;
	private JList<Partida> partidasJ1;
	private JList<Partida> partidasJ2;
	private JList<Partida> partidasCompletadas;

	public CambiarUsuario(JFrame frame, DatosPrograma datos, PanelUsuario panelDatosUsuario, JList<Usuario> amigos, JList<Usuario> solicitudesPendientes, JList<Partida> partidasJ1, JList<Partida> partidasJ2,JList<Partida> pc) {
		this.padre=frame;
		this.datos=datos;
		this.panelDatosUsuario=panelDatosUsuario;
		this.amigos=amigos;
		this.solicitudesPendientes=solicitudesPendientes;
		this.partidasJ1=partidasJ1;
		this.partidasJ2=partidasJ2;
		this.partidasCompletadas=pc;
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
		if(!nuevo || pantalla.isAceptar()) {
			nombreUsuario=pantalla.getNombreUsuario();
			contraseña=String.valueOf(pantalla.getContraseña());
			if(nombreUsuario.isEmpty() ||contraseña.isEmpty()) {
				JOptionPane.showMessageDialog(pantalla, "Debe rellenar ambos datos", "Error Cambiar de usuario", JOptionPane.ERROR_MESSAGE);
				nuevo=false;
				pantalla.setVisible(true);				
			}
			else {
				Usuario usuario=new Usuario(nombreUsuario, contraseña);
				try {
					datos.autenticar(usuario);
					nuevo=true;
				}catch (Exception ex) {
					nuevo=false;
					JOptionPane.showMessageDialog(pantalla, ex.getMessage(), "Error Cambiar de usuario", JOptionPane.ERROR_MESSAGE);
					pantalla.setVisible(true);
				}
			}
		}
		
		if (nuevo) 
		{
			
		
			panelDatosUsuario.mostrarUsuario(datos.getUsuarioActual());
			Vector<Usuario> vamigos=new Vector<>();
			for(Usuario amigo:datos.getUsuarioActual().getLista_mis_amigos()) {
				vamigos.addElement(amigo);
			}
			amigos.setListData(vamigos);
			Vector<Usuario> vSol=new Vector<>();
			for(Usuario sol:datos.getUsuarioActual().getSolicitudes_amigos_pendientes()) {
				vSol.addElement(sol);
			}
			solicitudesPendientes.setListData(vSol);
			Vector<Partida> vPar1=new Vector<>();
			for(Partida par:datos.getUsuarioActual().getpartidas_pendientesj1()) {
				vPar1.addElement(par);
			}
			partidasJ1.setListData(vPar1);
			Vector<Partida> vPar2=new Vector<>();
			for(Partida par:datos.getUsuarioActual().getpartidas_pendientesj2()) {
				vPar2.addElement(par);
			}
			partidasJ2.setListData(vPar2);
		
		
			Vector<Partida> vPar3=new Vector<>();
			for(Partida par:datos.getUsuarioActual().getPartidas_completas()) {
				vPar3.addElement(par);
			}
			partidasCompletadas.setListData(vPar3);
		}
		
		
	}

}
