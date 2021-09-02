package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import gui.DatosPrograma;
import gui.PantallaRegistroCritica;
import peliculas.Critica;
import peliculas.Pelicula;

public class CrearCritica implements ActionListener {
	
	
	DatosPrograma datosBackup;
	JList<Pelicula> peliculasBackup;
	JList<Critica> criticasBackup;
	private JFrame padre;

	public CrearCritica(DatosPrograma datos, JList<Pelicula> peliculas, JList<Critica> criticas,JFrame frame) {
		// TODO Auto-generated constructor stub
		
		datosBackup=datos;
		peliculasBackup=peliculas;
		criticasBackup=criticas;
		padre=frame;
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		PantallaRegistroCritica pantalla=new PantallaRegistroCritica(padre);
		pantalla.setVisible(true);
		String pelicula;
		String puntuacion;
		String texto;

			pelicula=pantalla.getPelicula();
			puntuacion=pantalla.getpuntuacion();
			texto=pantalla.getTexto();
			
			
			if(pelicula.isEmpty() ||puntuacion.isEmpty() || texto.isEmpty()){
				JOptionPane.showMessageDialog(pantalla, "Debe rellenar todos los datos", "Error al Crear la critica de la pelicula", JOptionPane.ERROR_MESSAGE);
				pantalla.setVisible(true);				
			}
			else {
				Critica critica=new Critica();
				try {
				
					 critica.setPelicula(pelicula);
					 critica.setPuntuacion(Double.valueOf(puntuacion));
					 critica.setTexto(texto);
				
					 
					 datosBackup.nuevaCritica(critica,peliculasBackup.getSelectedValue());
					 Vector <Critica>nuevosDatos=new Vector <Critica>();
					 for (int i = 0; i < peliculasBackup.getSelectedValue().getLista_criticas().size(); i++) 
					 
					 {
					
						 nuevosDatos.addElement(peliculasBackup.getSelectedValue().getLista_criticas().get(i));
						
						 
						 
					 }
					 criticasBackup.setListData(nuevosDatos);
					
					
				}catch (Exception ex) {

					JOptionPane.showMessageDialog(pantalla, ex.getMessage(), "Error al crear pelicula", JOptionPane.ERROR_MESSAGE);
					pantalla.setVisible(true);
				}
			}
		
			datosBackup.actualizarMuro();
	}

}
