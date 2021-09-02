package gui.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import gui.DatosPrograma;
import peliculas.Partida;
import peliculas.Usuario;

public class MenuContextualPartidasCompletadas extends MouseAdapter {
	
	private JPopupMenu menuConPartidas;
	private JMenuItem compartirConTodosAmigos;
	private JMenuItem compartirConAmigosSeleccionados;
	private JList<Partida> partidas;

	public MenuContextualPartidasCompletadas(DatosPrograma datos,JList<Usuario> amigos, JList<Partida> partidasCompletadas,JFrame frame) {
		this.partidas=partidasCompletadas;
		menuConPartidas=new JPopupMenu();
		compartirConTodosAmigos=new JMenuItem("Comparit con todos los amigo");
		compartirConTodosAmigos.addActionListener(new CompartirConTodos<Partida>(datos,partidasCompletadas,amigos));//cuando en la opcion del menu contextual llama a esta clase
		compartirConTodosAmigos.setEnabled(!partidasCompletadas.isSelectionEmpty()); 
		menuConPartidas.add(compartirConTodosAmigos);
		compartirConAmigosSeleccionados=new JMenuItem("Compartir con los amigos seleccionados");
		compartirConAmigosSeleccionados.addActionListener(new CompartirConSeleccionados<Partida>(datos,partidasCompletadas,amigos));//cuando en la opcion del menu contextual llama a esta clase
		compartirConAmigosSeleccionados.setEnabled(!partidasCompletadas.isSelectionEmpty()); 
		menuConPartidas.add(compartirConAmigosSeleccionados);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		compartirConTodosAmigos.setEnabled(!partidas.isSelectionEmpty()); 		 
		compartirConAmigosSeleccionados.setEnabled(!partidas.isSelectionEmpty());
		if (e.isPopupTrigger()) { //si es el boton secundario.
			menuConPartidas.show(e.getComponent(),e.getX(), e.getY());//muestras el menu contextual. 
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		compartirConTodosAmigos.setEnabled(!partidas.isSelectionEmpty());		
		compartirConAmigosSeleccionados.setEnabled(!partidas.isSelectionEmpty());
		if (e.isPopupTrigger()) { //si es el boton secundario.
			menuConPartidas.show(e.getComponent(),e.getX(), e.getY());//muestras el menu contextual. 
		}
	}

}
