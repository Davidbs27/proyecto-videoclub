package gui.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import gui.DatosPrograma;
import peliculas.Critica;
import peliculas.Usuario;

public class MenuContextualCriticas extends MouseAdapter {
	
	private JPopupMenu menuConCriticas;
	private JMenuItem compartirConTodosAmigos;
	private JMenuItem compartirConAmigosSeleccionados;
	private JList<Critica> criticas;

	//crear critica
	//compartir con todos los amigos 
	//compartir con amigos seleccionados
	
	public MenuContextualCriticas(DatosPrograma datos, JList<Usuario> amigos, JList<Critica> criticas) {
		this.criticas=criticas;
		menuConCriticas=new JPopupMenu();	
		compartirConTodosAmigos=new JMenuItem("Comparit con todos los amigo");
		compartirConTodosAmigos.addActionListener(new CompartirConTodos<Critica>(datos,criticas,amigos));//cuando en la opcion del menu contextual llama a esta clase
		compartirConTodosAmigos.setEnabled(!criticas.isSelectionEmpty()); 
		menuConCriticas.add(compartirConTodosAmigos);
		compartirConAmigosSeleccionados=new JMenuItem("Compartir con los amigos seleccionados");
		compartirConAmigosSeleccionados.addActionListener(new CompartirConSeleccionados<Critica>(datos,criticas,amigos));//cuando en la opcion del menu contextual llama a esta clase
		compartirConAmigosSeleccionados.setEnabled(!criticas.isSelectionEmpty()); 
		menuConCriticas.add(compartirConAmigosSeleccionados);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		compartirConTodosAmigos.setEnabled(!criticas.isSelectionEmpty());
		compartirConAmigosSeleccionados.setEnabled(!criticas.isSelectionEmpty()); 
		if (e.isPopupTrigger()) { //si es el boton secundario.
			menuConCriticas.show(e.getComponent(),e.getX(), e.getY());//muestras el menu contextual. 
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		compartirConTodosAmigos.setEnabled(!criticas.isSelectionEmpty());
		compartirConAmigosSeleccionados.setEnabled(!criticas.isSelectionEmpty()); 
		if (e.isPopupTrigger()) { //si es el boton secundario.
			menuConCriticas.show(e.getComponent(),e.getX(), e.getY());//muestras el menu contextual. 
		}
	}

}
