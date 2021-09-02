package gui.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import gui.DatosPrograma;
import peliculas.Critica;
import peliculas.Pelicula;
import peliculas.Usuario;

public class MenuContextualPeliculas extends MouseAdapter {
	
	private JPopupMenu menuConPeliculas;
	private JMenuItem crearCritica;
	private JMenuItem compartirConTodosAmigos;
	private JMenuItem compartirConAmigosSeleccionados;
	private JList<Pelicula> peliculas;

	//crear critica
	//compartir con todos los amigos 
	//compartir con amigos seleccionados
	
	public MenuContextualPeliculas(DatosPrograma datos, JList<Usuario> amigos, JList<Pelicula> peliculas, JList<Critica> criticas,JFrame frame) {
		this.peliculas=peliculas;
		menuConPeliculas=new JPopupMenu();
		crearCritica=new JMenuItem("Crear Critica");
		crearCritica.addActionListener(new CrearCritica(datos,peliculas,criticas,frame));//cuando en la opcion del menu contextual llama a esta clase
		crearCritica.setEnabled(!peliculas.isSelectionEmpty()); 
		menuConPeliculas.add(crearCritica);
		compartirConTodosAmigos=new JMenuItem("Comparit con todos los amigo");
		compartirConTodosAmigos.addActionListener(new CompartirConTodos<Pelicula>(datos,peliculas,amigos));//cuando en la opcion del menu contextual llama a esta clase
		compartirConTodosAmigos.setEnabled(!peliculas.isSelectionEmpty()); 
		menuConPeliculas.add(compartirConTodosAmigos);
		compartirConAmigosSeleccionados=new JMenuItem("Compartir con los amigos seleccionados");
		compartirConAmigosSeleccionados.addActionListener(new CompartirConSeleccionados<Pelicula>(datos,peliculas,amigos));//cuando en la opcion del menu contextual llama a esta clase
		compartirConAmigosSeleccionados.setEnabled(!peliculas.isSelectionEmpty()); 
		menuConPeliculas.add(compartirConAmigosSeleccionados);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		crearCritica.setEnabled(!peliculas.isSelectionEmpty()); 
		compartirConTodosAmigos.setEnabled(!peliculas.isSelectionEmpty());
		compartirConAmigosSeleccionados.setEnabled(!peliculas.isSelectionEmpty()); 
		if (e.isPopupTrigger()) { //si es el boton secundario.
			menuConPeliculas.show(e.getComponent(),e.getX(), e.getY());//muestras el menu contextual. 
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		crearCritica.setEnabled(!peliculas.isSelectionEmpty()); 
		compartirConTodosAmigos.setEnabled(!peliculas.isSelectionEmpty());
		compartirConAmigosSeleccionados.setEnabled(!peliculas.isSelectionEmpty()); 
		if (e.isPopupTrigger()) { //si es el boton secundario.
			menuConPeliculas.show(e.getComponent(),e.getX(), e.getY());//muestras el menu contextual. 
		}
	}

}
