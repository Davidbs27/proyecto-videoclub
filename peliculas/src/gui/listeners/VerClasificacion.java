/**
 * 
 */
package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui.DatosPrograma;
import gui.PantallaVerClasificacion;
import gui.TiposOrdenacion;


public class VerClasificacion implements ActionListener {
	
	private DatosPrograma datos;
	private JFrame padre;
	private TiposOrdenacion opcion;

	public VerClasificacion(JFrame frame, DatosPrograma datos, TiposOrdenacion opcion) {
		this.datos=datos;
		this.padre=frame;
		this.opcion=opcion;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {		
		PantallaVerClasificacion ventana= new PantallaVerClasificacion(padre,datos , opcion);
		ventana.setVisible(true);
	}

}
