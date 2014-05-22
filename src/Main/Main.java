
package Main;

import javax.swing.SwingUtilities;

import Vista.Principal;
import Controlador.Controlador;
import Modelo.Mundo;

public class Main {

	public static void main(String[] args) {
		// TODO terminar main
		Mundo modelo  = new Mundo();
		final Controlador controlador = new Controlador(modelo);	
		SwingUtilities.invokeLater(new Runnable() 
		 {
		 public void run() 
		 {						
			 @SuppressWarnings("unused")
			Principal vista = new Principal(controlador);
		 }
		 });
	}

}
