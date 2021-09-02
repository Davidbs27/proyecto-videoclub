package gui.listeners;

import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import gui.DatosPrograma;
import peliculas.Item;

public class MenuContextualVerClasificacion extends MouseAdapter {
	
	private JPopupMenu menuConVClasi;
	private JMenuItem verPartidas;
	private JList<Item> items;

	
	public MenuContextualVerClasificacion(DatosPrograma datos, JList<Item> items,Frame frame) {
		this.items=items;
		menuConVClasi=new JPopupMenu();	
		verPartidas=new JMenuItem("Ver partidas");
		verPartidas.addActionListener(new VerPartidas(datos,items,frame));//cuando en la opcion del menu contextual llama a esta clase
		verPartidas.setEnabled(!items.isSelectionEmpty()); 
		menuConVClasi.add(verPartidas);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		verPartidas.setEnabled(!items.isSelectionEmpty());		
		if (e.isPopupTrigger()) { //si es el boton secundario.
			menuConVClasi.show(e.getComponent(),e.getX(), e.getY());//muestras el menu contextual. 
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		verPartidas.setEnabled(!items.isSelectionEmpty()); 
		if (e.isPopupTrigger()) { //si es el boton secundario.
			menuConVClasi.show(e.getComponent(),e.getX(), e.getY());//muestras el menu contextual. 
		}
	}

}
