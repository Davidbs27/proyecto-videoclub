package gui.listeners;

import java.util.Vector;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import gui.PanelPeliculas;
import peliculas.Critica;
import peliculas.Pelicula;

public class PeliculasListener implements ListSelectionListener {

	private JList<Critica> criticas;
	private PanelPeliculas panelPeliculas;
	private JList<Pelicula> peliculas;

	public PeliculasListener(JList<Pelicula> peliculas,JList<Critica> criticas, PanelPeliculas panelPeliculas) {
		this.criticas=criticas;
		this.panelPeliculas=panelPeliculas;
		this.peliculas=peliculas;
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		Pelicula p=peliculas.getSelectedValue();
		if(p!=null) {
			panelPeliculas.mostrarPelicula(p);
			Vector<Critica> vaux=new Vector<>();
			for (Critica critica : p.getLista_criticas()) {
				vaux.add(critica);
			}
			criticas.setListData(vaux);
		}
	}

}
