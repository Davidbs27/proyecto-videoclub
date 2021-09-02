package gui.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import gui.DatosPrograma;
import peliculas.Partida;

public class MenuContextualPartidasJ1 extends MouseAdapter {
	
	private JPopupMenu menuConPartidas;
	private JMenuItem completarPartida;
	private JList<Partida> partidas;

	public MenuContextualPartidasJ1(DatosPrograma datos, JList<Partida> partidasJ1,JList<Partida> partidasCom,JFrame frame) {
		this.partidas=partidasJ1;
		menuConPartidas=new JPopupMenu();
		completarPartida=new JMenuItem("Completar Partida");
		completarPartida.addActionListener(new CompletarPartidaJ1(datos,partidasJ1,partidasCom,frame));//cuando en la opcion del menu contextual llama a esta clase
		completarPartida.setEnabled(!partidas.isSelectionEmpty()); 
		menuConPartidas.add(completarPartida);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		completarPartida.setEnabled(!partidas.isSelectionEmpty()); 		 
		if (e.isPopupTrigger()) { //si es el boton secundario.
			menuConPartidas.show(e.getComponent(),e.getX(), e.getY());//muestras el menu contextual. 
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		completarPartida.setEnabled(!partidas.isSelectionEmpty());		
		if (e.isPopupTrigger()) { //si es el boton secundario.
			menuConPartidas.show(e.getComponent(),e.getX(), e.getY());//muestras el menu contextual. 
		}
	}

}
