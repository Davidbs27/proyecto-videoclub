package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import gui.listeners.CambiarUsuario;
import gui.listeners.CargarFichero;
import gui.listeners.CrearNuevoUsuario;
import gui.listeners.CriticasListener;
import gui.listeners.EnviarSolicitudAmistad;
import gui.listeners.GuardarFichero;
import gui.listeners.MenuContextualCompatirTodo;
import gui.listeners.MenuContextualCriticas;
import gui.listeners.MenuContextualPartidasCompletadas;
import gui.listeners.MenuContextualPartidasJ1;
import gui.listeners.MenuContextualPartidasJ2;
import gui.listeners.MenuContextualPeliculas;
import gui.listeners.MenuContextualSolicitudAmigo;
import gui.listeners.PartidaNueva;
import gui.listeners.PeliculaNueva;
import gui.listeners.PeliculasListener;
import gui.listeners.VerClasificacion;
import peliculas.Critica;
import peliculas.Partida;
import peliculas.Pelicula;
import peliculas.Usuario;



public class Inicio {
//Aqui se inicia el programa vamos a llamar a la primera interfaz del programa.
	private JFrame frame;
	private DatosPrograma datos;
	
	/**
	 * Launch the application.
	 */	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the application.
	 */
	public Inicio() {
		datos=new DatosPrograma();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame(); // nueva ventana		
		frame.setBounds(100, 100, 450, 300); // tamaño de la ventana
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// que quieres hacer cuando le das a la x de cerrar ventana.(que se cierre)
		
		
		JLabel lblTematica = new JLabel("Peliculas"); //arriba
		frame.getContentPane().add(lblTematica, BorderLayout.NORTH);
		
		
		String nombre;
		if(datos.getUsuarioActual()!=null) {
		nombre=datos.getUsuarioActual().getusuarioNombre();
		}
		else {
			nombre="";
		}
		
		
		JLabel lblUsuarioActual = new JLabel("Usuario Actual: "+nombre);
		frame.getContentPane().add(lblUsuarioActual, BorderLayout.SOUTH);//abajo
		datos.setPanelUsuarioActual(lblUsuarioActual);
		
		JPanel panelCentral = new JPanel();
		frame.getContentPane().add(panelCentral, BorderLayout.CENTER);//parte central
		panelCentral.setLayout(new GridBagLayout()); //como se ordenan los componentes.
		GridBagConstraints restriccionesContenedor = new GridBagConstraints();


		PanelUsuario panelDatosUsuario = new PanelUsuario();
		panelCentral.add(panelDatosUsuario, restriccionesContenedor);
				
		JTextArea panelMuro = new JTextArea(50,50);
		panelMuro.setText("Muro vacio");
		panelMuro.setEditable(false);
		JScrollPane scrollMuro = new JScrollPane(panelMuro);
		restriccionesContenedor.gridx=0;
		restriccionesContenedor.gridy=1;	
		restriccionesContenedor.weightx=0.20;//1/4
		restriccionesContenedor.weighty=0.50;		//50% de la pantalla.
		restriccionesContenedor.fill=GridBagConstraints.BOTH;
		
		panelCentral.add(scrollMuro,restriccionesContenedor);
		this.datos.setPanelMuro(panelMuro);
		
		JList<Usuario> amigos = new JList<>();				
		JScrollPane scrollAmigos = new JScrollPane(amigos);
		restriccionesContenedor.gridx=1;
		restriccionesContenedor.gridy=0;
		amigos.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		amigos.setLayoutOrientation(JList.VERTICAL);
		amigos.setToolTipText("Amigos");
		panelCentral.add(scrollAmigos,restriccionesContenedor);
		
		JList<Usuario> solicitudesPendientes = new JList<>();				
		JScrollPane scrollSolicitudPendientes = new JScrollPane(solicitudesPendientes);
		restriccionesContenedor.gridx=1;
		restriccionesContenedor.gridy=1;
		solicitudesPendientes.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		solicitudesPendientes.setLayoutOrientation(JList.VERTICAL);
		solicitudesPendientes.setToolTipText("Solicitudes pendientes");
		panelCentral.add(scrollSolicitudPendientes,restriccionesContenedor);
		
		JList<Pelicula> peliculas = new JList<>();				
		JScrollPane scrollPeliculas = new JScrollPane(peliculas);
		restriccionesContenedor.gridx=2;
		restriccionesContenedor.gridy=0;
		peliculas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		peliculas.setLayoutOrientation(JList.VERTICAL);
		peliculas.setToolTipText("Peliculas");
		panelCentral.add(scrollPeliculas,restriccionesContenedor);
		
		PanelPeliculas panelPeliculas=new PanelPeliculas();
		restriccionesContenedor.gridx=2;
		restriccionesContenedor.gridy=1;
		panelCentral.add(panelPeliculas,restriccionesContenedor);
		
		JList<Critica> criticas = new JList<>();				
		JScrollPane scrollCriticas = new JScrollPane(criticas);
		restriccionesContenedor.gridx=3;
		restriccionesContenedor.gridy=0;
		criticas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		criticas.setLayoutOrientation(JList.VERTICAL);
		criticas.setToolTipText("Criticas");
		panelCentral.add(scrollCriticas,restriccionesContenedor);
		
		PanelCriticas panelCriticas=new PanelCriticas();
		restriccionesContenedor.gridx=3;
		restriccionesContenedor.gridy=1;
		panelCentral.add(panelCriticas,restriccionesContenedor);
		
		JList<Partida> partidasJ1 = new JList<>();				
		JScrollPane scrollPartidasJ1 = new JScrollPane(partidasJ1);
		restriccionesContenedor.gridx=4;
		restriccionesContenedor.gridy=0;
		partidasJ1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		partidasJ1.setLayoutOrientation(JList.VERTICAL);
		partidasJ1.setToolTipText("Partidas Creadas Pendientes");
		panelCentral.add(scrollPartidasJ1,restriccionesContenedor);
		
		JList<Partida> partidasJ2 = new JList<>();				
		JScrollPane scrollPartidasJ2 = new JScrollPane(partidasJ2);
		restriccionesContenedor.gridx=4;
		restriccionesContenedor.gridy=1;
		partidasJ2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		partidasJ2.setLayoutOrientation(JList.VERTICAL);
		partidasJ2.setToolTipText("Partidas retadas pendientes");
		panelCentral.add(scrollPartidasJ2,restriccionesContenedor);
		
		JList<Partida> partidasCompletadas = new JList<>();				
		JScrollPane scrollPartidasCompletadas = new JScrollPane(partidasCompletadas);
		restriccionesContenedor.gridx=5;
		restriccionesContenedor.gridy=0;
		partidasCompletadas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		partidasCompletadas.setLayoutOrientation(JList.VERTICAL);
		partidasCompletadas.setToolTipText("Partidas Completadas");
		panelCentral.add(scrollPartidasCompletadas,restriccionesContenedor);
		
		
		amigos.addMouseListener(new MenuContextualCompatirTodo(datos,amigos));
		solicitudesPendientes.addMouseListener(new MenuContextualSolicitudAmigo(datos,solicitudesPendientes,amigos)); // cuando pase algo con el raton llama a esta clase.
		peliculas.addListSelectionListener(new PeliculasListener(peliculas,criticas,panelPeliculas));		
		peliculas.addMouseListener(new MenuContextualPeliculas(datos,amigos,peliculas,criticas,frame));
		criticas.addListSelectionListener(new CriticasListener(panelCriticas,datos,criticas));		
		criticas.addMouseListener(new MenuContextualCriticas(datos,amigos,criticas));
		partidasJ1.addMouseListener(new MenuContextualPartidasJ1(datos,partidasJ1,partidasCompletadas,frame));
		partidasJ2.addMouseListener(new MenuContextualPartidasJ2(datos,partidasJ2,partidasCompletadas,frame));
		partidasCompletadas.addMouseListener(new MenuContextualPartidasCompletadas(datos,amigos,partidasCompletadas,frame));
		

		
		//Creacion de los menus de la parte de arriba.

		JMenuBar menuBar; //Crear barras de menus deplegables de arriba.
		menuBar = new JMenuBar();

		JMenu menuArchivo = new JMenu("Archivo"); //cada jmenu es un menu desplegable.	
		menuBar.add(menuArchivo);
		JMenu mLFichero=new JMenu("Ficheros"); //añades la sublista
		menuArchivo.add(mLFichero);
		JMenuItem mLCargar=new JMenuItem("Cargar Fichero..."); // y la sublista de la sublista.
		mLFichero.add(mLCargar);
		mLCargar.addActionListener(new CargarFichero(datos,frame,peliculas));
		JMenuItem mLGuardar=new JMenuItem("Guardar Fichero...");
		mLFichero.add(mLGuardar);
		mLGuardar.addActionListener(new GuardarFichero(datos));		
		menuArchivo.addSeparator();
		JMenu mLUsuario=new JMenu("Usuario");
		menuArchivo.add(mLUsuario);
		JMenuItem mLCrearUsuario=new JMenuItem("Crear nuevo usuario...");
		mLUsuario.add(mLCrearUsuario);
		mLCrearUsuario.addActionListener(new CrearNuevoUsuario(frame,datos));
		JMenuItem mLCambiarUsuario=new JMenuItem("Cambiar Usuario...");
		mLCambiarUsuario.addActionListener(new CambiarUsuario(frame,datos,panelDatosUsuario,amigos,solicitudesPendientes,partidasJ1,partidasJ2,partidasCompletadas));
		mLUsuario.add(mLCambiarUsuario);
			
		JMenu menuClasificacion = new JMenu("Clasificación");	
		menuBar.add(menuClasificacion);
		JMenuItem mCC1=new JMenuItem("Ordenar por porcentaje");
		menuClasificacion.add(mCC1);
		mCC1.addActionListener(new VerClasificacion(frame,datos,TiposOrdenacion.OPCION1));
		JMenuItem mCC2=new JMenuItem("Ordenar por puntos");
		menuClasificacion.add(mCC2);
		mCC2.addActionListener(new VerClasificacion(frame,datos,TiposOrdenacion.OPCION2));
		JMenuItem mCC3=new JMenuItem("Ordenar por victorias");
		menuClasificacion.add(mCC3);
		mCC3.addActionListener(new VerClasificacion(frame,datos,TiposOrdenacion.OPCION3));
		
		JMenu menuPelicula = new JMenu("Pelicula");	
		menuBar.add(menuPelicula);
		JMenuItem mCPeliculaNueva=new JMenuItem("Pelicula Nueva ...");
		menuPelicula.add(mCPeliculaNueva);
		mCPeliculaNueva.addActionListener(new PeliculaNueva(datos,peliculas,frame));
		
		
		JMenu menuPartida = new JMenu("Partida");	
		menuBar.add(menuPartida);
		JMenuItem mCPartidaNueva=new JMenuItem("Partida Nueva ...");
		menuPartida.add(mCPartidaNueva);
		mCPartidaNueva.addActionListener(new PartidaNueva(datos,partidasJ1));
		
		JMenu menuUsuario = new JMenu("Usuario");	
		menuBar.add(menuUsuario);
		JMenuItem mCSolicitudAmistad=new JMenuItem("Enviar Solicitud de amistad");
		menuUsuario.add(mCSolicitudAmistad);
		mCSolicitudAmistad.addActionListener(new EnviarSolicitudAmistad(frame,datos));
		

		frame.setJMenuBar(menuBar);
		
    }
		
		
		

}
