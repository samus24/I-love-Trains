package Vista;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Controlador.Controlador;


public class BarraMenu
{
	private JMenu menu = new JMenu("Menu");
	private Controlador controlador;
	
	public JMenuItem opcionTrenes = new JMenuItem("Trenes");
	public JMenuItem opcionSeñales = new JMenuItem("Señales");
	public JMenuItem opcionPagPrincipal = new JMenuItem("Pagina Principal");
	
	public BarraMenu(Controlador controlador){
		this.controlador = controlador;
	}
	
	public JMenuBar crearBarraMenu()
	{
		// Creamos la barra del menu.
		JMenuBar menuBar = new JMenuBar();

		//Añadimos los conjuntos en los que se incluyen las opciones a mostrar
		menuBar.add(menu);

		// Creamos las opciones posibles
		
		//Rellenamos los conjuntos
		menu.add(opcionTrenes);
		menu.add(opcionSeñales);
		menu.addSeparator();//Añadimos un separador
		menu.add(opcionPagPrincipal);

		return menuBar;
	}
}
