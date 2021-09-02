package gui.listeners;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import gui.DatosPrograma;
import gui.PanelCriticas;
import peliculas.Critica;

public class CriticasListener implements ListSelectionListener {


	PanelCriticas panelcriticasBackup;
	DatosPrograma datosBackup;
	JList<Critica> criticasbackup;


	public CriticasListener(PanelCriticas panelCriticas, DatosPrograma datos,  JList<Critica> criticas ) {
		// TODO Auto-generated constructor stub
			
		panelcriticasBackup=panelCriticas;
		datosBackup=datos;
		criticasbackup=criticas;
		
		
		
	}
	
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		Critica p=criticasbackup.getSelectedValue();
		if(p!=null) 
		{
			panelcriticasBackup.mostrarCritica(p);
			
			
		}
	
	
	
	}
}
