package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import peliculas.Usuario;

public class PanelUsuario extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel nombreUsuario,partidasG,partidasE,partidasP;

	/**
	 * 
	 */
	public PanelUsuario() {
		super();		
		setLayout(new GridBagLayout());
		GridBagConstraints restriccionesPanelUsuario = new GridBagConstraints();
		restriccionesPanelUsuario.gridx=0;
		restriccionesPanelUsuario.gridy=0;	
		restriccionesPanelUsuario.weightx=1;//1/4
		restriccionesPanelUsuario.weighty=0.25;		//50% de la pantalla.
		nombreUsuario=new JLabel("Nombre Usuario:");
		this.add(nombreUsuario,restriccionesPanelUsuario);
		partidasG=new JLabel("Partidas ganadas:");
		restriccionesPanelUsuario.gridy=1;
		this.add(partidasG,restriccionesPanelUsuario);		
		partidasE=new JLabel("Partidas empatadas:");
		restriccionesPanelUsuario.gridy=2;
		this.add(partidasE,restriccionesPanelUsuario);
		partidasP=new JLabel("Partidas perdidas:");
		restriccionesPanelUsuario.gridy=3;
		this.add(partidasP,restriccionesPanelUsuario);
		
	}
	
	public void mostrarUsuario(Usuario usuario) {
		nombreUsuario.setText("Nombre Usuario:"+usuario.getusuarioNombre());
		partidasG.setText("Partidas ganadas:"+usuario.getPartidas_ganadas());
		partidasE.setText("Partidas empatadas:"+usuario.getPartidas_empatadas());
		partidasP.setText("Partidas perdidas:"+usuario.getPartidas_perdidas());
	}
	

}
