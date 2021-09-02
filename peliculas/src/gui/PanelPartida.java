package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import peliculas.Partida;

public class PanelPartida extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel iden,ganador,puntosJ1,puntosJ2;

	/**
	 * 
	 */
	public PanelPartida() {
		super();		
		setLayout(new GridBagLayout());
		GridBagConstraints restriccionesPanelUsuario = new GridBagConstraints();
		restriccionesPanelUsuario.gridx=0;
		restriccionesPanelUsuario.gridy=0;	
		restriccionesPanelUsuario.weightx=1;//1/4
		restriccionesPanelUsuario.weighty=0.15;		//50% de la pantalla.
		iden=new JLabel("Identificador:");
		this.add(iden,restriccionesPanelUsuario);
		ganador=new JLabel("Ganador:");
		restriccionesPanelUsuario.gridy=1;
		this.add(ganador,restriccionesPanelUsuario);		
		puntosJ1=new JLabel("PuntosJ1:");
		restriccionesPanelUsuario.gridy=2;
		this.add(puntosJ1,restriccionesPanelUsuario);
		puntosJ2=new JLabel("PuntosJ2:");
		restriccionesPanelUsuario.gridy=3;
		this.add(puntosJ2,restriccionesPanelUsuario);
	}
	
	public void mostrarPartida(Partida partida) {
		iden.setText("Identificador:"+partida.getIdentificador());
		if(partida.getGanador()!=null) {
			ganador.setText("Ganador:"+partida.getGanador());
		}
		else {
			ganador.setText("Ganador:Empate");
		}
		puntosJ1.setText("PuntosJ1:"+partida.getPtos_jugador1());
		puntosJ2.setText("PuntosJ2:"+partida.getPtos_jugador2());		
	}
	

}
