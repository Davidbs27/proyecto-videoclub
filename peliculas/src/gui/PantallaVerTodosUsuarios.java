package gui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import gui.listeners.EnviarSolicitudesAmistad;
import peliculas.Usuario;

public class  PantallaVerTodosUsuarios extends JDialog {
	
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
	public PantallaVerTodosUsuarios(Frame padre,DatosPrograma datos) {

		// padre y modal
		super(padre, true);
		setTitle("Todos los usuarios");
		Vector<Usuario> vAux=new Vector<>();
		for(Usuario usuario:datos.getUsuarios().getListaUsuarios()) {
			if(!datos.getUsuarioActual().equals(usuario)) {
				vAux.add(usuario);
			}
		}
		JButton enviarPeticiones=new JButton("Enviar peticiones");
		JList<Usuario> lista=new JList<>(vAux);	
		JScrollPane scrollLista = new JScrollPane(lista);
		lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		lista.setLayoutOrientation(JList.VERTICAL);
		lista.setToolTipText("Usuarios");
		getContentPane().add(scrollLista,BorderLayout.CENTER);
		getContentPane().add(enviarPeticiones,BorderLayout.SOUTH);
		enviarPeticiones.addActionListener(new EnviarSolicitudesAmistad(datos,lista,this));
		this.setBounds(100, 100, 450, 300);
		
	}

}



