package gui.listeners;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import gui.PanelPartida;
import peliculas.Partida;

public class PartidaListener implements ListSelectionListener {
	
	private JList<Partida> lista;
	private PanelPartida pp;
	

	public PartidaListener(JList<Partida> lista, PanelPartida pp) {
		this.lista=lista;
		this.pp=pp;
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		pp.mostrarPartida(lista.getSelectedValue());
	}

}
