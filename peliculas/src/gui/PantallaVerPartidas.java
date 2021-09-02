package gui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import gui.listeners.PartidaListener;
import peliculas.Item;
import peliculas.Partida;
import peliculas.Usuario;

public class  PantallaVerPartidas extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2131188204117438063L;
	
	

	/**
	 * Constructor que pone titulo al dialogo, construye la ventana y la hace
	 * modal.
	 * 
	 * @param padre
	 *            Frame que hace de padre de esta dialogo.
	 */
	public PantallaVerPartidas(Frame padre,DatosPrograma datos,Item item) {

		// padre y modal
		super(padre, true);
		setTitle("Partidas");
		Vector<Partida> vAux=new Vector<>();
		Usuario usu=new Usuario(item.getNombreUSuario(), "");
		int i=datos.getUsuarios().getListaUsuarios().indexOf(usu);
		usu=datos.getUsuarios().getListaUsuarios().get(i);
		for(Partida p:usu.getPartidas_completas()) {			
			vAux.add(p);
		}
		JList<Partida> lista=new JList<>(vAux);	
		JScrollPane scrollLista = new JScrollPane(lista);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lista.setLayoutOrientation(JList.VERTICAL);
		lista.setToolTipText("Partidas");
		getContentPane().add(scrollLista,BorderLayout.EAST);
		PanelPartida pp=new PanelPartida();
		getContentPane().add(pp,BorderLayout.WEST);
		lista.addListSelectionListener(new PartidaListener(lista,pp));
		this.setBounds(100, 100, 450, 300);
		
	}

}



