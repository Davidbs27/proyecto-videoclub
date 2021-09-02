package gui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import gui.listeners.GuardarClasificacion;
import gui.listeners.MenuContextualVerClasificacion;
import peliculas.Item;

public class  PantallaVerClasificacion extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2131188204117438063L;
	
	private JButton guardarFichero;
	
	

	/**
	 * Constructor que pone titulo al dialogo, construye la ventana y la hace
	 * modal.
	 * 
	 * @param padre
	 *            Frame que hace de padre de esta dialogo.
	 */
	public PantallaVerClasificacion(Frame padre,DatosPrograma datos,TiposOrdenacion tipoOrdenacion) {

		// padre y modal
		super(padre, true);
		setTitle("Clasificacion");
		datos.ordenarClasificacion(tipoOrdenacion);
		Vector<Item> vAux=new Vector<>();
		for(Item item:datos.getClasificacion().getLista()) {
			vAux.add(item);
		}
		JList<Item> lista=new JList<>(vAux);	
		JScrollPane scrollLista = new JScrollPane(lista);
		lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		lista.setLayoutOrientation(JList.VERTICAL);
		lista.setToolTipText("Clasificacion ordenada por "+tipoOrdenacion.getLiteral());
		lista.addMouseListener(new MenuContextualVerClasificacion(datos, lista, padre));
		guardarFichero=new JButton("Exportar clasificacion...");
		guardarFichero.addActionListener(new GuardarClasificacion(datos));
		getContentPane().add(scrollLista,BorderLayout.CENTER);
		getContentPane().add(guardarFichero,BorderLayout.SOUTH);
		this.setBounds(100, 100, 450, 300);
		
	}

}



