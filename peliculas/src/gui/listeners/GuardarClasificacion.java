package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import gui.DatosPrograma;

public class GuardarClasificacion implements ActionListener 
{
	
	
	
	private DatosPrograma elementosBackup;

	public GuardarClasificacion(DatosPrograma elementos) 
	{
		// TODO Auto-generated constructor stub
		
		
		elementosBackup=elementos;
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		
		
		JFileChooser fileChooser = new JFileChooser(); //fichero  a grabar.
		
		int seleccion=fileChooser.showSaveDialog(null);		
		
		
		String mensajeError="";
		switch (seleccion) {// si es o.k pues lo guardo.
		case JFileChooser.APPROVE_OPTION:					
			try {
				elementosBackup.getClasificacion().escribirFicheroTexto(fileChooser.getSelectedFile().getPath()+".txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(mensajeError.length()==0) {
				JLabel label = new JLabel("Datos guardados correctamente en "+fileChooser.getSelectedFile().getPath()+".txt");
				Object[] ob = {label};
				JOptionPane.showMessageDialog(null, ob, "Guardar datos", JOptionPane.INFORMATION_MESSAGE);
			}
			else 
			
			{
				JOptionPane.showMessageDialog(null, mensajeError, "Guardar datos", JOptionPane.ERROR_MESSAGE);
			}
			break;
		default:

		}
	}
}
