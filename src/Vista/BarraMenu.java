package Vista;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class BarraMenu {
	private JMenu menu = new JMenu("Menu");
	public JMenuItem opcionTrenes = new JMenuItem("Trenes");
	public JMenuItem opcionSenales = new JMenuItem("Se�ales");
	public JMenuItem opcionPagPrincipal = new JMenuItem("Pagina Principal");
	
	public BarraMenu() { // esto no necesita controlador, no?
	}
	
	public JMenuBar crearBarraMenu() {
		JMenuBar menuBar = new JMenuBar();

		//A�adimos los conjuntos en los que se incluyen las opciones a mostrar
		menuBar.add(menu);

		// Creamos las opciones posibles
		
		//Rellenamos los conjuntos
		menu.add(opcionTrenes);
		menu.add(opcionSenales);
		menu.addSeparator(); //A�adimos un separador
		menu.add(opcionPagPrincipal);

		return menuBar;
	}
}
