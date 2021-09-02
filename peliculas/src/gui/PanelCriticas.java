package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import peliculas.Critica;

public class PanelCriticas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel pelicula,puntuacion,texto;

	/**
	 * 
	 */
	public PanelCriticas() {
		super();		
		setLayout(new GridBagLayout());
		GridBagConstraints restriccionesPanelUsuario = new GridBagConstraints();
		restriccionesPanelUsuario.gridx=0;
		restriccionesPanelUsuario.gridy=0;	
		restriccionesPanelUsuario.weightx=1;//1/4
		restriccionesPanelUsuario.weighty=0.33;		//50% de la pantalla.
		pelicula=new JLabel("Pelicula:");
		this.add(pelicula,restriccionesPanelUsuario);
		puntuacion=new JLabel("Puntuacion:");
		restriccionesPanelUsuario.gridy=1;
		this.add(puntuacion,restriccionesPanelUsuario);		
		texto=new JLabel("Texto:");
		restriccionesPanelUsuario.gridy=2;
		this.add(texto,restriccionesPanelUsuario);
		
	}
	
	public void mostrarCritica(Critica critica) {
		pelicula.setText("Pelicula:"+critica.getPelicula());
		puntuacion.setText("Puntuacion:"+critica.getPuntuacion());
		texto.setText("Texto:"+critica.getTexto());
	}
	

}
