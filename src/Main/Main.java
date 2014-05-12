package Main;

import Vista.Principal;
import Controlador.Controlador;
import Modelo.Mundo;

public class Main {

	public static void main(String[] args) {
		// TODO terminar main
		Mundo modelo  = new Mundo();
		Controlador controlador = new Controlador(modelo);
		Principal vista = new Principal(controlador);		
		
	}

}
