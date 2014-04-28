

/*
 Calidad: Las llaves de apertura de bloque no estan colocadas a continuaci—n
 del nombre del metodo/clase
 
 Corregido: Christian çlvarez.
 
 */

package pruebas;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class BarraMenu{
	private JMenu conjunto1 = new JMenu("Conjunto 1");
	
	public JMenuItem opcionTrenes = new JMenuItem("Trenes");
	public JMenuItem opcionSenales = new JMenuItem("Se–ales");
	
	public JMenuBar crearBarraMenu(){
		// Creamos la barra del menu.
		JMenuBar menuBar = new JMenuBar();

		//Añadimos los conjuntos en los que se incluyen las opciones a mostrar
		menuBar.add(conjunto1);

		// Creamos las opciones posibles
		
		//Rellenamos los conjuntos
		conjunto1.add(opcionTrenes);
		conjunto1.add(opcionSeñales);

		return menuBar;
	}
}
