package gui.listeners;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;

import gui.DatosPrograma;
import gui.PantallaVerPartidas;
import peliculas.Item;

public class VerPartidas implements ActionListener {
	
	private DatosPrograma datos;
	private JList<Item> items;
	private Frame frame;

	public VerPartidas(DatosPrograma datos, JList<Item> items, Frame frame) {
		this.datos=datos;
		this.items=items;
		this.frame=frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		PantallaVerPartidas ventana= new PantallaVerPartidas(frame,datos , items.getSelectedValue());
		ventana.setVisible(true);
	}

}
