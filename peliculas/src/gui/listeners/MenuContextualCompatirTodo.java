package gui.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import gui.DatosPrograma;
import peliculas.Usuario;

public class MenuContextualCompatirTodo extends MouseAdapter {
	
	private JPopupMenu menuConAmigos;
	private JMenuItem compartirConTodosAmigos;
	private JMenuItem compartirConAmigosSeleccionados;
	private JList<Usuario> amigos;
	

	public MenuContextualCompatirTodo(DatosPrograma datos, JList<Usuario> amigos) {
		this.amigos=amigos;
		menuConAmigos=new JPopupMenu();		
		compartirConTodosAmigos=new JMenuItem("Compartir todo con todos los amigos");
		compartirConTodosAmigos.addActionListener(new CompartirConTodosTodo(datos,amigos));//cuando en la opcion del menu contextual llama a esta clase
		compartirConTodosAmigos.setEnabled(!amigos.isSelectionEmpty()); 
		menuConAmigos.add(compartirConTodosAmigos);
		compartirConAmigosSeleccionados=new JMenuItem("Compartir todo con los amigos seleccionados");
		compartirConAmigosSeleccionados.addActionListener(new CompartirConSeleccionadosTodo(datos,amigos));//cuando en la opcion del menu contextual llama a esta clase
		compartirConAmigosSeleccionados.setEnabled(!amigos.isSelectionEmpty()); 
		menuConAmigos.add(compartirConAmigosSeleccionados);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		compartirConTodosAmigos.setEnabled(!amigos.isSelectionEmpty());
		compartirConAmigosSeleccionados.setEnabled(!amigos.isSelectionEmpty()); 
		if (e.isPopupTrigger()) { //si es el boton secundario.
			menuConAmigos.show(e.getComponent(),e.getX(), e.getY());//muestras el menu contextual. 
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		compartirConTodosAmigos.setEnabled(!amigos.isSelectionEmpty());
		compartirConAmigosSeleccionados.setEnabled(!amigos.isSelectionEmpty()); 
		if (e.isPopupTrigger()) { //si es el boton secundario.
			menuConAmigos.show(e.getComponent(),e.getX(), e.getY());//muestras el menu contextual. 
		}
	}

}
