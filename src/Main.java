import Vista.Principal;
import Modelo.Mundo;
import Controlador.Controlador;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mundo modelo = new Mundo();
		Principal vista= new Principal();
		Controlador control= new Controlador(modelo, vista);
		do{
			// Ejecucion del programa; Vista en ejecucion			
		}while(!modelo.isQuit()); //mientras no termine la ejecucion

	}

}
