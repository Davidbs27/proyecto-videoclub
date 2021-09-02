package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;

import gui.DatosPrograma;
import gui.PantallaVerTodosUsuarios;
import peliculas.Usuario;

public class EnviarSolicitudesAmistad implements ActionListener {
	
	private DatosPrograma datos;
	private JList<Usuario> lista;
	private PantallaVerTodosUsuarios pantallaVerTodosUsuarios;

	public EnviarSolicitudesAmistad(DatosPrograma datos, JList<Usuario> lista,PantallaVerTodosUsuarios pantallaVerTodosUsuarios) {
		this.datos=datos;
		this.lista=lista;
		this.pantallaVerTodosUsuarios=pantallaVerTodosUsuarios;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		pantallaVerTodosUsuarios.setVisible(false);
		for(Usuario usuario: lista.getSelectedValuesList()) {
			if(!usuario.getSolicitudes_amigos_pendientes().contains(datos.getUsuarioActual())) {
				usuario.getSolicitudes_amigos_pendientes().add(datos.getUsuarioActual());
			}
		}
	}

}
