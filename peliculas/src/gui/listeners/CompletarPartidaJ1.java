package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import gui.DatosPrograma;
import gui.PantallaPreguntasj1;
import peliculas.Partida;
import peliculas.Pregunta;

public class CompletarPartidaJ1 implements ActionListener {
	
	
	DatosPrograma datosBackup;
	JList<Partida> partidasJ1Backup;
	private JList<Partida> partidasComp;
	private JFrame padre;

	
	

	public CompletarPartidaJ1(DatosPrograma datos, JList<Partida> partidasJ1,JList<Partida> partidasComp,JFrame frame) {
		// TODO Auto-generated constructor stub
		
		datosBackup=datos;
		partidasJ1Backup=partidasJ1;
		padre=frame;
		this.partidasComp=partidasComp;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Partida partida;
		Pregunta [] p0 /*,p1,p2,p3,p4,p5*/;
		String []Pregunta= {"Titulo Pelicula","Año distribucion","Genero","Director/a","Actor","Actriz"};
		String []Ayuda1={"Año distribucion","Genero","Director","Actor","Actriz",
				"Titulo","Genero","Director","Actor","Actriz",
				"Titulo","Año distribucion","Director","Actor","Actriz",
				"Titulo","Año distribucion","Genero","Actor","Actriz",
				"Titulo","Año distribucion","Genero","Director","Actriz",
				"Titulo","Año distribucion","Genero","Director","Actor"};
				
		/*String []Ayuda2={"Titulo","Genero","Director","Actor","Actriz"};
		String []Ayuda3={"Titulo","Año distribucion","Director","Actor","Actriz"};
		String []Ayuda4={"Titulo","Año distribucion","Genero","Actor","Actriz"};
		String []Ayuda5={"Titulo","Año distribucion","Genero","Director","Actriz"};
		String []Ayuda6={"Titulo","Año distribucion","Genero","Director","Actor"};*/
		
		int numeroPelicula=1;
		int numeroPista=1;
		int x=0;
		int y=0;
		int z=0;
		int topeayuda=4;
		Boolean salida=false;
		p0=new Pregunta[6];
		int jugadorn=1;
		
		
		/*seleccionamos las preguntas del jugador 1*/
		
		
		
	     partida=partidasJ1Backup.getSelectedValue();
	   
	     p0[0]=partida.preguntaQueToca(0);
	     p0[1]=partida.preguntaQueToca(1);
	     p0[2]=partida.preguntaQueToca(2);
	     p0[3]=partida.preguntaQueToca(3);
	     p0[4]=partida.preguntaQueToca(4);
	     p0[5]=partida.preguntaQueToca(5);
	    
	    
	    
	    
		/*datosBackup.getUsuarioActual().completarPartida(partida);*/
		
		
		
		
		/*Vamos a hacer las preguntas en una pantalla popup nueva */
	     
	     while(salida==false) {
			
		

	    	 PantallaPreguntasj1 pantalla=new PantallaPreguntasj1(padre,p0[z],Pregunta[x],Ayuda1[y],numeroPelicula,numeroPista,jugadorn);
	    	 pantalla.setVisible(true);
	    	 String pregunta1;
	    	 /*String pregunta2;
			String pregunta3;
			String pregunta4;
			String pregunta5;
			String pregunta6;*/

			pregunta1=pantalla.getPregunta1();
			/*pregunta2=pantalla.getPregunta2();
			pregunta3=pantalla.getPregunta3();
			pregunta4=pantalla.getPregunta4();
			pregunta4=pantalla.getPregunta4();
			pregunta5=pantalla.getPregunta5();
			pregunta6=pantalla.getPregunta6();*/
			
			
			if(pregunta1.isEmpty()) { /*||pregunta2.isEmpty() || pregunta3.isEmpty() ||pregunta4.isEmpty() ||pregunta5.isEmpty() ||pregunta6.isEmpty()){*/
				JOptionPane.showMessageDialog(pantalla, "Debe rellenar todos los datos", "Error al introducir las respuestas del juego", JOptionPane.ERROR_MESSAGE);
				pantalla.setVisible(true);				
			}
			else {
				/*Critica critica=new Critica();*/
				try {
					
					
					/*vamos a comprobar si la respuesta es correcta*/
					
					
					
					if (p0[z].respuestaCorrecta(pregunta1, true)==true)
					{
						/* si la respuesta es correcta, podemos pasar a la siguiente pregunta.*/
						x=x+1;
						y=y+1;
						z=z+1;
						
						
						topeayuda=topeayuda+5;
						numeroPelicula++;
						if (numeroPelicula==2)
						{
							y=5;
						}
						else if(numeroPelicula==3)
						{
							y=10;
						}
						
						else if(numeroPelicula==4)
						{
							y=15;
						}
						else if(numeroPelicula==5)
						{
							y=20;
						}
						
						else if(numeroPelicula==6)
						{
							y=25;
						}
						
						
						numeroPista=1;
						if (x>5) /*Ya no hay mas preguntas salimos de aqui*/
						{
							salida=true;
							partida.finalizar_Partida(true);							
							
							
						}
						
					}else 
					
					{
						/*la respuesta es falsa, luego hay que dar  la siguiente pista y bajar posible puntuacion.*/
						y=y+1;
						numeroPista=numeroPista+1;
				
						if (y>topeayuda) 
						{
							y=topeayuda;
						}
						
						if (numeroPista>5)
						{
							numeroPista=5;
						}
						
					
					}
					
						
						
						
					
					
					/*
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
					*/
					
				}catch (Exception ex) {

					JOptionPane.showMessageDialog(pantalla, ex.getMessage(), "Error al trasmitir las respuestas", JOptionPane.ERROR_MESSAGE);
					pantalla.setVisible(true);
				}
				
			}
		}
	     Vector<Partida> aux=new Vector<>();
	     for(Partida p:datosBackup.getUsuarioActual().getpartidas_pendientesj1()) {
	    	 aux.addElement(p);
	     }
	     partidasJ1Backup.setListData(aux);
	     Vector<Partida> auxComp= new Vector<>();
		 for(Partida p:datosBackup.getUsuarioActual().getPartidas_completas()) {
			 auxComp.addElement(p);
	     }
		 partidasComp.setListData(auxComp);
		 datosBackup.actualizarMuro();
	}

}
