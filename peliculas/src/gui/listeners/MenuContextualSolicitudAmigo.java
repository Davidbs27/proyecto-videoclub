package gui.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import gui.DatosPrograma;
import peliculas.Usuario;

public class MenuContextualSolicitudAmigo extends MouseAdapter {

	private JPopupMenu menuConSolPend;
	private JMenuItem aceptar;
	private JMenuItem rechazar;
	private JList<Usuario> lista;




	public MenuContextualSolicitudAmigo(DatosPrograma datos,JList<Usuario> lista,JList<Usuario> amigos) {// aqui creas el menu contextual
		this.lista=lista;
		menuConSolPend=new JPopupMenu();
		aceptar=new JMenuItem("Aceptar solicitud");
		aceptar.addActionListener(new AceptarAmistad(datos,lista,amigos));//cuando en la opcion del menu contextual llama a esta clase
		aceptar.setEnabled(!lista.isSelectionEmpty()); 
		menuConSolPend.add(aceptar);
		rechazar=new JMenuItem("Rechazar solicitud");
		rechazar.addActionListener(new RechazarAmistad(datos,lista));//cuando en la opcion del menu contextual llama a esta clase
		rechazar.setEnabled(!lista.isSelectionEmpty()); 
		menuConSolPend.add(rechazar);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// este metodo es el que se le llama cuando mantienes presionado uno de los botones del raton 
		aceptar.setEnabled(!lista.isSelectionEmpty());
		rechazar.setEnabled(!lista.isSelectionEmpty()); 
		if (e.isPopupTrigger()) { //si es el boton secundario.
			menuConSolPend.show(e.getComponent(),e.getX(), e.getY());//muestras el menu contextual. 
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		//lo mismo que el de arriba pero cuando lo sueltas.(dependiendo del s.o se llama uno o otro).
		aceptar.setEnabled(!lista.isSelectionEmpty());
		rechazar.setEnabled(!lista.isSelectionEmpty());
		if (e.isPopupTrigger()) { 
			menuConSolPend.show(e.getComponent(),e.getX(), e.getY());
		}
	}

}
