package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/*import datosInternos.Administrador;
import datosInternos.Foro;^*/
import gui.DatosPrograma;

public class GuardarFichero implements ActionListener {
	
	
	DatosPrograma datosBackup;
	
	

	public GuardarFichero(DatosPrograma datos) {
		// TODO Auto-generated constructor stub
		
		
		datosBackup=datos;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
				
			
			JFileChooser fileChooser = new JFileChooser(); //fichero  a grabar.
			
			int seleccion=fileChooser.showSaveDialog(null);		
			
			String mensajeError="";
			switch (seleccion) {// si es o.k pues lo guardo.
			case JFileChooser.APPROVE_OPTION:					
				datosBackup.escribirFichero(fileChooser.getSelectedFile());
				if(mensajeError.length()==0) {
					JLabel label = new JLabel("Datos guardados correctamente en "+fileChooser.getSelectedFile().getPath());
					Object[] ob = {label};
					JOptionPane.showMessageDialog(null, ob, "Guardar datos", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, mensajeError, "Guardar datos", JOptionPane.ERROR_MESSAGE);
				}
				break;
			default:
				//no ha seleccionado nombre del fichero de salida
			}				
	}

}
