package gui.listeners;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.DatosPrograma;
import gui.PantallaVerTodosUsuarios;

public class EnviarSolicitudAmistad implements ActionListener {
	
	private DatosPrograma datos;
	private Frame padre;

	public EnviarSolicitudAmistad(Frame padre,DatosPrograma datos) {
		this.datos=datos;
		this.padre=padre;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		PantallaVerTodosUsuarios pantalla=new PantallaVerTodosUsuarios(padre, datos);
		pantalla.setVisible(true);
	}

}
